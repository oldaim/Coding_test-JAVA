package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2458 {
    public static int stdCount;
    public static int[][] distance;
    public static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        stdCount = Integer.parseInt(st2.nextToken());

        int Count = Integer.parseInt(st2.nextToken());

        distance = new int[stdCount+1][stdCount+1];

        for(int i=1; i <= stdCount; i++) {
            for(int j=1; j <= stdCount; j++) {
                if(i == j) continue;
                distance[i][j] = INF;
            }
        }

        while(Count-- > 0) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            distance[start][end] = Math.min(distance[start][end], 1);
        }

        floydWarshall();
        int cnt_col = 0;
        int cnt_row = 0;
        int cnt = 0;
        for(int i=1; i <= stdCount; i++) {
            for(int j=1; j <= stdCount; j++) {
                if(distance[i][j] != INF) cnt_row++;
                if(distance[j][i] != INF) cnt_col++;
            }


            if((cnt_col + cnt_row) == stdCount + 1) cnt++;
            cnt_row = 0;
            cnt_col = 0;

        }
        System.out.println(cnt);


    }

    public static void floydWarshall() {
        // 기준이 되는 거쳐가는 노드 K
        for(int k = 1; k <= stdCount; k++) {
            // 출발하는 노드 i
            for(int i=1; i <= stdCount; i++) {
                // 도착하는 노드 j
                for(int j=1; j <= stdCount; j++) {
                    //i에서 k를 거쳤다가 k에서 j 까지 가는 거리와 i에서 j 까지 가는 거리를 비교해서 작은 값이 최소거리이다.
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }


}
