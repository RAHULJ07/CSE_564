public class Main {

    public static void main(String args[]) {
        String filename;
        filename = "C:/Users/rkumar95/Downloads/ar9152.tsp";

        ITsp symmetricTsp= TspFactory.getTspObj(filename,TspType.Symmetric);
        symmetricTsp.findMinRoute();

    }
}
