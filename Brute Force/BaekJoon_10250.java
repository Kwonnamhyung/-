import java.io.*;

public class BaekJoon_10250 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++) {

            String[] strings = br.readLine().split(" ");
            int height = Integer.parseInt(strings[0]);
            int width = Integer.parseInt(strings[1]);
            int target = Integer.parseInt(strings[2]);
            int result = 0;

            int w = target / height ;
            int h = target - (height * w);

            if(h == 0) {
                result = (height * 100) + w;
            }else {
                result = (h * 100) + (w + 1);
            }

            bw.write(result + "\n");
        }

        bw.flush();
    }
}
