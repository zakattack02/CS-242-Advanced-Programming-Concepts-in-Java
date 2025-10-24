/**
 * This class analyzes the distribution of first and last digits of values
 * from a sequence.
 */
public class DigitDistribution
{
    private final int[] lastDigitCounters;
    private final int[] firstDigitCounters;

    /**
     * Constructs a distribution whose counters are set to zero.
     */
    public DigitDistribution()
    {
        lastDigitCounters = new int[10];
        firstDigitCounters = new int[10];
    }

    /**
     * Processes values from this sequence, updating both first and last digit counters.
     * @param seq the sequence from which to obtain the values
     * @param valuesToProcess the number of values to process
     */
    public void process(Sequence seq, int valuesToProcess)
    {
        for (int i = 1; i <= valuesToProcess; i++)
        {
            int value = seq.next();
            int lastDigit = value % 10;
            lastDigitCounters[lastDigit]++;
            
            int firstDigit = Integer.toString(value).charAt(0) - '0';
            firstDigitCounters[firstDigit]++;
        }
    }

    /**
     * Helper method to display counters with a label.
     * @param counters the array of counters to display
     * @param label the label to print above the table of digit counts
     */
    private void displayCounters(int[] counters, String label)
    {
        System.out.println("\n" + label);
        for (int i = 0; i < counters.length; i++)
        {
            System.out.println(i + ": " + counters[i]);
        }
    }

    /**
     * Displays the last-digit distribution.
     */
    public void displayLast()
    {
        displayCounters(lastDigitCounters, "last-digit distribution");
    }

    /**
     * Displays the first-digit distribution.
     */
    public void displayFirst()
    {
        displayCounters(firstDigitCounters, "first-digit distribution");
    }
}