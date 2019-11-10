package hackerank;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PlusMinus {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        plusMinus(arr);

        scanner.close();
    }

    static void plusMinus(int[] arr) {
        Double positive  = ((Long)Arrays.stream(arr).filter(number -> number > 0).count()).doubleValue();
        Double negative  = ((Long)Arrays.stream(arr).filter(number -> number < 0).count()).doubleValue();
        Double zero  = ((Long)Arrays.stream(arr).filter(number -> number == 0).count()).doubleValue();

        Double positiveResult = positive / Arrays.stream(arr).count();
        Double negativeResult = negative / Arrays.stream(arr).count();
        Double zeroResult = zero / Arrays.stream(arr).count();

        System.out.printf("%.4f\n",positiveResult);
        System.out.printf("%.4f\n",negativeResult);
        System.out.printf("%.4f\n",zeroResult);
    }
}
