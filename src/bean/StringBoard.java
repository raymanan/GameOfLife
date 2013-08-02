package bean;

public class StringBoard extends Board {

  public String generateBoardString() {
	StringBuffer boardString = new StringBuffer();

	boardString.append("<html><body>");
	int lineWidth = 0;

	for (int i = 0; i < cells.size(); i++) {
	  Cell cell = cells.get(i);

	  CellStatus cellStatus = cell.getStatus();

	  boardString.append("<span class=\"highlight\">");
	  boardString.append("<font color=").append(cellStatus.getColorName()).append(
		  " size=4>");
	  boardString.append(cellStatus.getSymbol());
	  boardString.append("</font>");
	  boardString.append("</span>");
	  lineWidth++;

	  if (lineWidth == super.getWidth()) {
		boardString.append("<p>");
		lineWidth = 0;
	  }

	  if (i == cells.size() - 1) {
		boardString.append("</body></html>");
	  }
	}

	return boardString.toString();
  }
}
