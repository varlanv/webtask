import com.example.webtask.controllers.EquationController;
import com.example.webtask.domain.Result;
import com.example.webtask.services.SquareEquationService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EquationControllerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void givenAnyInput_whenCalculate_shouldCallEquationService() {
        double a = 1;
        double b = 3;
        double c = 5;
        SquareEquationService service = Mockito.mock(SquareEquationService.class);
        when(service.calculateAndSave(a, b, c)).thenReturn(new Result());
        EquationController controller = new EquationController(service);

        controller.calculate(a, b, c);

        verify(service, only()).calculateAndSave(a, b, c);
    }

//    @Test
//    public void given() {
//        expectedException.expect(NoSolutionException.class);
//        expectedException.expectMessage("qwe");
//        double a = 1;
//        double b = 3;
//        double c = 5;
//        EquationService service = Mockito.mock(EquationService.class);
//        when(service.calculateAndSave(a, b, c)).thenThrow(new NoSolutionException("qwe"));
//        EquationController controller = new EquationController(service);
//
//        controller.calculate(a, b, c);
//    }
}
