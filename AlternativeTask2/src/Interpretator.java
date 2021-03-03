import java.util.List;

public class Interpretator {
    public String[][] interpretate(List<String> lines){
        String[][] map = new String[lines.size()][lines.get(0).length()];

            for(int y = 0; y < lines.size(); y++)
                for(int x = 0; x < lines.get(0).length(); x++)
                    map[y][x] = Character.toString(lines.get(y).charAt(x));
        return  map;
    }
}
