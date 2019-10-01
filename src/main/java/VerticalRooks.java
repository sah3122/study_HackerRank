import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VerticalRooks {
    /*
     * Complete the verticalRooks function below.
     */
    static String verticalRooks(int[] r1, int[] r2) {
        /*
         * Write your code here.
         */
        int result = 0;
        for(int i = 0; i < r2.length; i++) {
            result ^= Math.abs(r1[i] - r2[i]) -1;
        }

        if(result == 0) return "player-1";
        else return "player-2";
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] r1 = {3, 3, 3, 3};
        int[] r2 = {4, 4, 4, 4};
        String result = verticalRooks(r1, r2);

        System.out.println(result);


    }

}
