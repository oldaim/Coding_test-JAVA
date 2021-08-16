package com.company;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;


class Pair{
    Integer y;
    Integer x;
    Integer dis;
    public Pair(Integer y, Integer x, Integer dis) {
        this.y = y;
        this.x = x;
        this.dis = dis;
    }

}





public class BOJ2178{

    static int[][] safe = new int[101][101];
    static boolean[][] visit = new boolean[101][101];
    static int[][] d=  { {-1,0},{ 1,0 },{ 0,-1 },{ 0, 1} };




    public static void main(String[] args) throws IOException {

        BufferedReader br  =  new BufferedReader(new InputStreamReader(System.in));
        Queue<Pair> queue = new LinkedList<>();
        Pair tmp = new Pair(0,0 ,0);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++) {
                safe [i][j] = str.charAt(j) - '0';

            }
        }

        visit[0][0] = true;
        tmp.y = 0;
        tmp.x = 0;
        tmp.dis = 1;
        queue.add(tmp);

        while(!((tmp.y == n -1) && (tmp.x == m-1))) {
            tmp = queue.remove();
            for (int k = 0; k < 4; k++) // BFS
            {
                int col =tmp.y + d[k][0];
                int row =tmp.x + d[k][1];
                if(col < 0 || col >= n || row < 0 || row >= m) continue;
                else if(visit[col][row]||safe[col][row] != 1) continue;

                visit[col][row] = true;
                queue.add(new Pair(col, row ,tmp.dis +1));


            }


         }


        System.out.println(tmp.dis);
        queue.clear();



    }
}
