package finalizingEXCEINTE;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Todd {
    private Robot robot;
    private List<Integer> events;
    private boolean isReplaying;

    public Todd() throws AWTException {
        robot = new Robot();
        events = new ArrayList<>();
        isReplaying = false;
    }

    public void startRecording() {
        events.clear();
    }

    public void stopRecording() {
    }

    public void pressKey(int keyCode) {
        robot.keyPress(keyCode);
        events.add(keyCode);
    }

    public void releaseKey(int keyCode) {
        robot.keyRelease(keyCode);
        events.add(-keyCode);
    }

    public void moveMouse(int x, int y) {
        robot.mouseMove(x, y);
        events.add(x);
        events.add(y);
    }

    public void clickMouse(int buttons) {
        robot.mousePress(buttons);
        events.add(buttons);
    }

    public void releaseMouse(int buttons) {
        robot.mouseRelease(buttons);
        events.add(-buttons);
    }

    public void replay() {
        isReplaying = true;
        while (isReplaying) {
            for (int i = 0; i < events.size(); i++) {
                int event = events.get(i);
                if (event > 0) {
                    if (event < 0x0100) {
                        robot.keyPress(event);
                    } else if (event < 0x0101) {
                        robot.mouseMove(event, events.get(++i));
                    } else {
                        robot.mousePress(event);
                    }
                } else {
                    if (event > -0x0100) {
                        robot.keyRelease(-event);
                    } else if (event > -0x0101) {
                        // no action needed for mouse move
                    } else {
                        robot.mouseRelease(-event);
                    }
                }
            }
        }
    }


    public void stopReplaying(){
        isReplaying = false;
    }
    public boolean isReplaying(){
        return isReplaying;
    }
