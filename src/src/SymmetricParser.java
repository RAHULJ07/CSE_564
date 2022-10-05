import java.util.ArrayList;
import java.util.List;

public class SymmetricParser implements IParser {

    @Override
    public ITsp parse(String path) {
        List<int[]> distances = new ArrayList<int[]>();

        return new SymmetricTsp(distances);
    }
}
