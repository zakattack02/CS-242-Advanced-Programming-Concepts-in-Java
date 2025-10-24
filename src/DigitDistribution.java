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
        for (int i = 1; i <= valuesToProcess && seq.hasNext(); i++)
        {
            int value = seq.next();
            int lastDigit = value % 10;
            lastDigitCounters[lastDigit]++;
            
            int firstDigit = Integer.toString(value).charAt(0) - '0';
            firstDigitCounters[firstDigit]++;
        }
    }

    /**
     * Helper method to display counters with a label, percentages, and histogram.
     * @param counters the array of counters to display
     * @param label the label to print above the table of digit counts
     */
    private void displayCounters(int[] counters, String label)
    {
        System.out.println("\n" + label);
        
        // Calculate total and find the largest count
        int total = 0;
        int maxCount = 0;
        for (int count : counters) {
            total += count;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        
        // Determine the width needed for the count column
        int countWidth = String.valueOf(maxCount).length();
        
        // Build the format string dynamically for right-aligned counts
        String formatString = "%" + countWidth + "d";
        
        // Display each digit with count, percentage, and histogram
        for (int i = 0; i < counters.length; i++)
        {
            int count = counters[i];
            double percentage = (total > 0) ? (count * 100.0 / total) : 0.0;
            int histogramBars = (int) Math.round(percentage / 2.0);
            String histogram = "*".repeat(histogramBars);
            
            System.out.printf("%d: " + formatString + ": %6.2f%%: %s%n", 
                              i, count, percentage, histogram);
        }
        
        System.out.println("Total count: " + total);
    }

    /**
     * Displays the last-digit distribution.
     */
    public void displayLast()
    {
        displayCounters(lastDigitCounters, "Last-digit distribution");
    }

    /**
     * Displays the first-digit distribution.
     */
    public void displayFirst()
    {
        displayCounters(firstDigitCounters, "First-digit distribution");
    }
}