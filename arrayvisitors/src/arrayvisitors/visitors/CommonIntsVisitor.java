package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;

import java.util.HashSet;
import java.util.Set;

/**
 * Class that implements the Visitor Common Ints. Takes out common integers from 2 inout files and stores them in
 * appropriate results instance.
 *
 * @author Rashmi Badadale
 */
public class CommonIntsVisitor implements Visitor {

    private final Results results;
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Constructor
     *
     * @param resultsIn Results instance
     */
    public CommonIntsVisitor(Results resultsIn) {
        myLogger.writeMessage("Constructor for CommonIntsVisitor was called.", MyLogger.DebugLevel.CONSTRUCTOR);
        results = resultsIn;
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Implements the Visitor Interface for determining the common integers between the 2 input files.";
    }


    /**
     * Empty implementation for visit method with MyArrayI type parameter.
     *
     * @param myArrayIn
     */
    @Override
    public void visit(MyArrayI myArrayIn) {
        throw new UnsupportedOperationException("Undefined behavior!");
    }

    /**
     * Method that determines the common integers from both input files and stores in results instance
     *
     * @param myArrayListIn List containing the arrays populated from both files
     */
    @Override
    public void visit(MyArrayListI myArrayListIn) {
        MyArrayI MyArray1, MyArray2;
        int[] array1, array2;
        Set<Integer> tempSet = new HashSet<>();
        MyArray1 = (myArrayListIn.getElement(0));
        array1 = MyArray1.getArrayOfIntegers();
        myLogger.writeMessage("An array with size" + MyArray1.getLength() + "was extracted from MyArrayList",
                MyLogger.DebugLevel.COMMON_INTS_VISITOR);
        MyArray2 = (myArrayListIn.getElement(1));
        array2 = MyArray2.getArrayOfIntegers();
        myLogger.writeMessage("An array with size" + MyArray2.getLength() + "was extracted from MyArrayList",
                MyLogger.DebugLevel.COMMON_INTS_VISITOR);

        for (int i = 0; i < MyArray1.getLength(); i++) {
            for (int j = 0; j < MyArray2.getLength(); j++) {
                if (array1[i] == array2[j] && !tempSet.contains(array1[i])) {
                    tempSet.add(array1[i]);
                    results.storeResults(String.format("%02d",array1[i]));
                }
            }
        }
        myLogger.writeMessage("Common Integers from both input files were stored in the Results Instance", MyLogger.DebugLevel.OUTPUT_DATA_STORED);
    }
}
