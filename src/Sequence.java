/**
 * This interface represents a sequence of integers.
 * Implementing classes provide methods to retrieve successive values
 * from the sequence.
 */
public interface Sequence
{
    /**
     * Gets the next number in the sequence.
     * @return the next integer value in the sequence
     */
    int next();

    /**
     * Checks if there are more values available in the sequence.
     * @return true if there is a next value, false otherwise
     */
    boolean hasNext();
}
