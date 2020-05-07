import exceptions.GameNotFound;
import exceptions.GamerNotFoundException;
import java.util.Optional;
import model.ActionEnum;
import model.GameResponse;
import model.Gamer;
import model.Move;
import repository.Repository;
import service.GameService;
import service.impl.GameServiceImpl;

public class Main {

  final static int PLAYER_1 = 1;
  final static int PLAYER_2 = 2;
  static String[] player1Moves  = {"0,2","1,1","2,0"};
  static String[] player2Moves  = {"0,1","1,2"};

  public static void main(String[] args) {

    GameService service = new GameServiceImpl(Repository.getInstance());
    try {

      Repository.getInstance().getGamerRepository().put(PLAYER_1, Optional.of(new Gamer(PLAYER_1)));
      Repository.getInstance().getGamerRepository().put(PLAYER_2, Optional.of(new Gamer(PLAYER_2)));

      int gameId = service.start(3,PLAYER_1,PLAYER_2);
      System.out.println("Game with Id "+gameId+" started");

      GameResponse response = service.move(new Move(player1Moves[0],PLAYER_1,gameId));
      System.out.println(message(response.getAction(), PLAYER_1));

      response = service.move(new Move(player2Moves[0],PLAYER_2,gameId));
      System.out.println(message(response.getAction(), PLAYER_2));

      response= service.move(new Move(player1Moves[1],PLAYER_1,gameId));
      System.out.println(message(response.getAction(), PLAYER_1));

      response = service.move(new Move(player2Moves[1],PLAYER_2,gameId));
      System.out.println(message(response.getAction(), PLAYER_2));

      response = service.move(new Move(player1Moves[2],PLAYER_1,gameId));
      System.out.println(message(response.getAction(), PLAYER_1));


    } catch (GamerNotFoundException e) {
      e.printStackTrace();
    } catch (GameNotFound gameNotFound) {
      gameNotFound.printStackTrace();
    }

  }

  static String message(ActionEnum actionEnum, int gamerId) {

    String message = actionEnum == ActionEnum.GAMER_WON ? "Gamer "+gamerId+" won" : "Game continues";
    return message;
  }

}
