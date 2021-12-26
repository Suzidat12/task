package com.app.task.utils;

import java.util.*;

public class TaskUtils {


    //abcda
    public static String getTask2(String str) {
        List<String> resultList = new LinkedList<>();
        for (String rs : str.split("")) {
            if (resultList.contains(rs)) {
                return rs;
            } else {
                resultList.add(rs);
            }
        }
        return null;
    }

    public static Integer[] getTask3(Integer arr[]) {
        Integer result[] = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }

            }
            result[i] = count;
        }
        return result;
    }
    public static Integer[] getTask4(int arr[]) {
        List<Integer> st = new ArrayList<>(); //Array list is been used to take care of the duplicate numbers

        for (int i = 0; i < arr.length; i++) {
            int num = (int) Math.pow(arr[i], 2);
            st.add(num);
        }
        Collections.sort(st); //use to sort method is use to sort the list of integers
        return st.stream().toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int load=1;
        for(int i=1; i<=load; i++){
            Calendar cl = Calendar.getInstance();
           cl.add(Calendar.DAY_OF_MONTH,2);
            System.out.println(cl.getTime());
        }
    }
}
