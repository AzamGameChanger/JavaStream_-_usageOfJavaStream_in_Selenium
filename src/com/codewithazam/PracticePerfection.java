package com.codewithazam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticePerfection {
    public static void main(String[] args) {

        //Starting from 1 increase by 1 and filter number if divides by 3 print six of them
        Stream.iterate(1,count->count+1).filter(number->number%3==0).limit(6).forEach(s-> System.out.println(s));

        System.out.println("______");

        //
        Stream<Integer> ls = Stream.iterate(1, count-> count+1);
        List<Integer> newLs = ls.limit(6).collect(Collectors.toList());
        System.out.println(newLs);

        System.out.println("_______");

        List<String> alphabets = Arrays.asList("A","B","C"); //first list
        List<String> names = Arrays.asList("Azam","Amin","Atoullo"); //second list
        Stream<String> join = Stream.concat(alphabets.stream(),names.stream()); //joined f+s lists
        List<String> newList = join.collect(Collectors.toList()); //created a new list joining f+s lists
        newList.forEach(s-> System.out.print(s+",")); //printed them

        List<String> alp = Arrays.asList("Ali","Kamil","Zabil","Kabir","Abduali","Makhsumkhuja");
        Stream<String> newAlp = alp.stream();
        newAlp.filter(s->s.length()>3).limit(3).sorted().forEach(System.out::println);
    }
}
