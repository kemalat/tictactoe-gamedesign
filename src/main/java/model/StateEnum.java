package model;

public enum StateEnum {

  STARTED(1),
  ENDED(2);

  private final int value;

  StateEnum(final int newValue) {
    value = newValue;
  }

  public int getValue() { return value; }

}
