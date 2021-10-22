package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

/**
 * Interface to be implemented by MyArray ADT
 */
public interface MyArrayI extends Element {
    boolean insertElement(int elementIn);

    int[] getArrayOfIntegers();

    boolean removeElement(int elementIn);

    void setArrayOfIntegers(int[] arrayOfIntegersIn);

    int getLength();

    int getElement(int indexIn);
}
