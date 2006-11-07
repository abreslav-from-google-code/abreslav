import javax.swing.JOptionPane;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;
import ru.amse.abreslav.graphs.presentation.PresentationFactory;
import ru.amse.abreslav.graphs.presentation.PresentationFactory.Result;
import ru.amse.abreslav.graphs.ui.JGraphDisplay.ElementCreator;
import ru.amse.abreslav.graphs.ui.JGraphDisplay.GraphActionListener;

public class Main {
	private static final String ENTER_VERTEX_DATA = "Enter vertex data:";

	public static void main(String[] args) {
		ListGraph<String> graph = new ListGraph<String>();
//		ListVertex<String> a = graph.addVertex("A");
//		ListVertex<String> b = graph.addVertex("B");
//		ListVertex<String> c = graph.addVertex("C");
//		ListVertex<String> d = graph.addVertex("D");
//		graph.createEdge(a, c);
//		graph.createEdge(b, d);
		Result<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> result = PresentationFactory.createFactory(graph);
		final IGraph<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> wg = result.graph;
//		wg.createEdge(a, b);
//		wg.createEdge(c, d);
//		ListVertex<String> x = wg.addVertex("X");
//		ListVertex<String> y = wg.addVertex("Y");
//		wg.createEdge(x, y);
//		wg.createEdge(x, a);
		ElementCreator<String, ListVertex<String>> ec = new ElementCreator<String, ListVertex<String>>() {

			public Edge<ListVertex<String>> createEdge(ListVertex<String> a, ListVertex<String> b) {
				return wg.createEdge(a, b);
			}

			public ListVertex<String> createVertex() {
				return wg.addVertex(JOptionPane.showInputDialog(ENTER_VERTEX_DATA));
			}

						
		};
		GraphActionListener<String> gal = new GraphActionListener<String>() {

			public boolean vertexClicked(Vertex<String> v) {
				String data = JOptionPane.showInputDialog(ENTER_VERTEX_DATA, v.getData());
				if (data != null) {
					v.setData(data);
					return true;
				}
				return false;
			}
			
		};
		GraphFrame frame = new GraphFrame(ec, result.factory.getGraphPresentation(), gal);
		frame.setVisible(true);

	}
}
