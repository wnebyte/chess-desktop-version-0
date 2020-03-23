package model;

import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.HashMap;

public class King extends ChessPiece {
    public King(FontIcon icon) {
        super(icon);
    }

    public HashMap<Direction, ArrayList<Action>> createActions(final Board state)
    {
        // Todo: imp checkCheck
        return new HashMap<Direction, ArrayList<Action>>() {
            {
                put(Direction.POS_HORIZONTAL, new ArrayList<Action>() {
                    {
                        add(new Action(1, 0));
                    }
                });

                put(Direction.NEG_HORIZONTAL, new ArrayList<Action>() {
                    {
                        add(new Action(-1, 0));
                    }
                });

                put(Direction.POS_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(0, 1));
                    }
                });

                put(Direction.NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(0, -1));
                    }
                });

                put(Direction.POS_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(1, 1));
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(-1, -1));
                    }
                });

                put(Direction.POS_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(1, -1));
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>() {
                    {
                        add(new Action(-1, 1));
                    }
                });
            }
        };
    }
}
