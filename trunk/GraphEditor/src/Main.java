import ru.amse.abreslav.graphs.model.list.ListGraph;
import ru.amse.abreslav.graphs.model.list.ListVertex;


public class Main {

	public static void main(String[] args) {
		ListGraph<Integer> graph = new ListGraph<Integer>();
		ListVertex<Integer> a = graph.addVertex(1);
		ListVertex<Integer> b = graph.addVertex(2);
		ListVertex<Integer> c = graph.addVertex(3);
		ListVertex<Integer> d = graph.addVertex(4);
		ListVertex<Integer> e = graph.addVertex(5);
		graph.connect(a, b);
		graph.connect(a, c);
		graph.connect(b, d);
		graph.connect(e, d);
		System.out.println(graph);
	}
}
