import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

public class TextEngine implements KeyListener {

    GamePanel gp;
    TextEngine(GamePanel gp) {
        this.gp = gp;
    }

    String dialogue = "";
    int pointer = 0;
    char[] characters;

    public void startTheGame() {
        gp.sfx.ambienceEffects.stop();
        if (gp.story.endingChecklist.size() == 9) {
            gp.story.showFinalEnding(1);
        } else if (gp.story.endingChecklist.size() == 10) {
            gp.story.showFinalEnding(2);
        } else {
            gp.story.textQueue = new LinkedList<>();
            if(gp.story.resets == 3) {
                gp.story.textQueue.add("Get to 10 Clicks. NO FOOLISHNESS ALLOWED.");
            } else {
                gp.story.textQueue.add("Hello. Welcome to “Click Till 10“.");
                gp.story.textQueue.add("This psychological test will assess your capabilities and intelligence as a human person.");
                gp.story.textQueue.add("Getting straight to the point, there is one task for you.");
                gp.story.textQueue.add("That task is to click the button that says “Increase” 10 times.");
                gp.story.textQueue.add("After that, please press the “Submit” button to send the results to our laboratory for further analyzing.");
                gp.story.textQueue.add("We do NOT tolerate foolishness, so please cooperate with us.");
            }
            say(gp.story.textQueue.poll());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() != KeyEvent.VK_Z) {
            return;
        }
        if (timer.isRunning()) {
            timer.stop();
            gp.dialogueText.setText(dialogue);
            gp.submit.setEnabled(gp.story.textQueue.isEmpty());
            gp.increase.setEnabled(gp.story.textQueue.isEmpty());
            gp.decrease.setEnabled(gp.story.textQueue.isEmpty());
        } else if (!gp.story.textQueue.isEmpty()) {
            say(gp.story.textQueue.poll());
        }
        if (!timer.isRunning() && gp.story.textQueue.isEmpty() && gp.story.endingAchieved) {
            gp.story.showEnding();
            disableButtons();
        }
        if (!timer.isRunning() && gp.story.textQueue.isEmpty() && gp.story.counter666) {
            gp.submit.setEnabled(false);
        }
    }

    Timer timer = new Timer(80, e -> {
        gp.dialogueText.setText(gp.dialogueText.getText() + characters[pointer]);
        if (pointer == characters.length - 1) {
            stop();
            if (gp.story.textQueue.isEmpty()) {
                gp.submit.setEnabled(true);
                gp.increase.setEnabled(true);
                gp.decrease.setEnabled(true);
                if (gp.story.endingAchieved) {
                    gp.story.showEnding();
                    disableButtons();
                }
                if (gp.story.counter666) {
                    gp.submit.setEnabled(false);
                }
            }
        } else {
            pointer++;
            delayTimer();
        }
    });

    private void delayTimer() {
        if (!(characters[pointer] == ' ')) {
            gp.sfx.playEffect(2);
        }
        if (characters[pointer] == '.' || characters[pointer] == '!' || characters[pointer] == '?') {
            timer.setDelay(1000);
        } else if (characters[pointer] == ',') {
            timer.setDelay(325);
        } else {
            timer.setDelay(60);
        }
    }

    private void stop() {
        timer.stop();
        pointer = 0;
        timer.setDelay(60);
    }
    public void say(String sentence) {
        stop();
        gp.dialogueText.setText("");
        gp.submit.setEnabled(false);
        gp.increase.setEnabled(false);
        gp.decrease.setEnabled(false);
        dialogue = sentence;
        characters = dialogue.toCharArray();
        timer.restart();
    }

    private void disableButtons() {
        gp.submit.setEnabled(false);
        gp.increase.setEnabled(false);
        gp.decrease.setEnabled(false);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}
