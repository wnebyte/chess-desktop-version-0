package model;

import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class BoardCreator {

    private static final String[] LETTERS = {"A", "B", "C", "D", "E", "F", "G", "H"};
    private static final String[] NUMBERS = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final String[] REVERSE_NUMBERS = {"8", "7", "6", "5", "4", "3", "2", "1"};

    public static Group createBoard(final int size, Theme theme)
    {
        if (theme == null)
            theme = Theme.DEFAULT_THEME;

        Group rootNode = new Group();
        boolean isLight = true;

        for (int row = 0; row < 8; row++)
        {
            rootNode.getChildren().add(createFrame(
                    0, size / 2.0 + (size * row),
                    size / 2.0, size, REVERSE_NUMBERS[row], theme
            ));

            for (int col = 0; col < 8; col++)
            {
                if (row == 0) {
                    rootNode.getChildren().add(createFrame(
                            size / 2.0 + (col * size), 0,
                            size, size / 2.0, LETTERS[col], theme
                    ));
                }

                Color fillColor;
                if (isLight)
                    fillColor = theme.getSquarePrimaryColor();
                else
                    fillColor = theme.getSquareSecondaryColor();
                isLight = !isLight;

                final Square mySquare = new Square(
                        size / 2.0 + (col * size), size / 2.0 + (row * size),
                        size, fillColor, theme.getSquareStrokeColor(),
                        new Coordinates(Integer.parseInt(NUMBERS[col]), Integer.parseInt(REVERSE_NUMBERS[row]))
                );
                rootNode.getChildren().add(mySquare);

                rootNode.getChildren().add(createFrame(
                        size / 2.0 + (size * 8), size / 2.0 + (size * col),
                        size / 2.0, size,
                        "", theme
                ));
            }
            isLight = !isLight;

            rootNode.getChildren().add(createFrame(
                    size / 2.0 + (size * row), size / 2.0 + (size * 8),
                    size, size / 2.0,
                    "", theme
            ));
        }

        rootNode.getChildren().add(createCorner(
                0, 0, size / 2.0, size / 2.0,
                0, 0, size / 2.0, size / 2.0, theme
        ));
        rootNode.getChildren().add(createCorner(
                size / 2.0 + (size * 8), 0, size / 2.0, size / 2.0,
                size + (size * 8), 0, size / 2.0 + (size * 8), size / 2.0, theme
        ));
        rootNode.getChildren().add(createCorner(
                0, size / 2.0 + (size * 8), size / 2.0, size / 2.0,
                size + (size * 8), 0, size / 2.0 + (size * 8), size / 2.0, theme
        ));
        rootNode.getChildren().add(createCorner(
                size / 2.0 + (size * 8), size / 2.0 + (size * 8), size / 2.0, size / 2.0,
                size + (size * 8), size + (size * 8), size / 2.0 + (size * 8), size / 2.0 + (size * 8), theme
        ));

        return rootNode;
    }

    private static StackPane createFrame(double xLayout, double yLayout, double rectWidth, double rectHeight, String c,
                                         Theme theme) {
        StackPane sPane = new StackPane();
        sPane.setLayoutX(xLayout);
        sPane.setLayoutY(yLayout);
        Rectangle rect = new Rectangle(rectWidth, rectHeight);
        rect.setFill(theme.getFramePrimaryColor());
        rect.setStroke(theme.getFrameStrokeColor());
        Text text = new Text(c);
        text.setStroke(theme.getFrameSecondaryColor());
        sPane.getChildren().addAll(rect, text);
        return sPane;
    }

    private static StackPane createCorner(double xLayout, double yLayout, double rectWidth, double rectHeight,
                                          double xStart, double yStart, double xEnd, double yEnd, Theme theme) {
        StackPane sPane = new StackPane();
        sPane.setLayoutX(xLayout);
        sPane.setLayoutY(yLayout);
        Rectangle rect = new Rectangle(rectWidth, rectHeight);
        rect.setFill(theme.getFramePrimaryColor());
        rect.setStroke(theme.getFrameStrokeColor());
        /*
        Line line = new Line(xStart, yStart, xEnd, yEnd);
        line.setStroke(Color.BLACK);
        line.setStrokeWidth(0.5);

         */
        sPane.getChildren().addAll(rect);
        return sPane;
    }

}