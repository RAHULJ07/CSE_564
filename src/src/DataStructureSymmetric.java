import java.util.Scanner;

/**
 * Data structure class for Symmetric type TSP that creates the adjacency matrix after parsing.
 * @version 1.0.0.
 */
public class DataStructureSymmetric implements IData{

    private int dimension;
    private Scanner scanner;
    private Coordinate [] coordinates;

    /**
     * Constructor for assigning the dimension and scanner for creating the matrix.
     * @param dimension of the city
     * @param scanner scanner object
     */
    public DataStructureSymmetric(int dimension, Scanner scanner) {
        this.dimension = dimension;
        this.scanner = scanner;

    }
    /**
     * Method to scan all the coordinates from the Symmetric TSP file and put them in Coordinate array
     * @return ITsp object to further implement the algorithm for Asymmetric TSP.
     */
    public ITsp setCoordinates(){
        int row = 0;
        coordinates= new Coordinate[dimension];

        while (row < dimension) { // picking exactly the required number of items.
            String line = scanner.nextLine();
            String[] values = line.split(" ");
            double x = Double.parseDouble(values[1]);
            double y = Double.parseDouble(values[2]);
            Coordinate coordinate = new Coordinate(x, y);
            coordinates[row++] = coordinate;
        }
        return createAdjacencyMatrix();
    }

    /**
     * Method for creating the adjaceny matrix from file data
     * @return ITsp object to further implement the algorithm for Asymmetric TSP.
     */
    @Override
    public ITsp createAdjacencyMatrix() {
        int[][] distances = new int[dimension][dimension];
        for (int row = 0; row < dimension; row++) {
            for (int col = 0; col <= row; col++) {
                if (row == col)
                    distances[row][col] = 0;
                else {
                    double dX = coordinates[row].getX() - coordinates[col].getX();
                    double dY = coordinates[row].getY() - coordinates[col].getY();
                    distances[row][col] = (int) Math.round(Math.sqrt(dX * dX + dY * dY));
                    distances[col][row] = distances[row][col];
                }
            }
        }
        return new SymmetricTsp(distances, coordinates);
    }
}