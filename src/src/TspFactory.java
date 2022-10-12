public class TspFactory {

    static IParser parser;

    public static ITsp getTspObj(String path, TspType type){

        parser = ParserFactory.getParser(type);

        if(parser == null)
            return null;

        return parser.parse(path);
    }
}
