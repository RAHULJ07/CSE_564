import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymmetricParser implements IParser {

    private int dimension;
    private Coordinate[] coordinates;
    private Scanner scanner;
    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimension();
        return getCoordinates();
    }

    private void setScanner(String path) {
        File file = new File(path);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void getDimension(){
        String fileType;
        String nextLine = scanner.nextLine();

        while (!nextLine.startsWith("DIMENSION")) {
            nextLine = scanner.nextLine();
        }

        dimension = Integer.parseInt(nextLine.split(" ")[2]);//use 4th
        fileType = scanner.nextLine().split(" ")[2];
        scanner.nextLine();
    }
    private ITsp getCoordinates(){
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
        return new SymmetricTsp(distances);
    }
}

