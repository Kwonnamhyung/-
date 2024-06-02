import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_10431 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < testCount; i++) {
            String[] strArray = br.readLine().split(" ");
            int count = 0;
            int caseNumber = Integer.parseInt(strArray[0]);

            int[] array = new int[20];

            for(int k = 1; k < strArray.length; k++) {

                int index = k - 1;
                int value = Integer.parseInt(strArray[k]);

                if(index == 0) {
                    array[index] = value;
                    continue;
                }

                if(array[index - 1] > value) {

                    int temp = index - 1;

                    while (true) {

                        if(temp == -1) {
                            break;
                        }

                        if(array[temp] > value) {
                            temp = temp - 1;
                        }else {
                            break;
                        }
                    }

                    if(temp == -1) {
                        for(int j = index - 1 ; j >= 0 ; j--) {
                            array[j + 1] = array[j];
                            count++;
                        }
                        array[0] = value;
                    }else {
                        for(int j = index - 1 ; j > temp ; j--) {
                            if(j != array.length - 1) {
                                array[j + 1] = array[j];
                                count++;
                            }
                        }
                        array[temp + 1] = value;
                    }

                }else {
                    array[index] = value;
                }

            }

            System.out.println(caseNumber + " " + count);

        }


    }
}
