
package org.eclipse.etrice.integration.ConfigTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.etrice.runtime.java.config.VariableService;
import org.eclipse.etrice.runtime.java.config.ConfigSourceFile
		;

public class SubSystemConfigTestVariableService extends VariableService{
	
	private SubSystemConfigTest subSystem;
	private Map<String, Object> diffMap;
	
	// Actor instances			
	private DynTestee_ac testee2;
	
	public SubSystemConfigTestVariableService(SubSystemConfigTest subSystem) {
		this.subSystem = subSystem;
		source = new ConfigSourceFile("tmp/subSystemConfigTest");
		diffMap = new HashMap<String, Object>();
	}
	
	@Override
	protected void getInstances(){
		testee2 = (DynTestee_ac)subSystem.getInstance("/SubSystemConfigTest/top/testee2");
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
				if(!_int_i.equals((Integer)diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(testee2.getInt_iLock()){
					if(testee2.getInt_iLock().isUpdate()){
						if(_int_i != null){
							testee2.setInt_i(_int_i);
							diffMap.put("/SubSystemConfigTest/int_i", _int_i);
						}
					} 
				}
		}catch(IllegalArgumentException e){
			error(id, e);
		}
		try{
			boolean changed = false;
			id = "/SubSystemConfigTest/top/testee2/dc_i/dc_i/char_i";
			char[] _char_i = null;
			object = values.get(id);
			if(object != null){
				_char_i = ensureCharArray(object, 10);
				if(!Arrays.equals(_char_i, (char[])diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/long_array_i";
			long[] _long_array_i = null;
			object = values.get(id);
			if(object != null){
				_long_array_i = ensureLongArray(object, 1);
				if(!Arrays.equals(_long_array_i, (long[])diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/dc_i/double_i";
			Double _double_i = null;
			object = values.get(id);
			if(object != null){
				_double_i = ensureDouble(object);
				if(!_double_i.equals((Double)diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			id = "/SubSystemConfigTest/top/testee2/dc_i/int_i";
			Integer _int_i = null;
			object = values.get(id);
			if(object != null){
				_int_i = ensureInt(object);
				if(!_int_i.equals((Integer)diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(testee2.getDc_iLock()){
					if(testee2.getDc_iLock().isUpdate()){
						if(_char_i != null){
							testee2.getDc_i().getDc_i().setChar_i(_char_i);
							diffMap.put("/SubSystemConfigTest/dc_i/dc_i/char_i", _char_i);
						}
						if(_long_array_i != null){
							testee2.getDc_i().setLong_array_i(_long_array_i);
							diffMap.put("/SubSystemConfigTest/dc_i/long_array_i", _long_array_i);
						}
						if(_double_i != null){
							testee2.getDc_i().getDc_i().setDouble_i(_double_i);
							diffMap.put("/SubSystemConfigTest/dc_i/dc_i/double_i", _double_i);
						}
						if(_int_i != null){
							testee2.getDc_i().setInt_i(_int_i);
							diffMap.put("/SubSystemConfigTest/dc_i/int_i", _int_i);
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
				if(!_blockMe.equals((Integer)diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(testee2.getBlockMeLock()){
					if(testee2.getBlockMeLock().isUpdate()){
						if(_blockMe != null){
							testee2.setBlockMe(_blockMe);
							diffMap.put("/SubSystemConfigTest/blockMe", _blockMe);
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
				if(!_blocker.equals((Boolean)diffMap.get(id)))
					changed = true;
			} else
				warning(id, "is missing");
			if(changed)
				synchronized(testee2.getBlockerLock()){
					if(testee2.getBlockerLock().isUpdate()){
						if(_blocker != null){
							testee2.setBlocker(_blocker);
							diffMap.put("/SubSystemConfigTest/blocker", _blocker);
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
		values.put("/SubSystemConfigTest/top/testee2/int_i", testee2.getInt_i());
		values.put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/char_i", toObjectArray(testee2.getDc_i().getDc_i().getChar_i()));
		values.put("/SubSystemConfigTest/top/testee2/dc_i/long_array_i", toObjectArray(testee2.getDc_i().getLong_array_i()));
		values.put("/SubSystemConfigTest/top/testee2/dc_i/dc_i/double_i", testee2.getDc_i().getDc_i().getDouble_i());
		values.put("/SubSystemConfigTest/top/testee2/dc_i/int_i", testee2.getDc_i().getInt_i());
		values.put("/SubSystemConfigTest/top/testee2/blockMe", testee2.getBlockMe());
		values.put("/SubSystemConfigTest/top/testee2/blocker", testee2.getBlocker());
		
		return values;
	}
	
	@Override
	public void write(String id, Object object){
		if(object.getClass().isPrimitive() || object.getClass().isArray())
			writeTasks.put(id, object);
		else {
			synchronized(writeTasks){
			}
		}
	}
	
	// DataClasses write operations
	
	
}
