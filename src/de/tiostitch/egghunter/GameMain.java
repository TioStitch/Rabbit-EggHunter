package de.tiostitch.egghunter;

import com.sun.tools.javac.Main;
import de.tiostitch.egghunter.controller.Grass;
import de.tiostitch.egghunter.controller.KeyHandler;
import de.tiostitch.egghunter.controller.Player;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameMain extends JFrame  {
    private static final Player player = new Player((short) 195, (short) 150, new ImageIcon(GameMain.class.getResource("assets/Idle_Left.gif")));
    private static final List<Grass> eggsGrass = new ArrayList<>();
    private final GameMain main;


    public GameMain(boolean load) {
        main = this;

        if (load) {
            startPanel();
            loadGrass();
        }
    }


    public static void main(String[] args) {
        new GameMain(true);
    }


    public void startPanel() {
        setTitle("Egg Hunter ALPHA-1");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        add(new GamePanel());
        addKeyListener(new KeyHandler());

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public Player getPlayer() {
        return player;
    }

    public void updatePlayer(String type, String direction) {
        String formula = "assets/" + type + direction + ".gif";
        ImageIcon icon = new ImageIcon(getClass().getResource(formula));
        player.setIcon(icon);
    }

    public void loadGrass() {
        eggsGrass.add(new Grass(145, 180, 40, 40));
        eggsGrass.add(new Grass(115, 94, 40, 40));
        eggsGrass.add(new Grass(239, 54, 40, 40));
        eggsGrass.add(new Grass(407, 134, 40, 40));
        eggsGrass.add(new Grass(385, 236,40, 40));
    }

    public List<Grass> getEggsGrass() {
        return eggsGrass;
    }

    public boolean itsMAXED() {
        final int MAX_SCORE = 20;
        return getPlayer().getPontuacao() == MAX_SCORE;
    }

    public GameMain getMain() {
        return main;
    }
}
