package common;

import bean.*;

final public class CalculateCellStatus {

  public static CellStatus calculate(Cell cell, Rule rule, Board board) {
    return rule.applyRule(cell, board);
  }
}
