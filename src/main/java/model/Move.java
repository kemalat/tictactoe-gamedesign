package model;

public class Move {

  int row;
  int col;
  int playerId;
  int gameId;


  public Move(String position, int playerId, int gameId) {
    String[] arr = position.split(",");
    this.row = Integer.valueOf(arr[0]);
    this.col = Integer.valueOf(arr[1]);
    this.playerId = playerId;
    this.gameId = gameId;
  }

  public int getRow() {
    return row;
  }

  public void setRow(int row) {
    this.row = row;
  }

  public int getCol() {
    return col;
  }

  public void setCol(int col) {
    this.col = col;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }

  public int getPlayerId() {
    return playerId;
  }

  public int getGameId() {
    return gameId;
  }

  public void setGameId(int gameId) {
    this.gameId = gameId;
  }
}

