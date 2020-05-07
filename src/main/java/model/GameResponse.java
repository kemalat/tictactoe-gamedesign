package model;

public class GameResponse {

  private ActionEnum action;
  String message;
  int code;
  int gamerId;

  public GameResponse(int id, ActionEnum action) {
    this.gamerId = id;
    this.action = action;
  }

  public GameResponse(ActionEnum actionEnum) {
  }

  public GameResponse(ActionEnum actionEnum, int gamerId) {
    this.action = actionEnum;
    this.gamerId = gamerId;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public int getGamerId() {
    return gamerId;
  }

  public void setGamerId(int gamerId) {
    this.gamerId = gamerId;
  }

  public ActionEnum getAction() {
    return action;
  }

  public void setAction(ActionEnum action) {
    this.action = action;
  }
}
