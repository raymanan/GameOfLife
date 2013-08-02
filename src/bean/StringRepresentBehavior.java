package bean;

import interfaces.RepresentBehavior;

import java.util.List;

import javax.swing.*;

public class StringRepresentBehavior implements RepresentBehavior {
  JScrollPane boardScrollPane;
  JTextPane boardTextPane;

  public StringRepresentBehavior() {
	boardScrollPane = new javax.swing.JScrollPane();
	boardTextPane = new javax.swing.JTextPane();

	boardTextPane.setContentType("text/html");
	boardScrollPane.setViewportView(boardTextPane);
  }

  @Override
  public JComponent getRepresntationContainer() {
	return boardScrollPane;
  }

  @Override
  public void represent(Board board) {
	boardTextPane.setText(generateBoardString(board));
  }

  private String generateBoardString(Board board) {
	StringBuffer boardString = new StringBuffer();
	List<Cell> cells = board.getCells();

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

	  if (lineWidth == board.getWidth()) {
		boardString.append("<p>");
		lineWidth = 0;
	  }

	  if (i == cells.size() - 1) {
		boardString.append("</body></html>");
	  }
	}

	System.out.println(boardString.toString());

	return boardString.toString();
  }

}
