public enum Direction {
  NORTH("north"),
  EAST("east"),
  SOUTH("south"),
  WEST("west");

  private final String word;

  Direction(String word) {
    this.word = word;
  }

  public String getWord() {
    return word;
  }

}
