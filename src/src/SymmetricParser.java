import java.util.Scanner;

/**
 * The Symmetric parser class extends BaseParser class and implements the parse method.
 * @version 1.0.0.
 */
public class SymmetricParser extends BaseParser {

    /**
     * This method scans the path and fetches metadata like dimension and sets the scanner to fetch the datastructure.
     * @param path path to the input file.
     * @return ITsp object to further implement the algorithm for Symmetric TSP.
     */
    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimensionFromScanner(":");
        getStartingPos("NODE_COORD_SECTION");
        int dimension = getDimension();
        Scanner scanner = getScanner();
        DataStructureSymmetric dss = new DataStructureSymmetric(dimension, scanner);
        return dss.setCoordinates();
    }
}

