/**
 This class analyzes the distribution of the last digit of values
 from a sequence.
 */
public class LastDigitDistribution
{
    private final int[] counters;

    /**
     Constructs a distribution whose counters are set to zero.
     */
    public LastDigitDistribution()
    {
        counters = new int[10];
    }

    /**
     Processes values from this sequence.
     @param seq the sequence from which to obtain the values
     @param valuesToProcess the number of values to process
     */
    public void process(Sequence seq, int valuesToProcess)
    {
        for (int i = 1; i <= valuesToProcess; i++)
        {
            int value = seq.next();
            int lastDigit = value % 10;
            counters[lastDigit]++;
        }
    }

    /**
     * Displays the counter values of this distribution.
     * @param label the label to print above the table of digit counts.
     */
    public void display(String label)
    {
        System.out.println("\n" + label);
        for (int i = 0; i < counters.length; i++)
        {
            System.out.println(i + ": " + counters[i]);
        }
    }
}