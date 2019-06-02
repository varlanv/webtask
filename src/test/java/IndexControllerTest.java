import com.example.webtask.controllers.IndexController;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IndexControllerTest {

    @Test
    public void whenControllerCallsIndex_thenItReturnIndexString() {
        IndexController indexController = new IndexController();

        String index = indexController.index();

        assertThat(index).isEqualTo("index");
    }

}
