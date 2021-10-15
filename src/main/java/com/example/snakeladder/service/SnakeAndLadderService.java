package com.example.snakeladder.service;

import com.example.snakeladder.models.Ladder;
import com.example.snakeladder.models.Player;
import com.example.snakeladder.models.Snake;
import com.example.snakeladder.models.SnakeAndLadderBoard;

import java.util.*;


public class SnakeAndLadderService {
    private static final int DEFAULT_BOARD_SIZE = 100;
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private Queue<Player> players;


    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<Player>();
    }

    public SnakeAndLadderService() {
        this(SnakeAndLadderService.DEFAULT_BOARD_SIZE);
    }

    /**
     * ==================Initialize board==================
     */

    public void setPlayers(Player player) {
        this.players = new LinkedList<Player>();
        Map<String, Integer> playerPieces = new HashMap<String, Integer>();
        this.players.add(player);
        playerPieces.put(player.getId(), 0);
        snakeAndLadderBoard.setPlayerPieces(playerPieces);
    }

    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders); // Add ladders to board
    }


    private int getNewPositionAfterGoingThroughSnakesAndLadders(int newPosition) {
        int previousPosition;

        do {
            previousPosition = newPosition;
            for (Snake snake : snakeAndLadderBoard.getSnakes()) {
                if (snake.getStart() == newPosition) {
                    newPosition = snake.getEnd();
                }
            }

            for (Ladder ladder : snakeAndLadderBoard.getLadders()) {
                if (ladder.getStart() == newPosition) {
                    newPosition = ladder.getEnd();
                }
            }
        } while (newPosition != previousPosition);
        return newPosition;
    }

    private void movePlayer(Player player, int positions) {
        int oldPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int newPosition = oldPosition + positions;
        int boardSize = snakeAndLadderBoard.getSize();

        if (newPosition > boardSize) {
            newPosition = oldPosition;
        } else {
            newPosition = getNewPositionAfterGoingThroughSnakesAndLadders(newPosition);
        }
        snakeAndLadderBoard.getPlayerPieces().put(player.getId(), newPosition);

        System.out.println(player.getName() + " rolled a " + positions + " and moved from " + oldPosition + " to " + newPosition);
    }


    private boolean hasPlayerWon(Player player) {

        int playerPosition = snakeAndLadderBoard.getPlayerPieces().get(player.getId());
        int winningPosition = snakeAndLadderBoard.getSize();
        return playerPosition == winningPosition;
    }


    public void startGame(Boolean flag,Integer noofturns) {
   int count=0;
     while( count <noofturns) {
        count++;
         int totalDiceValue =0;
    if(flag) {
         totalDiceValue = DiceService.crookedRollEven(); // Each player rolls the dice when their turn comes.
    }
    else{
         totalDiceValue = DiceService.roll();
    }
    Player currentPlayer = players.poll();
    movePlayer(currentPlayer, totalDiceValue);
    if (hasPlayerWon(currentPlayer)) {
        System.out.println(currentPlayer.getName() + " wins the game");
        snakeAndLadderBoard.getPlayerPieces().remove(currentPlayer.getId());
    } else {
        players.add(currentPlayer);
    }
}

    }
}
