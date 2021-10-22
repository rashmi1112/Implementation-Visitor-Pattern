package arrayvisitors.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Results stores the individual processed input into a StringBuilder object and prints the output on standard output
 * and output file.
 * Implements the FileDisplayInterface and StdoutDisplayInterface
 *
 * @author Rashmi Badadale
 */

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private String fileName;
    private final StringBuilder stringBuilder = new StringBuilder();
    private final MyLogger myLogger = MyLogger.getInstance();
    List<Results> listOfResultsInstances = new ArrayList<>();

    public Results() {

    }

    /**
     * Constructor for initializing the StringBuilder and the output filename.
     *
     * @param outputFileName output filename/error filename
     */
    public Results(String outputFileName) {
        fileName = outputFileName;
        myLogger.writeMessage("Constructor for Results was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Implements the FileDisplayInterface and StdoutDisplayInterface for storing the results from the visitors" +
                "into a data structure";
    }

    /**
     * Stores the string into StringBuilder object
     *
     * @param numberIn String to be printed
     */
    public void storeResults(String numberIn) {
        stringBuilder.append(numberIn);
        stringBuilder.append("\n");
    }

    /**
     * Overloading the storeResults() for storing integer value into StringBuilder object
     *
     * @param numberIn int Number to be printed
     */
    public void storeResults(int numberIn) {
        stringBuilder.append(numberIn);
        stringBuilder.append("\n");
    }

    /**
     * Creates BufferedWriter for printing the stored output into the output file
     */
    public void writeToFile() {
        for (Results results : listOfResultsInstances) {

            BufferedWriter bufferedWriter = null;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(results.fileName));
                bufferedWriter.write(results.stringBuilder.toString());
                bufferedWriter.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
                System.exit(0);
            }
        }
    }

    /**
     * Method to loop over Results instances.
     * @param results1In Results instance 1
     * @param results2In Results instance 2
     */

    @Override
    public void populateList(Results results1In, Results results2In) {
        listOfResultsInstances.add(results1In);
        listOfResultsInstances.add(results2In);
    }

    /**
     * Writes the output from the stringBuilder on to the std output
     */
    @Override
    public void writeToStdout() {
        for (Results result : listOfResultsInstances) {
            System.out.println(result.stringBuilder.toString());
        }

    }
}
