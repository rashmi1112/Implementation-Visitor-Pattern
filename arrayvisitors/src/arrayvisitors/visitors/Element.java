package arrayvisitors.visitors;

import java.io.IOException;

/**
 * Interface to be implemented by both the ADTs
 */
public interface Element {
    void accept(Visitor visitorIn);
}
