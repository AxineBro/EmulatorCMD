package basicFiles;

import javax.swing.SwingUtilities;

public class Main {
	private static int splashScreenTime = 3000;
	private static String splashScreenPath = "/image/SplashScreenLogo.png";
	
	 public static void main(String[] args) {
	        SplashScreen splash = new SplashScreen(splashScreenPath, splashScreenTime);
	        splash.show();

	        try {
	            Thread.sleep(splashScreenTime);
	        } catch (InterruptedException ignored) {}

	        CMDFrame frame = new CMDFrame();
			frame.setVisible(true);
	    }
}
