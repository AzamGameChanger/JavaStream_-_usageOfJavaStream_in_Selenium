package com.codewithazam;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        name.add("Kobil");
        name.add("Almal");
        name.add("Asad");
        name.add("Komil");
        name.add("Abdu");
        name.add("Karim");


        //Print names which have last letter as "a"  with Uppercase
        Stream.of("Azam", "Atoullo", "Khuja", "Amin", "Nurullo", "Said").
                filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

        System.out.println("_____________");

        //Print the names which have the first letter as "a" with uppercase and sorted
        List<String> names = Arrays.asList("Azam", "Atoullo", "Khuja", "Amin", "Nurullo", "Said");
        names.stream().filter(s -> s.startsWith("A")).sorted().map(s->s.toUpperCase()).
                forEach(s-> System.out.println(s));

        System.out.println("__________");

        //Concat 2 lists
        Stream<String> join = Stream.concat(name.stream(),names.stream());
        //join.sorted().forEach(s-> System.out.println(s));
        boolean azam = join.anyMatch(s->s.equalsIgnoreCase("Azam"));
        System.out.println(azam);
        Assert.assertTrue(true);

        System.out.println("______");

        //Getting a list and creating to a new list instead of modifying it.
        List<String> ls = Stream.of("Azam", "Atoullo", "Khuja", "Amin", "Nurullo", "Said").
                filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
        System.out.println(ls.get(0));
    }
}
