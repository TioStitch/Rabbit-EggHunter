package de.tiostitch.egghunter.controller;

import javax.swing.*;

public class Player {

    private int x,y;
    private ImageIcon icon;
    private short pontuacao;

    public Player(int x, int y, ImageIcon icon) {
        this.x = x;
        this.y = y;

        this.icon = icon;
        this.pontuacao = 0;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public short getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(short pontuacao) {
        this.pontuacao = pontuacao;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}
