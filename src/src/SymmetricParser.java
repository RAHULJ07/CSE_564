import java.util.Scanner;

public class SymmetricParser extends BaseParser {

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

