package basicFiles;

import java.util.ArrayList;
import java.util.List;

import utils.TimeUtils;

public class Dir extends SystemElements{
	private List<SystemElements> componentsDir = new ArrayList<SystemElements>();
	public Dir(String dirName, String fullParentName, List<SystemElements> componentsDir) {
		super(dirName, fullParentName);
		this.setComponentsDir(componentsDir);
	}
	
	public Dir(String dirName, String fullParentName, SystemElements componentDir) {
		super(dirName, fullParentName);
		componentsDir = new ArrayList<SystemElements>();
		addComponent(componentDir);
	}

	public Dir(String dirName, String fullParentName) {
		super(dirName, fullParentName);
	}

	public Dir(String dirName) {
		super(dirName);
	}

	public List<SystemElements> getComponentsDir() {
		return componentsDir;
	}

	public void setComponentsDir(List<SystemElements> componentsDir) {
		this.componentsDir = componentsDir;
	}
	
	public void addComponent(SystemElements componentDir) {
		componentsDir.add(componentDir);
	}
	public void addComponent(Dir componentDir) {
		componentsDir.add(componentDir);
	}
	 
}
