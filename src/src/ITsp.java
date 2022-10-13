/**
 * Interface for finding minimum route for TSP type problem.
 */
public interface ITsp {
    void findMinRoute();

	int getSum();

	int[] getRoute();
}
