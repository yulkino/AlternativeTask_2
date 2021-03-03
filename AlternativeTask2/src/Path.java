import java.awt.*;

public class Path {
    public Path previous;
    public Point currentPoint;

    public Path(Point currentPoint, Path previous){
        this.currentPoint = currentPoint;
        this.previous = previous;
    }
}
