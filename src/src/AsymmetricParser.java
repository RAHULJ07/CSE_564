import java.util.Scanner;

/**
 * The Asymmetric parser class extends BaseParser class and implements the parse method.
 */
public class AsymmetricParser extends BaseParser{
    /**
     * This method scans the path and fetches metadata like dimension and sets the scanner to fetch the datastructure.
     * @param path path to the input file.
     * @return ITsp object to further implement the algorithm for Asymmetric TSP.
     */
    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimensionFromScanner(":");
        getStartingPos("EDGE_WEIGHT_SECTION");
        int dimension = getDimension();
        Scanner scanner = getScanner();
        DataStructureAsymmetric dsa = new DataStructureAsymmetric(dimension, scanner);
        return dsa.createAdjacencyMatrix();
    }
}
