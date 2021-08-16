package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9461 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i = 6; i < 101 ; i++) dp[i] = dp[i-1] + dp[i-5];

        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++) {
            int test_case = Integer.parseInt(br.readLine());
            System.out.println(dp[test_case]);
        }



    }
}
