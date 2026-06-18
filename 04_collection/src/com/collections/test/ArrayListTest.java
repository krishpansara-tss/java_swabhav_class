package com.collections.test;

import com.bank.model.Account;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class ArrayListTest {
    public static void main(String[] args) {
//        List<Object> numbers = new ArrayList<>();
//
//        System.out.println(numbers);
//        numbers.add(10);
//        numbers.add(20);
////        numbers.
//        numbers.add(false);
//        numbers.add("GAJB");
//        numbers.add(new Thread());
//        System.out.println(numbers);
//        numbers.set(1, 55);
//        System.out.println(numbers);
//        System.out.println(numbers.contains(10 != 10));
//        System.out.println(numbers.indexOf(10 != 10));
//        numbers.remove(0);
////        System.out.println(numbers.containsAll());
//        System.out.println(numbers);

        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(new Account("Krish", 5000));
        accountList.add(new Account("Rushi", 500));
        accountList.add(new Account("Het", 55000));

        System.out.println(accountList);


        Collections.sort(accountList, new NameComparator());

        // After Sorting
        System.out.println("After Sorting:");
        System.out.println(accountList);

        Collections.sort(accountList, new BalanceComparator());
        System.out.println(accountList);

//        Collection.sort()


        HashMap<Integer, String> dymmySet = new HashMap<>();

        dymmySet.put(1, "lamo");
        dymmySet.put(2, "bamo");
        dymmySet.put(3, "kamo");
        System.out.println(dymmySet);


        for(Map.Entry<Integer, String> entry : dymmySet.entrySet()){
            System.out.println("_________________________");
            System.out.println("Entry:" +entry);

            System.out.println("Key:"+entry.getKey());
            System.out.println("Value:"+entry.getValue());
            System.out.println("Class:"+entry.getClass());
            System.out.println("Hashcode:"+entry.hashCode());
        }


        System.out.println();
        Set<Map.Entry<Integer, String>> entriesOfDummy1 = dymmySet.entrySet();
        Set<Map.Entry<Integer, String>> entriesOfDummy2 = dymmySet.entrySet();

        System.out.println(entriesOfDummy1);
        System.out.println(entriesOfDummy2);

        Object[] newObj = entriesOfDummy1.toArray();
//        entriesOfDummy.

        System.out.println(entriesOfDummy1);
        newObj[0] = "hei";
        System.out.println(newObj[0]);


//        entriesOfDummy1.

    }

}
