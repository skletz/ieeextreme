import java.util.*;

/**
 * Created by BNS on 10/24/2015.
 */
public class ZoomIn {

    public static void main (String[] args) {

        int totalTickets = 0;

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if (n < 1 || n > 100) return;

        int m = Integer.parseInt(in.nextLine());
        if (m < 1 || m > 100) return;

        int numChars = Integer.parseInt(in.nextLine());
        if (numChars < 3 || numChars > 95) return;

        String[] characters = new String[numChars];
        String[] characterLines = new String[numChars];


        for (int i=0; i<numChars; i++)
        {
            String line = in.nextLine();
            characters[i] = line; //substring(0, line.length()-1);

            // rows
            for (int k=0;k<m;k++)
            {
                String charLine = in.nextLine();
                //charLine = charLine.substring(0, charLine.length()-1);
                //System.out.println("Length: "+charLine.length());
                // columns
                for (int x=0;x<n;x++)
                {
                    if (characterLines[i] == null) characterLines[i] = (""+charLine.charAt(x));
                    else characterLines[i] += (""+charLine.charAt(x));
                }
            }
        }

        int x = Integer.parseInt(in.nextLine());
        if (x < 1 || x > 500) return;

        for (int i=0; i < x; i++)
        {
            String word = in.nextLine();
            printLine(word, numChars, characters, characterLines, n, m);
        }

        //word = word.substring(0, word.length()-1);

    }


    public static void printLine(String word, int numChars, String[] characters, String[] characterLines, int n, int m)
    {
        int[] order = new int[word.length()];

        for (int i=0; i<word.length();i++)
        {
            String charact = ""+word.charAt(i);
            for (int z=0; z<characters.length; z++)
            {
                if (charact.equals(" ")) order[i] = -1;
                else if (charact.equals(characters[z])) order[i] = z;
            }
        }

        for (int i=0; i<m;i++)
        {
            for (int k=0; k<order.length;k++)
            {
                if (order[k] == -1)
                {
                    for (int x=0;x<n;x++) System.out.print(" ");
                }
                else
                {
                    String charLine = characterLines[order[k]];
                    for (int x=0;x<n;x++)
                    {
                        System.out.print(""+charLine.charAt(x + (n*i)));
                    }
                }
            }
            System.out.println();
        }
    }

}
