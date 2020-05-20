import org.testng.annotations.Test;
import org.testng.Assert;

public class PointTest {

    @Test
    public void testDistanceM() {
        Point TOne = new Point(0,0);
        Point TTwo = new Point(12, 5);

        Assert.assertEquals(TOne.anotherDistance(TTwo),13.0);
    }

    @Test
    public void testDistanceF() {
        Point TOne = new Point(0,0);
        Point TTwo = new Point(-3, 15);

        Assert.assertEquals(TOne.anotherDistance(TTwo), 15.297058540778355);
    }
}
