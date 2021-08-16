package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1003 {
    static int[] zero = new int[41];
    static int[] one = new int[41];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        /////
        int []test_case = new int[n];
        for(int i = 0; i < n; i++) test_case[i] = Integer.parseInt(br.readLine());
        ////
        zero[0] = 1;
        zero[1] = 0;
        zero[2] = 1;
        one[0] = 0;
        one[1] = 1;
        one[2] = 2;

        for(int i = 0; i < n; i++){
            if(test_case[i] >= 3){
            for(int j = 3; j <= test_case[i]; j++ ){
                zero[j] = zero[j - 1] + zero[j - 2];
                one[j] = zero[j - 1] + one[j - 1];
            }
            }
        }


        for(int i = 0; i < n; i++){
            System.out.println(zero[test_case[i]] + " " + one[test_case[i]]);
        }
        /////




    }

}
