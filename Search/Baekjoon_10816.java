package Search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Baekjoon_10816
 */
public class Baekjoon_10816 {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] nArray = new int[n];

        String[] nStringArray = br.readLine().split(" ");

        for(int i = 0; i < nStringArray.length; i++) {
            nArray[i] = Integer.parseInt(nStringArray[i]);
        }

        Arrays.sort(nArray);

        int m = Integer.parseInt(br.readLine());

        int[] mArray = new int[m];

        String[] mStringArray = br.readLine().split(" ");

        for(int i = 0 ; i < mStringArray.length; i++) {
            mArray[i] = Integer.parseInt(mStringArray[i]);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            int result = findEndIndex(nArray, mArray[i]) - findStartIndex(nArray, mArray[i]);
            sb.append(result).append(" ");
        }

        System.out.println(sb);


    }

    public static int findStartIndex(int[] array , int key) {

        int pl = 0;
        int pr = array.length ;

        while(pl < pr) {

            int pc = (pl + pr) / 2;

            if(key <= array[pc]){
                pr = pc;
            }else{
                pl = pc + 1;
            }
       }
       return pl;
    } 

    public static int findEndIndex(int[] array , int key) {

        int pl = 0;
        int pr = array.length;

        while(pl < pr) {

            int pc = (pl + pr) / 2;

            if(array[pc] > key) {
                pr = pc;
            }else {
                pl = pc + 1;
            }
       }
       return pl;
    }
}