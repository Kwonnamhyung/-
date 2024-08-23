import java.io.*;

public class BaekJoon_17232 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);
        int T = Integer.parseInt(split[2]);

        split = br.readLine().split(" ");

        int K = Integer.parseInt(split[0]);
        int a = Integer.parseInt(split[1]);
        int b = Integer.parseInt(split[2]);

        char[][] array = new char[N + 1][M + 1];

        for(int i = 1; i <= N ; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int k = 1 ; k <= M; k++) {
                array[i][k] = charArray[k - 1];
            }
        }

        for(int i = 0 ; i < T; i++) {

            int[][] sumArray = getSumArray(array);

            for(int j = 1 ; j <= N ; j++) {
                for(int k = 1; k <= M ; k++) {
                    int count = getAliveCount(sumArray , j , k , K);

                    if(array[j][k] == '*') {
                        count--;
                    }

                    if(array[j][k] == '*') {
                        if(count < a || count > b) {
                            array[j][k] = '.';
                        }
                    }else {
                        if(a < count && count <= b) {
                            array[j][k] = '*';
                        }
                    }
                }
            }
        }

        for(int i = 1 ; i < array.length; i++) {
            for(int k = 1; k < array[0].length; k++) {
                System.out.print(array[i][k]);
            }
            System.out.println();
        }


    }

    static int[][] getSumArray(char[][] array) {
        int[][] sumArray = new int[array.length][array[0].length];
        for(int i = 1 ; i < array.length; i++) {
            for(int k = 1 ; k < array[0].length; k++) {
                sumArray[i][k] = sumArray[i - 1][k] + sumArray[i][k - 1] - sumArray[i - 1][k - 1] + ( array[i][k] == '*' ? 1 : 0 ) ;
            }
        }
        return sumArray;
    }

    static int getAliveCount(int[][] array , int x , int y ,int K) {
        int x1 = Math.max(x - K , 1);
        int y1 = Math.max(y - K , 1);
        int x2 = Math.min(x + K , array.length - 1);
        int y2 = Math.min(y + K , array[0].length - 1);

        return array[x2][y2] - array[x1 - 1][y2] - array[x2][y1 - 1] + array[x1 -1][y1 -1];
    }
}
