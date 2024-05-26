import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1543 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();

        String str2 = br.readLine();

        int count = 0;

        if(str1.length() < str2.length() || (str1.indexOf(str2)) < 0) {
            System.out.println(count);
            return;
        }

        while ( str1.indexOf(str2) >= 0 ) {
            int index = str1.indexOf(str2);
            str1 = str1.substring( (index + str2.length()));
            count ++;
        }

        System.out.println(count);
    }
}
