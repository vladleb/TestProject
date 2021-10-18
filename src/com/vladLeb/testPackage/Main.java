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

        ///////////////////////число в массив чисел////////////////////////////
        int num = 1234567;
        int[] digits = Integer.toString(num).chars().map(c -> c-'0').toArray();



        ///////////////////////////////////////////////////////////////////
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

        String hello = "Hello world man Vlad";
        String[] helloSplit = hello.split(" ");
//        List<String> gg = Arrays.stream(hello.split(" ")).collect(Collectors.toList());
//        String[] a = gg.toArray(new String[0]);
        System.out.println(Arrays.toString(helloSplit));
        System.out.println();

        String hello2 = "Hello, world. Hello, Vlad";
        String[] helloSplit2 = hello.split("(, | |\\. )");

        //////////////////////Поиск цифр в тексте///////////////////////////////

        String line = "2Th56is order was32354 placed 64for QT68 ! OK?";
        String regex = "[^\\d]+";

        String[] str2 = line.split(regex);
        if(str2[0].equals(""))
            System.arraycopy(str2, 1,  str2,0, str2.length - 1 );
        System.out.println(Arrays.toString(str2));

        int[] str2Int = Arrays.stream(str2).mapToInt(Integer::parseInt).toArray();

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

        ///Найти самый часто встречающийся символ в строке(без учета регистра)///

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



         /////////////////с учетом регистра////////////////////////////
//        String word = "hello my name is wombat";
//        int size = word.length();
//        int max = 0;
//        char maxChar = 'a';
//        for (char x = 'A'; x <= 'z'; x++) {
//            word = word.replace(String.valueOf(x), "");
//            int newSize = word.length();
//            if (size - newSize > max) {
//                maxChar = x;
//                max = size - newSize;
//            }
//            size = newSize;
//        }
//
//        System.out.println("maxchar is " + maxChar);


        String strScobe = new String("{[]}()");

        if(strScobe.equals("") || strScobe == null)
            System.out.println("hueta");

        Map<Character, Character> mapChar = new HashMap<>();
        mapChar.put(']', '[');
        mapChar.put(')', '(');
        mapChar.put('}', '{');

        Stack<Character> stackChar = new Stack<>();

        for(int i = 0; i < strScobe.length(); i++){
            char c = strScobe.charAt(i);
            if(stackChar.empty()){
                stackChar.push(c);
            }else {
                if (!mapChar.containsKey(c)){
                    stackChar.push(c);
                }else
                    if (stackChar.peek() != mapChar.get(c)) {
                        System.out.println("hueta");
                    }else {
                        stackChar.pop();
                    }


            }
        }


    }





}
