package repository;

import java.util.HashMap;
import java.util.Optional;
import model.Gamer;
import model.GameState;

public class Repository {

  private static final Repository SINGLE_INSTANCE = new Repository();

  final static HashMap<Integer, Optional<GameState>> gameRepository = new HashMap<>();
  final static HashMap<Integer, Optional<Gamer>> gamerRepository = new HashMap<>();

  public HashMap<Integer, Optional<GameState>> getGameRepository() {
    return gameRepository;
  }


  public HashMap<Integer, Optional<Gamer>> getGamerRepository() {
    return gamerRepository;
  }

  public static Repository getInstance() {
    return SINGLE_INSTANCE;
  }



}
