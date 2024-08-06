import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BaekJoon_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        Data[] array = new Data[T];

        for(int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            array[i] = new Data(Integer.parseInt(split[0]) , Integer.parseInt(split[1]));
        }

        Arrays.sort(array, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.endTime == o2.endTime) {
                    return o1.startTime - o2.startTime;
                }
                return o1.endTime - o2.endTime;
            }
        });

        int currentTime = array[0].endTime;
        int count = 1 ;
        for(int i = 1 ; i < array.length; i++) {
            if(array[i].startTime >= currentTime) {
                currentTime = array[i].endTime;
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
    }

    static class Data {
        int startTime;
        int endTime;

        public Data(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
