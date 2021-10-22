# Implementation of Visitor Pattern

**Name:** Rashmi A.Badadale

-----------------------------------------------------------------------

Following are the commands and the instructions to run ANT on your project.


Note: build.xml is present in csx42-summer-2020-assign3-rashmi1112\arrayvisitors\src  folder.

## Instruction to clean:

```commandline
ant -buildfile arrayvisitors/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

## Instructions to compile:

```commandline
ant -buildfile arrayvisitors/src/build.xml all
```
The above command compiles your code and generates .class files inside the BUILD folder.

## Instructions to run:

```commandline
ant -buildfile arrayvisitors/src/build.xml run -Dinput1="input1.txt" -Dinput2="input2.txt" -Dout1="output1.txt" -Dout2="output2.txt" -Ddebug="(debug_value)"
```
Note: Arguments accept the absolute path of the files.

## Description:

The program takes 5 arguments, inputFile1, inputFile2, outputfile1,outputfile2 and debug value. The program parses the input for required strings and perform respective operations based on the 
parsed input. The goal of the assignment is to populate arrays from the input provided in the input files and then retrieves common integers from both arrays and store it in the first output file. 
Also, the missing integers from both the arrays between 00-99 are printed in the second output file.  

I use 2 Abstract Data types (MyArray and MyArrayList) that represent arrays and perform operations on the given populated array. The access time for an array is O(n) where n is the size of the array. 
The MyArrayList implements functions that can make the MyArrayList act as a list. 

There are 3 visitors PopulateMyArrayVisitor, CommonIntsVisitor and MissingIntsVisitor. The PopulateMyArrayVisitor takes the input from the file and populates it in both the arrays. 
The CommonIntsVisitor takes out the common integer between the 2 arrays sends to the Results instance. This visitor uses a set to store common integers because set stores only unique elements. 
The MissingIntsVisitor prints the missing integers from a given array between 00-99. It uses a list to store the numbers between 00-99 except for the ones in the provided array because it is 
easier to add/remove operation in a list. 

A String  builder is used to store the output result and then passed on to an output file through a buffered writer and also to the standard output console.  

