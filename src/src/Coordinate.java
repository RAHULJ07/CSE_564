/**
 * A coordinate class for storing x and y coordinate of symmetric TSP data.
 * @version 1.0.0.
 */
class Coordinate {
    private double x;
    private double y;

    /**
     * Constructor for assigning the x and y coordinate.
     * @param x x_coordinate
     * @param y y_coordinate
     */
    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x_coordinate
     * @return x_coordinate
     */
    public double getX() {return x;}

    /**
     * Getter for y_coordinate
     * @return y_coordinate
     */
    public double getY() {return y;}
}
