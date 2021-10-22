package arrayvisitors.driver;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileDisplayInterface;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.util.MyLogger;
import arrayvisitors.util.Results;
import arrayvisitors.util.StdoutDisplayInterface;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;

import java.io.FileNotFoundException;
import java.io.IOException;


/**
 * @author Rashmi Badadale
 */
public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

    public static void main(String[] args) {
        try {
            if ((args.length != REQUIRED_NUMBER_OF_CMDLINE_ARGS) ||
                    (args[0].equals("${input1}")) ||
                    (args[1].equals("${input2}")) ||
                    (args[2].equals("${out1}")) ||
                    (args[3].equals("${out2}")) ||
                    (args[4].equals("${debug_value}"))) {

                throw new IllegalArgumentException("Error: Incorrect number of arguments. Program accepts " + REQUIRED_NUMBER_OF_CMDLINE_ARGS + " arguments.");
            }
            if (args[0].isEmpty() || args[1].isEmpty() || args[2].isEmpty() ||
                    args[3].isEmpty() || args[4].isEmpty()) {
                throw new IllegalArgumentException(" Provided Invalid arguments: Empty arguments");
            }
            if (Integer.parseInt(args[4]) < 0 || Integer.parseInt(args[4]) > 8) {
                throw new IllegalArgumentException("Debug value should be between 1 and 7.");
            }
            if (args[0].equals(args[1])) {
                throw new IllegalArgumentException("Both input files have the same path and name");
            }
            if (args[2].equals(args[3])) {
                throw new IllegalArgumentException("Both output files have the same path and name");
            }
            MyLogger myLogger = MyLogger.getInstance();
            myLogger.setDebugValue(Integer.parseInt(args[4]));
            Results results = new Results(args[2]);
            Results results1 = new Results(args[3]);
            FileDisplayInterface fileDisplayInterface = new Results();
            StdoutDisplayInterface stdoutDisplayInterface = new Results();
            fileDisplayInterface.populateList(results, results1);
            stdoutDisplayInterface.populateList(results, results1);

            Element element = new MyArray();
            Element element1 = new MyArray();
            Element myArrayList = new MyArrayList();

            FileProcessor fileProcessor = new FileProcessor(args[0]);

            Visitor populateMyArrayVisitor = new PopulateMyArrayVisitor(fileProcessor);
            Visitor commonIntsVisitor = new CommonIntsVisitor(results);
            Visitor missingIntsVisitor = new MissingIntsVisitor(results1);

            element.accept(populateMyArrayVisitor);
            ((PopulateMyArrayVisitor) populateMyArrayVisitor).setFileName(args[1]);
            myLogger.writeMessage("Contents of Input file " + args[0] + " were read and populated" +
                    "into MyArray1.\n", MyLogger.DebugLevel.FILE_PROCESSOR);
            myLogger.writeMessage("Contents of Input file " + args[0] + " populated into MyArray1.", MyLogger.DebugLevel.POPULATE_MY_ARRAY);
            element1.accept(populateMyArrayVisitor);
            myLogger.writeMessage("Contents of Input file " + args[1] + " were read." +
                    "\n", MyLogger.DebugLevel.FILE_PROCESSOR);
            myLogger.writeMessage("Contents of Input file " + args[1] + " populated into MyArray2.", MyLogger.DebugLevel.POPULATE_MY_ARRAY);
            ((MyArrayListI) myArrayList).addElement((MyArrayI) element);
            ((MyArrayListI) myArrayList).addElement((MyArrayI) element1);
            myArrayList.accept(commonIntsVisitor);
            results1.storeResults("InputFile1:\n");
            element.accept(missingIntsVisitor);
            missingIntsVisitor = new MissingIntsVisitor(results1);
            results1.storeResults("\nInputFile2:\n");
            element1.accept(missingIntsVisitor);
            myLogger.writeMessage("The contents stored in the Results data structure of Common Integers from file "
                    + args[0] + " and " + args[1] + " were printed to the output file and the standard output" +
                    args[2], MyLogger.DebugLevel.RESULTS);
            fileDisplayInterface.writeToFile();
            stdoutDisplayInterface.writeToStdout();
            myLogger.writeMessage("The contents stored in the Results data structure of Missing Integers from file " + args[0] +
                    " and " + args[1] + " were printed to the output file and the standard output.", MyLogger.DebugLevel.RESULTS);
            fileProcessor.close();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
            System.exit(0);
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            System.exit(0);
        } catch (SecurityException | IOException securityException) {
            securityException.printStackTrace();
            System.exit(0);
        }catch (UnsupportedOperationException unsupportedOperationException){
            unsupportedOperationException.printStackTrace();
            System.exit(0);
        }
    }
}
