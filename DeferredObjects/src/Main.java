import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import ru.ifmo.rain.breslav.deferred.DObject;
import ru.ifmo.rain.breslav.deferred.ResolveFailedException;

public class Main {

	private static class Vertex {
		String name;

		Integer value;

		@Override
		public String toString() {
			return name;
		}
	}

	private static class Edge {
		Vertex start;

		Vertex end;

		@Override
		public String toString() {
			return start + " -> " + end;
		}
	}

	private static abstract class Node {
		public abstract void process();
	}

	private static class VertexNode extends Node {

		private final String name;

		private final String value;

		public VertexNode(String n, String v) {
			name = n;
			value = v;
		}

		@Override
		public void process() {
			ElementFactory.INSTANCE.createVertex(name);
		}
	}

	private static class EdgeNode extends Node {

		private final String start;

		private final String end;

		public EdgeNode(String s, String e) {
			start = s;
			end = e;
		}

		@Override
		public void process() {
			ElementFactory f = ElementFactory.INSTANCE;
			f.getEdge(f.getVertex(start), f.getVertex(end));
		}

	}

	private static class ElementFactory {
		public static ElementFactory INSTANCE = new ElementFactory();

		private final Map<String, DObject<Vertex>> dmap = new HashMap<String, DObject<Vertex>>();

		private final Map<String, Vertex> vmap = new HashMap<String, Vertex>();

		private final Collection<DObject<Edge>> dedges = new ArrayList<DObject<Edge>>();

		private ElementFactory() {
		}

		public DObject<Vertex> getVertex(final String name) {
			DObject<Vertex> result = dmap.get(name);
			if (result == null) {
				result = new DObject<Vertex>() {
					@Override
					protected Vertex doResolve() throws ResolveFailedException {
						if (!vmap.containsKey(name)) {
							throw new ResolveFailedException("Vertex not defined: " + name);
						}
						return vmap.get(name);
					}

					@Override
					public String toString() {
						return name;
					}
				};
				dmap.put(name, result);
			}
			return result;
		}

		public void createVertex(String name) {
			Vertex v = new Vertex();
			v.name = name;
			vmap.put(name, v);
		}

		public DObject<Edge> getEdge(final DObject<Vertex> start,
				final DObject<Vertex> end) {
			DObject<Edge> dedge = new DObject<Edge>() {

				@Override
				protected Edge doResolve() throws ResolveFailedException {
					Vertex s = start.resolve();
					Vertex e = end.resolve();
					Edge edge = new Edge();
					edge.start = s;
					edge.end = e;
					return edge;
				}

				@Override
				public String toString() {
					return start + " -> " + end;
				}

			};
			dedges.add(dedge);
			return dedge;
		}

		public Collection<Vertex> resolveVertices() {
			Collection<Vertex> result = new HashSet<Vertex>(vmap.values());
			return result;
		}

		public Collection<Edge> resolveEdges() {
			ArrayList<Edge> result = new ArrayList<Edge>();
			for (DObject<Edge> dedge : dedges) {
				try {
					result.add(dedge.resolve());
				} catch (ResolveFailedException e) {
					System.out.println(e.getMessage());
				}
			}
			return result;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Node> nodes = new ArrayList<Node>();
		nodes.add(new EdgeNode("A", "B"));
		nodes.add(new VertexNode("A", "10"));
		nodes.add(new VertexNode("B", "8"));
		nodes.add(new EdgeNode("B", "C"));
		nodes.add(new VertexNode("C", "5"));
		nodes.add(new EdgeNode("A", "C"));
		nodes.add(new VertexNode("D", "3"));
		nodes.add(new EdgeNode("A", "X"));
		nodes.add(new EdgeNode("Y", "B"));
		nodes.add(new EdgeNode("Z", "M"));
		nodes.add(new VertexNode("K", "9"));
		for (Node node : nodes) {
			node.process();
		}
		Collection<Vertex> vertices = ElementFactory.INSTANCE.resolveVertices();
		System.out.println(vertices);
		Collection<Edge> edges = ElementFactory.INSTANCE.resolveEdges();
		System.out.println(edges);

	}

}
