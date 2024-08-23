import java.io.*;

public class BaekJoon_19951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int N = Integer.parseInt(split[0]);
        int T = Integer.parseInt(split[1]);

        int[] array = new int[N];
        int[] sumArray = new int[N + 2];

        split = br.readLine().split(" ");

        for(int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }

        for(int i = 0 ; i < T; i++) {
            split = br.readLine().split(" ");
            int x = Integer.parseInt(split[0]);
            int y = Integer.parseInt(split[1]);
            int idx = Integer.parseInt(split[2]);

            sumArray[x] = sumArray[x] + idx;
            sumArray[y + 1] = sumArray[y + 1] - idx;
        }

        int[] result = new int[N + 2];

        for(int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] + sumArray[i];
        }

        for (int i = 0 ; i < array.length; i++) {
            bw.write(array[i] + result[i + 1] + " ");
        }

        bw.flush();
    }

}
