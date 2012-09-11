
package org.eclipse.etrice.integration.ConfigTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.etrice.runtime.java.config.VariableService;
import org.eclipse.etrice.runtime.java.config.ConfigSourceFile;
import org.eclipse.etrice.integration.ConfigTest.*;


public class SubSystemConfigTestVariableService extends VariableService{
	
	private SubSystemConfigTest subSystem;
	
	// Actor instances
	private DynTestee_ac _top_testee2;
	
	public SubSystemConfigTestVariableService(SubSystemConfigTest subSystem) {
		super(new ConfigSourceFile("tmp/subSystemConfigTest"));
		this.subSystem = subSystem;
	}
	
	@Override
	protected void initInstances(){
		_top_testee2 = (DynTestee_ac)subSystem.getInstance("/SubSystemConfigTest/top/testee2");
	}
	

	@Override
	protected void setAttributeValues(Map<String, Object> values) {
		Object object;
		String id = null;
		try{
			boolean changed = false;
			id = "/SubSystemConfigTest/top/testee2/int_i";
			Integer _int_i = null;
			object = values.get(id);
			if(object != null){
				_int_i = ensureInt(object);
				if(!_int_i.equals((Integer)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(_top_testee2.getInt_iLock()){
					if(_top_testee2.getInt_iLock().isUpdate()){
						if(_int_i != null){
							_top_testee2.setInt_i(_int_i);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/int_i", _int_i);
						}
					} 
				}
		}catch(IllegalArgumentException e){
			error(id, e);
		}
		try{
			boolean changed = false;
			id = "/SubSystemConfigTest/top/testee2/dc_i/long_array_i";
			long[] _long_array_i = null;
			object = values.get(id);
			if(object != null){
				_long_array_i = ensureLongArray(object, 1);
				if(!Arrays.equals(_long_array_i, (long[])getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/dc_i/double_i";
			Double _double_i = null;
			object = values.get(id);
			if(object != null){
				_double_i = ensureDouble(object);
				if(!_double_i.equals((Double)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/dc_i/char_i";
			char[] _char_i = null;
			object = values.get(id);
			if(object != null){
				_char_i = ensureCharArray(object, 10);
				if(!Arrays.equals(_char_i, (char[])getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/int_i";
			Integer _int_i = null;
			object = values.get(id);
			if(object != null){
				_int_i = ensureInt(object);
				if(!_int_i.equals((Integer)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(_top_testee2.getDc_iLock()){
					if(_top_testee2.getDc_iLock().isUpdate()){
						if(_long_array_i != null){
							_top_testee2.getDc_i().setLong_array_i(_long_array_i);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/dc_i/long_array_i", _long_array_i);
						}
						if(_double_i != null){
							_top_testee2.getDc_i().getDc_i().setDouble_i(_double_i);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/double_i", _double_i);
						}
						if(_char_i != null){
							_top_testee2.getDc_i().getDc_i().setChar_i(_char_i);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/char_i", _char_i);
						}
						if(_int_i != null){
							_top_testee2.getDc_i().setInt_i(_int_i);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/dc_i/int_i", _int_i);
						}
					} 
				}
		}catch(IllegalArgumentException e){
			error(id, e);
		}
		try{
			boolean changed = false;
			id = "/SubSystemConfigTest/top/testee2/blockMe";
			Integer _blockMe = null;
			object = values.get(id);
			if(object != null){
				_blockMe = ensureInt(object);
				if(!_blockMe.equals((Integer)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(_top_testee2.getBlockMeLock()){
					if(_top_testee2.getBlockMeLock().isUpdate()){
						if(_blockMe != null){
							_top_testee2.setBlockMe(_blockMe);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/blockMe", _blockMe);
						}
					} 
				}
		}catch(IllegalArgumentException e){
			error(id, e);
		}
		try{
			boolean changed = false;
			id = "/SubSystemConfigTest/top/testee2/blocker";
			Boolean _blocker = null;
			object = values.get(id);
			if(object != null){
				_blocker = ensureBoolean(object);
				if(!_blocker.equals((Boolean)getDiffMap().get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(_top_testee2.getBlockerLock()){
					if(_top_testee2.getBlockerLock().isUpdate()){
						if(_blocker != null){
							_top_testee2.setBlocker(_blocker);
							getDiffMap().put("/SubSystemConfigTest/top/testee2/blocker", _blocker);
						}
					} 
				}
		}catch(IllegalArgumentException e){
			error(id, e);
		}
	}
	
	@Override
	protected Map<String, Object> getAttributeValues(){
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("/SubSystemConfigTest/top/testee2/int_i", _top_testee2.getInt_i());
		values.put("/SubSystemConfigTest/top/testee2/dc_i/long_array_i", toObjectArray(_top_testee2.getDc_i().getLong_array_i()));
		values.put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/double_i", _top_testee2.getDc_i().getDc_i().getDouble_i());
		values.put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/char_i", toObjectArray(_top_testee2.getDc_i().getDc_i().getChar_i()));
		values.put("/SubSystemConfigTest/top/testee2/dc_i/int_i", _top_testee2.getDc_i().getInt_i());
		values.put("/SubSystemConfigTest/top/testee2/blockMe", _top_testee2.getBlockMe());
		values.put("/SubSystemConfigTest/top/testee2/blocker", _top_testee2.getBlocker());
		
		return values;
	}
	
	@Override
	public void writeDataClass(String id, Object dcObject, Map<String, Object> writeMap) {
		if(dcObject.getClass().equals(Dyn_DC1.class))
			writeDataClass(id, (Dyn_DC1) dcObject, writeTasks);
	}
	
	// DataClasses write operations
	
	private void writeDataClass(String id, Dyn_DC1 object, Map<String, Object> map){
		map.put(id+"/int_i", object.getInt_i());
		map.put(id+"/long_array_i", toObjectArray(object.getLong_array_i()));
		writeDataClass(id+"/dc_i", object.getDc_i(), map);
	}
	private void writeDataClass(String id, Dyn_DC2 object, Map<String, Object> map){
		map.put(id+"/double_i", object.getDouble_i());
		map.put(id+"/char_i", toObjectArray(object.getChar_i()));
	}
	
	@Override
	protected int getPollingTimerUser(){
		return 4000;
	}
	
}
