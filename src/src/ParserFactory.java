
public class ParserFactory {

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
