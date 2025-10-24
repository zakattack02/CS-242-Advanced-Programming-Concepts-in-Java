import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class Step2DigitDistributionTest {

    Sequence squareSequence;
    DigitDistribution ddSquares;

    // Following lines for capturing System.out.
    // See https://www.baeldung.com/java-testing-system-out-println
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream outCaptor =
            new ByteArrayOutputStream();

    @org.junit.Before
    public void setUp() {
        System.setOut(new PrintStream(outCaptor));
        squareSequence = new SquareSequence();
        ddSquares = new DigitDistribution();
        ddSquares.process(squareSequence, 100);
    }

    @org.junit.After
    public void tearDown() {
        System.setOut(stdout);
    }

    @org.junit.Test
    public void displayFirstSquaresInPart2() {
        final String LABEL = "displayFirst() test";
        ddSquares.displayFirst(LABEL);
        final String EXPECTED = """
                
                displayFirst() test
                0: 1
                1: 20
                2: 14
                3: 12
                4: 12
                5: 9
                6: 9
                7: 8
                8: 7
                9: 8
                """;
        assertEquals("Incorrect output from displayFirst()",
                     EXPECTED,
                     outCaptor.toString()
                     );
    }

    @org.junit.Test
    public void displayLastSquaresInPart2() {
        final String LABEL = "displayLast() test";
        ddSquares.displayLast(LABEL);
        final String EXPECTED = """
                
                displayLast() test
                0: 10
                1: 20
                2: 0
                3: 0
                4: 20
                5: 10
                6: 20
                7: 0
                8: 0
                9: 20
                """;
        assertEquals("Incorrect output from displayLast()",
                     EXPECTED,
                     outCaptor.toString()
        );
    }
}