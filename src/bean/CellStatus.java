package bean;

import java.awt.Color;

public enum CellStatus {
  UNKNOWN(Color.RED, "unknown", "U", "RED"), DEAD(Color.GRAY, "dead", "D",
	  "GRAY"), ALIVE(Color.GREEN, "alive", "A", "GREEN"), REPRODUCTION(
	  Color.BLUE, "reproduction", "R", "BLUE");

  private Color color;
  private String desc;
  private String symbol;
  private String colorName;

  CellStatus(Color represent, String desc, String symbol, String colorName) {
	this.color = represent;
	this.desc = desc;
	this.symbol = symbol;
	this.colorName = colorName;
  }

  public Color getColor() {
	return this.color;
  }

  public String getColorName() {
	return this.colorName;
  }

  public String getSymbol() {
	return this.symbol;
  }

  @Override
  public String toString() {
	return this.desc;
  }

  // public CellStatus fromValue(Color represent) {
  // if (represent == Color.WHITE) {
  // return DEAD;
  // } else if (represent == Color.BLACK) {
  // return ALIVE;
  // } else if (represent == Color.GREEN) {
  // return REPRODUCTION;
  // } else if (represent == Color.RED) {
  // return UNKNOWN;
  // }
  //
  // return null;
  // }
}
