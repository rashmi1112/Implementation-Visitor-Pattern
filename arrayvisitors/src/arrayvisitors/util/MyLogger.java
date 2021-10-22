package arrayvisitors.util;

/**
 * Logger to set the debug level and print the debug messages.
 *
 * @author Rashmi Badadale
 */
public class MyLogger {

    private MyLogger() {

    }

    public static MyLogger myLogger;

    /**
     * Enum to store various level for debugging.
     */
    public enum DebugLevel {
        CONSTRUCTOR,
        FILE_PROCESSOR,
        MISSING_INTS_VISITOR,
        POPULATE_MY_ARRAY,
        COMMON_INTS_VISITOR,
        OUTPUT_DATA_STORED,
        RESULTS,
        NONE
    }

    public static MyLogger getInstance() {
        if (myLogger == null) {
            myLogger = new MyLogger();
        }
        return myLogger;
    }

    private DebugLevel debugLevel;

    /**
     * Method to set the debug level
     *
     * @param levelIn int debug level value from the command line
     */
    public void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 7:
                debugLevel = DebugLevel.RESULTS;
                break;
            case 6:
                debugLevel = DebugLevel.OUTPUT_DATA_STORED;
                break;
            case 5:
                debugLevel = DebugLevel.COMMON_INTS_VISITOR;
                break;
            case 4:
                debugLevel = DebugLevel.POPULATE_MY_ARRAY;
                break;
            case 3:
                debugLevel = DebugLevel.MISSING_INTS_VISITOR;
                break;
            case 2:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;
            case 1:
                debugLevel = DebugLevel.FILE_PROCESSOR;
                break;
            default:
                debugLevel = DebugLevel.NONE;
                break;
        }
    }


    /**
     * Method to print the debug message on the std output.
     *
     * @param message String debug message
     * @param levelIn int debug level
     */
    public void writeMessage(String message,
                             DebugLevel levelIn) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }

    /**
     * Overriding toString method
     *
     * @return String
     */

    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }

}
