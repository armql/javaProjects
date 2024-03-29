import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Todd {

    private Robot robot;
    private List<Integer> events;

    public Todd() throws AWTException {
        robot = new Robot();
        events = new ArrayList<>();
    }

    public void startRecording() {
        events.clear();
    }

    public void stopRecording() {
        replay();
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
        for (Integer event : events) {
            if (event > 0) {
                if (event < 0x0100) {
                    robot.keyPress();
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
}