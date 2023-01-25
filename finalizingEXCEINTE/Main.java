package finalizingEXCEINTE;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main implements KeyListener, ActionListener {
    
    private Todd todd;
    private boolean recording;
    private JButton recordButton;
    private JButton replayButton;

    public Main() throws AWTException {
        todd = new Todd();
        recording = false;
        recordButton = new JButton("Start Recording");
        recordButton.addActionListener(this);
        recordButton.addKeyListener(this);

        replayButton = new JButton("Replay");
        replayButton.addActionListener(this);
        replayButton.setEnabled(false);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            toggleRecording();
        }
    }

    public void keyReleased(KeyEvent e) {
        // No action needed
    }

    public void keyTyped(KeyEvent e) {
        // No action needed
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == recordButton)
            toggleRecording();
        if(e.getSource() == replayButton)
            replay();
    }

    private void toggleRecording() {
        if (!recording) {
            recording = true;
            recordButton.setText("Stop Recording");
            todd.startRecording();
        } else {
            recording = false;
            recordButton.setText("Start Recording");
            replayButton.setEnabled(true);
            todd.stopRecording();
        }
    }
    private void replay(){
        replayButton.setEnabled(false);
        todd.replay();
    }

    public static void main(String[] args) throws AWTException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setTitle("Record and Replay");
        Main main = new Main();
        frame.add(main.recordButton);
        frame.add(main.replayButton);
        main.recordButton.setBounds(20, 20, 150, 50);
        main.replayButton.setBounds(40, 80, 150, 50);

        main.recordButton.addKeyListener(main);
        main.recordButton.addActionListener(main);
        main.replayButton.addActionListener(main);

        frame.setVisible(true);
    }
}