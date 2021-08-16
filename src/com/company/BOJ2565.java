package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Maps{
    Integer first;
    Integer second;

    public Maps(Integer first , Integer second ){
        this.first = first;
        this.second = second;

    }

}




public class BOJ2565 {

    static int count = 0;
    static int cnt = 0;
    static Maps[] strings = new Maps[101];




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = Integer.parseInt(br.readLine());

        for(int i = 1; i <= count; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            strings[i] = new Maps(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }


        int max = 0;
        int index = 0;
        int cnt = 0;

        while(true)
        {
            int []dp = new int[101];
            for(int i = 1; i <= count; i++){
                for(int j = 1; j <= count; j++){
                    if(strings[i].first > strings[j].first && strings[i].second < strings[j].second ) dp[j]++;
                    if(strings[i].first < strings[j].first && strings[i].second > strings[j].second ) dp[j]++;
                }
            }

            for (int i = 1; i <= count; i++){
                if(max < dp[i])
                {
                    max = dp[i];
                    index = i;
                }
            }
            if(max == 0) break;
            /////
            cnt++;
            strings[index].first = -1;
            strings[index].second = -1;
            ///////

            max = 0;
            index = 0;

        }


        System.out.println(cnt);




    }
}
