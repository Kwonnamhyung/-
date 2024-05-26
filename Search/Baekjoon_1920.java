package Search;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Baekjoon_1920
 */
public class Baekjoon_1920 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nArray = new int[n];

        for(int i = 0; i < n; i++) {
            nArray[i] = scanner.nextInt();
        }

        Arrays.sort(nArray);

        int m = scanner.nextInt();

        int[] mArray = new int[m];

        for(int i = 0 ; i < m; i++) {
            mArray[i] = scanner.nextInt();
        }

        for(int i = 0 ; i < m; i++) {
            System.out.println(binarySearch(nArray , mArray[i]));
        }
        
    }

    public static int binarySearch(int[] array , int key) {

        int pl = 0 ;
        int pr = array.length - 1;

        while(pl <= pr){
            int pc = (pl + pr) / 2;

            if(array[pc] == key) {
                return 1;
            }else if (array[pc] < key) {
                pl = pc + 1;
            }else {
                pr = pc - 1;
            }
        }
        return 0;
    }
}