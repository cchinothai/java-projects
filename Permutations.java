package com.cody.main;
import java.util.Scanner;
import java.util.ArrayList;

public class Permutations {

    // TODO: Write method to create and output all permutations of the list of names.
    public static void allPermutations(ArrayList<String> permList, ArrayList<String> nameList) {
        if(nameList.size() == 0 )
        {
            for(int i = 0; i< permList.size(); i++)
            {
                System.out.print(permList.get(i)+" ");
            }
            System.out.println();
        }
        else
        {
            for(int i = 0; i<nameList.size();i++)
            {
                ArrayList<String> sortPerm = new ArrayList<String>(permList);
                sortPerm.add(nameList.get(i)); //First word


                ArrayList<String> newNameList = new ArrayList<String>(nameList);
                newNameList.remove(i);
                allPermutations(sortPerm,newNameList);


            }
        }

        //nameList ex) A, B, C
        //             A, C, B
        //             B, A, C
        //             B, C, A




    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> permList = new ArrayList<String>();
        String name;


        // TODO: Read in a list of names; stop when -1 is read. Then call recursive method.
        name = scnr.nextLine();
        String names[] = name.split(" ");
        for (int i = 0; i < names.length; i++) {
            name = names[i];
            if (!names[i].equals("-1")) {
                nameList.add(name);
            }
        }
        allPermutations(permList,nameList);
    }
}
