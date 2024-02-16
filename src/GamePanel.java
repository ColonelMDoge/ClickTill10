import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.CompoundBorder;

public class GamePanel extends JPanel {

    TextEngine textEngine = new TextEngine(this);
    Story story = new Story(this);
    SoundFX sfx = new SoundFX();
    JTextArea dialogueText = new JTextArea();
    Timer wait, spam;

    JLabel clicks;
    JLabel intro;
    JLabel ending;
    JButton submit;
    JButton increase;
    JButton decrease;
    JButton play;
//    JButton devCheatsIncrease;
//    JButton devCheatsDecrease;

    int clicksCounter = 0;
    private int clicksLimit = 0;

    public GamePanel() {

        String text = "<html> ~ Click Till 10! ~<br> <h2><center> A game by ColonelMDoge </center></h2></html>";
        URL imageIcon = getClass().getResource("Icon.png");
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(imageIcon));
        Image rescale = icon.getImage().getScaledInstance(130,130, Image.SCALE_SMOOTH);
        ImageIcon newIcon = new ImageIcon(rescale);

        this.setBackground(Color.BLACK);
        this.intro = new JLabel();
        this.intro.setText(text);
        this.intro.setBounds(25,20,450,250);
        this.intro.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        this.intro.setHorizontalTextPosition(SwingConstants.CENTER);
        this.intro.setVerticalTextPosition(SwingConstants.TOP);
        this.intro.setIcon(newIcon);
        this.intro.setIconTextGap(5);
        this.intro.setForeground(Color.WHITE);
        this.intro.setHorizontalAlignment(SwingConstants.CENTER);

