package ru.amse.abreslav.graphs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;

public class GraphFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JToolBar toolBar = null;

	/**
	 * This is the default constructor
	 */
	public <D> GraphFrame(GraphPresentation<D> presentation) {
		super();
		createJContentPane(presentation);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		return jContentPane;
	}

	private <D> JPanel createJContentPane(GraphPresentation<D> presentation) {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getToolBar(), BorderLayout.NORTH);
			jContentPane.add(new JGraphDisplay(presentation), BorderLayout.CENTER);			
		}
		return jContentPane;
	}

	/**
	 * This method initializes toolBar	
	 * 	
	 * @return javax.swing.JToolBar	
	 */
	private JToolBar getToolBar() {
		if (toolBar == null) {
			toolBar = new JToolBar();
		}
		return toolBar;
	}

}
