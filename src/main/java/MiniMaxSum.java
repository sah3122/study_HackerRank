import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MiniMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        Long sum = 0L;
        Long minSum = 0L;
        Long maxSum = 0L;

        for(int i = 0; i< arr.length; i++) {
            sum += arr[i];
            if(max < arr[i]) max = arr[i];
            if(min > arr[i]) min = arr[i];
        }
        minSum = (long)(sum - max);
        maxSum = (long)(sum - min);

        System.out.print(minSum);
        System.out.print(" ");
        System.out.println(maxSum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
