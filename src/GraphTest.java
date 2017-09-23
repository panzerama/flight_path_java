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

        int weight = test.getEdgeWeight(alpha, beta);
        assertEquals(weight, 100);
    }

    @Test
    void getEdgeWeight() {
        fail("write test");
    }

    @Test
    void errorForEdgeNotInGraph(){
        fail("write test");
    }

    @Test
    void deleteEdge() {
        fail("write test");
    }

    @Test
    void findPath() {
        fail("write test");
    }

}