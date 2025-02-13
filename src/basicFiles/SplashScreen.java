package basicFiles;

import javax.swing.*;
import java.awt.*;

public class SplashScreen {
    private final JWindow window;
    
    public SplashScreen(String imagePath, int duration) {
        window = new JWindow();
        JLabel label = new JLabel(new ImageIcon(Frame.class.getResource(imagePath))); 
        window.getContentPane().add(label, BorderLayout.CENTER);
        window.setSize(label.getPreferredSize());
        window.setLocationRelativeTo(null);

        new Thread(() -> {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException ignored) {}
            window.dispose();
        }).start();
    }

    public void show() {
        window.setVisible(true);
    }
}