import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class Step3DigitDistributionTest {

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
    public void displayFirstSquaresInPart3() {
        final String LABEL = "displayFirst() test";
        ddSquares.displayFirst(LABEL);
        final String EXPECTED = """
                
                displayFirst() test
                0:   1 :   1.00% :  *
                1:  20 :  20.00% :  **********
                2:  14 :  14.00% :  *******
                3:  12 :  12.00% :  ******
                4:  12 :  12.00% :  ******
                5:   9 :   9.00% :  *****
                6:   9 :   9.00% :  *****
                7:   8 :   8.00% :  ****
                8:   7 :   7.00% :  ****
                9:   8 :   8.00% :  ****
                Total count: 100
                """;
        assertEquals("Incorrect output from displayFirst()",
                     EXPECTED,
                     outCaptor.toString()
                     );
    }

    @org.junit.Test
    public void displayLastSquaresInPart3() {
        final String LABEL = "displayLast() test";
        ddSquares.displayLast(LABEL);
        final String EXPECTED = """
               
               displayLast() test
               0:  10 :  10.00% :  *****
               1:  20 :  20.00% :  **********
               2:   0 :   0.00% : \s
               3:   0 :   0.00% : \s
               4:  20 :  20.00% :  **********
               5:  10 :  10.00% :  *****
               6:  20 :  20.00% :  **********
               7:   0 :   0.00% : \s
               8:   0 :   0.00% : \s
               9:  20 :  20.00% :  **********
               Total count: 100
               """;
        assertEquals("Incorrect output from displayLast()",
                     EXPECTED,
                     outCaptor.toString()
        );
    }
}