        this.dialogueText.setBounds(25, 50, 450, 100);
        this.dialogueText.setFocusable(true);
        this.dialogueText.setLayout(null);
        this.dialogueText.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.dialogueText.setLineWrap(true);
        this.dialogueText.setWrapStyleWord(true);
        this.dialogueText.setHighlighter(null);
        this.dialogueText.setEditable(false);
        this.dialogueText.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 1), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        this.dialogueText.setVisible(false);
        this.dialogueText.addKeyListener(this.textEngine);

        this.clicks = new JLabel();
        this.clicks.setText("0");
        this.clicks.setBounds(175, 160, 150, 75);
        this.clicks.setLayout(null);
        this.clicks.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        this.clicks.setHorizontalAlignment(SwingConstants.CENTER);
        this.clicks.setVisible(false);
        this.clicks.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));

        this.submit = new JButton();
        this.submit.setBounds(200, 265, 100, 60);
        this.submit.setLayout(null);
        this.submit.setFocusable(false);
        this.submit.setText("Submit");
        this.submit.setVisible(false);
        this.submit.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.submit.setFocusPainted(false);
        this.submit.setBackground(Color.gray);
        this.submit.setBorder(BorderFactory.createEtchedBorder());
        this.submit.addActionListener((e) -> this.story.checkCounter());

        this.increase = new JButton();
        this.increase.setBounds(145, 350, 100, 60);
        this.increase.setLayout(null);
        this.increase.setFocusable(false);
        this.increase.setText("Increase");
        this.increase.setVisible(false);
        this.increase.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.increase.setFocusPainted(false);
        this.increase.setBackground(Color.decode("#7bc043"));
        this.increase.setBorder(BorderFactory.createEtchedBorder());
        this.increase.addMouseListener(new MouseAdapter() {

            private void checkIncrease() {
                if (clicksLimit < 25) {
                    sfx.playEffect(0);
                    clicksLimit++;
                }
                if (clicksCounter == 999 && clicksLimit < 25) {
                    sfx.playEffect(1);
                    clicksLimit++;
                } else if (clicksCounter > -999 && clicksCounter < 999){
                    clicksCounter++;
                    clicksLimit++;
                    clicks.setText(String.valueOf(clicksCounter));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!(e.getButton() == MouseEvent.BUTTON1)) {
                    return;
                }
                if (increase.isEnabled()) {
                    checkIncrease();
                    if (clicksCounter >= 716 && story.counter666 && story.textQueue.isEmpty()) {
                        story.ending666();
                    }
                    wait = new Timer(500, w -> {
                        spam = new Timer(20, t -> {
                            checkIncrease();
                            if (clicksCounter >= 716 && story.counter666 && story.textQueue.isEmpty()) {
                                if(increase.isEnabled()) {
                                    try {
                                        wait.stop();
                                        spam.stop();
                                    } catch (NullPointerException ignored) {}
                                }
                                story.ending666();
                            }
                        });
                        spam.start();
                    });
                    wait.setRepeats(false);
                    wait.start();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(increase.isEnabled()) {
                    try {
                        wait.stop();
                        spam.stop();
                    } catch (NullPointerException ignored) {}
                }
                clicksLimit = 0;
            }
        });

        this.decrease = new JButton();
        this.decrease.setBounds(255, 350, 100, 60);
        this.decrease.setLayout(null);
        this.decrease.setText("Decrease");
        this.decrease.setVisible(false);
        this.decrease.setFocusable(false);
        this.decrease.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.decrease.setFocusPainted(false);
        this.decrease.setBackground(Color.decode("#ee4035"));
        this.decrease.setBorder(BorderFactory.createEtchedBorder());
        this.decrease.addMouseListener(new MouseAdapter() {

            private void checkDecrease() {
                if (clicksLimit < 25) {
                    sfx.playEffect(0);
                    clicksLimit++;
                }
                if (clicksCounter == -999 && clicksLimit < 25) {
                    sfx.playEffect(1);
                    clicksLimit++;
                } else if (clicksCounter > -999 && clicksCounter < 999) {
                    clicksCounter--;
                    clicksLimit++;
                    clicks.setText(String.valueOf(clicksCounter));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (!(e.getButton() == MouseEvent.BUTTON1)) {
                    return;
                }
                if (decrease.isEnabled()) {
                    checkDecrease();
                    if (clicksCounter <= 616 && story.counter666 && story.textQueue.isEmpty()) {
                        story.ending666();
                    }
                    wait = new Timer(500, w -> {
                        spam = new Timer(20, t -> {
                            checkDecrease();
                            if (clicksCounter <= 616 && story.counter666 && story.textQueue.isEmpty()) {
                                if(decrease.isEnabled()) {
                                    try {
                                        wait.stop();
                                        spam.stop();
                                    } catch (NullPointerException ignored) {}
                                }
                                story.ending666();
                            }
                        });
                        spam.start();
                    });
                    wait.setRepeats(false);
                    wait.start();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(decrease.isEnabled()) {
                    try {
                        wait.stop();
                        spam.stop();
                    } catch (NullPointerException ignored) {}
                }
                clicksLimit = 0;
            }
        });

//        this.devCheatsIncrease = new JButton();
//        this.devCheatsIncrease.setBounds(20, 350, 100, 60);
//        this.devCheatsIncrease.setLayout(null);
//        this.devCheatsIncrease.setFocusable(false);
//        this.devCheatsIncrease.setText("+50");
//        this.devCheatsIncrease.setVisible(false);
//        this.devCheatsIncrease.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//        this.devCheatsIncrease.setFocusPainted(false);
//        this.devCheatsIncrease.setBackground(Color.decode("#7bc043"));
//        this.devCheatsIncrease.setBorder(BorderFactory.createEtchedBorder());
//        this.devCheatsIncrease.addActionListener((e) -> {
//            clicksCounter += 50;
//            this.clicks.setText(String.valueOf(this.clicksCounter));
//        });
//
//        this.devCheatsDecrease = new JButton();
//        this.devCheatsDecrease.setBounds(375, 350, 100, 60);
//        this.devCheatsDecrease.setLayout(null);
//        this.devCheatsDecrease.setFocusable(false);
//        this.devCheatsDecrease.setText("+50");
//        this.devCheatsDecrease.setVisible(false);
//        this.devCheatsDecrease.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
//        this.devCheatsDecrease.setFocusPainted(false);
//        this.devCheatsDecrease.setBackground(Color.decode("#ee4035"));
//        this.devCheatsDecrease.setBorder(BorderFactory.createEtchedBorder());
//        this.devCheatsDecrease.addActionListener((e) -> {
//            clicksCounter -= 50;
//            this.clicks.setText(String.valueOf(this.clicksCounter));
//        });


        this.play = new JButton();
        this.play.setBounds(150, 310, 200, 120);
        this.play.setLayout(null);
        this.play.setText("Play");
        this.play.setVisible(true);
        this.play.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        this.play.setFocusPainted(false);
        this.play.setBackground(Color.WHITE);
        this.play.setBorder(BorderFactory.createLineBorder(Color.GRAY, 5));
        this.play.addActionListener((e) -> {

            this.submit.setVisible(true);
            this.increase.setVisible(true);
            this.decrease.setVisible(true);
            this.clicks.setVisible(true);
            this.dialogueText.setVisible(true);
            this.ending.setVisible(false);
            this.play.setVisible(false);
            this.intro.setVisible(false);
            this.setBackground(new Color(238, 238, 238));
            this.textEngine.startTheGame();

//            this.devCheatsIncrease.setVisible(true);
//            this.devCheatsDecrease.setVisible(true);

        });

        this.ending = new JLabel();
        this.ending.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.ending.setForeground(Color.WHITE);

        this.add(play);
        this.add(submit);
        this.add(increase);
        this.add(decrease);
        this.add(clicks);
        this.add(dialogueText);
        this.add(ending);
        this.add(intro);
        sfx.playSong(0);
//        this.add(devCheatsIncrease);
//        this.add(devCheatsDecrease);

    }
}
