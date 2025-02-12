package commands;

import basicFiles.SystemElements;

public class Dir {
	public static String completDir(String dirCommand, basicFiles.Dir currentDirectory) {
		StringBuilder resultString = new StringBuilder(
				"\r\n Том в устройстве Axine имеет метку AxinePad\r\n"
				+ " Серийный номер тома: 7A77-A777\r\n\r\n"
				+ " Содержимое папки " + currentDirectory.getFullSystemElementsName()+ "\r\n\r\n");
		for(SystemElements dirs : currentDirectory.getComponentsDir()) {
			resultString.append(dirs.getSystemElementsDate() + "  " + dirs.getSystemElementsTime() + "\t" + (dirs instanceof basicFiles.Dir? "<DIR>\t" : "\t") + dirs.getSystemElementsName() + "\r\n");
		}
		return resultString.toString();
	}
}
