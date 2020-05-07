package model;

public enum ActionEnum {

  GAMER_WON(1),
  GAME_CONTINUES(2);

  private final int value;

  ActionEnum(final int newValue) {
    value = newValue;
  }

  public int getValue() { return value; }

}
