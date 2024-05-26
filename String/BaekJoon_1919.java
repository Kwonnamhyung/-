import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_1919 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine().trim();
        String strB = br.readLine().trim();

        int count = 0;

        char[] charArrayA = strA.toCharArray();
        char[] charArrayB = strB.toCharArray();

        Map<Character , Integer> mapA = new HashMap<>();
        Map<Character , Integer> mapB = new HashMap<>();

        for (char c : charArrayA) {
            if(!mapA.containsKey(c)) {
                mapA.put(c , 1);
            }else {
                mapA.put(c , mapA.get(c) + 1);
            }
        }

        for (char c : charArrayB) {
            if(!mapB.containsKey(c)) {
                mapB.put(c , 1);
            }else {
                mapB.put(c , mapB.get(c) + 1);
            }
        }

        for (char c : mapA.keySet()) {
            if(!mapB.containsKey(c)) {
                count += mapA.get(c);
            }else {
                Integer A = mapA.get(c);
                Integer B = mapB.get(c);

                if(A > B) {
                    count += (A - B);
                }else if(A < B){
                    count += (B -A);
                }
            }
        }

        for (char c : mapB.keySet()) {
            if(!mapA.containsKey(c)) {
                count += mapB.get(c);
            }
        }

        System.out.println(count);
    }
}
