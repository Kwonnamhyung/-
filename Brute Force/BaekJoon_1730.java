import java.io.*;

public class BaekJoon_1730 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        char[][] array = new char[T][T];
        int x = 0;
        int y = 0;

        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array.length; k++) {
                array[i][k] = (char)46;
            }
        }

        String[] strings = br.readLine().split("");

        for(int i = 0 ; i < strings.length; i++) {
            if(strings[i].equals("U")) {
                int temp = x - 1 ;
                if(temp >= 0) {
                    if(array[x][y] == (char)45) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)124;
                    }
                    x = temp;
                    if(array[x][y] == (char)45) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)124;
                    }
                }
            }else if (strings[i].equals("D")) {
                int temp = x + 1 ;
                if(temp < T) {
                    if(array[x][y] == (char)45) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)124;
                    }
                    x = temp;
                    if(array[x][y] == (char)45) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)124;
                    }
                }
            }else if (strings[i].equals("R")){
                int temp = y + 1 ;
                if(temp < T) {
                    if(array[x][y] == (char)124) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)45;
                    }
                    y = temp;
                    if(array[x][y] == (char)124) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)45;
                    }
                }
            }else {
                int temp = y -1;
                if(temp >= 0) {
                    if(array[x][y] == (char)124) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)45;
                    }
                    y = temp;
                    if(array[x][y] == (char)124) {
                        array[x][y] = (char)43;
                    }else if(array[x][y] == (char)46){
                        array[x][y] = (char)45;
                    }
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array.length; k++) {
                bw.write(array[i][k]);
            }
            bw.write("\n");
        }

        bw.flush();
    }
}
