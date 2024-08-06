import java.io.*;
import java.util.*;

public class BaekJoon_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int maxNum = Integer.parseInt(split[1]);

        Map<Integer , Data> map = new HashMap<>();

        String[] numArray = br.readLine().split(" ");

        for(int i = 0 ; i < numArray.length; i++) {
            int num = Integer.parseInt(numArray[i]);
            if(!map.containsKey(num)) {
                map.put(num , new Data(num , i , 1));
            }else {
                Data data = map.get(num);
                data.addMaxCount();
                map.put(num , data);
            }
        }

        Data[] array = map.values().toArray(new Data[map.values().size()]);

        Arrays.sort(array , new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.maxCount == o2.maxCount) {
                    return o1.idx - o2.idx;
                }
                return o2.maxCount - o1.maxCount;
            }
        });

        for (Data data : array) {
            for(int i = 0 ; i < data.maxCount; i++) {
                bw.write(data.num + " ");
            }
        }
        bw.flush();
    }

    static class Data {
        int num;
        int idx;
        int maxCount;

        public Data(int num, int idx, int maxCount) {
            this.num = num;
            this.idx = idx;
            this.maxCount = maxCount;
        }

        public void addMaxCount() {
            this.maxCount = maxCount + 1;
        }
    }
}
