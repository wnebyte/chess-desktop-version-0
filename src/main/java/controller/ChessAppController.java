package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.*;

public class ChessAppController {

    @FXML
    private StackPane root;

    private final BackgroundImage backgroundImage = new BackgroundImage(
            new Image(getClass().getResource("/image/wallpaper.png").
                    toExternalForm(), 1920, 1080, false, true),
            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT
    );

    private final Game game = new Game(
            new Player(Color.WHITE, Util.getWhitePieces()),
            new Player(Color.BLACK, Util.getBlackPieces())
    );

    @FXML
    private final Group group = game.getBoard().getGroup();

    public void initialize()
    {
        root.setBackground(new Background(backgroundImage));

        root.sceneProperty().addListener((observableScene, oldScene, newScene) -> {
         if (oldScene == null && newScene != null)
         {
             newScene.windowProperty().addListener((observableWindow, oldWindow, newWindow) -> {
                 if (oldWindow == null && newWindow != null)
                 {
                     Stage stage = (Stage) newWindow;
                     stage.setMaximized(true);
                     stage.setResizable(false);
                 }
             });
         }
     });
    }

    @FXML
    private void setOnMousePressed(MouseEvent mouseEvent) {
        Node parent = mouseEvent.getPickResult().getIntersectedNode().getParent();
        Square square = null;

        if (parent instanceof Square)
            square = (Square) parent;
        else if (parent.getParent() instanceof Square)
            square = (Square) parent.getParent();
        if (square != null) {
            handleSquarePressed(square);
        }
    }

    private void handleSquarePressed(Square square) {
        String key = square.getCoordinates().key();

        // a square containing a chessPiece has been clicked
        if (square.getChessPiece() != null)
        {
            // a chessPiece of the same color as the nextPlayer has been clicked
            if (square.getChessPiece().getIconColor() == game.peekNextPlayer().getColor()) {

                if (game.getBoard().getQueuedSquare() != null &&
                        game.getBoard().getQueuedSquare().equals(square)) {
                    square.dequeue();
                }
                else
                {
                    game.getBoard().getMySquares().values().
                            iterator().forEachRemaining(Square::dequeue);
                    square.queue();
                }
            }
            // a chessPiece of the opposite color as the nextPlayer has been clicked
            else if (square.getChessPiece().getIconColor() == game.peekNotNextPlayer().getColor())
            {
                if (game.getBoard().getQueuedSquare() != null)
                {
                    if (game.getBoard().getQueuedSquare().getChessPiece().validates(square, game.getBoard()))
                    {
                        square.setChessPiece(game.getBoard().getQueuedSquare().getChessPiece());
                        game.getBoard().getQueuedSquare().setChessPiece(null);
                        game.getBoard().getQueuedSquare().dequeue();
                        game.nextPlayer();
                    }
                }

            }
        }
        // a square not containing a chessPiece has been clicked
        else
        {
            if (game.getBoard().getQueuedSquare() != null)
            {
                if (game.getBoard().getQueuedSquare().getChessPiece().validates(square, game.getBoard()))
                {
                    square.setChessPiece(game.getBoard().getQueuedSquare().getChessPiece());
                    game.getBoard().getQueuedSquare().setChessPiece(null);
                    game.getBoard().getQueuedSquare().dequeue();
                    game.nextPlayer();
                }
            }
        }
    }
}
