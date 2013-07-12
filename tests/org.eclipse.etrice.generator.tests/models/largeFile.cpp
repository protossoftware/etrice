/* **************************************************************
 *
 *    bs_ActorClass.cpp
 *
 *    (C) 1998 Protos Logistik Software GmbH
 *
 *    The actor class implementation.
 *
 *    980826 kb  created
 *
 *************************************************************** */

#ifdef CHECK_MEM
	#define WITHOUT_MFCXLib
	#include "../stdafx.h"
#else
	#define TRACE (void)0
#endif

/* ************************************************************* */

// switch off compiler warning: reduced identifier length in debug information
#pragma warning(disable : 4786)

// ***************************************************************

#ifdef _DEBUG
#define DEBUG_MAKE_CONSISTENT
#endif

// ***************************************************************

#include <assert.h>

#include <ostream>
#include <istream>
#include <algorithm>
#include <limits>
using namespace std;


#include "bs_ActorClass.h"
#include "bs_ActorVisitor.h"
#include "bs_StateMachine.h"
#include "bs_DataClassObj.h"
#include "bs_MemberVisitor.h"
#include "bs_ClassVisitor.h"
#include "bs_ParallelMdlVisitor.h"
#include "bs_GraphSort.h"
#include "../bsRoomBase/bs_ErrorHdlr.h"
#include "bs_MdlLocation.h"
#include "bsFormal/bs_AuxGraph.h"

/* ************************************************************* */

#ifdef CHECK_MEM
	#define new DEBUG_NEW
	#undef THIS_FILE
	static char THIS_FILE[] = __FILE__;
#endif

/* ************************************************************* */

#include "../bsRoomBase/bs_RoomList.cpp"

/* ************************************************************* */

// explicit instantiation
template class bs_RoomList<bs_ActorClass>;

// ***************************************************************

// helper class for creating duplicates of actor interface and structure PortRefLists
class pr_entry
{
public:
	typedef enum
	{
		none,
		iface,
		structure,
		common
	}
	Owner;

	pr_entry (void)  
		: _port_ref(NULL), _owner(none), _if_id(-1), _st_id(-1)
	{}

	pr_entry (bs_PortRefPtr p, Owner o, int i, int s)
		: _port_ref(p), _owner(o), _if_id(i), _st_id(s)
	{}

	// data
	bs_PortRefPtr _port_ref;
	Owner _owner;
	int _if_id;
	int _st_id;
};

// default: compare interface id
bool operator< (const pr_entry& e0, const pr_entry& e1)
{
	return e0._if_id < e1._if_id;
}

bool operator== (const pr_entry& e0, const pr_entry& e1)
{
	return e0._if_id == e1._if_id;
}

// special compare: structure id
class st_cmp
{
public:
	bool operator() (const pr_entry& e0, const pr_entry& e1)
	{
		return e0._st_id < e1._st_id;
	}
};

// ***************************************************************

/**# implementation bs_ActorClass:: id(C_0902130146)
*/

// ***************************************************************

DEFINE_STREAMABLE(bs_ActorClass,"bs_ModelClass")

bs_ActorClass::bs_ActorClass (void) :
	bs_ModelClass(),
	_check_bindings(false),
	_enable_debug_macros(true),
	_override_enable_debug(false),
	_allow_override(false),
	_abstract_class(false),
	_generated_ids_valid(true)
{
}

bs_ActorClass::bs_ActorClass (const bs_ActorClass& orig, CopyType t)
:	bs_ModelClass(orig),
	bs_Cloner<bs_ActorClass>(orig),
	_interface(orig._interface, t),
	_structure(orig._structure, t),
	_behaviour(orig._behaviour, t),
	_memberfct(orig._memberfct, t),
	_base_class(GetAppropriatePtr(orig._base_class, t)),
	_check_bindings(false),
	_enable_debug_macros(orig._enable_debug_macros),
	_override_enable_debug(orig._override_enable_debug),
	_allow_override(orig._allow_override),
	_perso_version(orig._perso_version),
	_abstract_class(orig._abstract_class),
	_generated_ids_valid(orig._generated_ids_valid)
{
}

bs_ActorClass::~bs_ActorClass (void)
{
}


bs_ActorClass::bs_ActorClass (bs_RoomName name)
:	bs_ModelClass(name),
	_check_bindings(false),
	_enable_debug_macros(true),
	_override_enable_debug(false),
	_allow_override(false),
	_abstract_class(false)
{
	CommonConstruct();
}


bs_ActorClass::bs_ActorClass (int version, istream& is, bs_ProtocolClassList& pcl, bs_ActorClassList& acl)
:	bs_ModelClass(),
	_check_bindings(false),
	_enable_debug_macros(true),
	_override_enable_debug(false),
	_allow_override(false),
	_abstract_class(false)
{
	ReadStream(version, is, pcl, acl);

	CommonConstruct();
}

	
void bs_ActorClass::CommonConstruct (void)
{
	// join the namespaces of all lists that produce members in the generated class
	_interface.GetPortRefList().JoinNamespace(_structure.GetPortRefList());
	_interface.GetPortRefList().JoinNamespace(_structure.GetSAPs());
	_interface.GetPortRefList().JoinNamespace(_behaviour.GetStateMachine()->GetStateVariables());
}


// ***************************************************************

void bs_ActorClass::Dump (bs_TMSContext& tmsc)
{
	tmsc.TMS() << "actor class " << GetName();
	if (_base_class)
		tmsc.TMS() << "derived from " << _base_class->GetName();
	
	tmsc.TMS() << " {\n";
	tmsc.Indent();

		tmsc.TMS() << "interface: {\n";
		tmsc.Indent();
			_interface.GetPortRefList().Dump(tmsc);
		tmsc.Unindent();
		tmsc.TMS() << "}\n";

		tmsc.TMS() << "structure: {\n";
		tmsc.Indent();
			tmsc.TMS() << "end ports: {\n";
			tmsc.Indent();
				_structure.GetPortRefList().Dump(tmsc);
			tmsc.Unindent();
			tmsc.TMS() << "}\n";

			tmsc.TMS() << "saps: {\n";
			tmsc.Indent();
				_structure.GetSAPs().Dump(tmsc);
			tmsc.Unindent();
			tmsc.TMS() << "}\n";

			tmsc.TMS() << "components: {\n";
			tmsc.Indent();
				_structure.GetActorRefList().Dump(tmsc);
				_structure.GetPrtvRefList().Dump(tmsc);
			tmsc.Unindent();
			tmsc.TMS() << "}\n";

			tmsc.TMS() << "bindings: {\n";
			tmsc.Indent();
				_structure.GetBindingContractList().Dump(tmsc);
			tmsc.Unindent();
			tmsc.TMS() << "}\n";
		tmsc.Unindent();
		tmsc.TMS() << "}\n";

		tmsc.TMS() << "behaviour: {\n";
		tmsc.Indent();
			_behaviour.Dump(tmsc);
		tmsc.Unindent();
		tmsc.TMS() << "}\n";

	tmsc.Unindent();
	tmsc.TMS() << "};\n";
}

void bs_ActorClass::Docu (bs_DocuContext& dc)
{
	if (_base_class)
	{
		dc.Docu("derived from" + _base_class->GetName());
		dc.Newline();
		if (_allow_override)
			dc.Docu("(allows overrides)");
		else
			dc.Docu("(prohibits overrides)");
		dc.Newline();
		dc.Newline();
	}

	dc.BeginSection("Interface");
		_interface.GetPortRefList().Docu(dc);
	dc.EndSection();

	dc.BeginSection("Structure");
		dc.Picture(*this, GetName()+"_structure", "Structure of actor class "+GetName());
		_structure.Docu(dc);
	dc.EndSection();

	dc.BeginSection("Behaviour");
		dc.Picture(_behaviour, *this, GetName()+"_behaviour", "Hierarchical state machine of actor class "+GetName());
		_behaviour.GetStateMachine()->Docu(dc);
	dc.EndSection();
}


// ***************************************************************

// bs_StreamObj touch interface

bool bs_ActorClass::IsComponentTouched (void) const
{
    if (_interface.IsTouched()) return true;
    if (_structure.IsTouched()) return true;
    if (_behaviour.IsTouched()) return true;
    if (_memberfct.IsTouched()) return true;
	return false;
}

time_t bs_ActorClass::GetLastTouchTime (void) const
{
	time_t touched = bs_TouchableObject::GetLastTouchTime();
	touched = GetMaxTouchTime(_interface.GetLastTouchTime(), touched);
	touched = GetMaxTouchTime(_structure.GetLastTouchTime(), touched);
	touched = GetMaxTouchTime(_behaviour.GetLastTouchTime(), touched);
	touched = GetMaxTouchTime(_memberfct.GetLastTouchTime(), touched);

	return touched;
}

