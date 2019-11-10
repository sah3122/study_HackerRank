package algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * 삽입 정렬
 * 시간 복잡도 O(n^2)
 * 공간 복잡도 O(n)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] ary = {4,2,5,1,10,9,3,7,8,6};
        int length = 10;

        for(int i = 1; i < length; i++) {
            int j = i - 1;
            int num = ary[i];
            while (j >= 0 && num < ary[j]) {
                ary[j+1] = ary[j];
                j--;
            }
            ary[j + 1] = num;
        }

        for (int i : ary) {
            System.out.println(i);
        }
    }
}
