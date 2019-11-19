package algorithms;

public class MergeSort {
    static int[] ary = {4,2,5,1,10,9,3,7,8,6};
    static int[] sorted = new int[10];

    public static void main(String[] args) {
        int length = 10;
        merge_sort(ary, 0, length -1);

        for (int i : sorted) {
            System.out.println(i);
        }
    }

    public static void merge_sort(int ary[], int left, int right) {
        int mid;

        if(left < right) {
            mid = (left + right) / 2;
            merge_sort(ary, left, mid);
            merge_sort(ary, mid + 1, right);
            merge(ary, left, mid, right);
        }
    }

    private static void merge(int[] ary, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while(i <= mid && j <= right) {
            if(ary[i] <= ary[j]) {
                sorted[k++] = ary[i++];
            } else {
                sorted[k++] = ary[j++];
            }
        }

        if(i > mid) {
            for (int a = j; a <= right; a++) {
                sorted[k++] = ary[a];
            }
        }
        else {
            for (int a = i; a <= mid; a++) {
                sorted[k++] = ary[a];
            }
        }


    }
}
