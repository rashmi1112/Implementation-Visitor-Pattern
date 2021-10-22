package arrayvisitors.adt;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.Element;
import arrayvisitors.visitors.Visitor;

import java.io.IOException;
import java.util.Iterator;

/**
 * Abstract DataType class that represents array.
 *
 * @author Rashmi Badadale
 */
public class MyArray implements MyArrayI, Element, Cloneable, Iterator<Object> {
    private int[] arrayOfIntegers = new int[10];
    private int size = 0;
    private int index = 0;
    private final MyLogger myLogger = MyLogger.getInstance();

    /**
     * Empty constructor
     */
    public MyArray() {
        myLogger.writeMessage("Empty Constructor for MyArray was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Parametrized constructor
     *
     * @param sizeIn Initialization size of the array
     */
    public MyArray(int sizeIn) {
        this.arrayOfIntegers = new int[sizeIn];
        myLogger.writeMessage("Parameterized Constructor for MyArray with size " + sizeIn + " was called.", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Overriding the toString() method
     *
     * @return String
     */
    public String toString() {
        return "Abstract data structure representing an array of size" + size;
    }

    /**
     * MyArrayI interface method that inserts elements into the array
     *
     * @param elementIn element to be added
     * @return boolean true, if the elemnt is added successfully
     */
    @Override
    public boolean insertElement(int elementIn) {
        if (size == arrayOfIntegers.length) {
            setArrayOfIntegers(formNewArray());
        }
        arrayOfIntegers[size] = elementIn;
        size++;
        return true;
    }

    /**
     * Getter for array
     *
     * @return int[] newly created array object
     */

    @Override
    public int[] getArrayOfIntegers() {
        int[] tempArray = new int[getLength()];
        System.arraycopy(arrayOfIntegers, 0, tempArray, 0, getLength());
        return tempArray;
    }

    /**
     * MyArrayI interface method that removes elements from the array
     *
     * @param elementIn element to be added
     * @return boolean true, if successful
     */
    @Override
    public boolean removeElement(int elementIn) {
        int[] tempArray = new int[size - 1];
        for (int i : arrayOfIntegers) {
            if (i != elementIn) {
                for (int j : tempArray)
                    tempArray[j] = arrayOfIntegers[i];
            }
        }
        setArrayOfIntegers(tempArray);
        size--;
        return true;
    }

    /**
     * Setter for the integer array
     *
     * @param arrayOfIntegersIn int[] array to be set to
     */
    @Override
    public void setArrayOfIntegers(int[] arrayOfIntegersIn) {
        this.arrayOfIntegers = arrayOfIntegersIn;
    }

    /**
     * Overriding the clone method
     *
     * @return Object cloned object
     * @throws CloneNotSupportedException when the class does not implement cloneable
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        MyArray myArray = (MyArray) super.clone();
        myArray.arrayOfIntegers = new int[size];
        System.arraycopy(arrayOfIntegers, 0, myArray.arrayOfIntegers, 0, getLength());
        return myArray;
    }

    /**
     * Getter for an element in the array
     *
     * @param indexIn Position from where the element needs to be retrieved.
     * @return MyArray element object
     */

    @Override
    public int getElement(int indexIn) {
        if(indexIn > size || index<0){ return -1;}
        return arrayOfIntegers[indexIn];
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
     * Expansion of array when size is full
     *
     * @return int[] New array with increased size
     */

    private int[] formNewArray() {
        int[] newArray = new int[arrayOfIntegers.length + (arrayOfIntegers.length + arrayOfIntegers.length / 2)];
        System.arraycopy(arrayOfIntegers, 0, newArray, 0, arrayOfIntegers.length);
        setArrayOfIntegers(newArray);
        return arrayOfIntegers;
    }

    /**
     * Empty finalize method
     */
    public void finalize() {

    }

    /**
     * Method to accept any visitor
     *
     * @param visitorIn Visitor to visit
     * @throws IOException when reading from input file
     */
    @Override
    public void accept(Visitor visitorIn){
        visitorIn.visit(this);
    }

    /**
     * Method that determines if there are more elements in the iteration
     *
     * @return boolean True, if present
     */
    @Override
    public boolean hasNext() {
        return index <= getLength();
    }

    /**
     * Method to return the next element in the iterator
     *
     * @return Object next element
     */

    @Override
    public Object next() {
        int variable = arrayOfIntegers[index];
        index = index + 1;
        return variable;
    }
}
