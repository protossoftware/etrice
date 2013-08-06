package DynamicActorTest7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.eclipse.etrice.runtime.java.modelbase.ReplicatedOptionalActorInterfaceBase;
import org.eclipse.etrice.runtime.java.modelbase.ScalarOptionalActorInterfaceBase;

public class FilePersistor {

	public static boolean createAndLoad(ScalarOptionalActorInterfaceBase opt, int thread, String fname, String actorClass) {
		boolean success = false;
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			fin = new FileInputStream(fname);
			ois = new ObjectInputStream(fin);
			
			success = opt.createOptionalActor(actorClass, thread, ois);
		}
		catch (FileNotFoundException e) {
			success = opt.createOptionalActor(actorClass, thread);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ois!=null)
					ois.close();
				if (fin!=null)
					fin.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}
	
	public static boolean saveAndDestroy(ScalarOptionalActorInterfaceBase opt, String fname) {
		boolean success = false;
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(fname);
			oos = new ObjectOutputStream(fout);
			success = opt.destroyOptionalActor(oos);
		}
		catch (FileNotFoundException e) {
			success = opt.destroyOptionalActor();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (oos!=null)
					oos.close();
				if (fout!=null)
					fout.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}

	public static int createAndLoad(ReplicatedOptionalActorInterfaceBase opt, int thread, String fname, String actorClass) {
		int idx = -1;
		FileInputStream fin = null;
		ObjectInputStream ois = null;
		try {
			fin = new FileInputStream(fname);
			ois = new ObjectInputStream(fin);
			
			idx = opt.createOptionalActor(actorClass, thread, ois);
		}
		catch (FileNotFoundException e) {
			idx = opt.createOptionalActor(actorClass, thread);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (ois!=null)
					ois.close();
				if (fin!=null)
					fin.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return idx;
	}
	
	public static boolean saveAndDestroy(ReplicatedOptionalActorInterfaceBase opt, String fname, int idx) {
		boolean success = false;
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(fname);
			oos = new ObjectOutputStream(fout);
			success = opt.destroyOptionalActor(idx, oos);
		}
		catch (FileNotFoundException e) {
			success = opt.destroyOptionalActor(idx);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (oos!=null)
					oos.close();
				if (fout!=null)
					fout.close();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return success;
	}
}
