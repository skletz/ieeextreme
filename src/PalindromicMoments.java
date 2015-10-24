import java.util.*;

/**
 * Created by BNS on 10/24/2015.
 */
public class PalindromicMoments {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        if (t < 1 || t > 20) return;

        for (int i=0;i<t; i++)
        {
            String yearString = in.nextLine();

            int year = Integer.parseInt(in.nextLine());
            if (t < 10 || t > (10*10*10*10*10*10)) return;
            System.out.println(checkPalindrom(yearString));
        }
    }

    public static int checkPalindrom(String year)
    {
        int[] numbers = new int[year.length()];

        for (int i = 0;i < year.length(); i++){

            boolean isNL = ((year.charAt(i) == '\n' ) ||  ( year.charAt(i) == '\r' ))  ? true : false;
            if (!isNL) numbers[i] = Integer.parseInt("" + year.charAt(i));
        }

        int numPalindroms = 0;



        return numPalindroms;
    }
}
