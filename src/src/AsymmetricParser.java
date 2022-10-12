import java.util.Scanner;

public class AsymmetricParser extends BaseParser{

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
