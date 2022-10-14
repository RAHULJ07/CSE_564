import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class implements IParser and is used to remove code redundancy.
 * The class has same methods that is used by its subclasses.
 * @version 1.0.0.
 */
public abstract class BaseParser implements IParser {

    private Scanner scanner;
    private int dimension;

    /**
     * Fetches the dimension.
     * @return dimension of parsed 2-D array.
     */
    public int getDimension(){
        return dimension;
    }

    /**
     * Fetches the scanner to scan through file.
     * @return scanner
     */
    public Scanner getScanner(){
        return scanner;
    }

    /**
     * creates a scanner for the file path.
     * @param path file path
     */
    protected void setScanner(String path) {

        File file = new File(path);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * gets the metadata dimension from the file
     * @param delimiter to split the dimension string from dimension number.
     */
    protected void getDimensionFromScanner(String delimiter){

        String nextLine = scanner.nextLine();
        while (!nextLine.startsWith("DIMENSION")) {
            nextLine = scanner.nextLine();
        }
        nextLine = nextLine.split(delimiter)[1].replaceAll("\\s","");
        dimension = Integer.parseInt(nextLine);//use 4th
    }

    /**
     * sets the starting position of scanner, so that 2-D array could be parsed
     * @param identifier string to identify the start of 2-D array.
     */
    protected void getStartingPos(String identifier){

        String nextLine = scanner.nextLine();
        while (!nextLine.startsWith(identifier)) {
            nextLine = scanner.nextLine();
        }
    }
}
