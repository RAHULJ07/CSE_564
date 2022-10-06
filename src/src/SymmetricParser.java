import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SymmetricParser implements IParser {

    int dimension;
    Coordinate[] coordinates;
    Scanner scanner;
    @Override
    public ITsp parse(String path) {
        setScanner(path);
        getDimension();
        return getCoordinates();
    }

    public void setScanner(String path) {
        File file = new File(path);

        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void getDimension(){
        String fileType;
        String nextLine = scanner.nextLine();

        while (!nextLine.startsWith("DIMENSION")) {
            nextLine = scanner.nextLine();
        }

        dimension = Integer.parseInt(nextLine.split(" ")[2]);//use 4th
        fileType = scanner.nextLine().split(" ")[2];
        scanner.nextLine();
    }
    public ITsp getCoordinates(){
        int i = 0;
        coordinates= new Coordinate[dimension];

        while (i < dimension) { // picking exactly the required number of items.
            String line = scanner.nextLine();
            String[] values = line.split(" ");
            double x = Double.parseDouble(values[1]);
            double y = Double.parseDouble(values[2]);
            Coordinate coordinate = new Coordinate(x, y);
            coordinates[i++] = coordinate;
        }
        return createAdjacencyMatrix();
    }

    public ITsp createAdjacencyMatrix() {
        int[][] distances = new int[dimension][dimension];

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j)
                    distances[i][j] = 0;
                else {
                    double dX = coordinates[i].getX() - coordinates[j].getX();
                    double dY = coordinates[i].getY() - coordinates[j].getY();
                    distances[i][j] = (int) Math.round(Math.sqrt(dX * dX + dY * dY));
                    distances[j][i] = distances[i][j];
                }
            }
        }
        return new SymmetricTsp(distances);
    }
}

