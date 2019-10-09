import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SockMerchant {
    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        List<Integer> distinctList = new ArrayList<>();
        List<Integer> sortList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(!distinctList.contains(ar[i])) {
                distinctList.add(ar[i]);
            }
        }

        for(int i = 0; i < n; i++) {
            sortList.add(ar[i]);
        }


        Map<Integer, Integer> resultMap = new HashMap<>();

        for (Integer integer : distinctList) {
            resultMap.put(integer, 0);
        }

        for (Integer integer : sortList) {
            resultMap.put(integer, resultMap.get(integer) + 1);
        }

        for (Integer value : resultMap.values()) {
            result += (value / 2);
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);



        scanner.close();
    }
}
