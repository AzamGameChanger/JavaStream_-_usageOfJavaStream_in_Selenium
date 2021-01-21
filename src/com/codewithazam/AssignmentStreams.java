package com.codewithazam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AssignmentStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3,2,2,7,5,1,9,7);
        numbers.stream().distinct().forEach(s-> System.out.println(s));
        System.out.println("________");
        List<Integer> list = numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(list.get(2));
    }
}
