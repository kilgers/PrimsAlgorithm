package PrimsAlgorithm;
import java.util.HashMap;


public class Vertex {
	public String name;
public HashMap<Vertex, Integer> edges;
public Vertex(HashMap<Vertex, Integer> edges) {
this.edges = edges;
}
public Vertex(String name) {
	this.edges = new HashMap<Vertex, Integer>();
	this.name = name;
}

}