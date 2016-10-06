package org.eclipse.etrice.generator.generic;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.etrice.core.common.base.Annotation;
import org.eclipse.etrice.core.common.base.AnnotationType;
import org.eclipse.etrice.core.etmap.eTMap.ETMapFactory;
import org.eclipse.etrice.core.etmap.eTMap.Mapping;
import org.eclipse.etrice.core.etmap.eTMap.MappingModel;
import org.eclipse.etrice.core.etmap.eTMap.SubSystemMapping;
import org.eclipse.etrice.core.etphys.eTPhys.NodeRef;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalModel;
import org.eclipse.etrice.core.etphys.eTPhys.PhysicalSystem;
import org.eclipse.etrice.core.genmodel.fsm.base.ILogger;
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
  public boolean createInstancesAndMapping(final ResourceSet rs) {
    boolean _xblockexpression = false;
    {
      final ArrayList<RoomModel> roomModels = CollectionLiterals.<RoomModel>newArrayList();
      final ArrayList<PhysicalModel> physModels = CollectionLiterals.<PhysicalModel>newArrayList();
      EList<Resource> _resources = rs.getResources();
      final Consumer<Resource> _function = new Consumer<Resource>() {
        public void accept(final Resource it) {
          EList<EObject> _contents = it.getContents();
          final Function1<EObject, Boolean> _function = new Function1<EObject, Boolean>() {
            public Boolean apply(final EObject it) {
              boolean _switchResult = false;
              boolean _matched = false;
              if (!_matched) {
                if (it instanceof RoomModel) {
                  _matched=true;
                  _switchResult = roomModels.add(((RoomModel)it));
                }
              }
              if (!_matched) {
                if (it instanceof PhysicalModel) {
                  _matched=true;
                  _switchResult = physModels.add(((PhysicalModel)it));
                }
              }
              return Boolean.valueOf(_switchResult);
            }
          };
          IterableExtensions.<EObject>forall(_contents, _function);
        }
      };
      _resources.forEach(_function);
      ArrayList<SubSystemClass> _newArrayList = CollectionLiterals.<SubSystemClass>newArrayList();
      final Function2<ArrayList<SubSystemClass>, RoomModel, ArrayList<SubSystemClass>> _function_1 = new Function2<ArrayList<SubSystemClass>, RoomModel, ArrayList<SubSystemClass>>() {
        public ArrayList<SubSystemClass> apply(final ArrayList<SubSystemClass> list, final RoomModel model) {
          EList<SubSystemClass> _subSystemClasses = model.getSubSystemClasses();
          final Function1<SubSystemClass, Boolean> _function = new Function1<SubSystemClass, Boolean>() {
            public Boolean apply(final SubSystemClass it) {
              return Boolean.valueOf(TestInstanceCreator.this.hasTestAnnotation(it));
            }
          };
          Iterable<SubSystemClass> _filter = IterableExtensions.<SubSystemClass>filter(_subSystemClasses, _function);
          Iterables.<SubSystemClass>addAll(list, _filter);
          return list;
        }
      };
      final ArrayList<SubSystemClass> allTestSubSystems = IterableExtensions.<RoomModel, ArrayList<SubSystemClass>>fold(roomModels, _newArrayList, _function_1);
      final List<StructureClass> allAnnotatedClasses = CollectionLiterals.<StructureClass>newArrayList(((StructureClass[])Conversions.unwrapArray(allTestSubSystems, StructureClass.class)));
      {
        SubSystemClass _createSubSystemClass = this._roomFactory.createSubSystemClass();
        final Procedure1<SubSystemClass> _function_2 = new Procedure1<SubSystemClass>() {
          public void apply(final SubSystemClass it) {
            it.setName("DerivedTestSubSystem");
          }
        };
        final SubSystemClass derivedSubSystem = ObjectExtensions.<SubSystemClass>operator_doubleArrow(_createSubSystemClass, _function_2);
        final Consumer<RoomModel> _function_3 = new Consumer<RoomModel>() {
          public void accept(final RoomModel model) {
            EList<ActorRef> _actorRefs = derivedSubSystem.getActorRefs();
            EList<ActorClass> _actorClasses = model.getActorClasses();
            final Function1<ActorClass, Boolean> _function = new Function1<ActorClass, Boolean>() {
              public Boolean apply(final ActorClass it) {
                return Boolean.valueOf(TestInstanceCreator.this.hasTestAnnotation(it));
              }
            };
            Iterable<ActorClass> _filter = IterableExtensions.<ActorClass>filter(_actorClasses, _function);
            final Function1<ActorClass, ActorRef> _function_1 = new Function1<ActorClass, ActorRef>() {
              public ActorRef apply(final ActorClass ac) {
                ActorRef _xblockexpression = null;
                {
                  allAnnotatedClasses.add(ac);
                  ActorRef _createActorRef = TestInstanceCreator.this._roomFactory.createActorRef();
                  final Procedure1<ActorRef> _function = new Procedure1<ActorRef>() {
                    public void apply(final ActorRef it) {
                      String _name = ac.getName();
                      String _plus = ("ref_" + _name);
                      it.setName(_plus);
                      it.setType(ac);
                    }
                  };
                  _xblockexpression = ObjectExtensions.<ActorRef>operator_doubleArrow(_createActorRef, _function);
                }
                return _xblockexpression;
              }
            };
            Iterable<ActorRef> _map = IterableExtensions.<ActorClass, ActorRef>map(_filter, _function_1);
            Iterables.<ActorRef>addAll(_actorRefs, _map);
          }
        };
        roomModels.forEach(_function_3);
        EList<ActorRef> _actorRefs = derivedSubSystem.getActorRefs();
        boolean _isEmpty = _actorRefs.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          allTestSubSystems.add(derivedSubSystem);
        }
      }
      boolean _isEmpty = allTestSubSystems.isEmpty();
      if (_isEmpty) {
        return true;
      }
      int _size = allAnnotatedClasses.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        final Consumer<StructureClass> _function_2 = new Consumer<StructureClass>() {
          public void accept(final StructureClass roomCls) {
            StringConcatenation _builder = new StringConcatenation();
            _builder.append("TestInstanceCreator: mapping failed, multiple test instances present");
            TestInstanceCreator.this.logger.logError(_builder.toString(), roomCls);
          }
        };
        allAnnotatedClasses.forEach(_function_2);
        return false;
      }
      ArrayList<PhysicalSystem> _newArrayList_1 = CollectionLiterals.<PhysicalSystem>newArrayList();
      final Function2<ArrayList<PhysicalSystem>, PhysicalModel, ArrayList<PhysicalSystem>> _function_3 = new Function2<ArrayList<PhysicalSystem>, PhysicalModel, ArrayList<PhysicalSystem>>() {
        public ArrayList<PhysicalSystem> apply(final ArrayList<PhysicalSystem> list, final PhysicalModel model) {
          EList<PhysicalSystem> _systems = model.getSystems();
          Iterables.<PhysicalSystem>addAll(list, _systems);
          return list;
        }
      };
      final List<PhysicalSystem> allPhysSystems = IterableExtensions.<PhysicalModel, ArrayList<PhysicalSystem>>fold(physModels, _newArrayList_1, _function_3);
      int _size_1 = allPhysSystems.size();
      boolean _notEquals = (_size_1 != 1);
      if (_notEquals) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("TestInstanceCreator: mapping failed, found ");
        int _size_2 = allPhysSystems.size();
        _builder.append(_size_2, "");
        _builder.append(" physical systems");
        this.logger.logError(_builder.toString(), null);
        return false;
      }
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("TestInstanceCreator: creating instance and mapping for ");
      StructureClass _head = IterableExtensions.<StructureClass>head(allAnnotatedClasses);
      String _name = _head.getName();
      _builder_1.append(_name, "");
      _builder_1.append(":");
      StructureClass _head_1 = IterableExtensions.<StructureClass>head(allAnnotatedClasses);
      EClass _eClass = _head_1.eClass();
      String _name_1 = _eClass.getName();
      _builder_1.append(_name_1, "");
      this.logger.logInfo(_builder_1.toString());
      final PhysicalSystem physSystem = IterableExtensions.<PhysicalSystem>head(allPhysSystems);
      final SubSystemClass testSubSystem = IterableExtensions.<SubSystemClass>head(allTestSubSystems);
      LogicalSystem _createLogicalSystem = this._roomFactory.createLogicalSystem();
      final Procedure1<LogicalSystem> _function_4 = new Procedure1<LogicalSystem>() {
        public void apply(final LogicalSystem it) {
          it.setName("DerivedTestSystem");
        }
      };
      final LogicalSystem testSystem = ObjectExtensions.<LogicalSystem>operator_doubleArrow(_createLogicalSystem, _function_4);
      EList<SubSystemRef> _subSystems = testSystem.getSubSystems();
      SubSystemRef _createSubSystemRef = this._roomFactory.createSubSystemRef();
      final Procedure1<SubSystemRef> _function_5 = new Procedure1<SubSystemRef>() {
        public void apply(final SubSystemRef it) {
          String _name = testSubSystem.getName();
          String _plus = ("ref_" + _name);
          it.setName(_plus);
          it.setType(testSubSystem);
        }
      };
      SubSystemRef _doubleArrow = ObjectExtensions.<SubSystemRef>operator_doubleArrow(_createSubSystemRef, _function_5);
      _subSystems.add(_doubleArrow);
      RoomModel _createRoomModel = this._roomFactory.createRoomModel();
      final Procedure1<RoomModel> _function_6 = new Procedure1<RoomModel>() {
        public void apply(final RoomModel it) {
          it.setName("DerivedTestRoomModel");
          EList<LogicalSystem> _systems = it.getSystems();
          _systems.add(testSystem);
          EList<SubSystemClass> _subSystemClasses = it.getSubSystemClasses();
          _subSystemClasses.add(testSubSystem);
        }
      };
      final RoomModel testRoomModel = ObjectExtensions.<RoomModel>operator_doubleArrow(_createRoomModel, _function_6);
      MappingModel _createMappingModel = this._eTMapFactory.createMappingModel();
      final Procedure1<MappingModel> _function_7 = new Procedure1<MappingModel>() {
        public void apply(final MappingModel it) {
          it.setName("DerivedTestMappingModel");
          EList<Mapping> _mappings = it.getMappings();
          Mapping _createMapping = TestInstanceCreator.this._eTMapFactory.createMapping();
          final Procedure1<Mapping> _function = new Procedure1<Mapping>() {
            public void apply(final Mapping it) {
              it.setLogicalSys(testSystem);
              it.setPhysicalSys(physSystem);
              EList<SubSystemMapping> _subsysMappings = it.getSubsysMappings();
              EList<SubSystemRef> _subSystems = testSystem.getSubSystems();
              final Function1<SubSystemRef, SubSystemMapping> _function = new Function1<SubSystemRef, SubSystemMapping>() {
                public SubSystemMapping apply(final SubSystemRef subSysRef) {
                  SubSystemMapping _createSubSystemMapping = TestInstanceCreator.this._eTMapFactory.createSubSystemMapping();
                  final Procedure1<SubSystemMapping> _function = new Procedure1<SubSystemMapping>() {
                    public void apply(final SubSystemMapping it) {
                      it.setLogicalSubSys(subSysRef);
                      EList<NodeRef> _nodeRefs = physSystem.getNodeRefs();
                      NodeRef _head = IterableExtensions.<NodeRef>head(_nodeRefs);
                      it.setNode(_head);
                    }
                  };
                  return ObjectExtensions.<SubSystemMapping>operator_doubleArrow(_createSubSystemMapping, _function);
                }
              };
              List<SubSystemMapping> _map = ListExtensions.<SubSystemRef, SubSystemMapping>map(_subSystems, _function);
              Iterables.<SubSystemMapping>addAll(_subsysMappings, _map);
            }
          };
          Mapping _doubleArrow = ObjectExtensions.<Mapping>operator_doubleArrow(_createMapping, _function);
          _mappings.add(_doubleArrow);
        }
      };
      final MappingModel testMappingModel = ObjectExtensions.<MappingModel>operator_doubleArrow(_createMappingModel, _function_7);
      Resource _xifexpression = null;
      Resource _eResource = testSubSystem.eResource();
      boolean _notEquals_1 = (!Objects.equal(_eResource, null));
      if (_notEquals_1) {
        _xifexpression = testSubSystem.eResource();
      } else {
        EList<ActorRef> _actorRefs = testSubSystem.getActorRefs();
        ActorRef _head_2 = IterableExtensions.<ActorRef>head(_actorRefs);
        ActorClass _type = null;
        if (_head_2!=null) {
          _type=_head_2.getType();
        }
        Resource _eResource_1 = null;
        if (_type!=null) {
          _eResource_1=_type.eResource();
        }
        _xifexpression = _eResource_1;
      }
      final Resource existingResource = _xifexpression;
      URI _uRI = existingResource.getURI();
      URI _trimFileExtension = _uRI.trimFileExtension();
      final URI uriPath = _trimFileExtension.trimSegments(1);
      URI _appendSegment = uriPath.appendSegment("DerivedTestMappingModel");
      URI _appendFileExtension = _appendSegment.appendFileExtension("etmap");
      Resource _createResource = rs.createResource(_appendFileExtension);
      EList<EObject> _contents = _createResource.getContents();
      _contents.add(testMappingModel);
      URI _appendSegment_1 = uriPath.appendSegment("DerivedTestRoomModel");
      URI _appendFileExtension_1 = _appendSegment_1.appendFileExtension("room");
      Resource _createResource_1 = rs.createResource(_appendFileExtension_1);
      EList<EObject> _contents_1 = _createResource_1.getContents();
      _xblockexpression = _contents_1.add(testRoomModel);
    }
    return _xblockexpression;
  }
  
  protected boolean hasTestAnnotation(final StructureClass cls) {
    EList<Annotation> _annotations = cls.getAnnotations();
    final Function1<Annotation, Boolean> _function = new Function1<Annotation, Boolean>() {
      public Boolean apply(final Annotation it) {
        AnnotationType _type = it.getType();
        String _name = _type.getName();
        return Boolean.valueOf(Objects.equal(_name, TestInstanceCreator.ANNOTATION_TYPE_NAME));
      }
    };
    return IterableExtensions.<Annotation>exists(_annotations, _function);
  }
  
  public TestInstanceCreator(final ILogger logger) {
    super();
    this.logger = logger;
  }
}
