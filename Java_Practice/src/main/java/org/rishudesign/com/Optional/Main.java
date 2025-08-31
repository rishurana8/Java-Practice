package org.rishudesign.com.Optional;

import java.util.Optional;

public class Main {
    private static Optional<String> getName(int id){
        String name1 = null;
        String name2 = "rishu";
//        return Optional.of(name); //is  se yeh null value handle nahi krega
        return Optional.ofNullable(name2); // is se yeh pta chlega ki name ki value null bhi ho skti hai toh woh nullpointerexception nahi dega
    }

    public static void main(String args[]){
         Optional<String> name = getName(1);
         if(name.isPresent()){
             System.out.println(name.get().toUpperCase());
         }

         // ifPresent takes functional interface
         name.ifPresent(x -> System.out.println(x.toUpperCase()));
         // another way of writing if present is
        name.ifPresent(System.out::println);

        name.map(x -> x.toUpperCase());
    }
}
