package com.cody.main;
/**
 * Program 6: GenMethods
 * create methods concerning the manipulation of arrays and arraylists that are able to use generic types.
 * Methods will remove duplicate values, shuffle values, and find the max value within the certain array/arraylist
 *CS108-3
 * 11/19/2020
 * @author Cody Chinothai
 */

import java.util.*;
import java.util.LinkedList;
public class GenMethods {
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list)
    {
        ArrayList<E> newList = new ArrayList<>();
        for(E element : list)
        {
            if(!newList.contains(element))
            newList.add(element);
        }
        return newList;
    }
    public static <E> void shuffle(ArrayList<E> list)
    {
        int count = 0;
        Random randa = new Random(340L);
        while(count < 30) {

            int a = randa.nextInt(list.size());
            int b = randa.nextInt(list.size());

                //swap a and b
                E holder = list.get(a);
                list.set(a, list.get(b));
                list.set(b, holder);
                count++;

            }



        }

    public static <E extends Comparable<E>> E max(ArrayList<E> list)
    {
        E max = list.get(0);
        for(int i = 0; i<list.size();i++)
        {
            if(list.get(i).compareTo(max)>0)
            {
                max = list.get(i);
            }
        }
        return max;
    }
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key)
    {
        int index = -1;
        for(int i = 0; i<list.length;i++)
        {
            if(list[i].compareTo(key) == 0)
            {
                index = i;
                break;
            }
        }
        return index;
    }
    public static <E extends Comparable<E>> E max(E[] list)
    {
        E maximum = list[0];
        for(E element : list)
        {
            if(element.compareTo(maximum) > 0)
            maximum = element;
        }
        return maximum;
    }
    public static <E extends Comparable<E>> E max(E[][] list)
    {
        E max = list[0][0];
        for(int r = 0; r < list.length; r++)
        {
            for(int c = 0 ; c < list[0].length; c++)
            {
                if(list[r][c].compareTo(max) > 0)
                {
                    max = list[r][c];
                }
            }
        }
        return max;
    }

    public static <E> void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Integer[] list = new Integer[n]; //Must be Integer[] and not int[] --> can't store primitives in generic types
        LinkedList<Integer> linked = new LinkedList<Integer>();
        for(int i = 0; i<n;i++)
        {
            list[i] = scan.nextInt();
            linked.add(list[i]);
        }

        System.out.println(Arrays.toString(list));
        System.out.println(linked);

        int keyInt = scan.nextInt();
        int val = linearSearch(list,keyInt);

        if(val == -1)
        {
            System.out.println("Key "+keyInt+" was not found");
        }
        else
        {
            System.out.println("Key "+keyInt+" was found at position"+val);
        }


        System.out.println(max(list)+" is the max element");

        int m = scan.nextInt();
        int p = scan.nextInt();
        Integer[][] list2 = new Integer[m][p]; //Must be Integer[][], not int[]], can't store primitives in generic types
        for(int r = 0; r < m; r++)
        {
            for(int c = 0; c < p;c++)
            {
                int in = scan.nextInt();
                list2[r][c] = in;
            }
        }

        //print list2
        for(int r = 0; r < m ; r++)
        {
            for(int c = 0; c< p; c++)
            {
                System.out.print(list2[r][c]+" ");
            }
            System.out.println();
        }

        System.out.println(max(list2)+" is the max element");

        ArrayList<Integer> alist = new ArrayList<Integer>(linked);
        System.out.println(alist);
        ArrayList<Integer> distinct = removeDuplicates(alist);
        System.out.println(distinct);

        shuffle(distinct);
        System.out.println(distinct);
        System.out.println(max(distinct)+" is the max element");

    }

    public String getIdentificationString()
    {
        return "Program 6, Cody Chinothai";
    }

}
