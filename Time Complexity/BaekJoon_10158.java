import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_10158 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] array = str.split(" ");

        int width = Integer.parseInt(array[0]);
        int height = Integer.parseInt(array[1]);

        String target = br.readLine();
        String[] targetArray = target.split(" ");

        int x = Integer.parseInt(targetArray[0]);
        int y = Integer.parseInt(targetArray[1]);

        int time = Integer.parseInt(br.readLine());

        int timeX = time % (2 * width);
        int timeY = time % (2 * height);

        int tempX = x + timeX;
        int tempY = y + timeY;

        int x1 = tempX / width;
        int x2 = tempX % width;

        int y1 = tempY / height;
        int y2 = tempY % height;

        if(x1 % 2 != 0) {
            x = width - x2;
        }else {
            x = x2;
        }

        if(y1 % 2 != 0) {
            y = height - y2;
        }else {
            y = y2;
        }

        System.out.print(x);
        System.out.print(" ");
        System.out.print(y);

    }
}
