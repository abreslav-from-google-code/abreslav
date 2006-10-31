package ru.amse.abreslav.graphs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;

public class GraphFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane = new JPanel(new BorderLayout());
	private JToolBar toolBar = new JToolBar();

	public <D> GraphFrame(GraphPresentation<D> presentation) {
		super("Graph Editor");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(toolBar, BorderLayout.NORTH);
		contentPane.add(new JGraphDisplay(presentation), BorderLayout.CENTER);			
		this.setContentPane(contentPane);		
	}

}
