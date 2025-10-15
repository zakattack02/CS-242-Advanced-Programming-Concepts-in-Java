
/**
 * This class demonstrates the use of the other components of this
 * project: digit-distribution analysis of various sequences.
 */
public class SequenceDemo
{
    /**
     * Demonstrates digit-distribution analysis of several sequences,
     * using other classes in this project.
     * @param args command-line arguments (unused).
     */
    public static void main(String[] args)
    {
        LastDigitDistribution dist1 = new LastDigitDistribution();
        dist1.process(new SquareSequence(), 1000);
        // dist1.displayFirst("Square Sequence, first-digit distribution");
        dist1.display("Square Sequence, last-digit distribution");
        System.out.println();

        LastDigitDistribution dist2 = new LastDigitDistribution();
        dist2.process(new RandomSequence(), 1000);
        // dist2.displayFirst("Random Sequence, first-digit distribution");
        dist2.display("Random Sequence, last-digit distribution");
        System.out.println();

//        try (Scanner in = new Scanner(new File("data/findata.txt"))) {
//            DigitDistribution dist3 = new DigitDistribution();
//            dist3.process(new ScannerSequence(in), 10000);
//            dist3.displayFirst("Scanner Sequence, first-digit distribution");
//            dist3.displayLast("Scanner Sequence, last-digit distribution");
//        } catch (FileNotFoundException e) {
//            System.err.println(e.getMessage());
//        }
    }
}
