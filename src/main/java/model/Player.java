package model;

import javafx.scene.paint.Color;

import java.util.HashMap;

public class Player {
    private final Color color;
    private HashMap<String, ChessPiece> initChessPieces;

    public Player(Color color) {
        this.color = color;
    }

    public Player(Color colorOfPieces, HashMap<String, ChessPiece> initPieces) {
        this.color = colorOfPieces;
        this.initChessPieces = initPieces;
    }

    public Color getColor() {
        return color;
    }


    public HashMap<String, ChessPiece> getInitChessPieces() {
        return initChessPieces;
    }

}