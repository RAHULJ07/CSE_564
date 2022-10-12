import java.util.Scanner;

public class DataStructureSymmetric implements IData{

    private int dimension;
    private Scanner scanner;
    private Coordinate [] coordinates;

    public DataStructureSymmetric(int dimension, Scanner scanner) {
        this.dimension = dimension;
        this.scanner = scanner;
    }

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
