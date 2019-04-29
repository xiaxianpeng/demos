package lambdaTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Created by xianpeng.xia
 * on 2019-04-21 22:59
 */
public class PointTest {

    @Test
    public void moveRightBy() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(5);
        assertEquals(10, p2.getX());
        assertEquals(5, p2.getY());
    }

    @Test
    public void testCompringTwoPoints() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = new Point(5, 6);
        int result = Point.compareByXandThenY.compare(p1, p2);
        assertEquals(-1, result);
    }

    @Test
    public void testMoveAllPointsRightBy() {
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        assertEquals(expectedPoints, newPoints);
    }
}