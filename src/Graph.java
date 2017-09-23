import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private int n;
    private List<Vertex> vertices;
    private Map<Vertex, List<Edge>> adjacencyMap;

    public Graph(){
        this(0, new ArrayList<Vertex>(), new HashMap<Vertex, List<Edge>>());
    }

    public Graph(int size, List<Vertex> vertices, Map<Vertex, List<Edge>> adjacency){
        this.n = size;
        this.vertices = vertices;
        this.adjacencyMap = adjacency;
    }

    public Graph(File inputFile){
        //do a thing
    }

    public int getSize(){
        return n;
    }

    //todo add error to mark duplication
    public boolean addVertex(Vertex v){
        int id = this.n; //todo replace with list length

        if(vertices.contains(v)){ return false; }
        else {
            vertices.add(v);
            this.n++;
            return true;
        }
    }

    public boolean addVertex(String name){
        Vertex add = new Vertex(this.n, name);
        return addVertex(add);
    }

    //delete vertex
    public boolean deleteVertex(Vertex v){
        if (n==0 || !vertices.contains(v)){ return false; }
        else {
            vertices.remove(v);
            n--;
            return true;
        }
    }

    public boolean deleteVertex(String name){
        Vertex delete = new Vertex(this.n, name);
        return deleteVertex(delete);
    }

    //add edge
    public boolean addEdge(Vertex start, Vertex end, int weight){
        if (!vertices.contains(start) || !vertices.contains(end)){ return false;}

        int idxStart = vertices.indexOf(start);
        int idxEnd = vertices.indexOf(end);

        Edge newEdge = new Edge(end, weight);
        if (adjacencyMap.containsKey(start)){ adjacencyMap.get(start).add(newEdge); }
        else {
            List<Edge> adjacencyList = new ArrayList<Edge>();
            adjacencyList.add(newEdge);
            adjacencyMap.put(start, adjacencyList);
        }
        return true;
    }

    //delete edge
    public boolean deleteEdge(Vertex start, Vertex end, int weight){
        Edge target = new Edge(end, weight);
        if(!adjacencyMap.get(start).contains(target)){
            return false;
        }
        else {
            adjacencyMap.get(start).remove(target);
            return true;
        }
    }

    public int getEdgeWeight(Vertex start, Vertex end){
        if(adjacencyMap.get(start).isEmpty()){
            throw new IllegalArgumentException("No connection found");
        }
        else {
            for (Edge e : adjacencyMap.get(start)){
                if (e.getConnection() == end){
                    return e.getWeight();
                }
            }
            throw new IllegalArgumentException("No connection found");
        }
    }

    //find paths
    public List<Vertex> findPath(Vertex start, Vertex end){
        return new ArrayList<Vertex>();
    }

    //find paths with limiting weight factors
}
