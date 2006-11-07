

import java.awt.BorderLayout;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.presentation.GraphPresentation;
import ru.amse.abreslav.graphs.ui.JGraphDisplay;
import ru.amse.abreslav.graphs.ui.JGraphDisplay.ElementCreator;
import ru.amse.abreslav.graphs.ui.JGraphDisplay.GraphActionListener;

public class GraphFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane = new JPanel(new BorderLayout());
	private JToolBar toolBar = new JToolBar();

	public <D, V extends Vertex<D>> GraphFrame(ElementCreator<D, V> ec, GraphPresentation<D> presentation, GraphActionListener<D> gal) {
		super("Graph Editor");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.add(toolBar, BorderLayout.NORTH);
		JGraphDisplay graphDisplay = new JGraphDisplay(ec, presentation, gal);
		contentPane.add(graphDisplay, BorderLayout.CENTER);
		for (Action a: graphDisplay.getActions()) {
			addAction(a);
		}
		this.setContentPane(contentPane);		
	}
	
	public void addAction(Action action) {
		toolBar.add(action);
	}

}
