import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {
    @Test
    void getConnection() {
        Vertex vTest = new Vertex( 1, "Alpha");
        Edge test = new Edge(vTest, 100);

        assertEquals(test.getConnection(), vTest);
    }

    @Test
    void equals() {
        Vertex vAlpha = new Vertex(1, "Alpha");

        Edge alpha = new Edge(vAlpha, 100);
        Edge beta = new Edge(vAlpha, 100);

        assertTrue(beta.equals(alpha));
    }

}