import java.io.*;

public class BaekJoon_25682 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int K = Integer.parseInt(split[2]);

        char[][] array = new char[N + 1][M + 1];

        for(int i = 1 ; i <= N ; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int k = 1 ; k <= M ; k++) {
                array[i][k] = charArray[k - 1];
            }
        }

        int[][] wArray = getSumArray(array, 'W');
        int[][] bArray = getSumArray(array, 'B');

        int result = Integer.MAX_VALUE;

        for(int i = 1 ; i <= N - K + 1; i++) {
            for(int j = 1; j <= M - K + 1; j++) {
                result = Math.min(result , Math.min(getCount(wArray , i , j , K) , getCount(bArray , i , j , K)));
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    static int[][] getSumArray(char[][] array , char str) {

        int[][]sumArray = new int[array.length][array[0].length];

        for(int i = 1 ; i < array.length; i++) {
            for(int k = 1 ; k < array[0].length; k++) {
                if((i + k) % 2 == 0) {
                    sumArray[i][k] = sumArray[i - 1][k] + sumArray[i][k - 1] - sumArray[i - 1][k - 1] + (array[i][k] == str ? 0 : 1);
                }else {
                    sumArray[i][k] = sumArray[i - 1][k] + sumArray[i][k - 1] - sumArray[i - 1][k - 1] + (array[i][k] == str ? 1 : 0);
                }
            }
        }

        return sumArray;
    }

    static int getCount(int[][] sumArray , int x , int y , int K) {

        int x1 = Math.min(x + K - 1, sumArray.length - 1);
        int y1 = Math.min(y + K - 1 , sumArray[0].length - 1);

        return sumArray[x1][y1] - sumArray[x - 1][y1] - sumArray[x1][y - 1] + sumArray[x - 1][y - 1];
    }
}
