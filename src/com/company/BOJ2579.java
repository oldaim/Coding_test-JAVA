package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count  = Integer.parseInt(br.readLine());

        int[] stairs = new int[301];
        int[] dp = new int[301];

        for(int i = 0; i < count; i++) stairs[i] = Integer.parseInt(br.readLine());

        for(int i=3;i< count;i++) {
            dp[i] = Math.max(dp[i-2] + stairs[i], dp[i-3] + stairs[i] + stairs[i-1]);
        }

        System.out.println(dp[count-1]);

    }
}
