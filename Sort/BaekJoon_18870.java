import java.io.*;
import java.util.*;

public class BaekJoon_18870 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        Set<Integer> set = new TreeSet<>();
        Map<String , Integer> map = new HashMap<>();

        String[] split = br.readLine().split(" ");

        for (String s : split) {
            set.add(Integer.parseInt(s));
        }

        Integer[] array = set.toArray(new Integer[0]);

        for(int i = 0; i < array.length; i++) {
            map.put(String.valueOf(array[i]) , i);
        }

        for (String s : split) {
            bw.write(map.get(s) + " ");
        }

        bw.write("\n");

        bw.flush();
    }
}
