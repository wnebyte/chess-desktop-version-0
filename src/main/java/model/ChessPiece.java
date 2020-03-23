package model;

import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class ChessPiece extends Label {
    private FontIcon icon;

    public ChessPiece(FontIcon icon)
    {
        this.icon = icon;
        setGraphic(icon);
    }

    public abstract HashMap<Direction, ArrayList<Action>> createActions(final Board state);

    public boolean validates(final Square endSquare, final Board state)
    {
        assert getParent() instanceof Square;
        final Square startSquare = (Square) getParent();
        final Direction relDirection =
                Util.calcDirection(startSquare.getCoordinates(), endSquare.getCoordinates());
        ArrayList<Action> potActions = createActions(state).get(relDirection);

        if (potActions == null)
            return false;

        for (Action action : potActions)
        {
            Coordinates n_cords =
                    new Coordinates(
                            startSquare.getCoordinates().getX() + action.getX(),
                            startSquare.getCoordinates().getY() + action.getY()
                    );

            if (n_cords.getX() < -8 || n_cords.getX() > 8 || n_cords.getY() < -8 || n_cords.getY() > 8)
                continue;

            if (state != null)
            {
                if (state.getMySquare(n_cords.key()).getChessPiece() != null)
                {
                    while (action != potActions.get(potActions.size() - 1))
                    {
                        potActions.remove(potActions.size() - 1);
                    }
                }
            }

            if (n_cords.equals(endSquare.getCoordinates()))
                return true;
        }

        return false;
    }

    public Paint getIconColor()
    {
        return icon.getIconColor();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ChessPiece chessPiece = (ChessPiece) obj;
        return icon == chessPiece.icon;
    }

    @Override
    public int hashCode()
    {
        final int prime = 62;
        int result = 5;
        result = prime * result + 79;
        return result;
    }
}
