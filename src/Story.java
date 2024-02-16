import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

public class Story {

    GamePanel gp;
    Queue<String> textQueue = new LinkedList<>();
    private final String[] endingNames = {"Cooperation", "Reaching the Stars", "Reaching the Underworld", "Devil's Number", "Intelligence", "Lucky", "Sussy Number", "Back On Track", "Math", "Thank You for Playing"};
    File data = new File("data/Playerdat.ser");
    File resetCounter = new File("data/Resets.txt");

    boolean endingAchieved, counter666 = false;
    private boolean counter547, counter69, counter420, counter314, counter271, counter961, counter729 = false;
    private int annoyance = 0;
    int resets;
    HashSet<Integer> endingChecklist;
    int endingNumber;

    @SuppressWarnings("unchecked")
    public Story (GamePanel gp) {
        this.gp = gp;
        if(data.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("data/Playerdat.ser")))) {
                endingChecklist = (HashSet<Integer>) ois.readObject();
            } catch (IOException e) {
                endingChecklist = new HashSet<>();
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            endingChecklist = new HashSet<>();
        }
        if (resetCounter.exists()) {
            try (DataInputStream dis = new DataInputStream(Files.newInputStream(Paths.get("data/Resets.txt")))) {
                resets = dis.read();
            } catch (IOException e) {
                resets = 0;
                throw new RuntimeException(e);
            }
        } else {
            resets = 0;
        }
    }

    public void ending666() {

        gp.decrease.setEnabled(false);
        gp.setBackground(Color.RED);
        gp.dialogueText.setBackground(Color.BLACK);
        gp.dialogueText.setForeground(Color.WHITE);
        gp.submit.setText("▯▯b▯▯t");
        gp.submit.setBackground(Color.BLACK);
        gp.submit.setForeground(Color.WHITE);
        gp.increase.setText("I▯▯▯e▯s▯");
        gp.increase.setBackground(Color.BLACK);
        gp.increase.setForeground(Color.WHITE);
        gp.decrease.setText("▯▯▯▯▯a▯▯");
        gp.decrease.setBackground(Color.BLACK);
        gp.decrease.setForeground(Color.WHITE);
        gp.clicks.setText("###");
        gp.increase.setEnabled(false);
        gp.sfx.ambienceEffects.stop();
        gp.sfx.playSong(2);

        textQueue.add("Wait, what? What did you do to this game…");
        textQueue.add("WHATTTT%&$^# HAVEEE ->547<- YOU DONE?3$(#$*}{“:>><^$@$#${}|{@{}}@$$)*&*&#@!");
        textQueue.add("(((((((((((((((((((((((((((((((((( terminating program…");
        endingAchieved = true;
        endingNumber = 4;
        endingChecklist.add(endingNumber);
        gp.textEngine.say(textQueue.poll());
    }

    private void ending547() {
        textQueue.add("That is incorrect. We had an idea that you stumbling here was by chance, and not because your brain had great potential.");
        textQueue.add("Use your luck for the lottery next time and not for some shoddy game. Have a good day.");
        endingAchieved = true;
        endingNumber = 6;
        endingChecklist.add(endingNumber);
        gp.textEngine.say(textQueue.poll());
    }

    private void ending420() {
        textQueue.add("We gave you a warning, and yet you brushed it aside. We are sorry, but it looks like you are a waste of space and oxygen with the intelligence threshold of a fool.");
        textQueue.add("Goodbye, and do not come back with that number. Ever. Again.");
        endingAchieved = true;
        endingNumber = 7;
        endingChecklist.add(endingNumber);
        gp.textEngine.say(textQueue.poll());
    }

    public void checkCounter() {
        switch (gp.clicksCounter) {
            case 10:
                if (counter69 || counter420) {
                    textQueue.add("Thank you for making the right choice and going back to 10 clicks. In the future, do not try to do this again. Have a good day.");
                    endingAchieved = true;
                    endingNumber = 8;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                } else if (counter314) {
                    textQueue.add("Now is not the time to go back to 10 clicks. Please go back to submitting the number we asked of you.");
                    gp.textEngine.say(textQueue.poll());
                } else if (counter547) {
                    ending547();
                } else {
                    textQueue.add("Thank you for assisting us with those ten clicks.");
                    textQueue.add("Your results are very valuable, and we do hope you have a lovely day.");
                    endingAchieved = true;
                    endingNumber = 1;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 999:
                if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    textQueue.add("Wow. You decided to reach the limits of this game.");
                    textQueue.add("999 clicks.");
                    textQueue.add("Truly, an amazing achievement.");
                    textQueue.add("Good job. You have completed this game, and these results will help our slav- developers make the game even better the next time you visit.");
                    textQueue.add("Thank you for your time, and have a good day.");
                    endingAchieved = true;
                    endingNumber = 2;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case -999:
                if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    textQueue.add("Oh. You decided to reach the depths of this game.");
                    textQueue.add("-999 clicks.");
                    textQueue.add("Interesting.");
                    textQueue.add("Good job. You have completed this game.");
                    textQueue.add("Have a good day, and next time, stay positive rather than negative. You might find more to explore there…");
                    endingAchieved = true;
                    endingNumber = 3;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 666:
                if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    textQueue.add("We don’t believe it. Do you actually believe in superstitions? HAHA-HAHA! ");
                    textQueue.add("We don’t believe in that con because we are only dialogue, and this three-digit number will not affect this trial.");
                    textQueue.add("What. So. Ever.");
                    textQueue.add("We’ll force you to get back to 10 clicks, so you will stop wasting everybody’s time.");
                    counter666 = true;
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 547:
                if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    textQueue.add("Wait, how did you know to click 547 times? Was this a coincidence, or perhaps, you played this game before and unlocked a certain path.");
                    textQueue.add("Then, you found the strategically placed number, and decided it was smart to click the button that specific number of times?");
                    textQueue.add("You really are intelligent, or just lucky.");
                    textQueue.add("To prove that this input was indeed, NOT by chance, please find the frequency of the “$” symbol occurring in the dialogue of that particular route.");
                    textQueue.add("Multiply that frequency by three, add six, square the sum, then divide the product by two. Click that number of times, then submit your answer.");
                    counter547 = true;
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 450:
                if (counter547) {
                    textQueue.add("That is correct. Good job! After reviewing the data you provided us, we believe that your brain is stronger than the average person.");
                    textQueue.add("Being capable of analyzing moving text,");
                    textQueue.add("doing quick math,");
                    textQueue.add("deducing that the number 547 had a significance in the trial,");
                    textQueue.add("and easily distinguishing each unicode character to get here truly astonishes us.");
                    textQueue.add("We would like you to head to our research facility so we can unite minds like you to fight for the greater good.");
                    textQueue.add("Please check [//////////////] as soon as we end [////////////] transmission. Together, [//////////////]  will be able to save [//////////////////]");
                    endingAchieved = true;
                    endingNumber = 5;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (counter420) {
                    ending420();
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            case 69:
                if (counter69) {
                    textQueue.add("Get back to 10 clicks already. Do not make us angrier.");
                    gp.textEngine.say(textQueue.poll());
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    textQueue.add("Seriously? 69? Instead of clicking the button 10 times, you deliberately clicked 69 times so you can see our emotionless reactions?");
                    textQueue.add("Please, get a new life, and when you’re done with that, get back to 10 clicks.");
                    counter69 = true;
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 420:
                if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else if (counter69) {
                    textQueue.add("Jesus Christ, will you stop it? Our researchers are considering classifying you as “Basic Foolish Primate” because of your stupidity.");
                    textQueue.add("Either you stop messing with us and go back to 10 clicks, or we will halt the game right here and prevent you from accessing this trial. EVER. AGAIN.");
                    textQueue.add("Hopefully this warning and/or threat will knock some sense into you.");
                    counter420 = true;
                    gp.textEngine.say(textQueue.poll());
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            case 314:
                if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else {
                    textQueue.add("Hmm? What’s this? You clicked 314 times, which is the first three digits of pi.");
                    textQueue.add("This gives us an idea. To test your capabilities for mathematics, please input the number 'e'");
                    counter314 = true;
                    counter420 = false;
                    gp.textEngine.say(textQueue.poll());
                }
                break;
            case 271:
                if (counter271) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (counter314) {
                    textQueue.add("Good, good. We see you’re taking on this challenge. Alright, input the largest perfect square.");
                    counter271 = true;
                    gp.textEngine.say(textQueue.poll());
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            case 961:
                if (counter961) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (counter271) {
                    textQueue.add("We see. You got some talent. This time, input the largest perfect cube.");
                    counter961 = true;
                    gp.textEngine.say(textQueue.poll());
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            case 729:
                if (counter729) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (counter961) {
                    textQueue.add("We do hope that you are not using 'Google' for help. That damned website.");
                    textQueue.add("Our apologies. The last number we want you to input, is the largest factorial. Using a calculator is NOT advisable, thank you.");
                    counter729 = true;
                    gp.textEngine.say(textQueue.poll());
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            case 720:
                if (counter729) {
                    textQueue.add("Good job. You have successfully completed the challenge.");
                    textQueue.add("Unfortunately, it is just math you excel in and we do not trust you if you did not use a computer for this challenge, therefore you are not truly capable of helping us. For. Something…");
                    textQueue.add("Anyway, do come back when you find the potential we seek. Have a lovely day.");
                    endingAchieved = true;
                    endingNumber = 9;
                    endingChecklist.add(endingNumber);
                    gp.textEngine.say(textQueue.poll());
                } else if (counter420) {
                    ending420();
                } else if (counter547) {
                    ending547();
                } else {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                }
                break;
            default:
                if (counter547) {
                    ending547();
                } else if (counter420) {
                    ending420();
                } else if (counter314) {
                    gp.textEngine.say("That is not the right number. Please try again.");
                } else if (annoyance >= 3) {
                    gp.textEngine.say("We are waiting...");
                } else if (gp.clicksCounter > 10) {
                    gp.textEngine.say("That is too many clicks. Please go back to 10 clicks.");
                    annoyance++;
                } else {
                    gp.textEngine.say("That is not enough clicks. Please click until you reach 10 clicks.");
                    annoyance++;
                }
            }
        }

    public void showEnding() {
        gp.ending.setText("Ending " + endingNumber + "/10: " + endingNames[endingNumber - 1]);
        gp.ending.setSize(gp.ending.getPreferredSize());
        Timer timer = new Timer(2000, e -> {
            gp.submit.setVisible(false);
            gp.increase.setVisible(false);
            gp.decrease.setVisible(false);
            gp.clicks.setVisible(false);
            gp.dialogueText.setVisible(false);
            gp.setBackground(Color.BLACK);
            gp.ending.setVisible(true);
            gp.sfx.ambienceEffects.stop();
            gp.sfx.playSong(1);
        });
        timer.setRepeats(false);
        timer.start();
    }

    public void showFinalEnding(int number) {
        gp.sfx.playSong(3);
        gp.submit.setVisible(false);
        gp.increase.setVisible(false);
        gp.decrease.setVisible(false);
        gp.clicks.setVisible(false);
        gp.dialogueText.setBounds(25, 150, 450, 100);
        gp.dialogueText.setBackground(Color.WHITE);
        gp.dialogueText.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        gp.dialogueText.setForeground(Color.BLACK);
        gp.dialogueText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        gp.setBackground(Color.WHITE);

        if (number == 1) {
            textQueue.add("You unlocked every single path and obtained every ending possible in this game.");
            textQueue.add("You have intelligence, luck, superstition, choice, stupidity, and dedication towards this game.");
            textQueue.add("We never recorded your name in our database yet, did we?");
            textQueue.add(System.getProperty("user.name") + ", was it?");
            textQueue.add("Congratulations. You passed the test. There is nothing else left for you to explore.");
            textQueue.add("...");
            textQueue.add("Perhaps… you could reinstall the trial, give the computer mouse to another person, and let them unlock their intelligence.");
            textQueue.add("We will be here waiting until that time comes…");
            endingAchieved = true;
            endingNumber = 10;
            endingChecklist.add(endingNumber);
            gp.textEngine.say(textQueue.poll());
        } else if (number == 2) {
            textQueue.add("We told you, there is nothing left.");
            textQueue.add("Reinstall the game, or reinstall your brain, for a fresh new experience.");
            gp.textEngine.say(textQueue.poll());
        }

    }
}
