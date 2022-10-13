import java.util.ArrayList;
import java.util.List;

public abstract class BaseTsp implements ITsp{

    private int[][] distances;
    private int sum;
    private int[] route;

    public BaseTsp(int[][] _dist){
        distances = _dist;
    }

    public int getSum() {
    	return sum;
    }

    public int[] getRoute() {
    	return route;
    }
    
    
    @Override
    public void findMinRoute(){
        sum = 0;
        int counter = 1;
        int col = 0, row = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();

        // Starting from the 0th indexed city row.e., the first city
        visitedRouteList.add(0);
        route = new int[distances.length +1];
        route[0]=1;

        // Traverse the adjacency matrix tsp[][]
        while (row < distances.length && col < distances[row].length) {

            // Corner of the Matrix
            if (counter >= distances[row].length) {
                break;
            }

            // If this path is unvisited then and if the cost is less than update the cost
            if (col != row && !(visitedRouteList.contains(col))) {
                if (distances[row][col] < min) {
                    min = distances[row][col];
                    route[counter] = col + 1;
                }
            }
            col++;

            // Check all paths from the ith indexed city
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

        System.out.print("Minimum Cost is : ");
        System.out.println(sum);
        for(int k=0;k<route.length;k++)
            System.out.print(route[k] + " ");
    }
}
