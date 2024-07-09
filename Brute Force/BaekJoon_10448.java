import java.io.*;

public class BaekJoon_10448 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Integer[] triangleNum = new Integer[100];

        int num = 1;
        int triangleIndex = 0;

        while (true) {

            int sum = num * (num + 1) / 2;

            if(sum > 1000) break;

            triangleNum[triangleIndex++] = sum;
            num++;
        }

        boolean[] subTriangle = new boolean[1001];
        boolean[] triangle = new boolean[1001];

        for(int i = 0; i < triangleIndex; i++) {
            for(int k = 0; k < triangleIndex; k++) {
                int subSum = triangleNum[i] + triangleNum[k];
                if(subSum < 1000) {
                    subTriangle[subSum] = true;
                }
            }
        }

        for(int i = 1 ; i < 1000; i++) {
            if(!subTriangle[i]) continue;
            for(int j = 0 ; j < triangleIndex; j++) {
                int sum = i + triangleNum[j];
                if(sum <= 1000) {
                    triangle[sum] = true;
                }
            }
        }


        int T = Integer.parseInt(br.readLine());
        Integer[] answer = new Integer[T];

        for(int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());
            if(triangle[target]) {
                answer[i] = 1;
            }else {
                answer[i] = 0;
            }
        }

        for(int i = 0 ; i  < answer.length; i++) {
            bw.write(answer[i] + "\n");
        }

        bw.flush();
    }
}
