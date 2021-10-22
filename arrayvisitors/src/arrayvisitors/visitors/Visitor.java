package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;

import java.io.IOException;

/**
 * Interface to be implemented by the classes acting as visitors.
 */
public interface Visitor {
    void visit(MyArrayI myArrayIn);

    void visit(MyArrayListI myArrayListIn);
}
