import java.io.*;

public class BaekJoon_10989 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] numArray = new int[10001];

        for(int i = 0; i < N; i++) {
            numArray[Integer.parseInt(br.readLine())]++;
        }

        for(int i = 1; i <= 10000; i++) {
            while (numArray[i] > 0) {
                bw.write(i + "\n");
                numArray[i]--;
            }
        }

        bw.flush();
    }
}
