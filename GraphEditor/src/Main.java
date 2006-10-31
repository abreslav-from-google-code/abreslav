import ru.amse.abreslav.graphs.model.IGraph;
import ru.amse.abreslav.graphs.model.SimpleEdge;
import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;
import ru.amse.abreslav.graphs.presentation.PresentationFactory;
import ru.amse.abreslav.graphs.presentation.PresentationFactory.Result;
import ru.amse.abreslav.graphs.ui.GraphFrame;

public class Main {
	public static void main(String[] args) {
		ListGraph<String> graph = new ListGraph<String>();
		ListVertex<String> a = graph.addVertex("A");
		ListVertex<String> b = graph.addVertex("B");
		ListVertex<String> c = graph.addVertex("C");
		ListVertex<String> d = graph.addVertex("D");
		graph.connect(a, c);
		graph.connect(b, d);
		Result<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> result = PresentationFactory.createFactory(graph);
		IGraph<String, ListVertex<String>, SimpleEdge<ListVertex<String>>> wg = result.graph;
		wg.connect(a, b);
		wg.connect(c, d);
		ListVertex<String> x = wg.addVertex("X");
		ListVertex<String> y = wg.addVertex("Y");
		wg.connect(x, y);
		wg.connect(x, a);
		new GraphFrame(result.factory.getGraphPresentation()).setVisible(true);

	}
}
