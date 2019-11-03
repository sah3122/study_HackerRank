import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AbsolutePermutation {
    // Complete the absolutePermutation function below.
    static int[] absolutePermutation(int n, int k) {
        int result[] = new int[n];
        boolean check = true;


        if (k == 0) {
            for(int i = 1; i <= n; i ++) {
                result[i-1] = i;

            }
            return  result;
        }
        if((n / k) % 2 != 0 ) {
            result = new int[1];
            result[0] = -1;
            return result;
        }
        for (int i = 1; i <= n; i ++) {
            if(check) {
                result[i - 1] = i + k;
            } else {
                result[i - 1] = i - k;
            }

            if(i % k == 0) {
                if(check) check = false;
                else check = true;
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


            int[] result = absolutePermutation(100, 2);


    }
}
