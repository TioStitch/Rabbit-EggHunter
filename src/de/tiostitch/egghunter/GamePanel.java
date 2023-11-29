package de.tiostitch.egghunter;

import com.sun.tools.javac.Main;
import de.tiostitch.egghunter.controller.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private final ImageIcon icon = new ImageIcon(getClass().getResource("assets/backdraw.png"));
    private final ImageIcon carrotIcon = new ImageIcon(getClass().getResource("assets/CarrotIcon.png"));
    private final Player player = new GameMain(false).getPlayer();

    public GamePanel() {
        Timer timer = new Timer(1000/60, e -> startGameTick());
        timer.start();
    }

    public void startGameTick() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        drawSchemes(g2D);
        drawDashboard(g2D);
    }

    public void drawSchemes(Graphics2D g2D) {
        g2D.drawImage(icon.getImage(), 0, -50, null);
        g2D.drawImage(player.getIcon().getImage(), player.getX(), player.getY(), null);
    }

    public void drawDashboard(Graphics2D g2D) {
        g2D.setColor(Color.WHITE);
        g2D.fillRoundRect(260, 5, 80, 40, 20, 20);
        g2D.setColor(Color.RED);
        g2D.setFont(new Font("BOLD", Font.BOLD, 26));

        g2D.drawString("" + player.getPontuacao(), 270, 30);
        g2D.drawImage(carrotIcon.getImage(), 300, 5, null);
    }
}
