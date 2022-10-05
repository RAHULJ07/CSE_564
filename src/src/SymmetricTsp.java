import java.util.ArrayList;
import java.util.List;

public class SymmetricTsp implements ITsp{

    private List<int[]> distances = new ArrayList<int[]>();

    public SymmetricTsp(List<int[]> _dist){
        distances = _dist;
    }

    @Override
    public void execute() {

    }
}
