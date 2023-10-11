/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{
    private int[][] posArray = new int[3][3];


    private int currentPlayer = 0;

    private int posPlayer = 2;

    int[] checkX = new int[]{2, 2, 2};
    int[] checkY = new int[]{3,3,3};

    int n = 3;
    private String winner;


    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        //TODO Implement this method
        if(currentPlayer == 0){
            currentPlayer = 1;
            posPlayer = 3;
            //System.out.println(currentPlayer);
            return 1;
        }
        else{
            posPlayer = 2;
            currentPlayer = 0;
            //System.out.println(currentPlayer);
            return 0;
        }
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        //TODO Implement this method
        //new game reset the posArray!!

        if(posArray[row][col] == 0){

            posArray[row][col] = posPlayer;
            System.out.println("You placed" + posArray[row][col]);
            //int currentPlayer = getNextPlayer();
            return true;
        }
        else{
            //System.out.println("You can not");
            return false;
        }
   }

    public boolean isGameOver() {
        // Assuming 'n' is the size of the Tic-Tac-Toe grid (typically 3)
        int gridSize = n;

        // Check rows, columns, and diagonals
        for (int i = 0; i < gridSize; i++) {
            // Check rows
            if (Arrays.equals(posArray[i], checkX) || Arrays.equals(posArray[i], checkY)) {
                return true;
            }

            // Check columns
            int[] column = new int[gridSize];
            for (int j = 0; j < gridSize; j++) {
                column[j] = posArray[j][i];
            }
            if (Arrays.equals(column, checkX) || Arrays.equals(column, checkY)) {
                return true;
            }
        }

        // Check main diagonal (top-left to bottom-right)
        int[] mainDiagonal = new int[gridSize];
        for (int i = 0; i < gridSize; i++) {
            mainDiagonal[i] = posArray[i][i];
        }
        if (Arrays.equals(mainDiagonal, checkX) || Arrays.equals(mainDiagonal, checkY)) {
            return true;
        }

        // Check secondary diagonal (top-right to bottom-left)
        int[] secondaryDiagonal = new int[gridSize];
        for (int i = 0; i < gridSize; i++) {
            secondaryDiagonal[i] = posArray[i][gridSize - 1 - i];
        }
        if (Arrays.equals(secondaryDiagonal, checkX) || Arrays.equals(secondaryDiagonal, checkY)) {
            return true;
        }

        // If no match is found in rows, columns, or diagonals, return false
        return false;
    }




    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {
        //TODO Implement this method

        return -1;
    }

    /**
     * Resets the game to a new game state.
     */

    //make the positions available again
    public void newGame()
    {
        for(int i = 0; i < posArray.length; i++){
            Arrays.fill(posArray[i], 0);
        }
        currentPlayer = 0;
        //TODO Implement this method
    }

}
