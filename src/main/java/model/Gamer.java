package model;

public class Gamer {

  int id;
  int markup;
  int numOfWins;

  public Gamer(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNumOfWins() {
    return numOfWins;
  }

  public void setNumOfWins(int numOfWins) {
    this.numOfWins = numOfWins;
  }

  public void increaseNumofWins() {
    numOfWins += 1;
  }

  public int getMarkup() {
    return markup;
  }

  public void setMarkup(int markup) {
    this.markup = markup;
  }
}
