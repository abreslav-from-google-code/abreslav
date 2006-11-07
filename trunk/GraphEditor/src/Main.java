import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;
import ru.amse.abreslav.graphs.presentation.PresentationFactory;
import ru.amse.abreslav.graphs.presentation.PresentationFactory.Result;

public class Main {
	public static void main(String[] args) {
		ListGraph<String> graph = new ListGraph<String>();
		ListVertex<String> a = graph.addVertex("A");
		ListVertex<String> b = graph.addVertex("B");
		ListVertex<String> c = graph.addVertex("C");
		ListVertex<String> d = graph.addVertex("D");
		graph.createEdge(a, c);
		graph.createEdge(b, d);
		Result<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> result = PresentationFactory.createFactory(graph);
		final IGraph<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> wg = result.graph;
		wg.createEdge(a, b);
		wg.createEdge(c, d);
		ListVertex<String> x = wg.addVertex("X");
		ListVertex<String> y = wg.addVertex("Y");
		wg.createEdge(x, y);
		wg.createEdge(x, a);
		GraphFrame frame = new GraphFrame(result.factory.getGraphPresentation());
		frame.addAction(new AbstractAction("Add") {
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				String data = JOptionPane.showInputDialog("Input vertex name");
				wg.addVertex(data);
			}
			
		});
		frame.setVisible(true);

	}
}
