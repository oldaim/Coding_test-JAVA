package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ2667 {


    public static Boolean case2(String st, int index, String c)
    {
        if(st.substring(index - 1,index ).equals(c)) return false;

        for (int i = 0; i <= index/2; i++) {
            if(index  - 2 * i - 1 < 0) continue;
            System.out.print(" 앞 "+st.substring(index  - 2 * i - 1 , index  - i ));
            System.out.print(" 뒤 "+st.substring(index  - i, index + 1 ));
            System.out.println();
            if(st.substring(index  - 2 * i - 1 , index  - i ).equals(st.substring(index  - i, index + 1 ))) return false;

        }
         return true;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String goodArray = "1";
        String one = new String();
        String two = new String();
        String three = new String();
        int spare = 0;

        for (int i = 1; i < num; i++)
        {
           ArrayList<Integer> val = new ArrayList<>();

            one = goodArray + "1";
            two = goodArray + "2";
            three = goodArray + "3";

            if(case2(one, i  ,String.valueOf(1))) val.add(1);
            if(case2(two, i  ,String.valueOf(2))) val.add(2);
            if(case2(three, i  ,String.valueOf(3))) val.add(3);

            if(val.isEmpty()){
                goodArray = goodArray.substring(0,i - 1);
                goodArray += spare;

                one = goodArray + "1";
                two = goodArray + "2";
                three = goodArray + "3";

                if(case2(one, i  ,String.valueOf(1))) val.add(1);
                if(case2(two, i  ,String.valueOf(2))) val.add(2);
                if(case2(three, i  ,String.valueOf(3))) val.add(3);

                Collections.sort(val);
                goodArray += val.get(0);
                if(val.size() > 1)  spare = val.get(1);

            }
            else{
                Collections.sort(val);
                goodArray += val.get(0);
                if(val.size() > 1)  spare = val.get(1);
            }
            System.out.println(goodArray);
            System.out.println();
        }

    }
}
