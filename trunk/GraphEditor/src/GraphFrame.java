

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.ui.JGraphDisplay;

public class GraphFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane = new JPanel(new BorderLayout());
	private JToolBar toolBar = new JToolBar();

	public <D> GraphFrame(GraphPresentation<D> presentation) {
		super("Graph Editor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(toolBar, BorderLayout.NORTH);
		JGraphDisplay graphDisplay = new JGraphDisplay(presentation);
		contentPane.add(graphDisplay, BorderLayout.CENTER);
		addAction(graphDisplay.getLayoutAction());
		this.setContentPane(contentPane);		
	}
	
	public void addAction(Action action) {
		toolBar.add(action);
	}

}
