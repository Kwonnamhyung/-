import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BaekJoon_1181 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<String>();

        for(int i = 0 ; i < T; i++) {
            String s  = br.readLine();
            if(!list.contains(s)) {
                list.add(s);
            }
        }

        String[] array = new String[list.size()];

        for(int i = 0 ; i < array.length; i++) {
            array[i] = list.get(i);
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char[] o1Array = o1.toCharArray();
                char[] o2Array = o2.toCharArray();

                if(o1Array.length == o2Array.length) {
                    return o1.compareTo(o2);
                }
                return o1Array.length - o2Array.length;
            }
        });

        for(int i = 0 ; i < array.length; i++) {
            bw.write(array[i] + "\n");
        }

        bw.flush();

    }
}
