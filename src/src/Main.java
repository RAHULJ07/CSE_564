public class Main {

    public static void main(String args[]) {
        String filename;
        filename = "../lu980.tsp";

        ITsp symmetricTsp= TspFactory.getTspObj(filename,TspType.Symmetric);
        symmetricTsp.findMinRoute();

    }
}
