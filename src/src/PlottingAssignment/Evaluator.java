package PlottingAssignment;

public class Evaluator {

    private Evaluator(){}

    private static Evaluator instance;

    public static Evaluator getInstance(){
        if(instance == null){
            instance = new Evaluator();
        }
        return instance;
    }

    public double getAverage(int[] arr){
        double sum = 0;
        for(int idx = 0; idx < arr.length; idx++){
            sum += arr[idx];
        }
        return sum/arr.length;
    }
}
