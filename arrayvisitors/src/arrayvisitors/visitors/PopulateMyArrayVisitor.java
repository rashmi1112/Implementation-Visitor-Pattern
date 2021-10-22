package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;

import java.io.IOException;

/**
 * Class that implements the Visitor Missing Ints. Takes out missing integers from given array and stores them in
 * appropriate results instance.
 *
 * @author Rashmi Badadale
 */
public class PopulateMyArrayVisitor implements Visitor {
    private FileProcessor fileProcessor;
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Constructor
     *
     * @param fileProcessorIn Fileprocessor instance
     */
    public PopulateMyArrayVisitor(FileProcessor fileProcessorIn) {
        fileProcessor = fileProcessorIn;
        myLogger.writeMessage("Constructor for PopulateMyArray was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public void setFileName(String fileNameIn) {
        fileProcessor.close();
        fileProcessor = new FileProcessor(fileNameIn);
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Implements the Visitor Interface for populating the integers from the input file into the MyArray ADT.";
    }

    /**
     * Method to retrieve the values from file processor and populating them into the array.
     *
     * @param myArrayIn Array that needs to be populated.
     */
    @Override
    public void visit(MyArrayI myArrayIn) {
        String currentWord;
        int currentNumber;
        try {
           currentWord = fileProcessor.poll();
            while (currentWord != null) {
                if(!currentWord.matches("[0-9][0-9]")){
                    throw new IllegalArgumentException("Invalid input format in file" + fileProcessor.getFileName() + "!");
                }
                currentNumber = Integer.parseInt(currentWord);
                if (myArrayIn.insertElement(currentNumber))
                    currentWord = fileProcessor.poll();
            }
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            System.exit(0);
        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.exit(0);
        }
    }

    /**
     * Empty implementation for visit method with MyArrayListI type parameter.
     *
     * @param myArrayListIn
     */
    @Override
    public void visit(MyArrayListI myArrayListIn) {
        throw new UnsupportedOperationException("Undefined behavior");
    }
}
