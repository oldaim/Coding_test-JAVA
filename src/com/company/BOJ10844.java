package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] dp = new int[200];
        dp[1] = 9;

        ///
        for(int i = 1; i <= num; i++){
            dp[i+1] = ((dp[i] * 2) - i);
        }
        ///
        System.out.println(dp[num]%1000000000);


    }
}
