package app.components;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void positionsWithSameCoordiantesShouldBeEqual() {
        assertEquals(new Position(2, 5), new Position(2, 5));
    }
}
