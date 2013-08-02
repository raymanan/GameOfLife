package interfaces;

import javax.swing.JComponent;

import bean.Board;

public interface RepresentBehavior {
  public JComponent getRepresntationContainer();

  public void represent(Board board);
}
