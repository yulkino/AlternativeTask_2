import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.print("1.Default file path\n2.Your path\n");
            int num = in.nextInt();
            List<String> lines = new ArrayList<String>();
            FileWorker fw = new FileWorker();
            switch (num) {
                case 1:
                    lines = fw.readFile("default");
                    break;
                case 2:
                    System.out.print("Enter your path: ");
                    String path = new Scanner(System.in).nextLine();
                    lines = fw.readFile(path);
                    break;
            }
            String[][] map = new Interpretator().interpretate(lines);
            String[][] path = new PathFinder().findPath(map);
            fw.writeResultInFile(path);
            System.out.print("Result in file \'output.txt\'");
    }

}