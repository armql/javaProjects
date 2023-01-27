package finalizingEXCEINTE;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Main {
    private JFrame frame;
    private JButton startRecordingButton,stopRecordingButton,startReplayingButton,stopReplayingButton;
    private Todd todd;
    private boolean recording, replaying;

    public Main() throws AWTException {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 100);
        frame.setLayout(null);
        frame.setVisible(true);

        startRecordingButton = new JButton("Start Recording");
        startRecordingButton.setBounds(10, 10, 150, 30);
        frame.add(startRecordingButton);
        startRecordingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleRecording();
            }
        });

        stopRecordingButton = new JButton("Stop Recording");
        stopRecordingButton.setBounds(10, 50, 150, 30);
        frame.add(stopRecordingButton);
        stopRecordingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleRecording();
            }
        });
        stopRecordingButton.setEnabled(false);

        startReplayingButton = new JButton("Start Replay");
        startReplayingButton.setBounds(10, 10, 150, 30);
        frame.add(startReplayingButton);
        startReplayingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleReplaying();
            }
        });

        stopReplayingButton = new JButton("Stop Replay");
        stopReplayingButton.setBounds(10, 50, 150, 30);
        frame.add(stopReplayingButton);
        stopReplayingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleReplaying();
            }
        });
        stopReplayingButton.setEnabled(false);

        todd = new Todd();
        frame.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (recording) {
                    todd.pressKey(evt)
                }

            }
        }

        public static void main(String[] args) throws AWTException {
            Main main = new Main();
            }
            }
            
            private void toggleRecording() {
            if (!recording) {
            recording = true;
            startRecordingButton.setText("Stop Recording");
            stopRecordingButton.setEnabled(true);
            todd.startRecording();
            } else {
            recording = false;
            startRecordingButton.setText("Start Recording");
            stopRecordingButton.setEnabled(false);
            todd.stopRecording();
            }
            }

            private void toggleReplaying() {
                if (!replaying) {
                    replaying = true;
                    startReplayingButton.setText("Stop Replay");
                    stopReplayingButton.setEnabled(true);
                    todd.startReplaying();
                } else {
                    replaying = false;
                    startReplayingButton.setText("Start Replay");
                    stopReplayingButton.setEnabled(false);
                    todd.stopReplaying();
                }
            }