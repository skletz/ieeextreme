import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by BNS on 10/24/2015.
 */
public class Pattern3 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 10) return;



        for(int i=0;i<n;i++)
        {
            String line = reader.readLine();
            //if (i == 5) line += "b";

            List<String> matches = getAllMatches(line, "^(.+?)(?=\\1*$)");

            int lengthOriginal = matches.get(0).length();
            int length = lengthOriginal;

            while (length == line.length())
            {
                if (line.length() < 2)
                {
                    length = lengthOriginal;
                    break;
                }
                line = line.substring(0, line.length()-1);
                List<String> matchesChopped = getAllMatches(line, "^(.+?)(?=\\1*$)");
                length = matchesChopped.get(0).length();
            }


            System.out.println(length);

            //System.out.println(getAllMatches(line, "a.*a"));

            //System.out.println(tree.best.stringDepth);

        }

    }

    public static List<String> getAllMatches(String text, String regex) {
        List<String> matches = new ArrayList<String>();
        Matcher m = Pattern.compile(regex).matcher(text);
        while(m.find()) {
            //System.out.println("Found value: " + m.group(0));
            //System.out.println("Found value: " + m.group(1));
            matches.add(m.group());
        }
        return matches;
    }
}

