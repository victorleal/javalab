package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private static final String ROOTFOLDER = "arquivos/";

	private String classFolder;
	private ObjectOutputStream output;
	private ObjectInputStream input;

	public FileManager(String classFolder) {
		this.classFolder = ROOTFOLDER + classFolder + "/";
	}

	public void writeObject(PersistentObject object) {
		String filePath = this.classFolder + object.getFileName();
		try {
			output = new ObjectOutputStream(new FileOutputStream(filePath));
			output.writeObject(object);
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public PersistentObject readObject(String filePath) {
		PersistentObject o = null;
		try {
			input = new ObjectInputStream(new FileInputStream(filePath));
			o = (PersistentObject) input.readObject();
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return o;
	}

	public List<PersistentObject> readList() {
		List<PersistentObject> files = new ArrayList<PersistentObject>();
		File pasta = new File(this.classFolder);
		for (File arquivo : pasta.listFiles()) {
			
			// Do not read DS_STORE file (Thanks Mac OS!!!)
			if (!arquivo.getName().equals("DS_Store")
					&& !arquivo.getName().equals(".DS_Store")
					&& !arquivo.getName().equals("DS_STORE")
					&& !arquivo.getName().equals(".DS_STORE")) {
				files.add(readObject(arquivo.getPath()));
			}
		}
		return files;

	}

	public void delete(PersistentObject object) {
		String filePath = this.classFolder + object.getFileName();
		File f = new File(filePath);
		if (f.exists()) {
			f.delete();
		}
	}
}
