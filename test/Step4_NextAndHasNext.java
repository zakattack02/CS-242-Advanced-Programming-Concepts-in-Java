import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class Step4_NextAndHasNext {
    // Maximum number of iterations when testing RandomSequence.
    private final int MAX_LOOPS = 100000;

    @Test
    public void randSeqHasNextAlwaysTrueForRandomSequence() {
        Sequence seq = new RandomSequence();
        for (int i = 0; i < MAX_LOOPS; ++i) {
            if (!seq.hasNext()) {
                fail("RandomSequence hasNext() false on iteration " + i);
            }
            seq.next();
        }
    }

    @Test
    public void randSeqNextAlwaysReturnsForRandomSequence() {
        Sequence seq = new RandomSequence();
        for (int i = 0; i < MAX_LOOPS; ++i) {
            try {
                seq.next();
            } catch (Exception e) {
                fail("RandomSequence next() threw on iteration " + i);
            }
        }
    }

    @Test
    public void squareSeqHasNextIsTrueForExactly46341Calls() {
        Sequence seq = new SquareSequence();
        for (int i = 0; i < 46341; ++i) {
            assertTrue("hasNext() returned false early: iteration " + i,
                       seq.hasNext());
            seq.next();
        }
        assertFalse("hasNext() returned true after 436341 next() calls",
                    seq.hasNext());
    }

    @Test
    public void squareSeqNextReturnsValueForExactly46341Calls() {
        Sequence seq = new SquareSequence();
        // From 0 to 46431, no overflow.
        try {
            for (int i = 0; i < 46341; ++i) {
                seq.next();
            }
        } catch (Exception e) {
            fail("next() threw exception too early");
        }

        try {
            seq.next();
            fail("next() did not throw on iteration 46432");
        } catch (Exception e) {
            assertEquals("next() threw wrong class",
                         NoSuchElementException.class,
                         e.getClass());
            assertEquals("Next() threw wrong exception message",
                         "next value would cause integer overflow",
                         e.getMessage());
        }
    }

    @Test
    public void squareSeqNextThrowsOnCall46341() {

    }
}