package manager;

import interfaces.RepresentBehavior;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import bean.GameRepresentation;
import bean.StringRepresentBehavior;

public class GameTestDrive {

  /**
   * @param args
   */
  public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {

	  @Override
	  public void run() {
		try {
		  UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		  e.printStackTrace();
		}

		JFrame frame = new JFrame();
		MainPanel mainPanel = new MainPanel();

		List<GameRepresentation> reps = new ArrayList<GameRepresentation>();
		
		GameRepresentation stringGameRep = new GameRepresentation();
		RepresentBehavior stringBehavior = new StringRepresentBehavior();
		stringGameRep.setBehavior(stringBehavior);
		GameRepresentation stringGameRep2 = new GameRepresentation();
		RepresentBehavior stringBehavior2 = new StringRepresentBehavior();
		stringGameRep2.setBehavior(stringBehavior2);
		reps.add(stringGameRep);
		reps.add(stringGameRep2);
		mainPanel.addRepresentationPanels(reps);

		mainPanel.init();

		frame.add(mainPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	  }

	});
  }
}
