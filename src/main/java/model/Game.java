package model;

import javafx.scene.Group;

import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Game {
    private Queue<Player> queue = new LinkedBlockingQueue<>();
    private Board board = new Board();

    public Game(Player playerOne, Player playerTwo) {
        queue.add(playerOne);
        queue.add(playerTwo);
        getBoard().popBoard(getInitChessPieces());

    }


    public Player getPlayerOne() {
        return (Player) queue.toArray()[0];
    }

    public Player getPlayerTwo() {
        return (Player) queue.toArray()[1];
    }

    public void nextPlayer() {
        Player nextPlayer = queue.poll();
        queue.add(nextPlayer);
    }

    public Player peekNextPlayer() {
        return queue.peek();
    }

    public Player peekNotNextPlayer()
    {
        if (peekNextPlayer().equals(getPlayerOne()))
            return getPlayerTwo();
        else
            return getPlayerOne();
    }

    public Group getRoot() {
        return board.getGroup();
    }

    public Board getBoard() {
        return board;
    }

    private HashMap<String, ChessPiece> getInitChessPieces()
    {
        return new HashMap<>() {
            {
                putAll(getPlayerOne().getInitChessPieces());
                putAll(getPlayerTwo().getInitChessPieces());
            }
        };
    }
}
