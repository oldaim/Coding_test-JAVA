package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
    Integer y;
    Integer x;
    Integer dis;
    public Pair(Integer y, Integer x, Integer dis) {
        this.y = y;
        this.x = x;
        this.dis = dis;
    }

    public Pair(Integer y, Integer x) {
        this.y = y;
        this.x = x;

    }
}

public class BOJ14502
{
    static int[][] laboratory = new int[9][9];
    static int widthMax = 0;
    static int heightMax = 0;
    static Queue<Pair> queue = new LinkedList<>();
    static boolean [][] visited = new boolean[9][9];

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        heightMax = Integer.parseInt(st.nextToken());
        widthMax = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= heightMax ; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= widthMax; j++){
             laboratory[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

    }

    static int findVirus(int[][] lab)
    {

        int total = 0;
        for (int i = 1; i <= heightMax ; i++) {
            for (int j = 1; j <= widthMax; j++) {
                if(!visited[i][j] && lab[i][j] == 2)
                {
                    Pair pair = new Pair(i,j);
                    visited[i][j] = true;
                    BFS(pair,lab);
                }
            }
        }

        for (int i = 1; i <= heightMax ; i++) {
            for (int j = 1; j <= widthMax ; j++) {
                if(lab[i][j] == 0) total++;
            }
        }

       for (int i = 1; i <=heightMax ; i++) {
            Arrays.fill(visited[i],false);
        }


        return total;
    }

    static void BFS(Pair virus,int[][] lab)
    {
        int[][] dx = {{-1,0},{1,0},{0,-1},{0,1}};
        queue.add(virus);
        while(!queue.isEmpty())
        {
            Pair location= queue.remove();
            for (int k = 0; k < 4; k++) {
              int newY = location.y + dx[k][0];
              int newX = location.x + dx[k][1];
              if(newY <= 0 || newX <= 0 || newY > heightMax || newX > widthMax) continue;
              if(visited[newY][newX] || lab[newY][newX] != 0) continue;

              visited[newY][newX] = true;
              lab[newY][newX] = 2;
              queue.add( new Pair(newY,newX) );


            }

        }





    }

    public static void main(String[] args) throws IOException {
        input();
        int safeMax = Integer.MIN_VALUE;
        int[][] copyOfLab = new int[9][9];

        for (int l = 1; l <= heightMax ; l++) {
            for (int m = 1; m <= widthMax ; m++) {
                copyOfLab[l][m] = laboratory[l][m];
            }
        }
        for (int i = 1; i <= heightMax; i++) {
            for (int j = 1; j <= widthMax; j++) {



                for (int k = 1; k <= heightMax; k++) {
                    for (int t = 1; t <= widthMax; t++) {



                        for (int a = 1; a <= heightMax; a++) {
                            for (int b = 1; b <=widthMax; b++) {
                                if((a == k && b == t) || (a == i && b == j) || ( k == i && t == j)) continue;
                                if (copyOfLab[a][b] == 0 && copyOfLab[k][t] == 0 && copyOfLab[i][j] == 0) {
                                    copyOfLab[i][j] = 1;
                                    copyOfLab[k][t] = 1;
                                    copyOfLab[a][b] = 1;

                                    safeMax = Math.max(safeMax,findVirus(copyOfLab));

                                    for (int l = 1; l <= heightMax ; l++) {
                                        for (int m = 1; m <= widthMax; m++) {
                                            copyOfLab[l][m] = laboratory[l][m];
                                        }
                                    }


                                }

                                //
                            }
                        }
                        //
                    }
                }
                //
            }
        }


        System.out.print(safeMax);
    }

}
