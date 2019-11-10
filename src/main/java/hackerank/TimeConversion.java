package hackerank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {
    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String time = s.substring(0, 8);
        String hour = time.split(":",8)[0];
        String min = time.split(":",8)[1];
        String sec = time.split(":",8)[2];

        if(s.contains("PM") && !hour.equals("12")){
            hour = Integer.toString(Integer.parseInt(hour) + 12);
        } else if (s.contains("PM") && hour.equals("12")) {

        }

        if(s.contains("AM") && hour.equals("12")){
            hour = "00";
        }


        return hour + ":" + min + ":" + sec;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scan.nextLine();

        String result = timeConversion("12:40:22AM");
        System.out.println(result);
//        bw.write(result);
//        bw.newLine();
//
//        bw.close();
    }
}
