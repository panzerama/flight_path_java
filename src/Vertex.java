
/**
 * Adapted from a homework assignment. This is intended to serve as a super to an AirMap class.
 */
class Vertex implements Comparable<Vertex>{

    private String name;
    private Integer id;

    public Vertex(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int compareTo(Vertex other){
        return this.name.compareTo(other.getName());
    }

    /***
     * two vertices are equal if their names are equal
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        return name.equals(vertex.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + id.hashCode();
        return result;
    }
}