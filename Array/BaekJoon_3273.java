import java.io.*;
import java.util.Arrays;

public class BaekJoon_3273 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nArray = new int[n];

        int count = 0;

        String[] sArray = br.readLine().split(" ");

        for(int i = 0 ; i < sArray.length; i++) {
            nArray[i] = Integer.parseInt(sArray[i]);
        }

        int target = Integer.parseInt(br.readLine());

        Arrays.sort(nArray);

        int lt = 0 ;
        int rt = nArray.length - 1;

        while (lt < rt) {
            if(nArray[lt] + nArray[rt] == target) {
                count++;
                lt++;
                rt--;
            }
            if(nArray[lt] + nArray[rt] > target) {
                rt--;
            }

            if(nArray[lt] + nArray[rt] < target) {
                lt++;
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
    }
}
