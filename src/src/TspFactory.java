/**
 * Factory class to create the TSP object
 */
public class TspFactory {
    /**
     * Creates the appropriate TSP object after parsing the file.
     * @param path file path to be parsed.
     * @param type Type of TSP object to be created.
     * @return TSP Object.
     */
    public static ITsp getTspObj(String path, TspType type){

        IParser parser = ParserFactory.getParser(type);
        if(parser == null)
            return null;
        return parser.parse(path);
    }
}
