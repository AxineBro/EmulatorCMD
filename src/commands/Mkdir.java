package commands;

import basicFiles.SystemElements;

public class Mkdir {
	public static String completMkdir(String mkdirCommand,  basicFiles.Dir currentDirectory) {
		String[] mkdirCommandComponents = mkdirCommand.split(" ");
		if(mkdirCommandComponents.length == 1) {
			return "\r\nОшибка в синтаксисе команды.";
		}else if(mkdirCommandComponents.length == 2) {
			currentDirectory.addComponent(new basicFiles.Dir(mkdirCommandComponents[1], currentDirectory.getFullSystemElementsName()));
		}else {
			
		}
		return null;
	}
}
