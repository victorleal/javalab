package core;

import java.io.Serializable;

public class PersistentObject implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SEPARATOR = "_";
	private static final String EXTENSION = ".bin";

	private String id;
	private String className;
	private String fileName;

	public PersistentObject(String className, String id) {
		this.className = className;
		this.id = id;
		this.fileName = className + SEPARATOR + this.id + EXTENSION;
	}
	
	public PersistentObject(String className) {
		this.className = className;
	}

	public int getId() {
		return Integer.parseInt(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
