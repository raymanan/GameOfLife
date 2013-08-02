package interfaces;

import bean.Board;
import bean.Rule;

public interface CellAction {

  public void calculateNextStatus(Rule rule, Board board);

}
