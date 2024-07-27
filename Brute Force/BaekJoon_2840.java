import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class BaekJoon_2840 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strings = br.readLine().split(" ");

        int boxCount = Integer.parseInt(strings[0]);
        int count = Integer.parseInt(strings[1]);
        boolean isStop = false;

        String array[] = new String[boxCount];

        int idx = array.length - 1;

        for(int i = 0; i < count; i++) {
            String[] split = br.readLine().split(" ");

            for(int k = 0 ; k < Integer.parseInt(split[0]); k++) {
                idx = idx - 1;
                if(idx == -1) {
                    idx = array.length - 1;
                }
            }
            if(array[idx] == null || array[idx].equals(split[1])) {
                array[idx] = split[1];
            }else {
                isStop = true;
                break;
            }
        }

        if(isStop) {
            bw.write("!");
        }else {

            List<String> list = new ArrayList<>();
            boolean isSame = false;

            for(int i = 0; i < array.length; i++) {
                if(!list.contains(array[i]) && array[i] != null) {
                    list.add(array[i]);
                }else if(array[i] != null && list.contains(array[i])){
                    isSame = true;
                }
            }

            if(isSame) {
                bw.write("!");
            }else {
                int temp = 0;
                while (true) {
                    if(temp == boxCount) {
                        break;
                    }

                    if(array[idx] == null) {
                        bw.write("?");
                    }else {
                        bw.write(array[idx]);
                    }

                    idx ++;
                    temp++;

                    if(idx == boxCount) {
                        idx = 0;
                    }
                }
            }
        }

        bw.flush();
    }
}
