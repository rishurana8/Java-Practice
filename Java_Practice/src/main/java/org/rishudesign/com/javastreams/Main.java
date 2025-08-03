package org.rishudesign.com.javastreams;

import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String []args){
        // withoug java streams
        List<Integer> salaryList = new ArrayList<>();
        int count = 0;
        salaryList.add(3000);
        salaryList.add(4000);
        salaryList.add(5600);

        for(Integer salary: salaryList){
            if(salary>3000){
                count++;
            }
        }
        System.out.println(count);


        // with java streams
        long output = salaryList.stream().filter((Integer sal) -> sal>3000).count();
        System.out.println(output);




    }



}
