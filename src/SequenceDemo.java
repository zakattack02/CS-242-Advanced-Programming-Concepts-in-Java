
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
     * @throws FileNotFoundException if the data file is not found
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        DigitDistribution dist1 = new DigitDistribution();
        dist1.process(new SquareSequence(), 1000);
        dist1.displayFirst();
        System.out.println();
        dist1.displayLast();
        System.out.println();

        DigitDistribution dist2 = new DigitDistribution();
        dist2.process(new RandomSequence(), 1000);
        dist2.displayFirst();
        System.out.println();
        dist2.displayLast();
        System.out.println();

        try (Scanner in = new Scanner(new File("data/findata.txt"))) {
            DigitDistribution dist3 = new DigitDistribution();
            dist3.process(new ScannerSequence(in), 10000);
            dist3.displayFirst();
            System.out.println();
            dist3.displayLast();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
