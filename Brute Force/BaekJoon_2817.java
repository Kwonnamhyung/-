import java.io.*;
import java.util.*;

public class BaekJoon_2817 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        double cutOff = T * 0.05;

        Map<Integer , String> result = new HashMap<>();
        Map<String , Integer> map = new HashMap<>();

        List<Integer> list = new ArrayList<>();

        for(int i = 0 ; i < N; i++) {
            String[] split = br.readLine().split(" ");

            String name = split[0];
            int vote = Integer.parseInt(split[1]);

            if(vote >= cutOff) {
                map.put(name , 0);
                for(int k = 1 ; k <= 14 ; k++) {
                    int value = vote;

                    value = value / k ;

                    list.add(value);
                    result.put(value , name);
                }

            }

        }

        Collections.sort(list , Collections.reverseOrder());

        for(int i = 0; i < 14; i++) {

            int value = list.get(i);

            String s = result.get(value);
            map.put(s , map.get(s) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            bw.write(entry.getKey() + " " + entry.getValue() + "\n");
        }

        bw.flush();

    }
}
