import java.util.Scanner;

public class SymmetricParser extends BaseParser {

    private Coordinate[] coordinates;

    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimensionFromScanner(":");
        getStartingPos("NODE_COORD_SECTION");
        return getCoordinates();
    }

    private ITsp getCoordinates(){
        int row = 0;
        int dimension = getDimension();
        Scanner scanner = getScanner();
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

    public ITsp createAdjacencyMatrix() {
        int dimension = getDimension();
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
        return new SymmetricTsp(distances);
    }
}

