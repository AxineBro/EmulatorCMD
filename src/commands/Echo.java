package commands;

public class Echo {
	
	private static boolean isEcho = true;
	
	public static String completEcho(String echoCommand,  basicFiles.Dir currentDirectory) {
		String[] echoCommandComponents = echoCommand.toLowerCase().split(" ");
		if(echoCommandComponents.length == 1) {
			return isEcho? "\r\nРежим вывода команд на экран (ECHO) включен." : "\r\nРежим вывода команд на экран (ECHO) отключен.";
		}else if(echoCommandComponents[1].equals("off")) {
			isEcho = false;
		}else if(echoCommandComponents[1].equals("on")) {
			isEcho = true;
		}else {
			if(!echoCommand.contains(">")) {
				return "\r\n" + echoCommand.substring(echoCommandComponents[0].length(), echoCommand.length()).trim();
			}else {
				String[] echoCommandComponentsWihtFile = echoCommand.substring(echoCommandComponents[0].length(), echoCommand.length()).trim().split(">");
				//return "\r\nВ Файл" + echoCommandComponentsWihtFile[1] +" записано " + echoCommandComponentsWihtFile[0];
				currentDirectory.addComponent(new basicFiles.File(echoCommandComponentsWihtFile[1].trim(), currentDirectory.getFullSystemElementsName(), echoCommandComponentsWihtFile[0].trim()));
			}
		}
		return null;
	}

	public static boolean isEcho() {
		return isEcho;
	}
}
