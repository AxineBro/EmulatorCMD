package commands;

import basicFiles.MainFrame;

public class Color {
	public static String completColor(String colorCommand) {
		String[] colorCommandComponents = colorCommand.toLowerCase().split(" ");
		System.out.print(colorCommandComponents.length);
		if(colorCommandComponents.length == 1) {
			MainFrame.getTextCMD().setForeground(MainFrame.getColorsArray().get(0xf));
			MainFrame.getTextCMD().setBackground(MainFrame.getColorsArray().get(0x0));
			MainFrame.getScrollPane().getVerticalScrollBar().setBackground(MainFrame.getColorsArray().get(0x0));
			return null;
		}else if(colorCommandComponents.length == 2 && colorCommandComponents[1].length() == 2) {
			try {
				int background = Integer.parseInt(String.valueOf(colorCommandComponents[1].charAt(0)), 16);
				int foreground = Integer.parseInt(String.valueOf(colorCommandComponents[1].charAt(1)), 16);
				System.out.print(background);
				if(background != foreground) { 
					 MainFrame.getTextCMD().setForeground(MainFrame.getColorsArray().get(foreground));
					 MainFrame.getTextCMD().setBackground(MainFrame.getColorsArray().get(background));
					 MainFrame.getScrollPane().getVerticalScrollBar().setBackground(MainFrame.getColorsArray().get(background));
				 }
				 return null;
			}catch(Exception e) {}
		}
		
		return Help.completHelp("help color");
	}
}
