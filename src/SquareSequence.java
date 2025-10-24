/**
 * This class implements the Sequence interface to generate a sequence
 * of perfect squares: 0, 1, 4, 9, 16, 25, ...
 */
public class SquareSequence implements Sequence
{
    private int n;

    /**
     * Constructs a SquareSequence starting at 0.
     */
    public SquareSequence() {
        // start at -1 so first element delivered is 0.
        n = -1;
    }

    /**
     * Gets the next perfect square in the sequence.
     * @return the next square number (n * n)
     */
    public int next()
    {
        n++;
        return n * n;
    }
}
