package com.github.starnowski.jbehave.fun;

import java.util.ArrayList;
import java.util.List;

public class StringRenderer {

    private int width;
    private int height;

    private List<Cordinates> cordinates = new ArrayList<Cordinates>();

    public String asString() {
        char[][] map = new char[height][width];
        for (int raw = 0; raw < height; raw++)
        {
            for (int col = 0; col < width; col++)
            {
                map[raw][col] = '.';
            }
        }
        for (Cordinates cor: cordinates)
        {
            map[cor.getY()][cor.getX()] = 'X';
        }
        StringBuilder sb = new StringBuilder();
        for (int raw = 0; raw < height; raw++)
        {
            for (int col = 0; col < width; col++)
            {
                sb.append(map[raw][col]);
            }
            if (raw < height - 1 ) {
                sb.append(String.format("%n"));
            }
        }
        return sb.toString();
    }

    public void setSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void toggleCellAt(int column, int row) {
        cordinates.add(new Cordinates(column, row));
    }
}
