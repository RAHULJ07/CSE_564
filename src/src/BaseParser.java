import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class BaseParser implements IParser {

    private Scanner scanner;
    private int dimension;

    public int getDimension(){
        return dimension;
    }

    public Scanner getScanner(){
        return scanner;
    }

    protected void setScanner(String path) {
        File file = new File(path);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    protected void getDimensionFromScanner(String delimiter){
        String nextLine = scanner.nextLine();

        while (!nextLine.startsWith("DIMENSION")) {
            nextLine = scanner.nextLine();
        }
        nextLine = nextLine.split(delimiter)[1].replaceAll("\\s","");
        dimension = Integer.parseInt(nextLine);//use 4th
    }

    protected void getStartingPos(String identifier){
        String nextLine = scanner.nextLine();

        while (!nextLine.startsWith(identifier)) {
            nextLine = scanner.nextLine();
        }
    }
}
