import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ImageFrame extends JFrame {
    private JLabel imageLabel;
    private ImageIcon[] images = new ImageIcon[4];
    int currentId;

    public ImageFrame() {
        setTitle("Open Challenge 11");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        for (int i = 0; i < images.length; i++)
            images[i] = new ImageIcon("images/image" + i + ".jpg");

        currentId = 0;
        imageLabel = new JLabel(images[currentId]);
        c.add(imageLabel, BorderLayout.CENTER);
        c.add(new MenuPanel(), BorderLayout.SOUTH);

        setSize(300, 400);
        setVisible(true);
    }

    class MenuPanel extends JPanel {
        public MenuPanel() {
            setBackground(Color.GRAY);
            ImageIcon leftIcon = new ImageIcon("images/left.png");
            ImageIcon rightIcon = new ImageIcon("images/right.png");
            JButton leftBtn = new JButton(leftIcon);
            JButton rightBtn = new JButton(rightIcon);

            add(leftBtn);
            add(rightBtn);

            leftBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentId--;
                    currentId += images.length;
                    currentId %= images.length;
                    imageLabel.setIcon(images[currentId]);
                }
            });

            rightBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    currentId++;
                    currentId %= images.length;
                    imageLabel.setIcon(images[currentId]);
                }
            });
        }
    }

    public static void main(String[] args) {
        new ImageFrame();
    }
}
