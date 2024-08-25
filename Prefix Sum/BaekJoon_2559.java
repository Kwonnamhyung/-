import java.io.*;

public class BaekJoon_2559 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] array = new int[N + 1];

        split = br.readLine().split(" ");

        for(int i = 1 ; i <= N ; i++) {
            array[i] = Integer.parseInt(split[i - 1]);
        }

        int[] sumArray = new int[N + 1];

        for(int i = 1 ; i < sumArray.length; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        int max = Integer.MIN_VALUE;

        for(int i = 1 ; i < sumArray.length - K + 1; i++) {
            max = Math.max(max , sumArray[i + K - 1] - sumArray[i - 1]);
        }

        bw.write(String.valueOf(max));
        bw.flush();

    }
}
