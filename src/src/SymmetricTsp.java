
public class SymmetricTsp extends BaseTsp{


    private Coordinate [] coordinates;

    public Coordinate[] getCoordinates() {
        return coordinates;
    }


    public SymmetricTsp(int[][] _dist, Coordinate[] coordinates){
        super(_dist);
        this.coordinates = coordinates;
    }



}
