package bean;

import interfaces.CellAction;

public abstract class Cell implements CellAction, Cloneable {

  private int coordinateX;
  private int coordinateY;
  private CellStatus status;

  public int getCoordinateX() {
	return coordinateX;
  }

  public void setCoordinateX(int coordinateX) {
	this.coordinateX = coordinateX;
  }

  public int getCoordinateY() {
	return coordinateY;
  }

  public void setCoordinateY(int coordinateY) {
	this.coordinateY = coordinateY;
  }

  public CellStatus getStatus() {
	return status;
  }

  public void setStatus(CellStatus status) {
	this.status = status;
  }

  @Override
  protected Cell clone() {
	Cell cell = null;

	try {
	  cell = (Cell) super.clone();
	} catch (CloneNotSupportedException e) {
	  e.printStackTrace();
	}

	return cell;
  }
}
