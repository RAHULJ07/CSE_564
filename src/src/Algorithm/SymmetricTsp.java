package Algorithm;

import DataStructure.Coordinate;

/**
 * This class extends BaseTsp class and sets the distance array.
 * It also gets the coordinate array from the Data Stricture symmetric class.
 * @version 1.0.0.
 */
public class SymmetricTsp extends BaseTsp{

    private Coordinate[] coordinates;

    /**
     * Getter for the coordinate array
     * @return coordinate array
     */
    public Coordinate[] getCoordinates() {
        return coordinates;
    }

    /**
     * Constructor for assigning the distance.
     * @param _dist 2-D array containing distances between cities.
     */
    public SymmetricTsp(int[][] _dist, Coordinate[] coordinates){
        super(_dist);
        this.coordinates = coordinates;
    }
}
