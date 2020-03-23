package model;

import javafx.scene.paint.Color;
import org.kordamp.ikonli.javafx.FontIcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pawn extends ChessPiece {

    private static final List<String> WHITE_START_CORDS = new ArrayList<>() {
        {
            add("A2"); add("B2"); add("C2"); add("D2"); add("E2"); add("F2"); add("G2"); add("H2");
        }
    };

    private static final List<String> BLACK_START_CORDS = new ArrayList<>() {
        {
            add("A7"); add("B7"); add("C7"); add("D7"); add("E7"); add("F7"); add("G7"); add("H7");
        }
    };

    public Pawn(FontIcon icon)
    {
        super(icon);
    }

    public HashMap<Direction, ArrayList<Action>> createActions(final Board state)
    {
        final Square parent = (Square) getParent();
        final Coordinates c_cords = parent.getCoordinates();

        return new HashMap<Direction, ArrayList<Action>>() {
            {
                put(Direction.POS_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.WHITE)
                        {
                            Coordinates n_cords = new Coordinates(c_cords.getX(), c_cords.getY() + 1);

                            if (state.withinBounds(n_cords))
                            {
                                if (state.getMySquare(n_cords.key()).getChessPiece() == null)
                                {
                                    add(new Action(0, 1));

                                }
                            }

                            n_cords = new Coordinates(c_cords.getX(), c_cords.getY() + 2);

                            if (state.withinBounds(n_cords))
                            {
                                if (state.getMySquare(n_cords.key()).getChessPiece() == null)
                                {
                                    if (WHITE_START_CORDS.contains(c_cords.key()))
                                    {
                                        add(new Action(0, 2));
                                    }
                                }
                            }
                        }
                    }
                });

                put(Direction.NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.BLACK)
                        {
                            Coordinates n_cords = new Coordinates(c_cords.getX(), c_cords.getY() - 1);

                            if (state.withinBounds(n_cords))
                            {
                                if (state.getMySquare(n_cords.key()).getChessPiece() == null)
                                {
                                    add(new Action(0, -1));
                                }
                            }

                            n_cords = new Coordinates(c_cords.getX(), c_cords.getY() - 2);

                            if (state.withinBounds(n_cords))
                            {
                                if (state.getMySquare(n_cords.key()).getChessPiece() == null)
                                {
                                    if (BLACK_START_CORDS.contains(c_cords.key()))
                                    {
                                        add(new Action(0, -2));
                                    }
                                }
                            }
                        }
                    }
                });

                put(Direction.POS_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.WHITE)
                        {
                            final Coordinates n_cords = new Coordinates(c_cords.getX() + 1, c_cords.getY() + 1);
                            ChessPiece chessPiece;

                            if (state.withinBounds(n_cords))
                            {
                                if ((chessPiece = state.getMySquare(n_cords.key()).getChessPiece()) != null)
                                {
                                    if (chessPiece.getIconColor() != getIconColor())
                                    {
                                        add(new Action(1, 1));
                                    }
                                }
                            }
                        }
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.BLACK)
                        {
                            final Coordinates n_cords = new Coordinates(c_cords.getX() - 1, c_cords.getY() - 1);
                            ChessPiece chessPiece;

                            if (state.withinBounds(n_cords))
                            {
                                if ((chessPiece = state.getMySquare(n_cords.key()).getChessPiece()) != null)
                                {
                                    if (chessPiece.getIconColor() != getIconColor())
                                    {
                                        add(new Action(-1, -1));
                                    }
                                }
                            }
                        }
                    }
                });

                put(Direction.NEG_HORIZONTAL_AND_POS_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.WHITE)
                        {
                            final Coordinates n_cords = new Coordinates(c_cords.getX() - 1, c_cords.getY() + 1);
                            ChessPiece chessPiece;

                            if (state.withinBounds(n_cords))
                            {
                                if ((chessPiece = state.getMySquare(n_cords.key()).getChessPiece()) != null)
                                {
                                    if (chessPiece.getIconColor() != getIconColor())
                                    {
                                        add(new Action(-1, 1));
                                    }
                                }
                            }
                        }
                    }
                });

                put(Direction.POS_HORIZONTAL_AND_NEG_VERTICAL, new ArrayList<Action>() {
                    {
                        if (getIconColor() == Color.BLACK)
                        {
                            final Coordinates n_cords = new Coordinates(c_cords.getX() + 1, c_cords.getY() - 1);
                            ChessPiece chessPiece;

                            if (state.withinBounds(n_cords))
                            {
                                if ((chessPiece = state.getMySquare(n_cords.key()).getChessPiece()) != null)
                                {
                                    if (chessPiece.getIconColor() != getIconColor())
                                    {
                                        add(new Action(1, -1));
                                    }
                                }
                            }
                        }
                    }
                });
            }
        };
    }
}