/* ************************************************************* */

// bs_ActorVisitor interface
void bs_ActorClass::Accept (bs_ActorClassPtr myself, bs_ActorVisitor& visitor)
{
	visitor.VisitActorClass(myself);

	bs_ActorRefList& arefs = _structure.GetActorRefList();
	bs_ActorRefIterator aref;
	for(aref=arefs.begin(); aref!=arefs.end(); aref++)
	{
		(*aref)->Accept(*aref, visitor);
	}

	bs_PrtvRefList& prefs = _structure.GetPrtvRefList();
	bs_PrtvRefIterator pref;
	for(pref=prefs.begin(); pref!=prefs.end(); pref++)
	{
		(*pref)->Accept(*pref, visitor);
	}

	visitor.VisitActorClassEnd(myself);
}
	
/* ************************************************************* */

void bs_ActorClass::Accept (bs_ActorClassPtr myself, bs_MemberVisitor& visitor)
{
	visitor.Visit(myself);

	// base class
	if (_base_class)
		_base_class->Accept(_base_class, visitor);

	// component actors
	{
		bs_ActorRefList& comp = _structure.GetActorRefList();
		for (bs_ActorRefIterator c=comp.begin(); c!=comp.end(); c++)
		{
			bs_ActorClassPtr ac = (*c)->GetActorClass();
			ac->Accept(ac,visitor);
		}
	}

	// component primitives
	{
		bs_PrtvRefList& comp = _structure.GetPrtvRefList();
		for (bs_PrtvRefIterator c=comp.begin(); c!=comp.end(); c++)
		{
			bs_PrtvClassPtr pc = (*c)->GetPrtvClass();
			pc->Accept(pc,visitor);
		}
	}

	// SAPClasses
	{
		bs_SAPRefList& saps = _structure.GetSAPs();
		for (bs_SAPRefIterator c=saps.begin(); c!=saps.end(); c++)
		{
			bs_SAPClassPtr sc = (*c)->GetSAPClass();
			sc->Accept(sc,visitor);
		}
	}

	// Protocols of PortRefs
	{
		bs_PortRefList& comp = _interface.GetPortRefList();
		bs_PortRefIterator c;
		for (c=comp.begin(); c!=comp.end(); ++c)
		{
			bs_ProtocolClassPtr pc = (*c)->GetProtocolClass();
			pc->Accept(pc,visitor);
		}
	}
	{
		bs_PortRefList& comp = _structure.GetPortRefList();
		bs_PortRefIterator c;
		for (c=comp.begin(); c!=comp.end(); ++c)
		{
			bs_ProtocolClassPtr pc = (*c)->GetProtocolClass();
			pc->Accept(pc,visitor);
		}
	}

	// DataMembers
	{
		bs_DataMemberList& dml = _behaviour.GetStateMachine()->GetStateVariables();
		for (bs_DataMemberIterator c=dml.begin(); c!=dml.end(); ++c)
		{
			(*c)->Accept(*c,visitor);
		}
	}
}

/* ************************************************************* */

void bs_ActorClass::Accept (bs_ActorClassPtr myself, bs_ClassVisitor& visitor)
{
	visitor.Visit(myself);
}

/* ************************************************************* */

void bs_ActorClass::Accept (bs_ActorClassPtr ac1, bs_ActorClassPtr ac2, bs_ParallelMdlVisitor& visitor)
{
	if (ac1)
		visitor.PushPath(ac1->GetName());
	else
		visitor.PushPath(ac2->GetName());

	bool descend = visitor.Visit(ac1, ac2);

	if (!descend || ac1==NULL || ac2==NULL)
	{
		visitor.PopPath();
		return;
	}

	bs_ActorInterface::Accept(ac1->_interface, ac2->_interface, visitor);
	bs_ActorStructure::Accept(ac1->_structure, ac2->_structure, visitor);
	bs_ActorBehaviour::Accept(ac1->_behaviour, ac2->_behaviour, visitor);
	bs_ActorMemberFct::Accept(ac1->_memberfct, ac2->_memberfct, visitor);

	visitor.PopPath();
}

/* ************************************************************* */

void bs_ActorClass::Handle (bs_InvalidateGeneratedIDsEvent& evt)
{
	if (&*evt.GetActorClass()==this)
		_generated_ids_valid = false;
}

void bs_ActorClass::Handle (bs_CmdExecutedEvent& evt)
{
	if (!_generated_ids_valid)
	{
		//TRACE("bs_ActorClass[%s]::Handle (bs_CmdExecutedEvent& evt) - setting generated IDs\n", GetName().c_str());
		_behaviour.GetStateMachine()->SetGeneratedIds();
		_generated_ids_valid = true;
	}
}

/* ************************************************************* */

void bs_ActorClass::GetBaseClasses (vector<bs_ActorClassPtr>& bcl) const
{
	if (!_base_class)
		return;

	// add direct base class
	bcl.push_back(_base_class);

	// recurse
	_base_class->GetBaseClasses(bcl);
}

bool bs_ActorClass::ContainsInstanceOf (bs_ActorClassPtr actor)
{
	// check references to component actors
	bs_ActorRefList& comp = _structure.GetActorRefList();
	bs_ActorRefIterator c;
	for(c=comp.begin(); c!=comp.end(); c++)
	{
		bs_ActorClassPtr refd = (*c)->GetActorClass();
		
		// direct reference
		if (refd==actor)
			return true;
		
		// or recursive reference
		if (refd->ContainsInstanceOf(actor))
			return true;
	}

	// no reference
	return false;
}

bool bs_ActorClass::IsDerivedFrom (bs_ActorClassPtr base_class)
{
	if (!_base_class)
		return false;

	// direct base class
	if (_base_class==base_class)
		return true;

	// or recursive base class
	if (_base_class->IsDerivedFrom(base_class))
		return true;

	return false;
}

bool bs_ActorClass::IsDerivedFrom (bs_RoomName base_class)
{
	if (!_base_class)
		return false;

	// direct base class
	if (_base_class->GetName()==base_class)
		return true;

	// or recursive base class
	if (_base_class->IsDerivedFrom(base_class))
		return true;

	return false;
}
	

bool bs_ActorClass::IsUsingActorClass (bs_ActorClassPtr ac)
{
	if (!ac)
		return false;

	const bs_RoomName& ac_name = ac->GetName();

	if (IsDerivedFrom(ac_name))
		return true;

	bs_ActorRefList& arefs = GetStructure().GetActorRefList();
	for (bs_ActorRefIterator it=arefs.begin(); it!=arefs.end(); ++it)
	{
		if ((*it)->GetActorClass()->GetName()==ac_name)
			return true;

		// start recursion
		if ((*it)->GetActorClass()->IsUsingActorClass(ac))
			return true;
	}
	return false;
}

static void AddInheritedStateVars (const bs_DataMemberList& base_dml, bs_DataMemberList& own_dml)
{
	// reset owner flag for inherited items
	for (bs_DataMemberList::const_iterator dmit=base_dml.begin(); dmit!=base_dml.end(); ++dmit)
	{
		own_dml.SetOwnerOf((*dmit)->GetName(), false);
	}
}

template<class T>
class AddItem
{
	public:
		virtual bool operator() (bs_RoomPtr<T> item) const { return true; }
};

template<class T>
class AddPortItem : public AddItem<T>
{
	public:
		AddPortItem (const bs_RoomList<T>& list) : _list(list) {}

		virtual bool operator() (bs_RoomPtr<T> item) const
		{
			// this is meant for structure ports
			// they are not mandatory if the port already is in the interface
			// i.e. an end port in the base class may be a relay port in the derived class
			bool in_interface = !_list[item->GetName()].IsNull();
			if (in_interface)
			{
				#ifdef _DEBUG
				TRACE("structure port %s is in the interface and will not be added to the derived structure\n",
					item->GetName().c_str()
				);
				#endif
			}
			return !in_interface;
		}

	private:
		const bs_RoomList<T>& _list;
};

