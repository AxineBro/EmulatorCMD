package commands;

import basicFiles.Dir;
import basicFiles.File;
import basicFiles.SystemElements;

public class Type {
	public static String completType(String typeCommand,  basicFiles.Dir currentDirectory) {
		String[] typeCommandComponents = typeCommand.toLowerCase().split(" ");
		if(typeCommandComponents.length == 2) {
			for(SystemElements files : currentDirectory.getComponentsDir()) {
				if(typeCommandComponents[1].toLowerCase().equals(files.getSystemElementsName().toLowerCase())) {
					basicFiles.File file = (File) files;
					return  "\r\n" + file.getFileText();
				}
			}
		}
		return "\r\nОшибка в синтаксисе команды.";
	}
}
