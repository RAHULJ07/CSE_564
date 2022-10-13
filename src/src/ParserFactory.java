/**
 * Factory class to create the parser object
 */
public class ParserFactory {
    /**
     * Creates the appropriate parser object.
     * @param type type of object to be created.
     * @return created object.
     */
    public static IParser getParser(TspType type){

        switch(type){
            case Symmetric:
                return new SymmetricParser();
            case Asymmetric:
                return new AsymmetricParser();
            default:
                return null;
        }
    }
}
