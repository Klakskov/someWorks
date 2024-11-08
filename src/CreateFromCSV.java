import java.util.List;
import java.util.Map;

public interface CreateFromCSV<T> {

    T createFromCSV(Map<String, String> attributes );
}
