import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    @Test
    void addVertex() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");
        Vertex delta = new Vertex(3, "Delta");

        assertTrue(test.addVertex(alpha));
        assertTrue(test.addVertex(beta));
        assertTrue(test.addVertex(delta));

        assertEquals(3, test.getSize());
    }

    @Test
    void addVertexNotAllowDupes() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");
        Vertex duplicate = new Vertex(3, "Alpha");

        assertTrue(test.addVertex(alpha));
        assertTrue(test.addVertex(beta));
        assertFalse(test.addVertex(duplicate));

        assertEquals(2, test.getSize());
    }

    @Test
    void deleteVertex() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");

        assertTrue(test.addVertex(alpha));
        assertTrue(test.addVertex(beta));
        assertTrue(test.deleteVertex(alpha));

        assertEquals(1, test.getSize());
    }

    @Test
    void addEdge() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");

        test.addVertex(alpha);
        test.addVertex(beta);

        assertTrue(test.addEdge(alpha, beta, 100));
    }

    @Test
    void getEdgeWeight() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");

        test.addVertex(alpha);
        test.addVertex(beta);

        test.addEdge(alpha, beta, 100);

        int weight = test.getEdgeWeight(alpha, beta);
        assertEquals(weight, 100);
    }

    @Test
    void errorForEdgeNotInGraph(){
        Graph test = new Graph();

        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");

        test.addVertex(alpha);
        test.addVertex(beta);

        test.addEdge(alpha, beta, 100);

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            test.getEdgeWeight(beta, alpha);
        });

        assertEquals("No connection found", exception.getMessage());
    }

    @Test
    void deleteEdge() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");

        test.addVertex(alpha);
        test.addVertex(beta);

        test.addEdge(alpha, beta, 100);

        assertTrue(test.deleteEdge(alpha, beta));

        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            test.getEdgeWeight(beta, alpha);
        });

        assertEquals("No connection found", exception.getMessage());
    }

    @Test
    void findPath() {
        Graph test = new Graph();
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");
        Vertex charlie = new Vertex(3, "Charlie");
        Vertex delta = new Vertex(4, "Delta");
        Vertex echo = new Vertex(5, "Echo");
        Vertex foxtrot = new Vertex(6, "Foxtrot");
        Vertex golf = new Vertex(7, "Golf");
        Vertex hotel = new Vertex(8, "Hotel");

        test.addEdge(alpha, beta, 100);
        test.addEdge(beta, charlie, 100);
        test.addEdge(beta, alpha, 100);
        test.addEdge(beta, beta, 100);
        test.addEdge(charlie, delta, 100);
        test.addEdge(delta, charlie, 100);
        test.addEdge(echo, charlie, 100);
        test.addEdge(echo, foxtrot, 100);
        test.addEdge(delta, charlie, 100);
        test.addEdge(golf, hotel, 100);
        test.addEdge(foxtrot, hotel, 100);
        test.addEdge(hotel, golf, 100);
        test.addEdge(beta, hotel, 100);
        test.addEdge(hotel, beta, 100);
        test.addEdge(beta, golf, 100);

    }

    Graph generateTestGraph(){

    }

}