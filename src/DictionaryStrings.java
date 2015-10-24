import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by BNS on 10/24/2015.
 */
public class DictionaryStrings {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 100) return;


        ArrayList<String> dictList = new ArrayList<String>();

        // testcases
        for (int i=0;i<n;i++)
        {
            String[] dictLine = reader.readLine().split(" ");

            int d = Integer.parseInt(dictLine[0]);
            if (d < 1) return;
            int s = Integer.parseInt(dictLine[1]);
            if (s > 100) return;


            // dict size
            for (int j = 0; j<d; j++)
            {
                String dictWord = null;
                try {
                    dictWord = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }
                dictList.add(dictWord);

            }

            // potential dict strings
            for (int h = 0; h<s; h++)
            {
                HashMap<String, Integer> sWordChars = new HashMap<String, Integer>();

                String dictWord = null;
                try {
                    dictWord = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.exit(0);
                }

                for (int x=0;x < dictWord.length(); x++)
                {
                    String charString = ""+dictWord.charAt(x);
                    if (sWordChars.containsKey(charString)) sWordChars.put(charString, sWordChars.get(charString) + 1);
                    else sWordChars.put(charString, 1);
                }


                boolean isDictString = true;
                boolean isPerfect = true;
                int charactersNeeded = 0;

                HashMap<String, Boolean> allCharsNeeded = new HashMap<String, Boolean>();
                for (Map.Entry<String, Integer> entry : sWordChars.entrySet())
                {
                    allCharsNeeded.put(entry.getKey(), false);
                }

                for (String element : dictList) {

                    HashMap<String, Integer> sWordCharsCopy = new HashMap<String, Integer>(); // = (HashMap<String,Integer>) sWordChars.clone();

                    for (Map.Entry<String, Integer> entry : sWordChars.entrySet()) sWordCharsCopy.put(entry.getKey(), entry.getValue());

                    for (int k = 0; k < element.length(); k++) {
                        String charString = "" + element.charAt(k);
                        if (sWordCharsCopy.containsKey(charString)) {
                            int val = sWordCharsCopy.get(charString);
                            if (val < 1) {
                                //isPerfect = false;
                                charactersNeeded++;
                                isDictString = false;
                            } else {
                                sWordCharsCopy.put(charString, val - 1);
                                if (val-1 == 0) allCharsNeeded.put(charString, true);
                            }

                        } else {
                            isDictString = false;
                            //isPerfect = false;
                            charactersNeeded++;
                        }
                    } // for sWord characters

                } // for dict list

                // check if all are used
                for (Map.Entry<String, Boolean> entry : allCharsNeeded.entrySet())
                {
                    if (entry.getValue() == false)
                    {
                        isPerfect = false;
                        break;
                    }
                }

                // output
                if (isDictString) System.out.print("Yes ");
                else System.out.print("No ");

                if (isDictString)
                {
                    if (isPerfect) System.out.print("Yes");
                    else System.out.print("No");
                }
                else System.out.print(charactersNeeded);
                System.out.println();

            } // loop through potential dict strings


        }

    } // main
}
