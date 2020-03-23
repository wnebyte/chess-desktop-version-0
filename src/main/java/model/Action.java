package model;

import javafx.scene.paint.Color;

public class Action {
    private final int x;
    private final int y;
    private Color[] permissibleBy;

    public Action(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Action(int x, int y, Color[] permissibleBy) {
        this.x = x;
        this.y = y;
        this.permissibleBy = permissibleBy;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color[] getPermissibleBy() {
        return permissibleBy;
    }


}