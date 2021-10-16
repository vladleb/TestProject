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
        System.out.println(Arrays.stream(test).distinct().boxed().collect(Collectors.toList()).size());

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

        ///////////Найти самый часто встречающийся символ в строке///////////

        String input = "Hellooo";
        input = input.toLowerCase();
        int max = 0;
        int diff;
        char maxChar = '\0'; // in case it's an empty string, ignore if you don't understand
        for(char c = 'a'; c <= 'z'; c++) {
            diff = input.length() - input.replace("" + c, "").length();
            if(diff > max) {
                maxChar = c;
                max = diff;
            }
        }
        System.out.println("MaxChar = " + maxChar);


        String text =   "aabaabaaaaabaabaabaabbaaab";
        String sample = "aabaabc";

        System.out.println(Arrays.toString(searchNaive(text, sample).toArray()));
        System.out.println(Arrays.toString(prefixFunction(sample)));
        System.out.println(Arrays.toString(KMPSearch(text, sample).toArray()));

    }

    static ArrayList<Integer> searchNaive(String text, String sample) {
        ArrayList<Integer> foundPositions = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            int j = 0;
            while (j < sample.length() && i + j < text.length() && sample.charAt(j) == text.charAt(i + j)) {
                j++;
            }
            if (j == sample.length()) {
                foundPositions.add(i);
            }
        }
        return foundPositions;
    }

    static int[] prefixFunction(String sample) {
        int [] values = new int[sample.length()];
        for (int i = 1; i < sample.length(); i++) {
            int j = 0;
            while (i + j < sample.length() && sample.charAt(j) == sample.charAt(i + j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }
        return values;
    }

    public static ArrayList<Integer> KMPSearch(String text, String sample) {
        ArrayList<Integer> found = new ArrayList<>();

        int[] prefixFunc = prefixFunction(sample);

        int i = 0;
        int j = 0;

        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == sample.length()) {
                found.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && sample.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return found;
    }


}
