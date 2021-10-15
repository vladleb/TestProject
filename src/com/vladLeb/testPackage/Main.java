package com.vladLeb.testPackage;

import com.sun.source.tree.Tree;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Vladislav Lebedev
 * @version 1.1
 * @since 1.0
 * This is my Main class. Here i will write some <strong>code</strong>
 */
public class Main
{


    public static void main (String [] args)
    {
        StringJoiner joiner = new StringJoiner(".", "prefix-", "-suffix");
        for (String s : "Hello the brave world".split(" ")) {
            joiner.add(s);
        }
        System.out.println(joiner); //prefix-Hello.the.brave.world-suffix\

        ////////////Проверка массива на уникальность значений//////////////

        int [] test = {1 ,2, 3, 4, 5, 6, 1};
        Set<Integer> testSet = new HashSet<>(
                Arrays.stream(test).boxed().collect(Collectors.toList()));
//        for(int i = 0; i < test.length; i++)
//            testSet.add(test[i]);

        System.out.println(test.length);
        System.out.println(testSet.size());

        System.out.println(test.length == testSet.size());

        //////////////Получить массив элементов из строки//////////////////

        String hello = "Hello world man vlad";
        String[] helloSplit = hello.split(" ");
//        List<String> gg = Arrays.stream(hello.split(" ")).collect(Collectors.toList());
//        String[] a = gg.toArray(new String[0]);
        System.out.println(Arrays.toString(helloSplit));
        System.out.println();

        ///////////////////////Отсортировать Map///////////////////////////

        Map<String, Integer> map = Map.of(
                "Two", 2,
                "Three", 3,
                "Five", 5,
                "One", 1,
                "Four", 4
        );

        map.entrySet().
                stream().
                sorted(Map.Entry.comparingByValue()).
                ////sorted(Map.Entry.comparingByKey()).
                forEach(System.out::println);

        ////////////////////////Отсортировать List////////////////////////////

        List<Integer> testList = List.of(1,3,2,4,7,6,5);

        testList.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).forEach(System.out::println);

        ///////////////////////Поиск вхождения подстроки//////////////////////

        String str = "Hello world";
        int index = str.indexOf("world");
        String res = str.substring(index, index + "world".length()); // .67
        System.out.println(res);

        /////////////////////////////////////////////////////////////////////

        String textString = "abcdirghoeirghoeughoetuihabcdijgoijg";
        String abcd = "abcd";

        //System.out.println(Arrays.toString());


    }


}
