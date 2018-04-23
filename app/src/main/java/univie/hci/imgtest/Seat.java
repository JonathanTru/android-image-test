package univie.hci.imgtest;

/**
 * Created by Jonathan on 23.04.2018.
 */

public class Seat {
    private Point topLeft;
    private Point bottomRight;
    private String name;

    public Seat(Point topLeft, Point bottomRight, String name) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.name = name;
    }

    public boolean isWithinShape(Point click){
        return click.x >= topLeft.x && click.x <= bottomRight.x
                && click.y >= topLeft.y && click.y <= bottomRight.y;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "topLeft=" + topLeft +
                ", bottomRight=" + bottomRight +
                ", name='" + name + '\'' +
                '}';
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
