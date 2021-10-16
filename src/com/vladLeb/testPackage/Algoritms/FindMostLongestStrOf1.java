package com.vladLeb.testPackage.Algoritms;

import java.util.Map;
import java.util.TreeMap;

public class FindMostLongestStrOf1 {

    public static void main(String[] args) {

        int[] mas = {0, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1};

        System.out.println(finder(mas));

    }
    public static int finder(int[] mas){
        int maxValue = 0;
        int curr_size = 0;

        for (int i = 0; i < mas.length; i++){

            if(mas[i] == (1)){
                if(curr_size > 0){
                    int temp = func(mas, i, curr_size);

                    if(temp > maxValue){
                        maxValue = temp;
                    }
                    curr_size = temp - curr_size;
                    i += curr_size;
                }else
                {
                    curr_size = func(mas, i, 0);
                    i += curr_size;

                    if(curr_size > maxValue){
                        maxValue = curr_size;
                    }

                }
            }else
            {
                if(curr_size > 0){
                    curr_size = 0;
                }
            }
        }

        return maxValue;
    }


    public static int func(int[] mas, int index, int curr_size){
        int size = 0;

        while(index < mas.length){
            if(mas[index] == 1){
                size++;
                index++;
            }else {
                break;
            }
        }

        if(curr_size == 0){
            return size;
        }

        return curr_size + size;
    }
}
