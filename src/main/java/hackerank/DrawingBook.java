package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DrawingBook {
    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int plusIndex = 0;
        int minusIndex = 0;
        for(int i = 1; i <= n; i += 2) {
            if(p <= i) break;
            plusIndex++;
        }

        if(n % 2 == 1) n = n -1;
        for(int j = n; j >= 1; j -= 2) {
            if(p >= j) break;
            minusIndex++;
        }

        return plusIndex > minusIndex ? minusIndex : plusIndex;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int result = pageCount(n, p);
        System.out.println(result);

        scanner.close();
    }

}
