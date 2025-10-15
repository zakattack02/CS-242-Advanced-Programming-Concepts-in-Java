public class SquareSequence implements Sequence
{
    private int n;

    public SquareSequence() {
        // start at -1 so first element delivered is 0.
        n = -1;
    }

    public int next()
    {
        n++;
        return n * n;
    }
}
