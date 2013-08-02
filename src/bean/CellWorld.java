package bean;

import java.util.ArrayList;
import java.util.List;

import factory.CellFactory;

public class CellWorld {

  public Board createWorld(int width, int height,
	  OriginalPattern originalPattern) {
	Board board = new Board();

	board.setWidth(width);
	board.setHeight(height);
	board.setCells(createCells(
	    originalPattern,
	    board.getWidth(),
	    board.getHeight()));

	return board;
  }

  private List<Cell> createCells(OriginalPattern originalPattern,
	  int maxBoardWidth, int maxBoarHeight) {
	int cellCount = maxBoardWidth * maxBoarHeight;

	List<Cell> cells = new ArrayList<Cell>(cellCount);

	int x = 0;
	int y = 0;

	for (int i = 0; i < cellCount; i++) {
	  Cell cell = CellFactory.createCell();

	  cell.setCoordinateX(x);
	  cell.setCoordinateY(y);

	  setCellStatus(originalPattern, cell);

	  cells.add(cell);

	  if (x == maxBoardWidth - 1) {
		x = 0;
		y++;

		continue;
	  }

	  x++;

	}
	return cells;
  }

  private void setCellStatus(OriginalPattern originalPattern, Cell cell) {
	int[][] aliveCellCoordinates = originalPattern.getAliveCellCoordinate();
	int[] currentCellCoordinate = new int[] { cell.getCoordinateX(),
	    cell.getCoordinateY() };

	for (int[] aliveCellCoordinate : aliveCellCoordinates) {
	  if (currentCellCoordinate[0] == aliveCellCoordinate[0]
		  && currentCellCoordinate[1] == aliveCellCoordinate[1]) {
		cell.setStatus(CellStatus.ALIVE);
		return;
	  }
	}

	cell.setStatus(CellStatus.DEAD);
  }
}
