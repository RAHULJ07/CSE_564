import java.util.ArrayList;
import java.util.List;

public class AsymmetricTsp implements ITsp{

    private List<int[]> distances = new ArrayList<int[]>();

    public AsymmetricTsp(List<int[]> _dist){
        distances = _dist;
    }


    @Override
    public void findMinRoute() {

    }
}
