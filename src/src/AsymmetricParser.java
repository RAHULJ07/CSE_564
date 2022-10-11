import java.util.Scanner;

public class AsymmetricParser extends BaseParser{

    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimensionFromScanner(":");
        getStartingPos("EDGE_WEIGHT_SECTION");
        return getDistanceMatrix();
    }

    private ITsp getDistanceMatrix(){
        int row = 0;
        int dimension = getDimension()-2;
        Scanner scanner = getScanner();
        int[][] distances = new int[dimension][dimension];
        scanner.nextLine();
        while (row < dimension) { // picking exactly the required number of items.
            String line = scanner.nextLine();
            String[] values = line.split("  ");
            int col = 0;
            for(int idx = 2; idx < values.length-1; idx++){
                distances[row][col++] = Integer.parseInt(values[idx].replaceAll("\\s",""));
            }
            row++;
        }
        return new AsymmetricTsp(distances);
    }
}
