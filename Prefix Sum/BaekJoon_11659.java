import java.io.*;

public class BaekJoon_11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");

        int T = Integer.parseInt(split[0]);
        int N = Integer.parseInt(split[1]);

        int[] array = new int[T + 1];
        int[] sumArray = new int[T + 1];

        split = br.readLine().split(" ");

        for (int i = 0 ; i < split.length; i++) {
            array[i + 1] = Integer.parseInt(split[i]);
        }

        for(int i = 1; i < array.length; i++) {
            sumArray[i] = sumArray[i - 1] + array[i];
        }

        for(int i = 0 ; i < N ; i++) {
            split = br.readLine().split(" ");
            int start = Integer.parseInt(split[0]);
            int end = Integer.parseInt(split[1]);

            int result = sumArray[end] - sumArray[start - 1];

            bw.write(result + "\n");
        }

        bw.flush();

    }

}
