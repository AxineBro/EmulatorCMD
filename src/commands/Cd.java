package commands;

import java.util.Arrays;

import basicFiles.Dir;
import basicFiles.SystemElements;

public class Cd {
	public static String completCd(String cdCommand, basicFiles.Dir currentDirectory) {
		String[] cdCommandComponents = cdCommand.toLowerCase().split(" ");
		if(cdCommandComponents.length == 1) {
			return "\r\n" + currentDirectory.getFullSystemElementsName();
		}else {
			if(!cdCommand.contains("\\")) {
				for(SystemElements dirs : currentDirectory.getComponentsDir()) {
					if(cdCommandComponents[1].toLowerCase().equals(dirs.getSystemElementsName().toLowerCase())) {
						basicFiles.MainFrame.setCurrentDirectory((Dir) dirs);
						return null;
					}
				}
			}else {
				if(searchSystemElements(cdCommandComponents[1]) != null) {
					basicFiles.MainFrame.setCurrentDirectory(searchSystemElements(cdCommandComponents[1]));
					return null;
				}
			}
		}
		return "\r\nСистеме не удается найти указанный путь.";
	}
	public static basicFiles.Dir searchSystemElements(String fullSystemElementName){
		basicFiles.Dir parentElement = basicFiles.MainFrame.getParentDirectory();
		basicFiles.Dir resultElement = parentElement;
		String[] path = fullSystemElementName.split("\\\\");
		if(path.length < 2 && !path[0].toLowerCase().equals(parentElement.getSystemElementsName().toLowerCase()) ) return null;
		search:for(int i = 1; i < path.length; i++) {
			for(int j = 0; j < resultElement.getComponentsDir().size(); j++) {
				if(path[i].toLowerCase().equals(resultElement.getComponentsDir().get(j).getSystemElementsName().toLowerCase())) {
					resultElement = (Dir) resultElement.getComponentsDir().get(j);
					continue;
				}
				if(j == resultElement.getComponentsDir().size()-1) return null;
			}
		}
		return resultElement;
	}
}
