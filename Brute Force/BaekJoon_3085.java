import java.io.*;

public class BaekJoon_3085 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNumber = Integer.parseInt(br.readLine());
        char[][] array = new char[caseNumber][caseNumber];
        int maxNumber = 0;

        for (int i = 0 ; i < caseNumber; i++) {
            char[] charArray = br.readLine().toCharArray();
            for(int k = 0 ; k < charArray.length; k++) {
                array[i][k] = charArray[k];
            }
        }

        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array.length - 1; k++) {

                if(array[i][k] != array[i][k + 1]) {
                    char temp = array[i][k];
                    array[i][k] = array[i][k + 1];
                    array[i][k + 1] = temp;

                    int findMaxNumber = findMaxNumber(array);

                    temp = array[i][k];
                    array[i][k] = array[i][k + 1];
                    array[i][k + 1] = temp;

                    if(findMaxNumber > maxNumber) {
                        maxNumber = findMaxNumber;
                    }
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            for(int k = 0; k < array.length - 1; k++) {

                if(array[k][i] != array[k + 1][i]) {
                    char temp = array[k][i];
                    array[k][i] = array[k + 1][i];
                    array[k + 1][i] = temp;

                    int findMaxNumber = findMaxNumber(array);

                    temp = array[k][i];
                    array[k][i] = array[k + 1][i];
                    array[k + 1][i] = temp;

                    if(findMaxNumber > maxNumber) {
                        maxNumber = findMaxNumber;
                    }
                }

            }
        }

        bw.write(String.valueOf(maxNumber));
        bw.flush();

    }

    public static int findMaxNumber(char[][] array) {

        int number = 0;

        for(int i = 0 ; i < array.length; i++) {

            char temp = ' ';
            int[] xArray = new int[] {0 , 0 , 0 , 0};

            for(int k = 0 ; k < array.length; k++) {
                if(array[i][k] == 'C') {
                    if(temp == 'C') {
                        xArray[0] = xArray[0] + 1;
                    }else {
                        temp = 'C';
                        xArray[0] = 1;
                    }
                }else if(array[i][k] == 'P') {
                    if(temp == 'P') {
                        xArray[1] = xArray[1] + 1;
                    }else {
                        temp = 'P';
                        xArray[1] = 1;
                    }
                }else if(array[i][k] == 'Z'){
                    if(temp == 'Z') {
                        xArray[2] = xArray[2] + 1;
                    }else {
                        temp = 'Z';
                        xArray[2] = 1;
                    }
                }else {
                    if(temp == 'Y') {
                        xArray[3] = xArray[3] + 1;
                    }else {
                        temp = 'Y';
                        xArray[3] = 1;
                    }
                }
            }

            for(int j = 0; j < xArray.length; j++) {
                if(xArray[j] > number) {
                    number = xArray[j];
                }
            }

        }

        for(int i = 0; i < array.length; i++) {
            char temp = ' ';
            int[] yArray = new int[] {0 , 0 , 0 , 0};
            for(int k = 0 ; k < array.length; k++) {
                if(array[k][i] == 'C') {
                    if(temp == 'C') {
                        yArray[0] = yArray[0] + 1;
                    }else {
                        temp = 'C';
                        yArray[0] = 1;
                    }
                }else if(array[k][i] == 'P') {
                    if(temp == 'P') {
                        yArray[1] = yArray[1] + 1;
                    }else {
                        temp = 'P';
                        yArray[1] = 1;
                    }
                }else if(array[k][i] == 'Z'){
                    if(temp == 'Z') {
                        yArray[2] = yArray[2] + 1;
                    }else {
                        temp = 'Z';
                        yArray[2] = 1;
                    }
                }else {
                    if(temp == 'Y') {
                        yArray[3] = yArray[3] + 1;
                    }else {
                        temp = 'Y';
                        yArray[3] = 1;
                    }
                }
            }

            for(int j = 0; j < yArray.length; j++) {
                if(yArray[j] > number) {
                    number = yArray[j];
                }
            }

        }

        return number;
    }
}
