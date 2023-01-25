package IES.Main;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Main implements KeyListener {

    private Todd todd;
    private boolean recording;

    public Main() throws AWTException {
        todd = new Todd();
        recording = false;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            if (!recording) {
                recording = true;
                todd.startRecording();
            } else {
                recording = false;
                todd.stopRecording();
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        // No action needed
    }

    public void keyTyped(KeyEvent e) {
        // No action needed
    }

    public static void main(String[] args) throws AWTException {
        JFrame frame = new JFrame();
        frame.addKeyListener(new Main());
        frame.setVisible(true);
    }
}
