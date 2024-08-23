import java.io.*;

public class BaekJoon_11660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int T = Integer.parseInt(split[1]);

        int[][] array = new int[N + 1][N + 1];

        for(int i = 1 ; i <= N ; i++) {
            split = br.readLine().split(" ");
            for(int k = 1 ; k <= split.length; k++) {
                array[i][k] = Integer.parseInt(split[k - 1]);
            }
        }

        int[][] sumArray = new int[N + 1][N + 1];

        for (int i = 1 ; i <= N ; i++) {
            for(int k = 1 ; k <= N; k++) {
                sumArray[i][k] = sumArray[i - 1][k] + sumArray[i][k - 1] - sumArray[i - 1][k - 1] + array[i][k];
            }
        }


        for(int i = 0; i < T ; i++) {
            split = br.readLine().split(" ");

            int x1 = Integer.parseInt(split[0]);
            int y1 = Integer.parseInt(split[1]);
            int x2 = Integer.parseInt(split[2]);
            int y2 = Integer.parseInt(split[3]);

            int result = 0;

            if(x1 == x2 && y1 == y2) {
                result = array[x1][y1];
            }else {
                result = sumArray[x2][y2] - sumArray[x1 - 1][y2] - sumArray[x2][y1 - 1] + sumArray[x1 -1][y1 - 1];
            }

            bw.write(result + "\n");
        }

        bw.flush();
    }


}
