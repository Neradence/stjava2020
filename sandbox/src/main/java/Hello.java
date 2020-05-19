public class Hello {
    public static void main(String[] args) {

        Point One = new Point(1,2);
        Point Two = new Point(4, -7);

        Point Three = new Point(-6.2, 8);
        Point Four = new Point(0, 12);

        System.out.println(distance(One, Two));
        System.out.println(distance(Three, Four));

        System.out.println(One.anotherDistance(Three));
        System.out.println(Two.anotherDistance(Four));
    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt((Math.pow((p2.x - p1.x),2)) + (Math.pow((p2.y - p1.y),2)));
    }
}
