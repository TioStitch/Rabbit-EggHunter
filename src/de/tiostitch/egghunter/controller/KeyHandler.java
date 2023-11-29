package de.tiostitch.egghunter.controller;

import de.tiostitch.egghunter.GameMain;
import de.tiostitch.egghunter.GameSound;
import de.tiostitch.egghunter.utilities.SoundType;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private final GameMain main = new GameMain(false);
    private final Player player = main.getPlayer();


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int x = player.getX();
        int y = player.getY();

        int speed = ((player.getPontuacao()/2) + 2);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                if (isAround(x, y)) {
                    player.setY((short) (y - speed));
                    return;
                }
                player.setY((short) (y + speed));
                break;
            case KeyEvent.VK_DOWN:
                if (isAround(x, y)) {
                    player.setY((short) (y + speed));
                    return;
                }
                player.setY((short) (y - speed));
                break;
            case KeyEvent.VK_RIGHT:
                if (isAround(x, y)) {
                    player.setX((short) (x + speed));
                    main.updatePlayer("Walk", "_Right");
                    return;
                }
                player.setX((short) (x - speed));
                break;
            case KeyEvent.VK_LEFT:
                if (isAround(x, y)) {
                    player.setX((short) (x - speed));
                    main.updatePlayer("Walk", "_Left");
                    return;
                }
                player.setX((short) (x + speed));
                break;
            case KeyEvent.VK_ENTER:
                if (main.itsMAXED()) {
                    return;
                }

                Rectangle playerRectangle = new Rectangle(player.getX(), player.getY(), 30, 30);
                main.getEggsGrass().forEach(grass -> {
                    Rectangle grassRectangle = new Rectangle(grass.getX(), grass.getY(), grass.getWidth(), grass.getHeight());

                    if (verificarColisao(grassRectangle, playerRectangle)) {
                        player.setPontuacao((short) (player.getPontuacao() + 1));

                        if (player.getPontuacao() == 20) {
                            new GameSound(SoundType.MAXED).play();
                            return;
                        }
                            new GameSound(SoundType.PICKUP).play();
                    }
                });

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                main.updatePlayer("Idle", "_Right");
                break;
            case KeyEvent.VK_LEFT:
                main.updatePlayer("Idle", "_Left");
                break;
        }
    }

    private static boolean verificarColisao(Rectangle r1, Rectangle r2) {
        return r1.intersects(r2);
    }

    private boolean isAround(int x, int y) {
        final int x1 = 59, y1 = 14;
        final int x2 = 499, y2 = 302;

        return x >= x1 && x <= x2 && y >= y1 && y <= y2;
    }
}