template<class T>
static void AddInheritedItems (
	const string& ac_name,
	const string& item_type,
	const bs_RoomList<T>& base_list,
	bs_RoomList<T>& own_list,
	bool signal_errors,
	const AddItem<T>& add_item
)
{
	// reset owner flag for inherited items
	for (bs_RoomList<T>::const_iterator it=base_list.begin(); it!=base_list.end(); ++it)
	{
		// own_list is not owner, but should contain item with same name
		bs_RoomPtr<T> own = own_list[(*it)->GetName()];
		if (own)
		{
			if (own!=*it)
			{
				// base and derived classes have items with same name, but there are
				// two different objects. kill zombie object and discard changes in zombie.
				(*it).TakeOverPtrsFrom(own);

				if (signal_errors)
				{
					bs_ErrorHdlr::Get()->Handle(
						bs_ErrorHdlr::error,
						"Actor class '" + ac_name + "' has inherited " +
						item_type + " '"+ (*it)->GetName() +"',\n"
						"which has been decoupled from its base class item!\n\n" +
						"This has been repaired by Trice's consistency check.\n",
						__FILE__,
						__LINE__
					);
				}
			}
		}
		else if (add_item(*it))
		{
			// own_list doesn't contain inherited item
			own_list.push_back(*it);

			if (signal_errors)
			{
				bs_ErrorHdlr::Get()->Handle(
					bs_ErrorHdlr::error,
						"Actor class '" + ac_name + "' has missing inherited " +
						item_type + " '" + (*it)->GetName() +"'!\n\n"
						"It is automatically added by Trice's consistency check.\n",
					__FILE__,
					__LINE__
				);
			}
			else
			{
				string msg = "AddInheritedItems - added " + item_type + " '" + (*it)->GetName() +"'\n";
				TRACE(msg.c_str());
			}
		}

		own_list.SetOwnerOf((*it)->GetName(), false);
	}
}

static void AddInheritedBehaviourNotes (
	const string& ac_name,
	bs_StateContext& base_sc,
	bs_StateContext& own_sc,
	bool signal_errors
)
{
	bs_StateGraph& base_sg = base_sc.GetStateMachine()->GetStateGraph();
	bs_StateGraph& own_sg = own_sc.GetStateMachine()->GetStateGraph();

	// handle items on this level
	AddInheritedItems(ac_name, "note", base_sg.GetNotes(), own_sg.GetNotes(), signal_errors, AddItem<bs_Note>());

	// handle sub-graphs recursively 
	bs_StateIterator sit;
	for(sit=own_sg.GetStates().begin(); sit!=own_sg.GetStates().end(); sit++)
	{
		if (! ((*sit)->IsInherited() && (*sit)->HasStateMachine()))
			continue;

		bs_StatePtr base_s = (*sit)->GetBaseClassState();
		if (base_s==NULL)
			continue;

		if (base_sc.OneLevelDown(base_s))
		{
			if (own_sc.OneLevelDown(*sit))
			{
				AddInheritedBehaviourNotes(ac_name, base_sc, own_sc, signal_errors);
				base_sc.OneLevelUp();
			}
			own_sc.OneLevelUp();
		}
	}
}

static void AddInheritedStateVarsOld (const bs_DataMemberList& base_dml, bs_DataMemberList& own_dml)
{
	// add derived
	bs_DataMemberList tmp;
	for (bs_DataMemberList::const_iterator dmit=base_dml.begin(); dmit!=base_dml.end(); ++dmit)
	{
		tmp.push_back(*dmit);
	}

	// add own
	for (dmit=own_dml.begin(); dmit!=own_dml.end(); ++dmit)
	{
		tmp.push_back(*dmit);
	}

	// copy tmp
	own_dml.clear();
	for (dmit=tmp.begin(); dmit!=tmp.end(); ++dmit)
	{
		own_dml.push_back(*dmit);
		
		if (base_dml[(*dmit)->GetName()])
			own_dml.SetOwnerOf((*dmit)->GetName(), false);
	}
}

template<class T>
static void AddInheritedItemsOld (const bs_RoomList<T>& base_list, bs_RoomList<T>& own_list)
{
	// make a copy of the base list
	bs_RoomList<T> tmp(base_list);

	// set inherited
	for (bs_RoomList<T>::iterator it=tmp.begin(); it!=tmp.end(); ++it)
	{
		tmp.SetOwnerOf((*it)->GetName(), false);
	}

	// add own
	for (it=own_list.begin(); it!=own_list.end(); ++it)
	{
		tmp.push_back(*it);
	}

	// copy back
	own_list = tmp;
}

void bs_ActorClass::AddInheritedAttributes (bool signal_errors)
{
	if (!_base_class)
		return;

	if (signal_errors)
	{
		bs_StateGraph& base_sg = _base_class->GetBehaviour().GetStateMachine()->GetStateGraph();
		_behaviour.GetStateMachine()->GetStateGraph().SetBaseClassPtrs(base_sg);
	}

	// NB: we can assume that the direct base class already is complete

	if (_perso_version>=8)
	{
		// state variables
		AddInheritedItems(
			GetName(), "data member",
			_base_class->GetBehaviour().GetStateMachine()->GetStateVariables(),
			GetBehaviour().GetStateMachine()->GetStateVariables(),
			signal_errors,
			AddItem<bs_DataMember>()
		);

		// interface ports
		AddInheritedItems(
			GetName(), "interface port",
			_base_class->GetInterface().GetPortRefList(),
			GetInterface().GetPortRefList(),
			signal_errors,
			AddItem<bs_PortRef>()
		);

		// structure ports
		AddInheritedItems(
			GetName(), "end port",
			_base_class->GetStructure().GetPortRefList(),
			GetStructure().GetPortRefList(),
			signal_errors,
			AddPortItem<bs_PortRef>(_base_class->GetInterface().GetPortRefList())
		);

		// actor refs
		AddInheritedItems(
			GetName(), "actor reference",
			_base_class->GetStructure().GetActorRefList(),
			GetStructure().GetActorRefList(),
			signal_errors,
			AddItem<bs_ActorRef>()
		);

		// prtv refs
		AddInheritedItems(
			GetName(), "primitive reference",
			_base_class->GetStructure().GetPrtvRefList(),
			GetStructure().GetPrtvRefList(),
			signal_errors,
			AddItem<bs_PrtvRef>()
		);

		// binding contracts
		AddInheritedItems(
			GetName(), "binding",
			_base_class->GetStructure().GetBindingContractList(),
			GetStructure().GetBindingContractList(),
			signal_errors,
			AddItem<bs_BindingContract>()
		);

		// SAPs
		AddInheritedItems(
			GetName(), "SAP",
			_base_class->GetStructure().GetSAPs(),
			GetStructure().GetSAPs(),
			signal_errors,
			AddItem<bs_SAPRef>()
		);

		// structure notes
		AddInheritedItems(
			GetName(), "note",
			_base_class->GetStructure().GetNoteList(),
			GetStructure().GetNoteList(),
			signal_errors,
			AddItem<bs_Note>()
		);

		// behaviour notes
		bs_StateContext base_sc(_base_class->GetBehaviour().GetStateMachine());
		bs_StateContext own_sc(_behaviour.GetStateMachine());
		AddInheritedBehaviourNotes(GetName(), base_sc, own_sc, signal_errors);
	}
	else
	{
		// state variables
		AddInheritedStateVarsOld(
			_base_class->GetBehaviour().GetStateMachine()->GetStateVariables(),
			GetBehaviour().GetStateMachine()->GetStateVariables()
		);

		// interface ports
		AddInheritedItemsOld(
			_base_class->GetInterface().GetPortRefList(),
			GetInterface().GetPortRefList()
		);

		// structure ports
		AddInheritedItemsOld(
			_base_class->GetStructure().GetPortRefList(),
			GetStructure().GetPortRefList()
		);

		// actor refs
		AddInheritedItemsOld(
			_base_class->GetStructure().GetActorRefList(),
			GetStructure().GetActorRefList()
		);

		// prtv refs
		AddInheritedItemsOld(
			_base_class->GetStructure().GetPrtvRefList(),
			GetStructure().GetPrtvRefList()
		);

		// binding contracts
		AddInheritedItemsOld(
			_base_class->GetStructure().GetBindingContractList(),
			GetStructure().GetBindingContractList()
		);

		// SAPs
		AddInheritedItemsOld(
			_base_class->GetStructure().GetSAPs(),
			GetStructure().GetSAPs()
		);
	}

	// now we are up to date
	_perso_version = STREAMOBJ_VERSION(bs_ActorClass);
}

string bs_ActorClass::GetObjID (void) const
{
	return "bs_ActorClass: " + GetName() + GetUniqueObjectIDstr();
}

// ***************************************************************

void bs_ActorClass::STREAMOBJ_WRITE(bs_ActorClass) (bs_ObjectOStream& oos)
{
	if (_base_class)
		oos << _base_class->GetName();
	else
		oos << "";

	oos << _allow_override;

	oos << _interface;
	oos << _structure;
	oos << _behaviour;
	oos << _memberfct;

	oos << _enable_debug_macros;
	oos << _override_enable_debug;
	oos << _abstract_class;
}


