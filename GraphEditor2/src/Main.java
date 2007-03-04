import javax.swing.JOptionPane;

import ru.amse.abreslav.graphs.model.Edge;
import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.Vertex;
import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;
import ru.amse.abreslav.graphs.presentation.PresentationFactory;
import ru.amse.abreslav.graphs.presentation.PresentationFactory.Result;
import ru.amse.abreslav.graphs.ui.ElementFactory;
import ru.amse.abreslav.graphs.ui.GraphActionListener;

public class Main {
	private static final String ENTER_VERTEX_DATA = "Enter vertex data:";

	public static void main(String[] args) {
		ListGraph<String> graph = new ListGraph<String>();
		Result<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> result = PresentationFactory.createPresentationAndGraph(graph);
		final IGraph<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> wg = result.graph;
		
		ElementFactory<String, ListVertex<String>> ec = new ElementFactory<String, ListVertex<String>>() {
			private int n = 0;
			
			public Edge<ListVertex<String>> createEdge(ListVertex<String> a, ListVertex<String> b) {
				return wg.createEdge(a, b);
			}

			public ListVertex<String> createVertex() {
				return wg.addVertex(++n + "");
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
		
		GraphFrame frame = new GraphFrame(ec, result.presentation, gal);
		frame.setVisible(true);
	}
}