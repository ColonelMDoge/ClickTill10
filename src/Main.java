import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class Main implements Serializable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Till 10!");
        final GamePanel gp = new GamePanel();
        gp.setSize(500, 500);
        gp.setLayout(null);
        frame.add(gp);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (gp.story.resets < 3)
                    gp.story.resets++;
                try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("data/Playerdat.ser")))) {
                    oos.writeObject(gp.story.endingChecklist);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                try (DataOutputStream dos = new DataOutputStream(Files.newOutputStream(Paths.get("data/Resets.txt")))) {
                    dos.write(gp.story.resets);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        ImageIcon image = new ImageIcon(Objects.requireNonNull(Main.class.getResource("Icon.png")));
        frame.setIconImage(image.getImage());
    }
}