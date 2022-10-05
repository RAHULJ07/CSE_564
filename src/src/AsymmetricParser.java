import java.util.ArrayList;
import java.util.List;

public class AsymmetricParser implements IParser{
    @Override
    public ITsp parse(String path) {
        List<int[]> distances = new ArrayList<int[]>();

        return new AsymmetricTsp(distances);
    }
}
