import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        int[] monthDays = {31,28,31,30,31,30,31,31,30,31,30,31};

        int daysPassed = d%7 + 7;
        int ans = 2;
        do{
            ans++;
            daysPassed += 7;
        }while(daysPassed <= monthDays[m]);

        System.out.println(ans);
   }
}
