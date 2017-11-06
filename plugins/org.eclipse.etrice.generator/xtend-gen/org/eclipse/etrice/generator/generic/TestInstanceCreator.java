package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.etmap.eTMap.ETMapFactory;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.genmodel.fsm.ILogger;
import org.eclipse.etrice.core.room.ActorClass;
import org.eclipse.etrice.core.room.ActorRef;
import org.eclipse.etrice.core.room.LogicalSystem;
import org.eclipse.etrice.core.room.RoomFactory;
import org.eclipse.etrice.core.room.RoomModel;
import org.eclipse.etrice.core.room.StructureClass;
import org.eclipse.etrice.core.room.SubSystemClass;
import org.eclipse.etrice.core.room.SubSystemRef;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class TestInstanceCreator {
  private final static String ANNOTATION_TYPE_NAME = "TestInstance";
  
  @Extension
  private final RoomFactory _roomFactory = RoomFactory.eINSTANCE;
  
  @Extension
  private final ETMapFactory _eTMapFactory = ETMapFactory.eINSTANCE;
  
  private final ILogger logger;
  
  /**
   * Creates instance and mapping for classes having <code>@TestInstance</code> annotation:
   * <p>
   * a) In case of a single SubSystemClass, a new LogicalSystem with a SubSystemRef will be created<br>
   * b) For ActorClasses, one new SubSystem- and LogicalSystem with necessary refs will be created</br>
   * Resulting ROOM classes are stored in new RoomModel within a new memory-only resource.</br>
   * Resulting mapping is stored in a new MappingModel within a new memory-only resource.</br>
   * </p>
   * 
   * Note: currently only one class having <code>@TestInstance</code> annotation is supported
   * 
   * @param rs ResourceSet for new resources
   * @return false, if creation failed and generation should stop
   */
  public List<Resource> createInstancesAndMapping(final ResourceSet rs) {
    final ArrayList<RoomModel> roomModels = CollectionLiterals.<RoomModel>newArrayList();
    final ArrayList<PhysicalModel> physModels = CollectionLiterals.<PhysicalModel>newArrayList();
    final Consumer<Resource> _function = (Resource it) -> {
      final Function1<EObject, Boolean> _function_1 = (EObject it_1) -> {
        boolean _switchResult = false;
        boolean _matched = false;
        if (it_1 instanceof RoomModel) {
          _matched=true;
          _switchResult = roomModels.add(((RoomModel)it_1));
        }
        if (!_matched) {
          if (it_1 instanceof PhysicalModel) {
            _matched=true;
            _switchResult = physModels.add(((PhysicalModel)it_1));
          }
        }
        return Boolean.valueOf(_switchResult);
      };
      IterableExtensions.<EObject>forall(it.getContents(), _function_1);
    };
    rs.getResources().forEach(_function);
    final Function2<ArrayList<SubSystemClass>, RoomModel, ArrayList<SubSystemClass>> _function_1 = (ArrayList<SubSystemClass> list, RoomModel model) -> {
      final Function1<SubSystemClass, Boolean> _function_2 = (SubSystemClass it) -> {
        return Boolean.valueOf(this.hasTestAnnotation(it));
      };
      Iterable<SubSystemClass> _filter = IterableExtensions.<SubSystemClass>filter(model.getSubSystemClasses(), _function_2);
      Iterables.<SubSystemClass>addAll(list, _filter);
      return list;
    };
    final ArrayList<SubSystemClass> allTestSubSystems = IterableExtensions.<RoomModel, ArrayList<SubSystemClass>>fold(roomModels, CollectionLiterals.<SubSystemClass>newArrayList(), _function_1);
    final List<StructureClass> allAnnotatedClasses = CollectionLiterals.<StructureClass>newArrayList(((StructureClass[])Conversions.unwrapArray(allTestSubSystems, StructureClass.class)));
    final ArrayList<Resource> result = CollectionLiterals.<Resource>newArrayList();
    {
      SubSystemClass _createSubSystemClass = this._roomFactory.createSubSystemClass();
      final Procedure1<SubSystemClass> _function_2 = (SubSystemClass it) -> {
        it.setName("DerivedTestSubSystem");
      };
      final SubSystemClass derivedSubSystem = ObjectExtensions.<SubSystemClass>operator_doubleArrow(_createSubSystemClass, _function_2);
      final Consumer<RoomModel> _function_3 = (RoomModel model) -> {
        EList<ActorRef> _actorRefs = derivedSubSystem.getActorRefs();
        final Function1<ActorClass, Boolean> _function_4 = (ActorClass it) -> {
          return Boolean.valueOf(this.hasTestAnnotation(it));
        };
        final Function1<ActorClass, ActorRef> _function_5 = (ActorClass ac) -> {
          ActorRef _xblockexpression = null;
          {
            allAnnotatedClasses.add(ac);
            ActorRef _createActorRef = this._roomFactory.createActorRef();
            final Procedure1<ActorRef> _function_6 = (ActorRef it) -> {
              String _name = ac.getName();
              String _plus = ("ref_" + _name);
              it.setName(_plus);
              it.setType(ac);
            };
            _xblockexpression = ObjectExtensions.<ActorRef>operator_doubleArrow(_createActorRef, _function_6);
          }
          return _xblockexpression;
        };
        Iterable<ActorRef> _map = IterableExtensions.<ActorClass, ActorRef>map(IterableExtensions.<ActorClass>filter(model.getActorClasses(), _function_4), _function_5);
        Iterables.<ActorRef>addAll(_actorRefs, _map);
      };
      roomModels.forEach(_function_3);
      boolean _isEmpty = derivedSubSystem.getActorRefs().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        allTestSubSystems.add(derivedSubSystem);
      }
    }
    boolean _isEmpty = allTestSubSystems.isEmpty();
    if (_isEmpty) {
      return result;
    }
    int _size = allAnnotatedClasses.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      final Consumer<StructureClass> _function_2 = (StructureClass roomCls) -> {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("TestInstanceCreator: mapping failed, multiple test instances present");
        this.logger.logError(_builder.toString(), roomCls);
      };
      allAnnotatedClasses.forEach(_function_2);
      return null;
    }
    final Function2<ArrayList<PhysicalSystem>, PhysicalModel, ArrayList<PhysicalSystem>> _function_3 = (ArrayList<PhysicalSystem> list, PhysicalModel model) -> {
      EList<PhysicalSystem> _systems = model.getSystems();
      Iterables.<PhysicalSystem>addAll(list, _systems);
      return list;
    };
    final List<PhysicalSystem> allPhysSystems = IterableExtensions.<PhysicalModel, ArrayList<PhysicalSystem>>fold(physModels, CollectionLiterals.<PhysicalSystem>newArrayList(), _function_3);
    int _size_1 = allPhysSystems.size();
    boolean _notEquals = (_size_1 != 1);
    if (_notEquals) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("TestInstanceCreator: mapping failed, found ");
      int _size_2 = allPhysSystems.size();
      _builder.append(_size_2);
      _builder.append(" physical systems");
      this.logger.logError(_builder.toString(), null);
      return null;
    }
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("TestInstanceCreator: creating instance and mapping for ");
    String _name = IterableExtensions.<StructureClass>head(allAnnotatedClasses).getName();
    _builder_1.append(_name);
    _builder_1.append(":");
    String _name_1 = IterableExtensions.<StructureClass>head(allAnnotatedClasses).eClass().getName();
    _builder_1.append(_name_1);
    this.logger.logInfo(_builder_1.toString());
    final PhysicalSystem physSystem = IterableExtensions.<PhysicalSystem>head(allPhysSystems);
    final SubSystemClass testSubSystem = IterableExtensions.<SubSystemClass>head(allTestSubSystems);
    LogicalSystem _createLogicalSystem = this._roomFactory.createLogicalSystem();
    final Procedure1<LogicalSystem> _function_4 = (LogicalSystem it) -> {
      it.setName("DerivedTestSystem");
    };
    final LogicalSystem testSystem = ObjectExtensions.<LogicalSystem>operator_doubleArrow(_createLogicalSystem, _function_4);
    EList<SubSystemRef> _subSystems = testSystem.getSubSystems();
    SubSystemRef _createSubSystemRef = this._roomFactory.createSubSystemRef();
    final Procedure1<SubSystemRef> _function_5 = (SubSystemRef it) -> {
      String _name_2 = testSubSystem.getName();
      String _plus = ("ref_" + _name_2);
      it.setName(_plus);
      it.setType(testSubSystem);
    };
    SubSystemRef _doubleArrow = ObjectExtensions.<SubSystemRef>operator_doubleArrow(_createSubSystemRef, _function_5);
    _subSystems.add(_doubleArrow);
    RoomModel _createRoomModel = this._roomFactory.createRoomModel();
    final Procedure1<RoomModel> _function_6 = (RoomModel it) -> {
      it.setName("DerivedTestRoomModel");
      EList<LogicalSystem> _systems = it.getSystems();
      _systems.add(testSystem);
      Resource _eResource = testSubSystem.eResource();
      boolean _tripleEquals = (_eResource == null);
      if (_tripleEquals) {
        EList<SubSystemClass> _subSystemClasses = it.getSubSystemClasses();
        _subSystemClasses.add(testSubSystem);
      }
    };
    final RoomModel testRoomModel = ObjectExtensions.<RoomModel>operator_doubleArrow(_createRoomModel, _function_6);
    MappingModel _createMappingModel = this._eTMapFactory.createMappingModel();
    final Procedure1<MappingModel> _function_7 = (MappingModel it) -> {
      it.setName("DerivedTestMappingModel");
      EList<Mapping> _mappings = it.getMappings();
      Mapping _createMapping = this._eTMapFactory.createMapping();
      final Procedure1<Mapping> _function_8 = (Mapping it_1) -> {
        it_1.setLogicalSys(testSystem);
        it_1.setPhysicalSys(physSystem);
        EList<SubSystemMapping> _subsysMappings = it_1.getSubsysMappings();
        final Function1<SubSystemRef, SubSystemMapping> _function_9 = (SubSystemRef subSysRef) -> {
          SubSystemMapping _createSubSystemMapping = this._eTMapFactory.createSubSystemMapping();
          final Procedure1<SubSystemMapping> _function_10 = (SubSystemMapping it_2) -> {
            it_2.setLogicalSubSys(subSysRef);
            it_2.setNode(IterableExtensions.<NodeRef>head(physSystem.getNodeRefs()));
          };
          return ObjectExtensions.<SubSystemMapping>operator_doubleArrow(_createSubSystemMapping, _function_10);
        };
        List<SubSystemMapping> _map = ListExtensions.<SubSystemRef, SubSystemMapping>map(testSystem.getSubSystems(), _function_9);
        Iterables.<SubSystemMapping>addAll(_subsysMappings, _map);
      };
      Mapping _doubleArrow_1 = ObjectExtensions.<Mapping>operator_doubleArrow(_createMapping, _function_8);
      _mappings.add(_doubleArrow_1);
    };
    final MappingModel testMappingModel = ObjectExtensions.<MappingModel>operator_doubleArrow(_createMappingModel, _function_7);
    Resource _xifexpression = null;
    Resource _eResource = testSubSystem.eResource();
    boolean _tripleNotEquals = (_eResource != null);
    if (_tripleNotEquals) {
      _xifexpression = testSubSystem.eResource();
    } else {
      _xifexpression = IterableExtensions.<StructureClass>head(allAnnotatedClasses).eResource();
    }
    final Resource existingResource = _xifexpression;
    final URI uriPath = existingResource.getURI().trimFileExtension().trimSegments(1);
    Resource res = rs.createResource(uriPath.appendSegment("DerivedTestMappingModel").appendFileExtension("etmap"));
    EList<EObject> _contents = res.getContents();
    _contents.add(testMappingModel);
    result.add(res);
    res = rs.createResource(uriPath.appendSegment("DerivedTestRoomModel").appendFileExtension("room"));
    EList<EObject> _contents_1 = res.getContents();
    _contents_1.add(testRoomModel);
    result.add(res);
    return result;
  }
  
  protected boolean hasTestAnnotation(final StructureClass cls) {
    final Function1<Annotation, Boolean> _function = (Annotation it) -> {
      String _name = it.getType().getName();
      return Boolean.valueOf(Objects.equal(_name, TestInstanceCreator.ANNOTATION_TYPE_NAME));
    };
    return IterableExtensions.<Annotation>exists(cls.getAnnotations(), _function);
  }
  
  public TestInstanceCreator(final ILogger logger) {
    super();
    this.logger = logger;
  }
}
