package basicFiles;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;

import commands.*;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import java.util.ArrayList;
import java.util.List;

import java.awt.GridLayout;
import java.util.HashMap;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private static HashMap<Integer, Color> colorsArray = new HashMap<>();
	private static Color background;
	private static Color foreground;
	private List<String> commandDat = new ArrayList<>();
	private StringBuilder memoryText = new StringBuilder();
	private static JTextPane textCMD;
	private static JScrollPane scrollPane;
	private static Dir parentDirectory = new Dir("Axine:");
	private static Dir currentDirectory = getParentDirectory();
	{
		memoryText.append("Axine Operating System[Version 10.0.26100.3037]\r\n(c) Корпорация Axine (Axine Corporation). Все права защищены.\r\n\r\nAxine:\\>");
	}
	static{
		getColorsArray().put(0x0, new Color(12, 12, 12));
		getColorsArray().put(0x1, new Color(0, 55, 218));
		getColorsArray().put(0x2, new Color(19, 161, 14));
		getColorsArray().put(0x3, new Color(58, 150, 221));
		getColorsArray().put(0x4, new Color(197, 15, 31));
		getColorsArray().put(0x5, new Color(136, 23, 152));
		getColorsArray().put(0x6, new Color(193, 156, 0));
		getColorsArray().put(0x7, new Color(204, 204, 204));
		getColorsArray().put(0x8, new Color(118, 118, 118));
		getColorsArray().put(0x9, new Color(59, 120, 255));
		getColorsArray().put(0xA, new Color(22, 198, 12));
		getColorsArray().put(0xB, new Color(97, 214, 214));
		getColorsArray().put(0xC, new Color(231, 72, 86));
		getColorsArray().put(0xD, new Color(180, 0, 158));
		getColorsArray().put(0xE, new Color(249, 241, 165));
		getColorsArray().put(0xF, new Color(242, 242, 242));
		
		setBackgroundText(getColorsArray().get(0x0));
		setForegroundText(getColorsArray().get(0xF));
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private String getCommand(String cmdText) {
		return cmdText.substring(memoryText.length(),  getTextCMD().getText().length()).trim();
	}
	private String accomplishment(String command) {
		if(command.toLowerCase().split(" ")[0].equals("echo")){
			return commands.Echo.completEcho(command, currentDirectory);
		} else if(command.toLowerCase().split(" ")[0].equals("help")) {
			return commands.Help.completHelp(command);
		} else if(command.toLowerCase().split(" ")[0].equals("dir")) {
			return commands.Dir.completDir(command, currentDirectory);
		} else if(command.toLowerCase().split(" ")[0].equals("mkdir") || command.split(" ")[0].equals("md")) {
			return commands.Mkdir.completMkdir(command, currentDirectory);
		} else if(command.toLowerCase().split(" ")[0].equals("cd")) {
			return commands.Cd.completCd(command, currentDirectory);
		} else if(command.toLowerCase().split(" ")[0].equals("type")) {
			return commands.Type.completType(command, currentDirectory);
		}
		else if(command.toLowerCase().split(" ")[0].equals("color")) {
			return commands.Color.completColor(command);
		}else if(command.toLowerCase().split(" ")[0].equals("tree")) {
			return "\r\n" + commands.Tree.completTree("", true, currentDirectory);
		}
		return null;
	}
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("AxineCMD");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 343);
		contentPane = new JPanel();
		contentPane.setBackground(background);

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		setScrollPane(new JScrollPane());
		getScrollPane().setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getScrollPane().getVerticalScrollBar().setBackground(background);
		contentPane.add(getScrollPane());
		
		textCMD  = new JTextPane();
		getTextCMD().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					e.consume();
					String command = getCommand(getTextCMD().getText());
					commandDat.add(command);
					String output = accomplishment(command);
					memoryText.append(command + (output == null? "\r\n": output + "\r\n"));
					if(Echo.isEcho()) {
						memoryText.append("\r\n"+ currentDirectory.getFullSystemElementsName() + ">");
					} 
					getTextCMD().setText(memoryText.toString());
				} else if(e.getKeyCode() == 8) {
					e.consume();
					String command = getCommand(getTextCMD().getText());
					getTextCMD().setText(memoryText + command.substring(0, command.length()!=0?  command.length()-1 : command.length()));
				} else if(e.getKeyCode() == 38) {
					e.consume();
					getTextCMD().setText(memoryText + getDatCommand(getCommand(getTextCMD().getText())));
				} else if(e.getKeyCode() == 40) {
					e.consume();
					getTextCMD().setText(memoryText + getDatCommandRevers(getCommand(getTextCMD().getText())));
				}

			}
		});
		getTextCMD().setFont(new Font("DejaVu Sans Mono", Font.PLAIN, 12));
		getTextCMD().setText(memoryText.toString());
		getTextCMD().setForeground(foreground);
		getTextCMD().setBackground(background);
		getScrollPane().setViewportView(getTextCMD());
		
	}

	public static JTextPane getTextCMD() {
		return textCMD;
	}

	public static void setTextCMD(String textCMD) {
		MainFrame.textCMD.setText(textCMD);
	}
	
	private String getDatCommand(String currentDat) {
		String result = currentDat;
		for(String commands : commandDat) {
			if(commands.equals(currentDat)) {
				break;
			}
			result = commands;
		}
		return result;
	}
	private String getDatCommandRevers(String currentDat) {
		String result = currentDat;
		for(int i = commandDat.size()-1; i >= 0 ; i--) {
			if(commandDat.get(i).equals(currentDat)) {
				break;
			}
			result = commandDat.get(i);
		}
		return result;
	}
	public static void setBackgroundText(Color background) {
		MainFrame.background = background;
	}

	public static void setForegroundText(Color foreground) {
		MainFrame.foreground = foreground;
	}
	public static void setCurrentDirectory(Dir currentDirectory) {
		MainFrame.currentDirectory = currentDirectory;
	}

	public static Dir getParentDirectory() {
		return parentDirectory;
	}

	public static HashMap<Integer, Color> getColorsArray() {
		return colorsArray;
	}

	public static JScrollPane getScrollPane() {
		return scrollPane;
	}

	public static void setScrollPane(JScrollPane scrollPane) {
		MainFrame.scrollPane = scrollPane;
	}

	
}
