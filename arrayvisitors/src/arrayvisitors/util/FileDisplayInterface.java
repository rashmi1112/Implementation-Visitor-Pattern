package arrayvisitors.util;

import java.io.IOException;

/**
 * Interface containing the method to be implemented by Results
 */
public interface FileDisplayInterface {
    void writeToFile() throws IOException;

    void populateList(Results results1In, Results results2In);
}
