import java.util.ArrayList;
import java.util.List;

/**
 * This class computes the minimum distance require to cover all the cities for TSP using greedy algorithm
 * @version 1.0.0.
 */
public abstract class BaseTsp implements ITsp{
    private int[][] distances;
    private int sum;
    private int[] route;

    /**
     * Constructor for assigning the distance.
     * @param _dist 2-D array containing distances between cities.
     */
    public BaseTsp(int[][] _dist){
        distances = _dist;
    }
    /**
     * Getter for the distance sum
     * @return distance sum
     */
    public int getSum() {
    	return sum;
    }

    /**
     * Getter for the route
     * @return route array
     */
    public int[] getRoute() {
    	return route;
    }

    /**
     * Method to find the minimum total distance required to cover cities and the route.
     * Starting from the 0th indexed city, city with minimum
     * distance is visited and this continues till all the cities are done
     */
    @Override
    public void findMinRoute(){
        sum = 0;
        int counter = 1;
        int col = 0, row = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();
        visitedRouteList.add(0);
        route = new int[distances.length +1];
        route[0]=1;

        while (row < distances.length && col < distances[row].length) {

            if (counter >= distances[row].length) {
                break;
            }
            if (col != row && !(visitedRouteList.contains(col))) {
                if (distances[row][col] < min) {
                    min = distances[row][col];
                    route[counter] = col + 1;
                }
            }
            col++;
            if (col == distances[row].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                col = 0;
                row = route[counter] - 1;
                counter++;
            }
        }
        row = route[counter - 1] - 1;
        sum += distances[row][0];
        route[counter]= 1;
    }
}
