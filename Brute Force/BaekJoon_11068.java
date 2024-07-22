import java.io.*;

public class BaekJoon_11068 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < count; i++) {
           int target = Integer.parseInt(br.readLine());

           for(int k = 2 ; k <= 64; k++) {

               boolean find = true;

               int y = target;

               String temp = "";

               while (y > 0) {
                   int x = y % k ;

                   if( x < 10) {
                       temp += x;
                   }else {
                       temp += (char)('A' + x - 10);
                   }

                   y = y / k ;
               }

               char[] charArray = temp.toCharArray();

               for(int j = 0; j <= ( charArray.length / 2 ); j++) {
                   int z = charArray.length - 1 - j;
                   if((int)charArray[j] != (int)charArray[z]) {
                       find = false;
                       break;
                   }
               }

               if(find) {
                   bw.write(1 + "\n");
                   break;
               }

               if(k == 64) {
                   bw.write(0 + "\n");
               }
           }


        }
        bw.flush();
    }
}
