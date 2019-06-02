import com.example.webtask.domain.Result;
import com.example.webtask.exceptions.NoSolutionException;
import com.example.webtask.repositories.ResultRepository;
import com.example.webtask.services.SquareEquationService;
import org.assertj.core.data.Offset;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class SquareEquationServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void givenSolvableInput_whenEquationCalculates_thenItProvidesCorrectResult() {
        ResultRepository mock = Mockito.mock(ResultRepository.class);
        SquareEquationService squareEquationService = new SquareEquationService(mock);
        double a = -1;
        double b = 5;
        double c = 8;

        Result result = squareEquationService.calculateDiscriminant(a, b, c);

        assertThat(result.getFirstX()).isCloseTo(-1.2, Offset.offset(0.1));
        assertThat(result.getSecondX()).isCloseTo(6.27, Offset.offset(0.1));
        Mockito.verifyZeroInteractions(mock);
    }

    @Test
    public void givenUnsolvableInput_whenEquationCalculates_thenItThrowsNoSolutionException() {
        ResultRepository mock = Mockito.mock(ResultRepository.class);
        SquareEquationService squareEquationService = new SquareEquationService(mock);
        double a = 1;
        double b = 1;
        double c = 1;

        expectedException.expect(NoSolutionException.class);
        expectedException.expectMessage("No solution for:" + " a=" + a + ", b=" + b + ", c=" + c);

        squareEquationService.calculateDiscriminant(a, b, c);
        Mockito.verifyZeroInteractions(mock);
    }

    @Test
    public void givenNullInput_whenEquationCalculates_thenItThrowsIllegalArgumentException() {
        ResultRepository mock = Mockito.mock(ResultRepository.class);
        SquareEquationService squareEquationService = new SquareEquationService(mock);
        Double a = null;
        double b = 1;
        double c = 1;

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("All fields have to be specified");

        squareEquationService.calculateDiscriminant(a, b, c);
        Mockito.verifyZeroInteractions(mock);
    }

    @Test
    public void givenSolvableInput_whenEquationCalculatesAndSaves_thenItShouldCallRepository() {
        ResultRepository mock = Mockito.mock(ResultRepository.class);
        SquareEquationService squareEquationService = new SquareEquationService(mock);
        double a = -1;
        double b = 5;
        double c = 8;

        Result result = squareEquationService.calculateAndSave(a, b, c);

        Mockito.verify(mock, Mockito.only()).save(result);
    }
}
