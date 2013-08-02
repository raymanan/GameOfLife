package bean;

import java.util.ArrayList;
import java.util.List;

public class Board implements Cloneable {

  private int width;

  private int height;

  protected List<Cell> cells;

  public int getWidth() {
	return width;
  }

  public void setWidth(int width) {
	this.width = width;
  }

  public int getHeight() {
	return height;
  }

  public void setHeight(int height) {
	this.height = height;
  }

  public List<Cell> getCells() {
	return cells;
  }

  public void setCells(List<Cell> cells) {
	this.cells = cells;
  }

  public List<Cell> getNeighbourCells(Cell currentCell) {
	List<Cell> nCells = new ArrayList<Cell>(8);

	for (Cell otherCell : cells) {
	  if (isNeighbourCell(currentCell, otherCell)) {
		nCells.add(otherCell);
	  }
	}

	return nCells;
  }

  public void calculateNextStatus(Rule rule) {
	Board oldBoard = this.clone();

	for (Cell cell : cells) {
	  if (cell.getCoordinateX() == 0 && cell.getCoordinateY() == 2) {
		cell.getCoordinateX();
	  }
	  cell.calculateNextStatus(rule, oldBoard);
	}
  }

  @Override
  protected Board clone() {
	Board board = null;
	List<Cell> cells = new ArrayList<Cell>();

	try {
	  board = (Board) super.clone();
	  for (Cell cell : this.cells) {
		cells.add(cell.clone());
	  }
	  board.cells = cells;
	} catch (CloneNotSupportedException e) {
	  e.printStackTrace();
	}

	return board;
  }

  private boolean isNeighbourCell(Cell currentCell, Cell otherCell) {
	int xOfOtherCell = otherCell.getCoordinateX();
	int xOfCurrentCell = currentCell.getCoordinateX();
	int yOfOtherCell = otherCell.getCoordinateY();
	int yOfCurrentCell = currentCell.getCoordinateY();

	int absX = Math.abs(xOfCurrentCell - xOfOtherCell);
	int absY = Math.abs(yOfCurrentCell - yOfOtherCell);

	if ((absX == 1 || absX == 0) && (absY == 1 || absY == 0)
	    && (!(absX == 0 && absY == 0))) {
	  return true;
	}

	return false;
  }

}
