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
    private boolean recording;
    private boolean replaying;

    public Todd() throws AWTException {
        robot = new Robot();
        events = new ArrayList<>();
        recording = false;
        replaying = false;
    }

    public void toggleRecording() {
        if (!recording) {
            recording = true;
            events.clear();
        } else {
            recording = false;
        }
    }

    public void toggleReplaying() {
        if (!replaying) {
            replaying = true;
            int i = 0;
            while (i < events.size() && replaying) {
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
                i++;
            }
            replaying = false;
        } else {
            replaying = false;
        }
    }

    public void pressKey(int keyCode) {
        if (recording) {
            events.add(keyCode);
        }
        robot.keyPress(keyCode);
    }

    public void releaseKey(int keyCode) {
        if (recording) {
            events.add(-keyCode);
        }
        robot.keyRelease(keyCode);
    }

    public void moveMouse(int x, int y) {
        if (recording) {
            events.add(x);
            events.add(y);
        }
        robot.mouseMove(x, y);
    }

    public void clickMouse(int buttons) {
        if (recording) {
            events.add(buttons);
        }
        robot.mousePress(buttons);
    }

    public void releaseMouse(int buttons) {
        if (recording) {
            events.add(-buttons);
        }
        robot.mouseRelease(buttons);
    }
}
