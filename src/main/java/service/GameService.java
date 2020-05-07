package service;

import exceptions.GameNotFound;
import exceptions.GamerNotFoundException;
import model.GameResponse;
import model.Move;

public interface GameService {

  public int start( int size, int player1, int player2) throws GamerNotFoundException;
  public GameResponse move( Move move) throws GameNotFound;

}
