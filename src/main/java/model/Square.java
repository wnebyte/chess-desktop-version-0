package model;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class Square extends StackPane {
    private final Coordinates cords;
    private final Rectangle rect;

    public Square(double layoutX, double layoutY,
                  int size, Color fillColor, Color strokeColor, Coordinates cords) {
        setLayoutX(layoutX);
        setLayoutY(layoutY);
        rect = new Rectangle(size, size);
        rect.setFill(fillColor);
        rect.setStroke(strokeColor);
        rect.setStrokeType(StrokeType.INSIDE);
        rect.setStrokeWidth(0.5);
        this.cords = cords;
        getChildren().add(rect);
    }

    public Coordinates getCoordinates() {
        return cords;
    }

    public Rectangle getRect()
    {
        return rect;
    }

    public ChessPiece getChessPiece() {
        for (Node n : getChildren()) {
            if (n instanceof ChessPiece) {
                return (ChessPiece) n;
            }
        }
        return null;
    }

    public void setChessPiece(ChessPiece cP) {
        ChessPiece existingCp;

        if ((existingCp = getChessPiece()) != null) {
            getChildren().remove(existingCp);
        }

        if (cP != null) {
            getChildren().add(cP);
        }
    }

    public void queue() {
        rect.setStroke(Color.LIGHTGREEN);
        rect.setStrokeWidth(3.0);
    }

    public void dequeue() {
        rect.setStroke(Color.BLACK);
        rect.setStrokeWidth(0.5);
    }
}