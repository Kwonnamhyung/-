import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_2744 {

    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        try {
            String str = br.readLine();


            char[] charArray = str.toCharArray();

            for (char c : charArray) {
                int intChar = (int)c;
                if(intChar >= 65 && intChar <= 90) {
                    sb.append(String.valueOf(c).toLowerCase());
                }else {
                    sb.append(String.valueOf(c).toUpperCase());
                }
            }

            System.out.println(sb);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
