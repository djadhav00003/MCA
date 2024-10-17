import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class BasketballGame extends JPanel implements ActionListener {
    private double angle; // in degrees
    private double power; // power of the shot
    private double ballX, ballY; // Ball position
    private boolean isShooting = false;
    private Timer timer;
    private Random random;
    private int basketX, basketY; // Basket position

    public BasketballGame() {
        setPreferredSize(new Dimension(600, 400));
        setBackground(Color.BLACK); // Set background to black
        timer = new Timer(20, this);
        random = new Random();

        // Initialize basket position
        resetBasket();

        // Input panel
        JPanel inputPanel = new JPanel();
        JTextField angleField = new JTextField(5);
        JTextField powerField = new JTextField(5);
        JButton shootButton = new JButton("Shoot");

        shootButton.addActionListener(e -> {
            try {
                angle = Double.parseDouble(angleField.getText());
                power = Double.parseDouble(powerField.getText());
                ballX = 50; // Starting position
                ballY = 350; // Ground level
                isShooting = true;
                timer.start();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input. Please enter numeric values.");
            }
        });

        inputPanel.add(new JLabel("Angle (degrees):"));
        inputPanel.add(angleField);
        inputPanel.add(new JLabel("Power (0-100):"));
        inputPanel.add(powerField);
        inputPanel.add(shootButton);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw basket (centered)
        g.setColor(Color.RED);
        g.fillRect(basketX, basketY, 20, 10); // Basket's rim
        g.drawRect(basketX - 20, basketY + 10, 60, 40); // Backboard

        // Draw ball
        g.setColor(Color.ORANGE);
        g.fillOval((int) ballX, (int) ballY, 20, 20);
    }

    private void resetBasket() {
        // Randomly position the basket
        basketX = random.nextInt(600 - 60) + 20; // Keep it within bounds
        basketY = random.nextInt(100) + 100; // Ensure it's not too low
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isShooting) {
            // Calculate ball position
            double radians = Math.toRadians(angle);
            double gravity = 9.8; // gravity
            double time = (ballX / (power * Math.cos(radians))); // time of flight

            ballY = (int) (350 - (power * Math.sin(radians) * time - 0.5 * gravity * Math.pow(time, 2)));

            // Move the ball faster
            ballX += power * Math.cos(radians) * 0.1; // increased speed

            // Check if ball is in basket
            if (ballX >= basketX - 20 && ballX <= basketX + 20 && ballY >= basketY && ballY <= basketY + 10) {
                // Check if more than half the ball is inside the basket
                if (ballX + 20 > basketX && ballX < basketX + 20 && ballY + 20 > basketY && ballY < basketY + 10) {
                    JOptionPane.showMessageDialog(this, "Score!");
                    resetBasket(); // Move the basket after scoring
                } else {
                    // Inform that it didn't count
                    JOptionPane.showMessageDialog(this, "Miss! Ball not inside enough.");
                }
                isShooting = false;
                ballX = 50; // Reset ball position
                timer.stop();
            }

            // Reset if the ball goes out of bounds
            if (ballX > 600) {
                isShooting = false;
                timer.stop();
            }

            repaint();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Basketball Game");
        BasketballGame game = new BasketballGame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
