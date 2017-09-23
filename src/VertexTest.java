import com.sun.javafx.geom.Edge;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    @org.junit.jupiter.api.Test
    void compareTo() {
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");
        Vertex otherAlpha = new Vertex(3, "Alpha");

        assertEquals(-1, alpha.compareTo(beta));
        assertEquals(0, alpha.compareTo(otherAlpha));
    }

    @org.junit.jupiter.api.Test
    void equals() {
        Vertex alpha = new Vertex(1, "Alpha");
        Vertex beta = new Vertex(2, "Beta");
        Vertex otherAlpha = new Vertex(3, "Alpha");

        assertTrue(alpha.equals(otherAlpha));
        assertFalse(alpha.equals(beta));
    }

}