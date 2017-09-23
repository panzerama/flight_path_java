public class Edge {
    private Vertex connection;
    private Integer weight;

    public Edge(Vertex adjacent){
        this(adjacent, 0);
    }

    public Edge(Vertex adjacent, Integer weight) {
        this.connection = adjacent;
        this.weight = weight;
    }

    public Vertex getConnection() {
        return connection;
    }

    public void setConnection(Vertex connection) {
        this.connection = connection;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
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
