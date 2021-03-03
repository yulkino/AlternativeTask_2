import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PathFinder {
    private Map<String, State> state = new HashMap<String, State>();{
        state.put("s", State.Start);
        state.put("#", State.Wall);
        state.put("f", State.Finish);
    }

    String[][] map;
    HashSet<Point> visited = new HashSet<Point>();

    public String[][] findPath(String[][] map){
        int x0 = 0;
        int y0 = 0;
        this.map = map;
        outter:
        for(int y = 0; y < this.map[0].length; y++)
            for(int x = 0; x < this.map.length; x++)
                if(state.get(this.map[x][y]) == State.Start)
                {
                    x0 = x;
                    y0 = y;
                    break outter;
                }

        Path path = visit(new Path(new Point(x0, y0), null), null);
        return changeMap(path);
    }

    private Path visit(Path path, Path result){
        if(path.currentPoint.x < 0 || path.currentPoint.x >= map.length
                || path.currentPoint.y < 0 || path.currentPoint.y >= map[0].length)
            return result;
        if(state.get(map[path.currentPoint.x][path.currentPoint.y]) == State.Wall)
            return result;
        if(visited.contains(path.currentPoint))
            return result;

        visited.add(path.currentPoint);

        if(state.get(map[path.currentPoint.x][path.currentPoint.y]) == State.Finish)
            return path;

        for (int dy = -1; dy <= 1; dy++)
            for (int dx = -1; dx <= 1; dx++) {
                if (Math.abs(dx) + Math.abs(dy) == 1)
                    result = visit(new Path(new Point(path.currentPoint.x+dx, path.currentPoint.y+dy), path), result);
            }
        return result;
    }

    private String[][] changeMap(Path path){
        Path current = path.previous;
        while(current.previous != null){
            map[current.currentPoint.x][current.currentPoint.y] = "*";
            current = current.previous;
        }
        return map;
    }
}
