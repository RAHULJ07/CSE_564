import java.util.ArrayList;
import java.util.List;

public class SymmetricTsp implements ITsp{

    private int[][] distances ;

    public SymmetricTsp(int[][] _dist){
        distances = _dist;
    }

        public void findMinRoute() {
        int sum = 0;
        int counter = 0;
        int j = 0, i = 0;
        int min = Integer.MAX_VALUE;
        List<Integer> visitedRouteList = new ArrayList<>();

        // Starting from the 0th indexed city i.e., the first city
        visitedRouteList.add(0);
        int[] route = new int[distances.length];

        // Traverse the adjacency matrix tsp[][]
        while (i < distances.length && j < distances[i].length) {

            // Corner of the Matrix
            if (counter >= distances[i].length - 1) {
                break;
            }

            // If this path is unvisited then and if the cost is less than update the cost
            if (j != i && !(visitedRouteList.contains(j))) {
                if (distances[i][j] < min) {
                    min = distances[i][j];
                    route[counter] = j + 1;
                }
            }
            j++;

            // Check all paths from the ith indexed city
            if (j == distances[i].length) {
                sum += min;
                min = Integer.MAX_VALUE;
                visitedRouteList.add(route[counter] - 1);
                j = 0;
                i = route[counter] - 1;
                counter++;
            }
        }

        i = route[counter - 1] - 1;
        sum += distances[i][0];
        route[counter]= 1;

        System.out.print("Minimum Cost is : ");
        System.out.println(sum);
        for(int k=0;k<route.length;k++)
            System.out.print(route[k] + " ");
    }
}
