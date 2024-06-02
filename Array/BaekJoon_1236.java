import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1236 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] intArray = br.readLine().split(" ");

        int height = Integer.parseInt(intArray[0]);
        int weight = Integer.parseInt(intArray[1]);

        char[][] array = new char[height][weight];

        for(int i =0 ;i < height; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int k = 0 ; k < charArray.length; k++) {
                array[i][k] = charArray[k];
            }
        }

        boolean[] weightChecked = new boolean[weight];
        boolean[] heightChecked = new boolean[height];


        for(int i = 0; i < height; i++) {
            for(int k = 0 ; k < weight; k++) {
                if(array[i][k] == 'X') {
                    heightChecked[i] = true;
                    weightChecked[k] = true;
                }
            }
        }

        int weightCheckedCount = weight;
        int heightCheckedCount = height;

        for(int i = 0; i < weight; i++) {
            if(weightChecked[i] == true) weightCheckedCount--;
        }

        for(int i = 0;  i < height; i++) {
            if(heightChecked[i] == true) heightCheckedCount--;
        }
        System.out.println(Math.max(weightCheckedCount , heightCheckedCount));
    }
}
