package model;

import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.HashMap;


public class Knight extends ChessPiece {
    public Knight(FontIcon icon) {
        super(icon);
    }

    public HashMap<Direction, ArrayList<Action>> createActions(final Board state)
    {
        return new HashMap<Direction, ArrayList<Action>>() {
            {
                put(Direction.POS_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>()
                {
                    {
                        add(new Action(1, 2));
                        add(new Action(2, 1));
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>()
                {
                    {
                        add(new Action(-1, -2));
                        add(new Action(-2, -1));
                    }
                });

                put(Direction.POS_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>()
                {
                    {
                        add(new Action(1, -2));
                        add(new Action(2, -1));
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>(){
                    {
                        add(new Action(-1, 2));
                        add(new Action(-2, 1));
                    }
                });
            }
        };
    }

    @Override
    public boolean validates(Square endSquare, Board state)
    {
        return super.validates(endSquare, null);
    }

}
