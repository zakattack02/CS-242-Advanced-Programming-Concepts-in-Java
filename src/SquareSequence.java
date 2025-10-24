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
     * @throws java.util.NoSuchElementException if the next value would cause integer overflow
     */
    public int next()
    {
        if (!hasNext()) {
            throw new java.util.NoSuchElementException("Integer overflow: next square would exceed Integer.MAX_VALUE");
        }
        n++;
        return n * n;
    }

    /**
     * Checks if there is a next value available without causing integer overflow.
     * @return true if the next square can be computed without overflow, false otherwise
     */
    public boolean hasNext()
    {
        // Check if n + 1 would cause overflow when squared
        return (n + 1) <= Math.sqrt(Integer.MAX_VALUE);
    }
}
