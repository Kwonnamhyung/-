import java.io.*;

public class BaekJoon_16713 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int T = Integer.parseInt(split[1]);

        int[] array = new int[N + 1];
        int[] XORArray = new int[N + 1];
        int[] resultArray = new int[T];

        String[] strArray = br.readLine().split(" ");

        for(int i = 0 ; i < strArray.length; i++) {
            array[i + 1] = Integer.parseInt(strArray[i]);
        }

        for(int i = 1; i < array.length; i++) {
            XORArray[i] = XORArray[i - 1] ^ array[i];
        }

        for(int i = 0 ; i < T ; i++) {
            String[] TArray = br.readLine().split(" ");
            int start = Integer.parseInt(TArray[0]);
            int end = Integer.parseInt(TArray[1]);

            resultArray[i] = XORArray[end] ^ XORArray[start - 1];
        }

        int result = 0;

        for(int i = 0 ; i < resultArray.length; i++) {
            result = result ^ resultArray[i];
        }

        bw.write(String.valueOf(result));

        bw.flush();
    }
}