void bs_ActorClass::STREAMOBJ_READ(bs_ActorClass) (bs_ObjectIStream& ois, Version version)
{
	_perso_version = version;

	if (version>=3)
		ois >> _base_class_name;

	if (version>=7)
		ois >> _allow_override;
	else
		_allow_override = false;

	ois >> _interface;
	ois >> _structure;
	ois >> _behaviour;

	if (version>=1)
		ois >> _memberfct;

	CommonConstruct();

	// check the oldstyle SAPRefList in ActorInterface and move it to ActorStructure
	bs_SAPRefIterator sap;
	for(sap=_interface.GetOldstyleSAPs().begin(); sap!=_interface.GetOldstyleSAPs().end(); sap++)
	{
		_structure.GetSAPs().push_back(*sap);
	}
	_interface.GetOldstyleSAPs().clear();

	/* todo: in later versions, checking can be switched off again,
	   currently, we keep it checking until the _real_ reason for
	   spurious bindings has been found.*/
//	_check_bindings = (version<2);

	_check_bindings = true;

	//if (version==2)
	{
		int errors = 0;
		bs_BindingContractList& bcl = _structure.GetBindingContractList();
		for (bs_BindingContractList::iterator it=bcl.begin(); it!=bcl.end(); /* no iterator step here */)
		{
			if ((*it)->GetPoint1().GetPortRef()==(*it)->GetPoint2().GetPortRef())
			{
				++errors;
				it = bcl.erase(it);
			}
			else
				++it;
		}

		if (errors)
		{
			char buf[32];
			sprintf(buf, "%d", errors);
			bs_ErrorHdlr::Get()->Handle(
				bs_ErrorHdlr::error,
				"Actor class '" + GetName() + "' had " + buf + " corrupt bindings,\n"
				"which have been deleted by Trice's consistency check.",
				__FILE__,
				__LINE__
			);
		}
	}

	if (version>=4)
	{
		ois >> _enable_debug_macros;
	}
	if (version>=6)
	{
		ois >> _override_enable_debug;
	}
	if (version>=5)
	{
		ois >> _abstract_class;
	}

	RemoveSpuriousTrPoints();
	RemoveSpuriousTrSegments();
}

void bs_ActorClass::RemoveSpuriousTrPoints (void)
{
	bool removed = false;

	bs_StateGraph& sg = _behaviour.GetStateMachine()->GetStateGraph();
	bs_StateList& sl = sg.GetStates();
	for (bs_StateIterator sit=sl.begin(); sit!=sl.end(); ++sit)
	{
		if ((*sit)->RemoveSpuriousTrPoints(sg))
			removed = true;
	}

	if (removed)
	{
		bs_ErrorHdlr::Get()->Handle(
			bs_ErrorHdlr::error,
			"Actor class '" + GetName() + "' had spurious extending transition points,\n"
			"which have been deleted by Trice's consistency check.\n\n"
			"Please check its behaviour for missing transitions!\n",
			__FILE__,
			__LINE__
		);
	}
}

void bs_ActorClass::RemoveSpuriousTrSegments (void)
{
	int count = _behaviour.GetStateMachine()->GetStateGraph().RemoveSpuriousTrSegments();
	
	if (count>0)
	{
		char buf[32];
		sprintf(buf, "%d", count);
		bs_ErrorHdlr::Get()->Handle(
			bs_ErrorHdlr::error,
			"Actor class '" + GetName() + "' had " + buf + " corrupt transition segments,\n"
			"which have been deleted by Trice's consistency check.\n\n"
			"Please check its behaviour for missing transition segments!\n",
			__FILE__,
			__LINE__
		);
	}
}

/*
static int CheckAndCorrectEndPoint (const bs_BCEndPoint& ep, bs_PortRefList& stp, bs_PortRefList& ifp)
{
	int corrected = 0;

	if (ep.IsLocal())
	{
		bs_PortRefIterator prit = find(stp.begin(), stp.end(), ep.GetPortRef());
		if (prit==stp.end())
			prit = find(ifp.begin(), ifp.end(), ep.GetPortRef());
		if (prit==ifp.end())
		{
			// pointer not found, try with name
			prit = stp.FindName(ep.GetPortRef()->GetName());
			if (prit==stp.end())
				prit = ifp.FindName(ep.GetPortRef()->GetName());
			if (prit==ifp.end())
			{
				// cannot correct
			}
			else
			{
				// correct it
				ep.SetPortRef(*prit);
				corrected++;
			}
		}
	}
	else
	{
		// todo: NIY
	}

	return corrected;
}
*/

