import java.io.*;

public class BaekJoon_11005 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] target = br.readLine().split(" ");
        int x = Integer.parseInt(target[0]);
        int y = Integer.parseInt(target[1]);

        String result = "";

        while (x > 0) {

            int z = x % y ;

            if(z < 10 ) {
                result += z;
            }else {
                result += (char)(z - 10 + 'A');
            }

            x = x / y;

        }

        for(int i = result.length() - 1 ; i >= 0; i--) {
            bw.write(result.charAt(i));
        }

        bw.flush();
    }
}
