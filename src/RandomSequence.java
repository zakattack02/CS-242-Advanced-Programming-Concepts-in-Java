/**
 * This class implements the Sequence interface to generate a sequence
 * of random integers.
 */
public class RandomSequence implements Sequence
{
    /**
     * Constructs a RandomSequence.
     */
    public RandomSequence() {
    }

    /**
     * Gets the next random integer in the sequence.
     * @return a random integer between 0 and Integer.MAX_VALUE
     */
    public int next()
    {
        return (int) (Integer.MAX_VALUE * Math.random());
    }
}
