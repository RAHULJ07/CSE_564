package DataStructure;

import Algorithm.AsymmetricTsp;
import Algorithm.ITsp;
import java.util.Scanner;

/**
 * Data structure class for Asymmetric type TSP that creates the adjacency matrix after parsing.
 * @version 1.0.0.
 */
public class DataStructureAsymmetric implements IData {

    private int dimension;
    private Scanner scanner;

    /**
     * Constructor for assigning the dimension and scanner for creating the matrix.
     * @param dimension of the city
     * @param scanner scanner object
     */
    public DataStructureAsymmetric(int dimension, Scanner scanner) {
        this.dimension = dimension;
        this.scanner = scanner;
    }

    /**
     * Method for creating the adjacency matrix from file data
     * @return ITsp object to further implement the algorithm for Asymmetric TSP.
     */
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
