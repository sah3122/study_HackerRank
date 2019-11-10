package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class BiggerisGreater {
    // Complete the biggerIsGreater function below.
    static String biggerIsGreater(String w) {
        List<String> stringList  = new ArrayList<>();

        String result = "";
        int max = 0;
        for(int i = w.length() - 1 ; i >= 0; i--) {
            if(max < w.charAt(i)) max = w.charAt(i);
            stringList.add(String.valueOf(w.charAt(i)));
        }


        int indexString = 0;
        for (int i = 0; i < stringList.size() -2; i++) {
            if(stringList.get(i).charAt(0) > stringList.get(i+1).charAt(0)) {
                String a = stringList.get(i+1);
                String b = stringList.get(i);
                stringList.set(i, a);
                stringList.set(i+1, b);
                break;
            }
        }
        for (int i = stringList.size() -1; i >= 0; i--) {
            result += stringList.get(i);
        }



        return result.equals(w) ? "no answer" : result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = 1;
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int TItr = 0; TItr < T; TItr++) {
            String w = "fedcbabcd";

            String result = biggerIsGreater(w);

            //
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
