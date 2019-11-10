package algorithms;

/**
 * 버블 정렬
 * 시간 복잡도 O(n^2)
 * 공간 복잡도 O(n)
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] ary = {4,2,5,1,10,9,3,7,8,6};
        int length = ary.length;

        for(int i = 0; i < length; i++) {
            for(int j = 1; j < length; j++) {
                if(ary[j - 1] > ary[j]) {
                    int temp = ary[j];
                    ary[j] = ary[j-1];
                    ary[j-1] = temp;
                }
            }
        }
        for (int i : ary) {
            System.out.println(i);
        }
    }
}
