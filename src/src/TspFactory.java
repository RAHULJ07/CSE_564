public class TspFactory {

    public static ITsp getTspObj(String path, TspType type){

        IParser parser = ParserFactory.getParser(type);

        if(parser == null)
            return null;

        return parser.parse(path);
    }
}
