package model;

import javafx.scene.paint.Color;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.HashMap;

public class Util {

    public static Coordinates cordsToCoordinates(String cords)
    {
        if (cords.length() != 2)
            throw new IllegalArgumentException(
                    "cords length must == 2"
            );

        int y = Integer.parseInt(String.valueOf(cords.charAt(1)));

        if (y < 0 || y > 8)
            throw new IllegalArgumentException(
                    "0 < cords.charAt(1) <= 8"
            );

        int x;

        switch (cords.toUpperCase().charAt(0))
        {
            case 'A':
                x = 1;
                break;
            case 'B':
                x = 2;
                break;
            case 'C':
                x = 3;
                break;
            case 'D':
                x = 4;
                break;
            case 'E':
                x = 5;
                break;
            case 'F':
                x = 6;
                break;
            case 'G':
                x = 7;
                break;
            case 'H':
                x = 8;
                break;
            default:
                throw new IllegalArgumentException(
                        "cords.charAt(0) must be one of: " +
                                "A, B, C, D, E, F, G, H"
                );
        }

        return new Coordinates(x, y);
    }

    public static String coordinatesToCords(Coordinates c)
    {
        IllegalArgumentException iAE = new IllegalArgumentException(
                "1 <= x <= 8 AND 1 <= y <= 8"
        );

        if (c.getX() < 1 || c.getX() > 8 || c.getY() < 1 || c.getY() > 8)
            throw iAE;

        StringBuilder cordsBuilder = new StringBuilder();

        switch (c.getX())
        {
            case 1:
                cordsBuilder.append("A");
                break;
            case 2:
                cordsBuilder.append("B");
                break;
            case 3:
                cordsBuilder.append("C");
                break;
            case 4:
                cordsBuilder.append("D");
                break;
            case 5:
                cordsBuilder.append("E");
                break;
            case 6:
                cordsBuilder.append("F");
                break;
            case 7:
                cordsBuilder.append("G");
                break;
            case 8:
                cordsBuilder.append("H");
                break;
            default:
                throw iAE;
        }

        cordsBuilder.append(c.getY());

        return new String(cordsBuilder);
    }

    public static Direction calcDirection(Coordinates startSquare, Coordinates endSquare)
    {
        int xDelta = endSquare.getX() - startSquare.getX();
        int yDelta = endSquare.getY() - startSquare.getY();
        Direction direction = null;

        if (xDelta > 0 & yDelta > 0)
            direction = Direction.POS_HORIZONTAL_AND_POS_VERTICAL;
        else if (xDelta < 0 && yDelta < 0)
            direction = Direction.NEG_HORIZONTAL_AND_NEG_VERTICAL;
        else if (xDelta < 0 && yDelta > 0)
            direction = Direction.NEG_HORIZONTAL_AND_POS_VERTICAL;
        else if (xDelta > 0 && yDelta <0)
            direction = Direction.POS_HORIZONTAL_AND_NEG_VERTICAL;
        else if (xDelta > 0)
            direction = Direction.POS_HORIZONTAL;
        else if (xDelta < 0)
            direction = Direction.NEG_HORIZONTAL;
        else if (yDelta > 0)
            direction = Direction.POS_VERTICAL;
        else if (yDelta < 0)
            direction = Direction.NEG_VERTICAL;

        return direction;
    }

    private static int size = 34;

    private static HashMap<String, ChessPiece> whitePieces = new HashMap<>() {
        {

            put("A1", new Rook  (getFontIcon("CHESS_ROOK",   size, Color.WHITE, Color.BLACK)));
            put("B1", new Knight(getFontIcon("CHESS_KNIGHT", size, Color.WHITE, Color.BLACK)));
            put("C1", new Bishop(getFontIcon("CHESS_BISHOP", size, Color.WHITE, Color.BLACK)));
            put("D1", new Queen (getFontIcon("CHESS_QUEEN",  size, Color.WHITE, Color.BLACK)));
            put("E1", new King  (getFontIcon("CHESS_KING",   size, Color.WHITE, Color.BLACK)));
            put("F1", new Bishop(getFontIcon("CHESS_BISHOP", size, Color.WHITE, Color.BLACK)));
            put("G1", new Knight(getFontIcon("CHESS_KNIGHT", size, Color.WHITE, Color.BLACK)));
            put("H1", new Rook  (getFontIcon("CHESS_ROOK",   size, Color.WHITE, Color.BLACK)));
            put("A2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("B2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("C2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("D2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("E2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("F2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("G2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));
            put("H2", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.WHITE, Color.BLACK)));

        }
    };

    private static HashMap<String, ChessPiece> blackPieces = new HashMap<>() {
        {

            put("A8", new Rook  (getFontIcon("CHESS_ROOK",   size, Color.BLACK, Color.WHITE)));
            put("B8", new Knight(getFontIcon("CHESS_KNIGHT", size, Color.BLACK, Color.WHITE)));
            put("C8", new Bishop(getFontIcon("CHESS_BISHOP", size, Color.BLACK, Color.WHITE)));
            put("D8", new Queen (getFontIcon("CHESS_QUEEN",  size, Color.BLACK, Color.WHITE)));
            put("E8", new King  (getFontIcon("CHESS_KING",   size, Color.BLACK, Color.WHITE)));
            put("F8", new Bishop(getFontIcon("CHESS_BISHOP", size, Color.BLACK, Color.WHITE)));
            put("G8", new Knight(getFontIcon("CHESS_KNIGHT", size, Color.BLACK, Color.WHITE)));
            put("H8", new Rook  (getFontIcon("CHESS_ROOK",   size, Color.BLACK, Color.WHITE)));
            put("A7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("B7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("C7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("D7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("E7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("F7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("G7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
            put("H7", new Pawn  (getFontIcon("CHESS_PAWN",   size, Color.BLACK, Color.WHITE)));
        }
    };

    public static HashMap<String, ChessPiece> getWhitePieces() {
        return whitePieces;
    }

    public static HashMap<String, ChessPiece> getBlackPieces() {
        return blackPieces;
    }

    public static FontIcon getFontIcon(String description, int iconSize, Color fillColor, Color strokeColor) {
        FontAwesomeSolid iconCode = FontAwesomeSolid.valueOf(description);
        FontIcon fontIcon = FontIcon.of(FontAwesomeSolid.valueOf(description), iconSize, fillColor);
        fontIcon.setStroke(strokeColor);
        return fontIcon;
    }


}
