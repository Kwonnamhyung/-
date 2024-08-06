import java.io.*;
import java.util.*;

public class BaekJoon_1302 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T  = Integer.parseInt(br.readLine());

        Map<String ,Integer > map = new HashMap<>();

        for(int i = 0 ; i < T; i ++) {
            String str = br.readLine();

            if(map.containsKey(str)) {
                map.put(str , map.get(str) + 1);
            }else {
                map.put(str , 1);
            }
        }

        String result = "";
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            Integer count = entry.getValue();
            if(count > maxCount || count == maxCount && title.compareTo(result) < 0) {
                maxCount = count;
                result = title;
            }
        }

        bw.write(result);

        bw.flush();
    }
}
