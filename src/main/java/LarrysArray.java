import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LarrysArray {
    // Complete the larrysArray function below.
    static String larrysArray(int[] A) {
        int sortCount = 2;
        int length = A.length;

        int temp1 = 0;

        for(int i = 0; i <= length - 1; i++) {
            for(int k = 0; k <= length - 1; k++) {
                if(A[i + 1] > A[i + 2] || A[i] > A[i + 1]) {
                    for(int j = 0; j < sortCount; j ++) {
                        temp1 = A[i];
                        A[i] = A[i + 2];
                        A[i + 2] = A[i + 1];
                        A[i + 1] = temp1;
                        if(A[i + 1] > A[i] && A[i + 2] > A[i + 1]) break;
                    }
                }
            }
        }
        for(int i = 0; i < length - 2; i ++) {
            if(A[i] > A[i + 1] || A[i] > A[i + 2] || A[i + 1] > A[i + 2]) return "NO";
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //int[] A = {1, 2, 3, 5, 4};
        //int[] A = {9, 6, 8, 12, 3, 7, 1, 11, 10, 2, 5, 4};
        int[] A = {17, 21, 2, 1, 16, 9, 12, 11, 6, 18, 20, 7, 14, 8, 19, 10, 3, 4, 13, 5, 15};

        String result = larrysArray(A);
        System.out.println(result);
    }
}
