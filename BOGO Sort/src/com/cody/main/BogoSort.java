/**
 * Program: Bogo Sort
 * Uses file I/O to read from a file containing a random seed and an unsorted list of numbers. File elements are
 * inserted into an ArrayList that repeatedly swaps elements using the random seed until the list is sorted. Checked
 * exceptions related to file I/O are accounted for.
 * CS108-3
 * @author Cody Chinothai
 */
package com.cody.main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
public class BogoSort {
    public ArrayList<Integer> input = new ArrayList<Integer>();
    public long randomSeed;
    public int noOfRuns;

    public BogoSort(String file)
    {
        readFromFile(file);
        printList();
        sort();
        printList();
    }
    //accept fileName to be opened to get in randomSeed and the list of integers to sort
    //add numbers into arraylist with correct format
    private void readFromFile(String file)
    {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);

            Double val = Double.parseDouble(s.nextLine());

            randomSeed = val.longValue();
            System.out.println(randomSeed);

            String list = s.nextLine();
            System.out.println(list);

            String[] array = list.split(",");
            for(String str : array)
            {
                input.add(Integer.parseInt(str));
            }
            
        }
        catch (Exception e)
        {
            if(file == null)
            {
                System.out.println("File does not exist!");
                System.exit(0);
            }
            else
                System.out.println("Error reading from file!");
                System.exit(0);
        }




    }
    //bogo sort
    private void sort() {
        boolean sorted = false;

        Random rand = new Random(randomSeed);
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.size() - 1; i++) {
                if (input.get(i + 1) < input.get(i)) {
                    sorted = false;
                    }
                }

            if(sorted) {
                break;
            }
            //**loop from 0 to n exclusive**
            for (int t = 0; t < input.size(); t++) {
                //1 2 3 4 5
                int randInt = rand.nextInt((input.size())); //int between 1 and n
                //swap element at i with index generated from random seed
                int holder = input.get(t);
                input.set(t, input.get(randInt));
                input.set(randInt, holder);
            }

            noOfRuns++;
        }
    }
    //print list separated in commas
    private void printList()
    {
        System.out.println("Sorted List in "+noOfRuns+" attempt(s):");
        for(int i = 0; i<input.size()-1;i++)
        {
            System.out.print(input.get(i));
            System.out.print(",");
        }

        System.out.println(input.get(input.size()-1));
    }

}
