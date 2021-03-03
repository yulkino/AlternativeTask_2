import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FileWorker {
    private String defaultPath = new String("D:\\IdeaProject\\AlternativeTask2\\src\\1.txt");

    public List<String> readFile(String path){
        if(path != "default")
            defaultPath = path;
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(defaultPath));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    public void writeResultInFile(String[][] map)
    {
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
            for(int y = 0; y < map.length; y++){
                for(int x = 0; x < map[0].length; x++){
                    writer.append(map[y][x]);
                }
                writer.append("\n");
            }
            writer.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
