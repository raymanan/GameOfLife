package bean;

import java.util.List;

public class ConwayRule extends Rule {

  @Override
  public CellStatus applyRule(Cell cell, Board board) {
	if (cell.getCoordinateX() == 0 && cell.getCoordinateY() == 1) {
	  cell.getCoordinateX();
	}

	List<Cell> neighbourCells = board.getNeighbourCells(cell);

	int aliveCellCount = 0;

	for (Cell nCell : neighbourCells) {
	  CellStatus nCellStatus = nCell.getStatus();
	  if (nCellStatus == CellStatus.ALIVE
		  || nCellStatus == CellStatus.REPRODUCTION) {
		aliveCellCount++;
	  }
	}

	CellStatus currentCellStatus = cell.getStatus();

	if (currentCellStatus == CellStatus.ALIVE
	    || currentCellStatus == CellStatus.REPRODUCTION) {
	  if (aliveCellCount < 2 || aliveCellCount > 3) {
		return CellStatus.DEAD;
	  } else if (aliveCellCount == 2 || aliveCellCount == 3) {
		return CellStatus.ALIVE;
	  }
	}

	if (currentCellStatus == CellStatus.DEAD) {
	  if (aliveCellCount == 3) {
		return CellStatus.REPRODUCTION;
	  } else {
		return CellStatus.DEAD;
	  }
	}

	return CellStatus.UNKNOWN;
  }
}
