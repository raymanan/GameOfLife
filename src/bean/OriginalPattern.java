package bean;

public enum OriginalPattern {
  CLEAR(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 } }), GLIDER(new int[][] {
	  { 1, 0 }, { 2, 1 }, { 2, 2 }, { 1, 2 }, { 0, 2 } }), LIGHTWEIGHT(
	  new int[][] {});

  private int[][] aliveCellCoordinate;

  OriginalPattern(int[][] aliveCellCoordinate) {
	this.aliveCellCoordinate = aliveCellCoordinate;
  }

  public int[][] getAliveCellCoordinate() {
	return this.aliveCellCoordinate;
  }
}
