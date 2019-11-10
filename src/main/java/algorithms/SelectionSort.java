package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 선택 정렬
 * 시간 복잡도 O(n^2)
 * 공간 복잡도 O(n)
 */
public class SelectionSort {
    public static void main(String[] args) {
        List<Integer> collect = Arrays.asList(4,2,5,1,10,9,3,7,8,6);
        int minIndex = 0;

        for (int i = 0; i < collect.size(); i++) {
            minIndex = i;
            for(int j = i + 1; j < collect.size(); j ++) {
                if(collect.get(minIndex) > collect.get(j)) {
                    minIndex = j;
                }
            }
            int temp = collect.get(i);
            collect.set(i, collect.get(minIndex));
            collect.set(minIndex, temp);
        }
        collect.forEach(System.out::println);
    }
}
