package arrayvisitors.adt;

import arrayvisitors.visitors.Element;

/**
 * Interface to be implemented by MyArrayList ADT
 */
public interface MyArrayListI extends Element {
    MyArrayI[] getMyArrayList();

    void setMyArrayList(MyArrayI[] myArrayListIn);

    boolean addElement(MyArrayI myArrayIn);

    MyArrayI getElement(int indexIn);

    boolean removeElement(MyArrayI myArrayIn);

    boolean contains(MyArrayI myArrayIn);

    int getLength();
}
