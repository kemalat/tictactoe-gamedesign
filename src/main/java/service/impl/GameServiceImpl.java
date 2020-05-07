package service.impl;

import exceptions.GameNotFound;
import exceptions.GamerNotFoundException;
import java.util.HashMap;
import java.util.Optional;
import model.ActionEnum;
import model.GameResponse;
import model.StateEnum;
import model.Gamer;
import model.Move;
import model.GameState;
import repository.Repository;
import service.GameService;

public class GameServiceImpl implements GameService {


  private final HashMap<Integer, Optional<GameState>> gameRepository;
  private final HashMap<Integer, Optional<Gamer>> gamerRepository;

  public GameServiceImpl(Repository repository) {
    this.gameRepository = repository.getGameRepository();
    this.gamerRepository = repository.getGamerRepository();
  }

  public int start(int size, int player1, int player2) throws GamerNotFoundException {

    Gamer gamer1 = gamerRepository.get(player1).orElseThrow(() -> new GamerNotFoundException("Gamer with id " + player1 + "not found"));
    Gamer gamer2 = gamerRepository.get(player2).orElseThrow(() -> new GamerNotFoundException("Gamer with id "+player2+ "not found"));

    GameState gameState = new GameState(size, gamer1,gamer2);
    int gameId = gameState.generateGameId();
    gameRepository.put(gameId,Optional.of(gameState));
    return gameId;
  }


  public GameResponse move(Move move) throws GameNotFound {

    GameState gameState = gameRepository.get(move.getGameId()).orElseThrow(() -> new GameNotFound("Game with id " + move.getGameId() + "not found"));
    Gamer gamer = gameState.getGamer(move.getPlayerId());
    int markup = gamer.getMarkup();
    int col = move.getCol();
    int row = move.getRow();
    int[] cols = gameState.getCols();
    int[] rows = gameState.getRows();

    rows[move.getRow()] += markup;
    cols[move.getCol()] += markup;

    gameState.setCols(cols);
    gameState.setRows(rows);

    if(move.getCol() == move.getRow())
      gameState.setDiagonal(gameState.getDiagonal() + markup);

    if(move.getCol() + move.getRow() == gameState.getBoardSize()-1)
      gameState.setAntidiagonal(gameState.getAntidiagonal() + markup);

    if (Math.abs(rows[row]) == gameState.getBoardSize() ||
        Math.abs(cols[col]) == gameState.getBoardSize() ||
        Math.abs(gameState.getDiagonal()) == gameState.getBoardSize() ||
        Math.abs(gameState.getAntidiagonal()) == gameState.getBoardSize()) {
        gameState.setStateEnum(StateEnum.ENDED);
        gameState.increaseNumofWins(gamer.getId());
        gameRepository.replace(move.getGameId(),Optional.of(gameState));
      return new GameResponse(ActionEnum.GAMER_WON,gamer.getId());
    }

    return new GameResponse(ActionEnum.GAME_CONTINUES);



  }

}
