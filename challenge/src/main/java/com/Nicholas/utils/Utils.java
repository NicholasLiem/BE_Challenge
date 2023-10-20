package com.Nicholas.utils;

import com.Nicholas.datastructures.Person;

import java.util.List;

public class Utils {
    public static String[] sanitizeInput(String input){
        input = input.trim();
        String command;
        String[] arguments;
        String[] parts = input.split(" ", 2);
        command = parts[0];

        if (parts.length > 1) {
            arguments = parts[1].split(" ");
        } else {
            arguments = new String[0];
        }

        String[] result = new String[arguments.length + 1];
        result[0] = command;
        System.arraycopy(arguments, 0, result, 1, arguments.length);
        return result;
    }

    public static <T extends Person> void printList(List<T> list) {
        if (!list.isEmpty()){
            for (T item : list) {
                System.out.print(item.getName() + " ");
            }
            System.out.println();
        } else {
            System.out.println("PERSON_NOT_FOUND");
        }
    }
}
