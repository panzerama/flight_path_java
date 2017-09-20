import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Adapted from a homework assignment. This is intended to serve as a super to an AirMap class.
 */
class Vertex implements Comparable<Vertex>{
    private class Edge{
        private Vertex connection;
        private Integer weight;

        private Edge(Vertex adjacent){
            this(adjacent, 0);
        }

        private Edge(Vertex adjacent, Integer weight) {
            this.connection = adjacent;
            this.weight = weight;
        }

        private Vertex getConnection() {
            return connection;
        }

        private void setConnection(Vertex connection) {
            this.connection = connection;
        }

        private Integer getWeight() {
            return weight;
        }

        private void setWeight(Integer weight) {
            this.weight = weight;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge edge = (Edge) o;

            if (!connection.equals(edge.connection)) return false;
            return weight.equals(edge.weight);
        }

        @Override
        public int hashCode() {
            int result = connection.hashCode();
            result = 31 * result + weight.hashCode();
            return result;
        }
    }

    private String name;
    private Integer id;
    private List<Edge> adjacentSet;

    private Vertex(String name, Integer index, List<Edge> adjacency){
        this.name = name;
        this.id = index;
        this.adjacentSet = adjacency;
    }

    public Vertex(Integer id) {
        this("", id, new ArrayList<Edge>());
    }

    public Vertex(String name, Integer id) {
        this(name, id, new ArrayList<Edge>());
    }

    public void addEdge(Vertex adjacent, Integer weight){
        Edge connection = new Edge(adjacent, weight);
        this.adjacentSet.add(connection);
    }

    /***
     * removes first edge to match adjacent vertex
     * @param adjacent
     */
    public boolean removeEdge(Vertex adjacent) {
        for (Edge e : this.adjacentSet) {
            if (e.connection == adjacent){
                this.adjacentSet.remove(e);
            }
        }
    }

    public String getName(){
        return this.name;
    }

    public int compareTo(Vertex other){
        return this.name.compareTo(other.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (!id.equals(vertex.id)) return false;
        return name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + adjacentSet.hashCode();
        return result;
    }
}