import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaekJoon_7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for(int i = 0 ; i < T ; i++) {
            String[] split = br.readLine().split(" ");

            if(set.contains(split[0])) {
                set.remove(split[0]);
            }else {
                set.add(split[0]);
            }
        }


        List<String> result = set.stream().sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        }).collect(Collectors.toList());


        for (String s : result) {
            bw.write(s + "\n");
        }

        bw.flush();

    }

}
