package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the Visitor Missing Ints. Takes out missing integers from given array and stores them in
 * appropriate results instance.
 *
 * @author Rashmi Badadale
 */
public class MissingIntsVisitor implements Visitor {

    private final Results results;
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Constructor
     *
     * @param resultsIn Results Instance
     */
    public MissingIntsVisitor(Results resultsIn) {
        results = resultsIn;
        myLogger.writeMessage("Constructor for MissingIntsVisitor called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Implements the Visitor Interface for determining the missing integers between 00-99 from the respective input file.";
    }

    /**
     * Method to detect the missing Integers from given array between 00-99
     *
     * @param myArrayIn Array from which missing ints are to be printed
     */
    @Override
    public void visit(MyArrayI myArrayIn) {
        List<Integer> tempList = new ArrayList<>();
        int size = myArrayIn.getLength();
        myLogger.writeMessage("Array of size " + size + "retrieved for determining the missing integers.", MyLogger.DebugLevel.MISSING_INTS_VISITOR);
        int[] arrayOfIntegers = myArrayIn.getArrayOfIntegers();
        List<Integer> tempList1 = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            tempList.add(arrayOfIntegers[i]);
        }
        for (int i = 0; i < 100; i++) {
            tempList1.add(i);
        }
        tempList1.removeAll(tempList);
        for (int i : tempList1) {
            results.storeResults(String.format("%02d",i));
            myLogger.writeMessage("Missing Ints were stored in respective Results instance.", MyLogger.DebugLevel.OUTPUT_DATA_STORED);
        }
    }

    /**
     * Empty implementation for visit method with MyArrayListI type parameter.
     *
     * @param myArrayListIn
     */

    @Override
    public void visit(MyArrayListI myArrayListIn) {
        throw new UnsupportedOperationException("Undefined Behavior!");
    }
}
