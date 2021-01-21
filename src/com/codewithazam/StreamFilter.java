package com.codewithazam;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamFilter {

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> name = new ArrayList<>();
        name.add("Azam");
        name.add("Amin");
        name.add("Atoullo");
        name.add("Khuja");
        name.add("Nurullo");
        name.add("Saidafzal");

        //What we learnt from this section
        //1.There is no life for intermediate operation if there is no terminal operation
        //2.Terminal operation will execute only if intermediate operation (filter) returns true
        //3.We can create stream
        //4.How to use filter in Stream API

        long count = name.stream().filter(s -> s.startsWith("A")).count();
        System.out.println(count);

        long d = Stream.of("Azam", "Atoullo", "Khuja", "Amin", "Nurullo", "Said").filter(r -> r.startsWith("A")).count();
        System.out.println(d);

        //Print all the names of ArrayList
        //name.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        name.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

    }
}
