/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainPanel.java
 *
 * Created on 2012-11-17, 13:22:08
 */

package manager;

import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import bean.*;
import factory.RuleFactory;

/**
 * 
 * @author nan
 */
public class MainPanel extends javax.swing.JPanel implements ActionListener,
    ItemListener {

  /**
   * 
   */
  private static final long serialVersionUID = -5767968581043135742L;

  private Board board;

  private List<GameRepresentation> representations;

  private boolean isStop = true;

  private GridBagConstraints gridBagConstraints;

  /** Creates new form MainPanel */
  public MainPanel() {
	initComponents();
	initListener();
	initCombobox();
  }

  public void init() {
	createBoard();
	repaintAllBoards(board);
  }

  public void addRepresentationPanels(List<GameRepresentation> representations) {
	this.representations = representations;

	for (int i = 0; i < representations.size(); i++) {
	  GameRepresentation rep = representations.get(i);

	  rep.init();

	  rep.setMaxLineWidth((Integer) maxBoardWidthComboBox.getSelectedItem());

	  gridBagConstraints = new java.awt.GridBagConstraints();
	  gridBagConstraints.gridx = 2;
	  gridBagConstraints.gridy = i;
	  gridBagConstraints.weightx = 1.0;
	  gridBagConstraints.weighty = 1.0;
	  gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
	  gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	  gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	  representPanel.add(rep, gridBagConstraints);
	}

	repaint();
  }

  private void initListener() {
	originalPatternComboBox.addItemListener(this);
	speedComboBox.addItemListener(this);
	ruleComboBox.addItemListener(this);
	maxBoardWidthComboBox.addItemListener(this);
	maxBoardHeightComboBox.addItemListener(this);
	startButton.addActionListener(this);
	stopButton.addActionListener(this);
	nextButton.addActionListener(this);
	resetButton.addActionListener(this);
  }

  private void initCombobox() {
	originalPatternComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    OriginalPattern.values()));
	ruleComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    RuleType.values()));
	speedComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    SpeedMode.values()));
	maxBoardWidthComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    new Integer[] { 40, 80, 100, 150 }));
	maxBoardHeightComboBox.setModel(new javax.swing.DefaultComboBoxModel(
	    new Integer[] { 5, 10, 20 }));
  }

  public void createBoard() {
	CellWorld world = new CellWorld();
	board = world.createWorld(
	    getMaxBoardWidth(),
	    getMaxBoardHeigh(),
	    getOriginalPattern());
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
	Object source = evt.getSource();
	if (source == startButton) {
	  startButtonSelected();
	} else if (source == stopButton) {
	  stopButtonSelected();
	} else if (source == nextButton) {
	  nextButtonSelected();
	} else if (source == resetButton) {
	  resetButtonSelected();
	}
  }

  private void resetButtonSelected() {
	init();
  }

  private void nextButtonSelected() {
	new CalculateAndRepaintAllBoardsTask().execute();

  }

  private void stopButtonSelected() {
	isStop = true;
  }

  private void startButtonSelected() {
	isStop = false;

	calculateAndRepaintTask();

	// startButton.setEnabled(true);
	// stopButton.setEnabled(false);
  }

  @Override
  public void itemStateChanged(ItemEvent evt) {
	Object source = evt.getSource();
	if (source == originalPatternComboBox) {
	  createBoard();

	  SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		  repaintAllBoards(board);
		}

	  });
	} else if (source == speedComboBox) {
	} else if (source == ruleComboBox) {
	} else if (source == maxBoardWidthComboBox) {
	  createBoard();

	  SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		  repaintAllBoards(board);
		}

	  });
	} else if (source == maxBoardHeightComboBox) {
	  createBoard();

	  SwingUtilities.invokeLater(new Runnable() {
		@Override
		public void run() {
		  repaintAllBoards(board);
		}

	  });
	}
  }

  private void repaintAllBoards(Board board) {
	for (GameRepresentation rep : representations) {
	  rep.setBoard(board);
	  rep.setMaxLineWidth(getMaxBoardWidth());
	  rep.repaintBoard();
	}
  }

  private OriginalPattern getOriginalPattern() {
	Object obj = originalPatternComboBox.getSelectedItem();
	if (obj instanceof OriginalPattern) {
	  return (OriginalPattern) obj;
	}

	return null;
  }

  private SpeedMode getSpeedMode() {
	Object obj = speedComboBox.getSelectedItem();
	if (obj instanceof SpeedMode) {
	  return (SpeedMode) obj;
	}

	return null;
  }

  private RuleType getRuleType() {
	Object obj = ruleComboBox.getSelectedItem();
	if (obj instanceof RuleType) {
	  return (RuleType) obj;
	}

	return null;
  }

  private Integer getMaxBoardWidth() {
	Object obj = maxBoardWidthComboBox.getSelectedItem();
	if (obj instanceof Integer) {
	  return (Integer) obj;
	}

	return null;
  }

  private Integer getMaxBoardHeigh() {
	Object obj = maxBoardHeightComboBox.getSelectedItem();
	if (obj instanceof Integer) {
	  return (Integer) obj;
	}

	return null;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  // @SuppressWarnings("unchecked")
  // <editor-fold default state="collapsed" desc="Generated Code">
  private void initComponents() {
	java.awt.GridBagConstraints gridBagConstraints;

	controlPanel = new javax.swing.JPanel();
	representPanel = new JPanel();
	speedComboBox = new JComboBox();
	originalPatternComboBox = new JComboBox();
	ruleComboBox = new JComboBox();
	maxBoardWidthComboBox = new JComboBox();
	maxBoardHeightComboBox = new JComboBox();
	speedLabel = new JLabel();
	originalPatternLabel = new JLabel();
	ruleLabel = new JLabel();
	maxBoardWidthLabel = new JLabel();
	maxBoardHeightLabel = new JLabel();
	startButton = new JButton();
	stopButton = new JButton();
	nextButton = new JButton();
	resetButton = new JButton();

	setLayout(new java.awt.BorderLayout());

	controlPanel.setLayout(new java.awt.GridBagLayout());

	originalPatternLabel.setText("Original Pattern");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
	controlPanel.add(originalPatternLabel, gridBagConstraints);
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 1;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(originalPatternComboBox, gridBagConstraints);

	ruleLabel.setText("Rule");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 2;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(ruleLabel, gridBagConstraints);
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 3;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(ruleComboBox, gridBagConstraints);

	speedLabel.setText("Speed");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 4;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(speedLabel, gridBagConstraints);
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 5;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(speedComboBox, gridBagConstraints);

	maxBoardWidthLabel.setText("Max Board Width");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 6;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(maxBoardWidthLabel, gridBagConstraints);
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 7;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(maxBoardWidthComboBox, gridBagConstraints);

	maxBoardHeightLabel.setText("Max Board Height");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 8;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(maxBoardHeightLabel, gridBagConstraints);
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 9;
	gridBagConstraints.gridy = 0;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(maxBoardHeightComboBox, gridBagConstraints);

	startButton.setText("Start");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 0;
	gridBagConstraints.gridy = 1;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
	controlPanel.add(startButton, gridBagConstraints);

	stopButton.setText("Stop");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 1;
	gridBagConstraints.gridy = 1;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
	controlPanel.add(stopButton, gridBagConstraints);

	nextButton.setText("Next");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 2;
	gridBagConstraints.gridy = 1;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
	controlPanel.add(nextButton, gridBagConstraints);

	resetButton.setText("Reset");
	gridBagConstraints = new java.awt.GridBagConstraints();
	gridBagConstraints.gridx = 3;
	gridBagConstraints.gridy = 1;
	gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
	gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 0);
	controlPanel.add(resetButton, gridBagConstraints);

	add(controlPanel, java.awt.BorderLayout.NORTH);

	representPanel.setLayout(new java.awt.GridBagLayout());
	add(representPanel, java.awt.BorderLayout.CENTER);
  }// </editor-fold>

  // Variables declaration - do not modify
  private JPanel controlPanel;
  private JPanel representPanel;
  private JComboBox originalPatternComboBox;
  private JComboBox speedComboBox;
  private JComboBox ruleComboBox;
  private JComboBox maxBoardWidthComboBox;
  private JComboBox maxBoardHeightComboBox;
  private JLabel originalPatternLabel;
  private JLabel speedLabel;
  private JLabel ruleLabel;
  private JLabel maxBoardWidthLabel;
  private JLabel maxBoardHeightLabel;
  private JButton startButton;
  private JButton stopButton;
  private JButton nextButton;
  private JButton resetButton;

  private void calculateAndRepaintTask() {
	Runnable calculateAndRepaintRunnable = new Runnable() {
	  @Override
	  public void run() {
		SwingWorker<Void, Void> task = new CalculateAndRepaintAllBoardsTask();
		task.execute();

		while (!isStop) {
		  if (task.isDone()) {
			try {
			  TimeUnit.MILLISECONDS.sleep(getSpeedMode().getInterval());
			} catch (InterruptedException e) {
			  break;
			}

			task = new CalculateAndRepaintAllBoardsTask();
			task.execute();
		  } else {
		  }
		}
	  }
	};

	Thread calculateAndRepaintTask = new Thread(calculateAndRepaintRunnable);
	calculateAndRepaintTask.start();
  }

  private class CalculateAndRepaintAllBoardsTask extends
	  SwingWorker<Void, Void> {
	@Override
	protected Void doInBackground() throws Exception {
	  board.calculateNextStatus(RuleFactory.createRule(getRuleType()));

	  return null;
	}

	@Override
	protected void done() {
	  try {
		get();

		System.out.print("repaintBoard");

		for (GameRepresentation rep : representations) {
		  rep.repaintBoard();
		}
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  } catch (ExecutionException e) {
		e.printStackTrace();
	  }
	  super.done();
	}
  }

}
