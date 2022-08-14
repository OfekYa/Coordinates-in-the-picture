public class Point implements ObjectWithCoordinates // That's a special Point that holds names aswell
{
    private int x;
    private int y;
    private String name;

    public Point()
    {
        x=0;
        y=0;
        name="";

    }

    public Point(int x, int y, String name)
    {
        this.x=x;
        this.y=y;
        this.name=name;
    }

    public Point getPoint()
    {
        return this;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Object getData() {
        return name;
    }
}
