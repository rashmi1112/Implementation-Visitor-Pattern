package arrayvisitors.adt;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Abstract DataType class that represents array.
 *
 * @author Rashmi Badadale
 */

public class MyArrayList implements MyArrayListI, Element, Cloneable, Iterator<Object> {

    private int size = 0;
    private int index = 0;
    private MyArrayI[] myArrayList = new MyArrayI[10];
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Empty constructor
     */
    public MyArrayList() {
        myLogger.writeMessage("Empty Constructor for MyArray was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Parametrized constructor
     *
     * @param sizeIn Initialization size of the array
     */
    public MyArrayList(int sizeIn) {
        this.myArrayList = new MyArrayI[sizeIn];
        myLogger.writeMessage("Parameterized Constructor for MyArrayList with size " + sizeIn + " was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Abstract data structure of ArrayList type and implementing an array of size" + size;
    }

    /**
     * Getter for array
     *
     * @return MyArrayI[] newly created array object
     */

    @Override
    public MyArrayI[] getMyArrayList() {
        MyArrayI[] tempList = new MyArrayI[getLength()];
        System.arraycopy(myArrayList, 0, tempList, 0, getLength());
        return tempList;
    }

    /**
     * Setter for the integer array
     *
     * @param myArrayListIn MyArray[] array to be set to
     */

    @Override
    public void setMyArrayList(MyArrayI[] myArrayListIn) {
        this.myArrayList = myArrayListIn;
    }

    /**
     * MyArrayListI interface method that inserts elements into the array
     *
     * @param myArrayIn element to be added
     * @return boolean true, if the element is added successfully
     */
    @Override
    public boolean addElement(MyArrayI myArrayIn) {
        if (myArrayList.length == size) {
            setMyArrayList(formNewArray());
        }
        myArrayList[size] = myArrayIn;
        size++;
        return true;
    }

    /**
     * Expansion of array when size is full
     *
     * @return MyArrayI[] New array with increased size
     */

    private MyArrayI[] formNewArray() {
        MyArrayI[] newArray = new MyArrayI[myArrayList.length + (myArrayList.length + myArrayList.length / 2)];
        System.arraycopy(myArrayList, 0, newArray, 0, myArrayList.length);
        setMyArrayList(newArray);
        return myArrayList;
    }

    /**
     * Get the size of the array
     *
     * @return size int size of the array
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * Overriding the clone method
     *
     * @return Object cloned object
     * @throws CloneNotSupportedException when the class does not implement cloneable
     */

    @Override
    public Object clone() throws CloneNotSupportedException {
        MyArrayList myArrayList = (MyArrayList) super.clone();
        myArrayList.myArrayList = new MyArrayI[size];
        System.arraycopy(this.myArrayList, 0, myArrayList.myArrayList, 0, getLength());
        return myArrayList;
    }

    /**
     * Getter for an element in the array
     *
     * @param indexIn Position from where the element needs to be retrieved.
     * @return MyArray element object
     */

    @Override
    public MyArrayI getElement(int indexIn) {
        return myArrayList[indexIn];
    }

    /**
     * MyArrayI interface method that removes elements from the array
     *
     * @param myArrayIn element to be added
     * @return boolean true, if successful
     */
    @Override
    public boolean removeElement(MyArrayI myArrayIn) {
        MyArrayI[] tempArray = new MyArrayI[size - 1];
        List<MyArrayI> tempList;
        tempList = Arrays.asList(tempArray);
        tempList.remove(myArrayIn);
        tempArray = (MyArrayI[]) tempList.toArray();
        setMyArrayList(tempArray);
        size--;
        return false;
    }

    /**
     * Method to accept any visitor
     *
     * @param visitorIn Visitor to visit
     */

    @Override
    public void accept(Visitor visitorIn) {
        visitorIn.visit(this);
    }

    /**
     * Method to determine if the given element is present in the ADT
     *
     * @param myArrayIn Element to be checked for
     * @return boolean true, if present
     */
    @Override
    public boolean contains(MyArrayI myArrayIn) {
        for (MyArrayI myArray : myArrayList) {
            return myArrayIn.equals(myArray);
        }
        return false;
    }

    /**
     * Method that determines if there are more elements in the iteration
     *
     * @return boolean True, if present
     */
    @Override
    public boolean hasNext() {
        return index <= getLength() && myArrayList[index] != null;
    }

    /**
     * Method to return the next element in the iterator
     *
     * @return Object next element
     */
    @Override
    public Object next() {

        MyArrayI myArray = myArrayList[index];
        index = index + 1;
        return myArray;
    }

    /**
     * Empty finalize method
     */
    public void finalize() {

    }
}
