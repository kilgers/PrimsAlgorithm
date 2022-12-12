package PrimsAlgorithm;
import java.util.HashMap;
public class Main {

	public static void main(String[] args) {
		HashMap<Vertex, Integer> solutionSet = new HashMap<Vertex, Integer>();
		HashMap<Vertex, Integer> queue = new HashMap<Vertex, Integer>();
//First we'll instantiate all the vertices
Vertex v1 = new Vertex("v1");
Vertex v2 = new Vertex("v2");
Vertex v3 = new Vertex("v3");
Vertex v4 = new Vertex("v4");
Vertex v5 = new Vertex("v5");
Vertex v6 = new Vertex("v6");
Vertex v7 = new Vertex("v7");
Vertex v8 = new Vertex("v8");
//Then populate them with edges
v1.edges.put(v3, 4);
v1.edges.put(v2, 5);

v2.edges.put(v3, 2);
v2.edges.put(v4, 3);
v2.edges.put(v1, 5);

v3.edges.put(v3, 2);
v3.edges.put(v5, 4);
v3.edges.put(v1, 4);

v4.edges.put(v5, 2);
v4.edges.put(v2, 3);
v4.edges.put(v7, 6);

v5.edges.put(v6, 1);
v5.edges.put(v4, 2);
v5.edges.put(v3, 4);

v6.edges.put(v5, 1);
v6.edges.put(v7, 8);

v7.edges.put(v8, 2);
v7.edges.put(v6, 8);
v7.edges.put(v4, 6);

v8.edges.put(v7, 2);


//populate solutionsSet with answer
//you can change the start vertex if you like. answer should be the same
getMST(v1,queue, solutionSet);
//sum total weight of MST
int MSTSum = 0;
for(Vertex v:solutionSet.keySet()) {
	MSTSum+=solutionSet.get(v);
}
//Aaaaand finally print it out.
System.out.println("The sum of the MST for this graph is:");
System.out.println(MSTSum);

	}
	public static Vertex getNext(HashMap<Vertex, Integer> queue) {
		//Looks through the queue to get the next vertex to add to the solution set
		Vertex next = null;
		int min = Integer.MAX_VALUE;
		for(Vertex v: queue.keySet()) {
			if(queue.get(v)<min) {
				min = queue.get(v);
				next = v;
			}
		}
		return next;
	}
	public static void addVertex(Vertex v, Integer e, HashMap<Vertex, Integer> queue, HashMap<Vertex, Integer> solutionSet) {
		//adds vertex to solution set and removes it from the queue
		solutionSet.put(v, e);
		queue.remove(v);
	}
	public static void getMST(Vertex start, HashMap<Vertex, Integer> queue, HashMap<Vertex, Integer> solutionSet) {
		//This is the main function that starts with a vertex supplied and proceeds to add more vertices until the MST is complete
		addVertex(start, 0, queue, solutionSet);
		updateQueue(start, queue, solutionSet);
		while(!queue.isEmpty()) {
			Vertex next = getNext(queue);
			updateQueue(next, queue, solutionSet);
			addVertex(next, queue.get(next), queue, solutionSet);

		}
			
	}
	public static void updateQueue(Vertex v, HashMap<Vertex, Integer> queue, HashMap<Vertex, Integer> solutionSet) {
		//Updates the queue with edges from current vertex
		for(Vertex edgeV: v.edges.keySet()) {
			if(solutionSet.containsKey(edgeV)) {
				continue;}
			if(!queue.containsKey(edgeV)) {
				queue.put(edgeV, v.edges.get(edgeV));
			}else {
				if(v.edges.get(edgeV)<queue.get(edgeV)) {
					queue.put(edgeV, v.edges.get(edgeV));
				}
			}
		}
	}
}
