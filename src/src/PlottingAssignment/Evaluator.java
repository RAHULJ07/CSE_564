package PlottingAssignment;

/**
 * Singleton class for evaluation.
 * @version 1.0.0.
 */
public class Evaluator {

    /**
     * private constructor
     */
    private Evaluator(){}

    private static Evaluator instance;

    /**
     * static method for single instance
     * @return instance of the class
     */
    public static Evaluator getInstance(){
        if(instance == null){
            instance = new Evaluator();
        }
        return instance;
    }

    /**
     * Method to calculate average.
     * @param arr integer array
     * @return average of the array
     */
    public double getAverage(int[] arr){
        double sum = 0;
        for(int idx = 0; idx < arr.length; idx++){
            sum += arr[idx];
        }
        return sum/arr.length;
    }
}
