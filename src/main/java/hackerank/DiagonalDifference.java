package hackerank;

import java.util.List;

public class DiagonalDifference {
    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int result = 0;
        int leftToRight = 0;
        int rightToLeft = 0;
        int length = arr.size();

        for(int i = 0; i < length; i++) {
            leftToRight += arr.get(i).get(i);
            rightToLeft += arr.get(i).get(length - i - 1);
        }

        result = Math.abs(leftToRight - rightToLeft);
        return result;
    }
}
