package model;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;


public class GameState {
  HashMap<Integer, Gamer> players;
  int[]rows;
  int[]cols;
  int diagonal;
  int antidiagonal;
  int size;
  StateEnum stateEnum;

  int currPlayerIndex;
  AtomicInteger gameIdGenerator =  new AtomicInteger(0);

  public int[] getRows() {
    return rows;
  }

  public int[] getCols() {
    return cols;
  }

  public GameState(int size, Gamer player1, Gamer player2) {
    players = new HashMap<>();
    player1.setMarkup(1);
    player2.setMarkup(-1);
    players.put(player1.getId(),player1);
    players.put(player2.getId(),player2);
    rows = new int[size];
    cols = new int[size];
    this.size = size;
    this.stateEnum = StateEnum.STARTED;
  }


  public int getRow(int row) {
    return rows[row];
  }

  public void setRows(int[] rows) {
    this.rows = rows;
  }

  public int getColumn(int col) {
    return cols[col];
  }

  public void setCols(int[] cols) {
    this.cols = cols;
  }

  public int getCurrPlayerIndex() {
    return currPlayerIndex;
  }

  public void setCurrPlayerIndex(int currPlayerIndex) {
    this.currPlayerIndex = currPlayerIndex;
  }

  public Gamer getGamer(int playerId) {
    return players.get(playerId);
  }

  public int getDiagonal() {
    return diagonal;
  }

  public void setDiagonal(int diagonal) {
    this.diagonal = diagonal;
  }

  public int getAntidiagonal() {
    return antidiagonal;
  }

  public void setAntidiagonal(int antidiagonal) {
    this.antidiagonal = antidiagonal;
  }

  public void setColumn(int newVal, int col) {
    cols[col] = newVal;
  }

  public void setRow(int newVal, int row) {
    rows[row] = newVal;
  }

  public int getBoardSize() {
    return size;
  }

  public int generateGameId() {
    return gameIdGenerator.incrementAndGet();
  }

  public void setStateEnum(StateEnum stateEnum) {
    this.stateEnum = stateEnum;
  }

  public void increaseNumofWins(int id) {
    players.get(id).increaseNumofWins();
  }
}
