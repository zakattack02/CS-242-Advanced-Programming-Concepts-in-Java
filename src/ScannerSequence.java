import java.util.Scanner;

/**
 * This class implements the Sequence interface to generate a sequence
 * of integers read from a Scanner.
 */
public class ScannerSequence implements Sequence
{
    private final Scanner scanner;

    /**
     * Constructs a ScannerSequence with the given Scanner.
     * Sets the scanner's delimiter to one or more non-digit characters.
     * @param scanner the Scanner to read integers from
     */
    public ScannerSequence(Scanner scanner)
    {
        this.scanner = scanner;
        // Set delimiter to one or more non-digit characters
        scanner.useDelimiter("\\D+");
    }

    /**
     * Gets the next integer from the scanner.
     * @return the next integer value read from the scanner
     */
    public int next()
    {
        return Integer.parseInt(scanner.next());
    }

    /**
     * Checks if there is a next integer available in the scanner.
     * @return true if there is a next token, false otherwise
     */
    public boolean hasNext()
    {
        return scanner.hasNext();
    }
}
