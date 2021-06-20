package com.github.starnowski.jbehave.fun;

public class Game {

    StringRenderer renderer;
    private int width;
    private int height;

    public Game(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setObserver(StringRenderer renderer) {
        this.renderer = renderer;
        this.renderer.setSize(this.width, this.height);
    }

    public void toggleCellAt(int column, int row) {
        renderer.toggleCellAt(column, row);
    }
}
