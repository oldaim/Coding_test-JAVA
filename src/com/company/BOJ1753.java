package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//////////////////////

public class BOJ1753 {
    static int V , E , start  ,min_index=-1;
    boolean[] visited = new boolean[V];
    int[] distance = new int[V];



    public static void main(String[] args) throws IOException {
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        //V(정점) E(간선) 입력
        StringTokenizer st1  = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st1.nextToken());
        //시작점
        int[][] vertex = new int[V][V];

        //정점이 모인 배열인스턴스 생성
        for(int i = 0; i < E ; i++){
            StringTokenizer st2  = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st2.nextToken()); // 시점
            int v = Integer.parseInt(st2.nextToken()); // 종점
            int w = Integer.parseInt(st2.nextToken()); // 무게
            //////
            vertex[u][v] = w;

        }
        for(int i = 0; i < V; i++){
            for(int j =0; j < V; j++)
            {
                if(vertex[i][j] == 0) vertex[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < V; i++){

        }
        // 그래프 생성

    }
}
