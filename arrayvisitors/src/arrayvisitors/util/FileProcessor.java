package arrayvisitors.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Queue;

/**
 * Class to parse the input file
 *
 * @author Rashmi Badadale
 */
public class FileProcessor {

    private final String inputFileName;
    private BufferedReader reader;
    private Queue<String> words;
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Constructor for the FileProcessor class
     *
     * @param inputFileName1In Inout file name to be parsed
     */
    public FileProcessor(String inputFileName1In) {
        inputFileName = inputFileName1In;
        try {
            if (!Files.exists(Paths.get(inputFileName))) {
                throw new FileNotFoundException("Invalid input file or input file in incorrect location");
            }
            reader = new BufferedReader(new FileReader(new File(inputFileName)));
        }catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
                System.exit(0);
            }
        myLogger.writeMessage("Constructor for File Processor was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Overriding the toString method
     *
     * @return String
     */

    public String toString() {
        return "Reads and processes the contents of the input file" + inputFileName;
    }

    /**
     * Get the filename
     *
     * @return String filename
     */
    public String getFileName() {
        return inputFileName;
    }

    /**
     * Method to initialize the scanner and read the first line from the input file
     */


    public String poll() throws IOException {
            return reader.readLine();
    }

    /**
     * Method to close the scanners created for reading the input file
     */
    public void close() {
        try {
            reader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(0);
        }
    }
}

