package model;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Group group;

    public Board()
    {
        group = BoardCreator.createBoard(70, Theme.DEFAULT_THEME);
    }

    public Group getGroup() {
        return group;
    }

    public HashMap<String, Square> getMySquares()
    {
        HashMap<String, Square> mySquares = new HashMap<>(64, 0.75f);

        for (Node ni : group.getChildren())
        {
            if (ni instanceof Square)
            {
                Square mySquare = (Square) ni;
                mySquares.put(mySquare.getCoordinates().key(), mySquare);
            }
        }

        return mySquares;
    }

    public Square getMySquare(String cords) {
        for (Node ni : group.getChildren()) {
            if (ni instanceof Square) {
                Square mySquare = (Square) ni;
                if (mySquare.getCoordinates().key().equals(cords.toUpperCase()))
                    return mySquare;
            }
        }
        return null;
    }

    public Square getQueuedSquare()
    {
        for (Node ni : group.getChildren())
        {
            if (ni instanceof Square)
            {
                Square square = (Square) ni;
                if (square.getRect().getStroke() == Color.LIGHTGREEN &&
                        square.getRect().getStrokeWidth() == 3.0)
                {
                    return square;
                }
            }
        }
        return null;
    }

    public boolean withinBounds(Coordinates cords)
    {
        return cords.getX() >= 1 && cords.getX() <= 8 && cords.getY() >= 1 && cords.getY() <= 8;
    }

    public void popBoard(HashMap<String, ChessPiece> map)
    {
        for (Map.Entry<String, Square> square : getMySquares().entrySet()) {
            String cords = square.getValue().getCoordinates().key();
            if (map.containsKey(cords))
                square.getValue().setChessPiece(map.get(cords));
        }

    }

}