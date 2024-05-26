import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_1157 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        char[] charArray = str.toCharArray();

        String result = "";
        int max = -1;

        Map<String , Integer> map = new HashMap<>();

        for (char c : charArray) {
            int intC = (int)c;
            boolean toUpperCase = false;

            if(intC >= 97 && intC <= 122) {
               toUpperCase = true;
            }

            if(toUpperCase) {
                String upperCase = String.valueOf(c).toUpperCase();
                if(!map.containsKey(upperCase)) {
                    map.put(upperCase , 1);
                }else {
                    map.put(upperCase , map.get(upperCase) + 1 );
                }
            }else {
                if(!map.containsKey(String.valueOf(c))){
                    map.put(String.valueOf(c) , 1);
                }else {
                    map.put(String.valueOf(c) , map.get(String.valueOf(c)) + 1);
                }
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }else if (entry.getValue() == max) {
                result = "?";
            }
        }

        System.out.println(result);

    }
}
