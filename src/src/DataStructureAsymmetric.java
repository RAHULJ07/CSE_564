import java.util.Scanner;

public class DataStructureAsymmetric implements IData{

    private int dimension;
    private Scanner scanner;

    public DataStructureAsymmetric(int dimension, Scanner scanner) {
        this.dimension = dimension;
        this.scanner = scanner;
    }

    @Override
    public ITsp createAdjacencyMatrix(){
        int row = 0;
        dimension = dimension-2;
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