void bs_ActorClass::RemoveSpuriousBindings (void)
{
	// check for BCEndpoints with spurious PortRefs (bug in Trice)
	// this is checked only for versions in a certain version range (see STREAMOBJ_READ)
	if (! _check_bindings)
		return;

	_check_bindings = false;

	typedef enum
	{
		bc_error
	}
	Exception;

	int errors = 0;

	bs_PortRefList& ifp = _interface.GetPortRefList();
	bs_PortRefList& stp = _structure.GetPortRefList();

	bs_BindingContractList& bcl = _structure.GetBindingContractList();
	int nbc_before = bcl.size(); // for debugging only
	int nbc_checked = 0; // for debugging only
//	int nbep_corrected = 0; // for debugging only
	for (bs_BindingContractList::iterator it=bcl.begin(); it!=bcl.end(); /* no iterator step here */)
	{
		nbc_checked++;

		try
		{
			const bs_BCEndPoint& p1 = (*it)->GetPoint1();
			const bs_BCEndPoint& p2 = (*it)->GetPoint2();

//			nbep_corrected += CheckAndCorrectEndPoint(p1, stp, ifp);

			if (p1.IsLocal())
			{
				bs_PortRefIterator prit = find(stp.begin(), stp.end(), p1.GetPortRef());
				if (prit==stp.end())
					prit = find(ifp.begin(), ifp.end(), p1.GetPortRef());
				if (prit==ifp.end())
					throw bc_error;
				if (p2.GetActorRef())
				{
					if (! p2.GetActorRef()->GetActorClass())
						throw bc_error;

					bs_PortRefList& compp = p2.GetActorRef()->GetActorClass()->GetInterface().GetPortRefList();
					prit = find(compp.begin(), compp.end(), p2.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
				}
				else
				{
					bs_PortRefList& compp = p2.GetPrtvRef()->GetPrtvClass()->GetInterface().GetPortRefList();
					prit = find(compp.begin(), compp.end(), p2.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
				}
			}
			else if (p2.IsLocal())
			{
				bs_PortRefIterator prit = find(stp.begin(), stp.end(), p2.GetPortRef());
				if (prit==stp.end())
					prit = find(ifp.begin(), ifp.end(), p2.GetPortRef());
				if (prit==ifp.end())
					throw bc_error;
				if (p1.GetActorRef())
				{
					if (! p1.GetActorRef()->GetActorClass())
						throw bc_error;

					bs_PortRefList& compp = p1.GetActorRef()->GetActorClass()->GetInterface().GetPortRefList();
					prit = find(compp.begin(), compp.end(), p1.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
				}
				else
				{
					bs_PortRefList& compp = p1.GetPrtvRef()->GetPrtvClass()->GetInterface().GetPortRefList();
					prit = find(compp.begin(), compp.end(), p1.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
				}
			}
			else
			{
				if (p1.GetActorRef())
				{
					if (! p1.GetActorRef()->GetActorClass())
						throw bc_error;

					bs_PortRefList& compp = p1.GetActorRef()->GetActorClass()->GetInterface().GetPortRefList();
					bs_PortRefIterator prit = find(compp.begin(), compp.end(), p1.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
					if (p2.GetActorRef())
					{
						if (! p2.GetActorRef()->GetActorClass())
							throw bc_error;

						bs_PortRefList& compp = p2.GetActorRef()->GetActorClass()->GetInterface().GetPortRefList();
						prit = find(compp.begin(), compp.end(), p2.GetPortRef());
						if (prit==compp.end())
							throw bc_error;
					}
					else
					{
						bs_PortRefList& compp = p2.GetPrtvRef()->GetPrtvClass()->GetInterface().GetPortRefList();
						prit = find(compp.begin(), compp.end(), p2.GetPortRef());
						if (prit==compp.end())
							throw bc_error;
					}
				}
				else
				{
					bs_PortRefList& compp = p1.GetPrtvRef()->GetPrtvClass()->GetInterface().GetPortRefList();
					bs_PortRefIterator prit = find(compp.begin(), compp.end(), p1.GetPortRef());
					if (prit==compp.end())
						throw bc_error;
					if (p2.GetActorRef())
					{
						if (! p2.GetActorRef()->GetActorClass())
							throw bc_error;

						bs_PortRefList& compp = p2.GetActorRef()->GetActorClass()->GetInterface().GetPortRefList();
						prit = find(compp.begin(), compp.end(), p2.GetPortRef());
						if (prit==compp.end())
							throw bc_error;
					}
					else
					{
						bs_PortRefList& compp = p2.GetPrtvRef()->GetPrtvClass()->GetInterface().GetPortRefList();
						prit = find(compp.begin(), compp.end(), p2.GetPortRef());
						if (prit==compp.end())
							throw bc_error;
					}
				}
			}

			// do an iterator step (otherwise it is increased in the catch() block)
			it++;
		}
		catch (Exception)
		{
			errors++;

			// remove this binding
			// NB: this will implicitly move the iterator one step forward
			it = bcl.erase(it);
		}
	}

	int nbc_after = bcl.size(); // for debugging only
	if (errors)
	{
		char buf[32];
		sprintf(buf, "%d", errors);
		bs_ErrorHdlr::Get()->Handle(
			bs_ErrorHdlr::error,
			"Actor class '" + GetName() + "' had " + buf + " corrupt bindings,\n"
			"which have been deleted by Trice's consistency check.\n\n"
			"Please check its structure for missing bindings!\n",
			__FILE__,
			__LINE__
		);
	}
}

static void CheckPortBases (string ac_name, bs_PortRefList& prl, bs_PortRefList& base_prl)
{
	bs_PortRefIterator pr;
	for(pr=prl.begin(); pr!=prl.end(); ++pr)
	{
		if (prl.IsOwnerOf((*pr)->GetName()))
			continue;

		// we are not owner, base class must have port with same name
		bs_PortRefPtr base_pr = base_prl[(*pr)->GetName()];
		if (base_pr)
		{
			if (base_pr!=*pr)
			{
				// base class contains port with same name, but there are
				// two different port objects. 
				// kill zombie PortRef object and discard changes in zombie
				base_pr.TakeOverPtrsFrom(*pr);

				bs_ErrorHdlr::Get()->Handle(
					bs_ErrorHdlr::error,
					"Actor class '" + ac_name + "' has inherited port " + (*pr)->GetName() +",\n"
					"which has been decoupled from its base class port! This has been repaired by\n"
					"Trice's consistency check.\n",
					__FILE__,
					__LINE__
				);
			}
		}
		else
		{
			// base class doesn't have port with same name, decouple it.
			prl.SetOwnerOf((*pr)->GetName());

			bs_ErrorHdlr::Get()->Handle(
				bs_ErrorHdlr::error,
				"Actor class '" + ac_name + "' has inherited port " + (*pr)->GetName() +",\n"
				"which is unknown in base class! It is automatically set to non-inherited.\n",
				__FILE__,
				__LINE__
			);
		}
	}
}

void bs_ActorClass::RemoveSpuriousPorts (void)
{
	if (! _base_class)
		return;

	CheckPortBases(
		GetName(),
		_interface.GetPortRefList(),
		_base_class->GetInterface().GetPortRefList()
	);
	CheckPortBases(
		GetName(),
		_structure.GetPortRefList(),
		_base_class->GetStructure().GetPortRefList()
	);
}

void bs_ActorClass::SetBaseClass (bs_ActorClassList& acl)
{
	_base_class = acl[_base_class_name];
}

void bs_ActorClass::ReadStream (int version, istream& is, bs_ProtocolClassList& pcl, bs_ActorClassList& acl)
{
	bs_RoomObject::ReadStream(is);

	_interface.ReadStream(is, pcl);
	_structure.ReadStream(version, is, pcl, acl);
	_behaviour.ReadStream(version, is);
}



bool bs_ActorClass::operator== (const bs_ActorClass& rhs) const
{
	if (((bs_ModelClass)rhs) != *(bs_ModelClass*)this)
		return false;

	string bc_name;
	if (_base_class)
		bc_name = _base_class->GetName();
	string rhs_bc_name;
	if (rhs._base_class)
		rhs_bc_name = rhs._base_class->GetName();

	if (bc_name!=rhs_bc_name)
		return false;

	if (_interface != rhs._interface)
		return false;

	if (_structure != rhs._structure)
		return false;

	if (_behaviour != rhs._behaviour)
		return false;

	if (_memberfct != rhs._memberfct)
		return false;

	return true;
}


void bs_ActorClass::PrepareTakingOver (bs_ActorClassPtr old)
{
	if (this==(bs_ActorClass*)old)
		return;

	_interface.PrepareTakingOver(old->GetInterface());
	_structure.PrepareTakingOver(old->GetStructure());
	_behaviour.GetStateMachine()->PrepareTakingOver(old->_behaviour.GetStateMachine());	
}


bs_CheckReport bs_ActorClass::CheckConsistency (void)
{
	return _behaviour.CheckConsistency(_base_class ? &_base_class->GetBehaviour() : NULL);
}


// ***************************************************************

bool bs_ActorClassList::MayDeletePortRef (bs_PortRefPtr port_ref)
{
	bs_ActorClassIterator i;
	for(i=begin(); i!=end(); i++)
	{
		if ((*i)->GetStructure().GetBindingContractList().IsBoundOnComponent(port_ref))
			return false;
	}

	return true;
}

bool bs_ActorClassList::IsUsingActorClass (bs_RoomName ac1_name, bs_RoomName ac2_name)
{
	bs_ActorClassPtr ac1 = (*this)[ac1_name];
	if (ac1)
	{
		bs_ActorClassPtr ac2 = (*this)[ac2_name];
		return ac1->IsUsingActorClass(ac2);
	}
	else
		return false;
}

bool bs_ActorClassList::HasDerivedClass (bs_ActorClassPtr base_ac)
{
	for (bs_ActorClassIterator it=begin(); it!=end(); ++it)
	{
		if ((*it)->IsDerivedFrom(base_ac))
			return true;
	}

	return false;
}

void bs_ActorClassList::RemoveAllBindingsTo (bs_ActorClassPtr ac)
{
	bs_ActorClassIterator i;
	for(i=begin(); i!=end(); i++)
	{
		bs_ActorRefList& arefs = (*i)->GetStructure().GetActorRefList();
		for (bs_ActorRefIterator aref=arefs.begin(); aref!=arefs.end(); ++aref)
		{
			if ((*aref)->GetActorClass()==ac)
			{
				bs_PortRefList& prl = ac->GetInterface().GetPortRefList();
				for (bs_PortRefIterator pref=prl.begin(); pref!=prl.end(); ++pref)
				{
					(*i)->GetStructure().GetBindingContractList().RemoveBindingsTo(*pref);
				}
			}
		}
	}
}


// ***************************************************************

DEFINE_STREAMABLE(bs_ActorClassList,"bs_Namespace")

bs_ActorClassList::bs_ActorClassList (void) :
	bs_RoomList<bs_ActorClass> ("ActorClassListDummyName")
{
}

bs_ActorClassList::bs_ActorClassList (bs_RoomName basename) :
	bs_RoomList<bs_ActorClass> (basename)
{
}

// helper class used for sorting
class GetReferencedActors
{
public:
	typedef bs_ActorClassPtr obj;
	typedef vector<obj> ObjVec;

	ObjVec operator() (const obj& ac)
	{
		ObjVec objs;
		objs.clear();

		ac->GetBaseClasses(objs);

		bs_ActorRefList& arefs = ac->GetStructure().GetActorRefList();
		for (bs_ActorRefIterator ir=arefs.begin(); ir!=arefs.end(); ++ir)
		{
			objs.push_back((*ir)->GetActorClass());
		}

		return objs;
	}
};

bs_ActorClassList::bs_ActorClassList (const bs_ActorClassList& orig, CopyType t)
:	bs_RoomList<bs_ActorClass>(orig, t)
{
}

void bs_ActorClassList::GetDependencySortedVector (vector<bs_ActorClassPtr>& result) const
{
	// (a) make a temporary vector
	vector<bs_ActorClassPtr> tmp(*this);

	// (b) sort following dependencies
	bs_GraphSort(tmp,GetReferencedActors());

	// (c) fill result
	result.clear();
	for (reverse_iterator i=tmp.rbegin(); i!=tmp.rend(); i++)
	{
		result.push_back(*i);
	}
}

void bs_ActorClassList::STREAMOBJ_WRITE(bs_ActorClassList) (bs_ObjectOStream& oos)
{
	for (iterator it=begin(); it!=end(); it++)
	{
		(*it)->GetBehaviour().GetStateMachine()->SetGeneratedIds();
	}

	WriteMembersSorted(oos);
}

void bs_ActorClassList::STREAMOBJ_READ(bs_ActorClassList) (bs_ObjectIStream& ois, Version)
{
	ReadMembers(ois);

	// loop actor classes and set pointers in actor refs
	for (iterator it=begin(); it!=end(); ++it)
	{
		(*it)->SetBaseClass(*this);

		bs_ActorRefList& arl = (*it)->GetStructure().GetActorRefList();
		for (bs_ActorRefIterator arit=arl.begin(); arit!=arl.end(); ++arit)
		{
			(*arit)->SetActorClassPtr(*this);
		}
	}

	// some clean-up
	for (it=begin(); it!=end(); ++it)
	{
		(*it)->RemoveSpuriousBindings();
	}
}




void bs_ActorClassList::ResetUsedFlags (void)
{
	bs_ActorClassIterator i;
	for(i=begin(); i!=end(); i++)
	{
		(*i)->SetUsed(false);
	}
}



void bs_ActorClassList::ResetVisitedFlags (void)
{
	bs_ActorClassIterator i;
	for(i=begin(); i!=end(); i++)
	{
		(*i)->ResetVisitedFlag();
	}
}



void bs_ActorClassList::ReadStream (int version, istream& is, bs_ProtocolClassList& pcl)
{
	bool more;

	// read actor classes (without bindings)
	is >> more;
	while (more)
	{
		push_back(new bs_ActorClass(version, is, pcl, *this));
		is >> more;
	}

	
	// read bindings
	is >> more;
	while (more)
	{
		bs_RoomName actor_name; actor_name.ReadStream(is);
		bs_ActorClassPtr actor = (*this)[actor_name];

		actor->GetStructure().GetBindingContractList().ReadStream(is, actor);
		is >> more;
	}

}

bs_CheckReport bs_ActorClassList::CheckConsistency (void)
{
	bs_CheckReport rep;

	vector<bs_ActorClassPtr> tmp;
	GetDependencySortedVector(tmp);

	// check in order of dependencies
	for (vector<bs_ActorClassPtr>::iterator it=tmp.begin(); it!=tmp.end(); it++)
	{
		bs_CheckReport actor_rep = (*it)->CheckConsistency();
		rep.AddReportSection(actor_rep,"Actor " + (*it)->GetName());
	}

	// check in order of dependencies
	for (vector<bs_ActorClassPtr>::iterator vit=tmp.begin(); vit!=tmp.end(); vit++)
	{
		(*vit)->RemoveSpuriousPorts();
	}

	return rep;
}


// ***************************************************************

void bs_ActorClass::RefreshFormalInfos (bs_ActorClassPtr actor, bool have_license)
{
	bs_StateMachinePtr toplevel_sm = actor->GetBehaviour().GetStateMachine();
	bs_StateGraph& graph = toplevel_sm->GetStateGraph();
	bs_TrSegmentList& transitions = graph.GetTrSegments();
	bs_StateList& states = graph.GetStates();

	/*
	{
		bs_SourceParser::Signals signals;
		bs_SourceParser parser(actor->GetStructure().GetPortRefList(), actor->GetStructure().GetSAPs());
		bs_TrSegmentIterator ti;
		for(ti=transitions.begin(); ti!=transitions.end(); ti++)
		{
			parser.GetSignals((*ti)->GetActionCode(), signals);
		}

		bs_StateIterator si;
		for(si=states.begin(); si!=states.end(); si++)
		{
			parser.GetSignals((*si)->GetEntryAction(), signals);
			parser.GetSignals((*si)->GetExitAction(), signals);
		}


		bs_SourceParser::Signals::iterator s;
		string txt = "Outgoing signals:\t";
		for(s=signals.begin(); s!=signals.end(); s++)
		{
			txt += s->GetSignal() + ":" + s->GetPortRef()->GetName() + "\t";
		}
		txt += "\n";
		TRACE(txt.c_str());
	}
	*/

	{
		FmlFactory factory(toplevel_sm);
		bs_AuxGraph aux_graph(graph, factory);
//		bs_SourceParser parser(actor->GetStructure().GetPortRefList(), actor->GetStructure().GetSAPs());

		// compute reachability of states, choicepoints and transitions
		{
			aux_graph.ComputeReachability();
			bs_AuxGraph::Nodes::iterator ni;
			/*
			for(si=aux_graph.GetStates().begin(); si!=aux_graph.GetStates().end(); si++)
			{
				bs_StatePtr s = si->second.GetState();
				if (s!=NULL)
				{
					bs_SourceParser::Signals signals;
					parser.GetSignals(s->GetEntryAction(), signals);
					parser.GetSignals(s->GetExitAction(), signals);
					bs_SourceParser::Signals::iterator sig;
					string txt;
					for(sig=signals.begin(); sig!=signals.end(); sig++)
					{
						if (sig!=signals.begin()) txt += ", ";
						txt += sig->GetSignal() + ":" + sig->GetPortRef()->GetName();
					}
					s->GetAnalysis()._textual_info = txt;
				}
			}
			*/
		}

		// without DEVELOP_FORMAL we will not do more ...
		if (! have_license)
			return;

		// compute outgoing signals for complete graph
		{
			/*
			bs_SourceParser::Signals signals;
			aux_graph.ComputeOutgoingSignals(actor, signals);

			bs_SourceParser::Signals::iterator s;
			string txt = "Outgoing signals:\t";
			for(s=signals.begin(); s!=signals.end(); s++)
			{
				txt += s->GetSignal() + ":" + s->GetPortRef()->GetName() + "\t";
			}
			txt += "\n";
			TRACE(txt.c_str());
			*/
		}

		// compute outstanding signals for each state
		if (graph.GetFormalCheckLevel()==bs_StateGraph::fc_full)
		{
			//bs_SourceParser::Signals signals;
			aux_graph.ComputeOutstandingSignals(actor);
		}
	}
}

template<class C>
class bs_HasPos
{
public:
	bs_HasPos (const bs_ContextCoord& pos) : _pos(pos) {}

	bool operator () (bs_RoomPtr<C>& obj)
	{
		return IsEqual(_pos, obj->GetContextCoord());
	}

private:
	static bool IsEqual (double a, double b)
	{
		return floor(a*1000)==floor(b*1000);
	}

	static bool IsEqual (bs_ContextCoord& a, bs_ContextCoord& b)
	{
		return IsEqual(a.X, b.X) && IsEqual(a.Y, b.Y);
	}

private:
	bs_ContextCoord _pos;
};

#undef max

template<class C>
static int RenameDerivedIff (bs_RoomList<C>& lst, bs_RoomPtr<C>& obj, bs_RoomPtr<C>& base_obj)
{
	if (base_obj->GetName()==obj->GetName())
		return 0;

	// have to rename inherited obj

	// check for name conflict first
	if (!lst.IsUniqueName(base_obj->GetName().c_str()))
	{
		#ifdef DEBUG_MAKE_CONSISTENT
		TRACE("    *** fix: renaming other obj %s", base_obj->GetName().c_str());
		#endif

		string new_name = lst.GetUniqueDefaultName();
		if (!lst.ChangeName(base_obj->GetName(), new_name))
		{
			HANDLE_ERROR("RenameDerivedIff - renaming other failed");
		}

		#ifdef DEBUG_MAKE_CONSISTENT
		TRACE(" to %s\n", new_name.c_str());
		#endif
	}
	
	// alright: here we go
	#ifdef DEBUG_MAKE_CONSISTENT
	TRACE("    *** fix: renaming %s to %s\n", obj->GetName().c_str(), base_obj->GetName().c_str());
	#endif

	if (!lst.ChangeName(obj->GetName(), base_obj->GetName()))
	{
		HANDLE_ERROR("RenameDerivedIff - renaming failed");
	}

	return 1;
}

template<class C, class Creator, class Matcher>
static int MakeDerivedListConsistent (bs_RoomList<C>& lst, bs_RoomList<C>& base_lst, Creator creator, Matcher match)
{
	int fixed = 0;

	int n_inherited = 0;
	{
		for (bs_RoomList<C>::iterator it2=lst.begin(); it2!=lst.end(); ++it2)
			if ((*it2)->IsInherited())
				n_inherited++;
	}

	int missing_inherited = base_lst.size()-n_inherited;
	if (missing_inherited)
		TRACE("    ### inherited mismatch (%d!=%d)\n", base_lst.size(), n_inherited);

	for (bs_RoomList<C>::iterator it=base_lst.begin(); it!=base_lst.end(); ++it)
	{
		#ifdef DEBUG_MAKE_CONSISTENT
		TRACE("--- %s ---\n", (*it)->GetName().c_str());
		#endif

		// find matching derived class object by position
		bs_RoomList<C>::iterator it_deriv = lst.end();
		double min = numeric_limits<double>::max();
		if (true)
		{
			// minimal dist^2
			for (bs_RoomList<C>::iterator it2=lst.begin(); it2!=lst.end(); ++it2)
			{
				if (!match(*it, *it2))
					continue;

				double dist2 = norm2((*it)->GetContextCoord()-(*it2)->GetContextCoord());
				if (dist2<min)
				{
					min = dist2;
					it_deriv = it2;
					if (min==0.0)
						break;
				}
			}
			#ifdef DEBUG_MAKE_CONSISTENT
			if (min!=0.0)
				TRACE("    min dist = %12.8f\n", sqrt(min));
			#endif
		}
		else
		{
			// exactly matching pos with rounding
			it_deriv = find_if(lst.begin(), lst.end(), bs_HasPos<C>((*it)->GetContextCoord()));
		}

		// require better than 1% match
		if (min>1e-4 || it_deriv==lst.end())
		{
			if (missing_inherited>0)
			{
				it_deriv = creator.GetNewObj();
				(*it_deriv)->SetInherited();

				missing_inherited--;

				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("    *** fix: added missing inherited\n");
				#endif
			}
			else
			{
				//HANDLE_ERROR("MakeDerivedListConsistent - inconsistent data structure");
				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("    missing inherited\n");
				TRACE("    searched pos (%12.8f,%12.8f)\n", (*it)->GetContextCoord().X, (*it)->GetContextCoord().Y);
				for (bs_RoomList<C>::iterator it2=lst.begin(); it2!=lst.end(); ++it2)
				{
					TRACE("                 (%12.8f,%12.8f) %s\n", (*it2)->GetContextCoord().X, (*it2)->GetContextCoord().Y, (*it2)->GetName().c_str());
				}
				#endif

				continue;
			}
		}
		if (!(*it_deriv)->IsInherited())
		{
//			HANDLE_ERROR("MakeDerivedListConsistent - inconsistent data structure");
			missing_inherited--;
			(*it_deriv)->SetInherited();
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("   *** fix: made inherited\n");
			#endif
		}

		// ensuring same pos
		(*it_deriv)->SetContextCoord((*it)->GetContextCoord());

		fixed += RenameDerivedIff(lst, *it_deriv, *it);
	}
	
	for (it=lst.begin(); it!=lst.end(); ++it)
	{
		if (!(*it)->IsInherited())
			continue;

		bs_RoomPtr<C> base_obj = base_lst[(*it)->GetName()];
		if (base_obj.IsNull())
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: %s: spurious inherited\n", (*it)->GetName().c_str());
			#endif

			(*it)->SetInherited(false);
		}
	}

	n_inherited = 0;
	{
		for (bs_RoomList<C>::iterator it2=lst.begin(); it2!=lst.end(); ++it2)
			if ((*it2)->IsInherited())
				n_inherited++;
	}

	missing_inherited = base_lst.size()-n_inherited;
	if (missing_inherited)
		TRACE("    ### still inherited mismatch (%d!=%d)\n", base_lst.size(), n_inherited);

	return fixed;
}

static int CheckInheritanceProperties (
	bs_TrSegmentPtr ts,
	bs_TrPointPtr tp,
	bs_StateMachinePtr sub_sm,
	bs_StateMachinePtr base_sm,
	bs_StateMachinePtr base_sub_sm
)
{
	if (ts->IsInherited())
	{
		int fixed = 0;
		if (!tp->IsInherited())
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: setting %s to inherited\n", tp->GetName().c_str());
			#endif

			fixed ++;
			tp->SetInherited();
		}

		bs_TrSegmentPtr base_ts = ts->GetBaseClassSegment();
		if (!base_ts)
			HANDLE_ERROR("CheckInheritanceProperties - inconsistent data structure");

		bs_TrSegmentList& base_tsl = base_sm->GetStateGraph().GetTrSegments();
		if (base_tsl.FindItem(base_ts)==base_tsl.end())
			HANDLE_ERROR("CheckInheritanceProperties - inconsistent data structure");

		bs_TrPointPtr base_tp = base_sub_sm->GetStateGraph().GetTrPoint(base_ts);
		if (!base_tp)
			HANDLE_ERROR("CheckInheritanceProperties - inconsistent data structure");

		if (tp->GetContextCoord()!=base_tp->GetContextCoord())
		{
			double dist2 = norm2(tp->GetContextCoord()-base_tp->GetContextCoord());
			if (dist2>1e-4)
			{
				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("    *** fix: setting %s to base tp position\n", tp->GetName().c_str());
				#endif

				fixed ++;
				tp->SetContextCoord(base_tp->GetContextCoord());
			}
		}
		return fixed + RenameDerivedIff(sub_sm->GetStateGraph().GetTrPoints(), tp, base_tp);
	}
	else
	{
		if (tp->IsInherited())
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: setting %s to non-inherited\n", tp->GetName().c_str());
			#endif

			tp->SetInherited(false);
			return 1;
		}
	}

	return 0;
}

static bs_TrPointPtr AddTrPoint (
	bs_TrSegmentPtr ts,
	bs_StatePtr s,
	bs_StateMachinePtr sub_sm,
	bs_StateMachinePtr base_sub_sm,
	bool is_incoming
)
{
	bs_TrPointPtr tp;

	if (ts->IsInherited())
	{
		bs_TrSegmentPtr base_ts = ts->GetBaseClassSegment();
		if (!base_ts)
			HANDLE_ERROR("AddTrPoint - inconsistent data structure");

		bs_TrPointPtr base_tp = base_sub_sm->GetStateGraph().GetTrPoint(base_ts);
		if (!base_tp)
			HANDLE_ERROR("AddTrPoint - inconsistent data structure");

		tp = sub_sm->GetStateGraph().AddNewTrPoint(ts, is_incoming);
		tp->SetInherited();

		RenameDerivedIff(sub_sm->GetStateGraph().GetTrPoints(), tp, base_tp);
	}
	else
	{
		tp = sub_sm->GetStateGraph().AddNewTrPoint(ts, is_incoming);

		int cnt = 0;
		while (true)
		{
			// use system time for unique name
			string name = tp->GetName();
			time_t tm = time(NULL);
			char buffer[32];
			sprintf(buffer, "%d%d", tm, cnt);
			name += buffer;

			if (sub_sm->GetStateGraph().GetTrPoints().ChangeName(tp->GetName(), name))
				// fine
				break;

			if (++cnt>100)
			{
				HANDLE_ERROR("AddTrPoint: inconsistent data structure");
				break;
			}
		}
	}
	tp->ComputeContextCoord(s->GetContextCoord());

	return tp;
}

class HasOutside2
{
public:
	HasOutside2(const bs_TrSegment* tseg, bool incoming) : _tseg(tseg), _incoming(incoming) { }

	bool operator() (const bs_TrPointPtr& item) const
	{
		if (item->IsNonExtending())
			return false;

		if (item->IsIncoming()!=_incoming)
			return false;

		bs_TrSegmentPtr t = item->GetOutsideTrSegment();
		return (_tseg==(const bs_TrSegment*)t);
	}

private:
	const bs_TrSegment* _tseg;
	bool _incoming;
};

static bs_TrPointPtr GetUniqueTrPoint (bs_StateGraph& sg, bs_TrSegment* outside, bool incoming)
{
	bs_TrPointList::iterator tp = find_if(sg.GetTrPoints().begin(), sg.GetTrPoints().end(), HasOutside2(outside, incoming));
	if (tp!=sg.GetTrPoints().end())
	{
		// check uniqueness
		bs_TrPointList::iterator tp2 = find_if(tp+1, sg.GetTrPoints().end(), HasOutside2(outside, incoming));
		while (tp2!=sg.GetTrPoints().end())
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: destroying %s\n", (*tp2)->GetName().c_str());
			#endif
			tp2 = sg.GetTrPoints().erase(tp2);
			tp2 = find_if(tp2, sg.GetTrPoints().end(), HasOutside2(outside, incoming));
		}

		return *tp;
	}

	return NULL;
}

static int MakeTrPointConnectivityConsistent (
	bs_StatePtr s,
	bs_StateMachinePtr sm,
	bs_StateMachinePtr base_sm,
	bs_StateMachinePtr sub_sm,
	bs_StateMachinePtr base_sub_sm
)
{
	bs_TrSegmentList& tsl = sm->GetStateGraph().GetTrSegments();
	bs_StateGraph& sub_sg = sub_sm->GetStateGraph();

	int fixed = 0;

	#ifdef DEBUG_MAKE_CONSISTENT
	TRACE("<<< MakeTrPointConnectivityConsistent >>>\n");
	#endif

	// loop outgoing trsegments of s
	for (bs_TrSegmentIterator it=tsl.GetOutgoing(s); it!=tsl.end(); it=tsl.GetOutgoing(s, it))
	{
		bs_TrPointPtr tp = GetUniqueTrPoint(sub_sg, *it, false);
		if (tp)
		{
			if (!tp->IsOutgoing())
			{
				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("    *** fix: setting %s to outgoing\n", tp->GetName().c_str());
				#endif

				++fixed;
				tp->SetOutgoing(*it);
			}
			fixed += CheckInheritanceProperties(*it, tp, sub_sm, base_sm, base_sub_sm);
		}
		else
		{
			// error: add trpoint
			++fixed;
			tp = AddTrPoint(*it, s, sub_sm, base_sub_sm, false);

			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: adding %s to outgoing\n", tp->GetName().c_str());
			#endif
		}
	}

	// loop incoming trsegments of s
	for (it=tsl.GetIncoming(s); it!=tsl.end(); it=tsl.GetIncoming(s, it))
	{
		bs_TrPointPtr tp = GetUniqueTrPoint(sub_sg, *it, true);
		if (tp)
		{
			if (!tp->IsIncoming())
			{
				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("    *** fix: setting %s to incoming\n", tp->GetName().c_str());
				#endif

				++fixed;
				tp->SetIncoming(*it);
			}
			fixed += CheckInheritanceProperties(*it, tp, sub_sm, base_sm, base_sub_sm);
		}
		else
		{
			// error: add trpoint
			++fixed;
			tp = AddTrPoint(*it, s, sub_sm, base_sub_sm, true);

			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("    *** fix: adding %s to incoming\n", tp->GetName().c_str());
			#endif
		}
	}

	return fixed;
}

class CPCreator
{
public:
	CPCreator (bs_StateGraph& sg) : _sg(sg) {}

	bs_ChoicepointIterator GetNewObj (void)
	{
		bs_ChoicepointPtr cp = _sg.AddNewChoicepoint();
		return _sg.GetChoicepoints().FindItem(cp);
	}

private:
	bs_StateGraph& _sg;
};

static bool MatchCP (bs_ChoicepointPtr&, bs_ChoicepointPtr&)
{
	return true;
}

class TrPCreator
{
public:
	TrPCreator (bs_StateGraph& sg) : _sg(sg) {}

	bs_TrPointIterator GetNewObj (void)
	{
		bs_TrPointPtr tp = _sg.AddNewTrPoint(NULL, false);
		return _sg.GetTrPoints().FindItem(tp);
	}

private:
	bs_StateGraph& _sg;
};

static bool MatchTrP (bs_TrPointPtr& tp1, bs_TrPointPtr& tp2)
{
	return tp1->IsNonExtending()==tp2->IsNonExtending();
}

static int MakeDerivedObjsConsistent (bs_StateMachinePtr sm, bs_StateMachinePtr base_sm)
{
	int fixed = 0;

	#ifdef DEBUG_MAKE_CONSISTENT
	TRACE("====== MakeDerivedObjsConsistent ======\n");
	#endif

	// choicepoints
	bs_ChoicepointList& cpl = sm->GetStateGraph().GetChoicepoints();
	bs_ChoicepointList& base_cpl = base_sm->GetStateGraph().GetChoicepoints();

	#ifdef DEBUG_MAKE_CONSISTENT
	TRACE("~~~~~~ checking choicepoints ~~~~~~\n");
	#endif
	fixed += MakeDerivedListConsistent(cpl, base_cpl, CPCreator(sm->GetStateGraph()), MatchCP);

	// trpoints
	bs_TrPointList& tpl = sm->GetStateGraph().GetTrPoints();
	bs_TrPointList& base_tpl = base_sm->GetStateGraph().GetTrPoints();

	#ifdef DEBUG_MAKE_CONSISTENT
	TRACE("~~~~~~ checking trpoints ~~~~~~\n");
	#endif
	fixed += MakeDerivedListConsistent(tpl, base_tpl, TrPCreator(sm->GetStateGraph()), MatchTrP);

	// recurse into base class states
	bs_StateList& sl = sm->GetStateGraph().GetStates();
	bs_StateList& base_sl = base_sm->GetStateGraph().GetStates();

	bs_StateContext sc(sm);
	bs_StateContext base_sc(base_sm);

	for (bs_StateIterator sit=base_sl.begin(); sit!=base_sl.end(); ++sit)
	{
		bs_StatePtr s = sl[(*sit)->GetName()];
		if (!s)
		{
			HANDLE_ERROR("MakeDerivedObjsConsistent - inconsistent data structure");
			continue;
		}
		if (!s->IsInherited())
		{
			HANDLE_ERROR("MakeDerivedObjsConsistent - inconsistent data structure");
			continue;
		}
		if (!s->HasStateMachine())
			continue;

		if (sc.OneLevelDown(s))
		{
			if (base_sc.OneLevelDown(*sit))
			{
				#ifdef DEBUG_MAKE_CONSISTENT
				TRACE("*** state %s ***\n", (*sit)->GetName().c_str());
				#endif

				fixed += MakeTrPointConnectivityConsistent(
					s,
					sm,
					base_sm,
					sc.GetStateMachine(),
					base_sc.GetStateMachine()
				);
				fixed += MakeDerivedObjsConsistent(sc.GetStateMachine(), base_sc.GetStateMachine());

				base_sc.OneLevelUp();
			}
			else
			{
				HANDLE_ERROR("MakeDerivedObjsConsistent - inconsistent data structure");
			}

			sc.OneLevelUp();
		}
		else
		{
			HANDLE_ERROR("MakeDerivedObjsConsistent - inconsistent data structure");
		}
	}

	return fixed;
}

void bs_ActorClassList::MakeDerivedObjectsConsistent (void)
{
	vector<bs_ActorClassPtr> tmp;
	GetDependencySortedVector(tmp);

	// we have to identify inherited choicepoints and trpoints in
	// derived classes with their base class counterparts and
	// make their names consistent because some commands rely
	// on this property of derived classes

	for (bs_ActorClassIterator it=tmp.begin(); it!=tmp.end(); ++it)
	{
		if (!(*it)->IsDerived())
			continue;

		// the base class is already fixed
		// recusrively descend into state machines
		bs_StateMachinePtr sm = (*it)->GetBehaviour().GetStateMachine();
		bs_StateMachinePtr base_sm = (*it)->GetBaseClass()->GetBehaviour().GetStateMachine();

		#ifdef DEBUG_MAKE_CONSISTENT
		TRACE("### actor class %s ###\n", (*it)->GetName().c_str());
		TRACE("*** state TOP ***\n");
		#endif

		int fixed = MakeDerivedObjsConsistent(sm, base_sm);

		if (fixed)
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("### %d fixes made \n\n", fixed);
			#endif

			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("### second run ### \n\n");
			#endif
			
			int fixed2 = MakeDerivedObjsConsistent(sm, base_sm);
			if (fixed2)
				TRACE("### still %d problems ### \n\n", fixed2);

			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("### second run end ### \n\n");
			#endif

			if (fixed2)
			{
				string msg =
					"Actor class '" + (*it)->GetName() + "' had inconsistencies\n"
					"WHICH COULD NOT BE REOLVED.\n\n"
					"Please send project file and version number of Trice to support@protos.de!\n";
				
				bs_ErrorHdlr::Get()->Handle(
					bs_ErrorHdlr::error,
					msg.c_str(),
					__FILE__,
					__LINE__
				);
			}
			else
			{
				char buf[32];
				sprintf(buf, "%d", fixed);
				string msg =
					"Actor class '" + (*it)->GetName() + "' had " + buf + " inconsistencies\n"
					"in derived Choicepoints and/or TrPoints.\n\n"
					"These problems have been fixed!\n";
				
				bs_ErrorHdlr::Get()->Handle(
					bs_ErrorHdlr::error,
					msg.c_str(),
					__FILE__,
					__LINE__
				);
			}
		}
		else
		{
			#ifdef DEBUG_MAKE_CONSISTENT
			TRACE("### ok\n\n");
			#endif
		}
	}
}

// **************************************************************
