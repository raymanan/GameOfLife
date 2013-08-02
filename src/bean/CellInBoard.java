package bean;

import common.CalculateCellStatus;

public class CellInBoard extends Cell {

  @Override
  public void calculateNextStatus(Rule rule, Board board) {
    this.setStatus(CalculateCellStatus.calculate(this, rule, board));
  }

}
