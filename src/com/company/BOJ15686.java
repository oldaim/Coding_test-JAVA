package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Chicken implements Comparable<Chicken>
{
    Integer y;
    Integer x;
    Integer dis;

    @Override
    public int compareTo(Chicken c)
    {
     if(this.dis > c.dis) return 1;
     else if(this.dis < c.dis) return -1;
     else return 0;
    }

    public Chicken(Integer x, Integer y ,Integer dis)
    {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }

}

public class BOJ15686 {
    public static int distance(int x , int y , int x_chicken , int y_chicken)
    {
        return Math.abs(x_chicken - x) + Math.abs(y_chicken - y);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Chicken> chicken = new ArrayList<>();
        int[][] location = new int[51][51];
        int[][] choice = new int[51][51];

        for(int i = 1; i <= N; i++)
        {
            StringTokenizer st2  = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++)
              {
                location[i][j] = Integer.parseInt(st2.nextToken());
                if(location[i][j] == 2)
                {
                    Chicken store = new Chicken( i, j ,0);
                    chicken.add(store);
                }
            }
        }



        for(int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
             if(location[i][j] == 1)
             {
                 for (int k = 0; k < chicken.size(); k++)
                 {
                   chicken.get(k).dis += distance( i , j ,chicken.get(k).x , chicken.get(k).y);

                 }

             }
            }
        }

        Collections.sort(chicken);

        int total = 0;
        int dis = Integer.MAX_VALUE;
        for(int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if(location[i][j] == 1)
                {
                    for (int k = 0; k < M; k++)
                    {
                        dis = Math.min(distance( i , j ,chicken.get(k).x , chicken.get(k).y), dis);


                    }
                    choice[i][j] = dis;
                    dis = Integer.MAX_VALUE;
                }
            }
        }


        for(int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                total += choice[i][j];
            }
        }

        System.out.println(total);


    }
}
