import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_13223 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        String[] str1Array = str1.split(":");
        String[] str2Array = str2.split(":");

        int[] int1Array = new int[str1Array.length];
        int[] int2Array = new int[str2Array.length];

        for(int i  = 0 ; i < str1Array.length; i++) {
            int1Array[i] = Integer.parseInt(str1Array[i]);
            int2Array[i] = Integer.parseInt(str2Array[i]);
        }

        int intA =  ( int1Array[0] * 3600 ) + (int1Array[1] * 60)  + int1Array[2];
        int intB = ( int2Array[0] * 3600) + (int2Array[1] * 60) + int2Array[2];

        int result = intB - intA;

        if(result <= 0) {
            result += 3600 * 24;
        }

        int hour = result / 3600;
        int min = (result % 3600) / 60;
        int sec = result % 60;

        StringBuilder sb = new StringBuilder();

        System.out.println(String.format("%02d:%02d:%02d", hour, min, sec));

    }
}
