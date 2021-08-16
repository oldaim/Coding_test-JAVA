package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Loc{
    Integer M;
    Integer N;
    Integer H;

    public Loc(Integer N, Integer M , Integer H) {
        this.N = N;
        this.M = M;
        this.H = H;
    }

}

public class BOJ7569 {
    static int M = 0 , N = 0 , H = 0;
    static int Day = 0;
    static int[][][] tomato = new int[101][101][101];
    static boolean [][][] visit = new boolean[101][101][101];
    static int[][] d=  {{-1,0,0},{1,0,0},{0,-1,0},{0,1,0},{0,0,1},{0,0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        Queue<Loc> queue = new LinkedList<>();
        StringTokenizer st  = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for(int i = 0; i < H; i++){
            for(int j = 0; j < N; j++){
                StringTokenizer x  = new StringTokenizer(br.readLine());
                for(int k = 0; k < M; k++) {
                    tomato[i][j][k] = Integer.parseInt(x.nextToken());

                }
            }
        }


        for(int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (visit[i][j][k] || tomato[i][j][k] == -1 || tomato[i][j][k] == 0) continue;
                    visit[i][j][k] = true;
                    Loc tmp = new Loc(j,k,i);
                    queue.add(tmp);
                    Day++;
                    while (!queue.isEmpty()) {
                        tmp = queue.remove();


                        for (int t = 0; t < 6; t++) // BFS
                        {
                            int hei = tmp.H + d[t][0]; //높이
                            int col = tmp.N + d[t][1]; //세로
                            int row = tmp.M + d[t][2]; //가로
                            if (col < 0 || col >= N || row < 0 || row >= M || hei < 0 || hei >= H) continue;
                            if ((visit[hei][col][row] || (tomato[hei][col][row] == -1) || (tomato[hei][col][row] == 1))) continue;
                            visit[hei][col][row] = true;
                            System.out.println(row+""+col+""+hei);
                            queue.add(new Loc(col, row, hei));



                        }
                        System.out.println();

                    }//BFS


                }
            }
        }
        System.out.println(Day);

    }

}
