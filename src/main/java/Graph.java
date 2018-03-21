import java.util.Set;
import java.util.TreeSet;

class Edge{
    private int firstVertex;
    private int secondVertex;


    Edge(int firstVertex, int secondVertex) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
    }

    public int getFirstVertex() {
        return firstVertex;
    }

    public void setFirstVertex(int firstVertex) {
        this.firstVertex = firstVertex;
    }

    public int getSecondVertex() {
        return secondVertex;
    }

    public void setSecondVertex(int secondVertex) {
        this.secondVertex = secondVertex;
    }
}

public abstract class Graph {

    private Set<Edge> edges = new TreeSet<>();
    private Set<Integer> vertexes = new TreeSet<>();

    public void addEdge(int v, int w){ // ~ O(log(n))
        edges.add(new Edge(v, w));
    }

    public void removeEdge(int v, int w){ // ~ O(log(n))
        edges.remove(new Edge(v, w));
        edges.remove(new Edge(w, v));
    }

    public int VertexesCount() {// ~ O(1)
        return vertexes.size();
    }
    public int EdgesCount(){// ~ O(1)
        return edges.size();
    }

    public void addVertex(int v){// ~ O(log(n))
        vertexes.add(v);
    }

    public void removeVertex(int v){// ~ O(log(n)*adj(n))
        vertexes.remove(v);
        for (Edge edge : edges) {
            if (edge.getFirstVertex() == v)
                removeEdge(edge.getSecondVertex(), v);
            if (edge.getSecondVertex() ==v)
                removeEdge(edge.getFirstVertex(), v);
        }
    }
}
