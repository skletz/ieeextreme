
import sun.misc.BASE64Encoder;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by Queativ-Idea on 24.10.2015.
 */
public class XtremeInSecurity {


    private static String commonPasswords = "password1\n" +
            "\n" +
            "1\n" +
            "digital\n" +
            "a\n" +
            "i\n" +
            "snakes\n" +
            "e\n" +
            "0\n" +
            "rice\n" +
            "shortening\n" +
            "subterranean\n" +
            "u\n" +
            "bunnies\n" +
            "\n" +
            "crashing\n" +
            "3\n" +
            "square7\n" +
            "xtreme4\n" +
            "world4\n" +
            "real7\n" +
            "dice9\n" +
            "bst\n" +
            "art1\n" +
            "anirbas\n"+
            "a\n" +
            "e\n" +
            "i\n" +
            "u\n" +
            "0\n" +
            "1\n" +
            "3\n" +
            "be2\n" +
            "bst\n" +
            "art1\n" +
            "b4r4\n" +
            "cow3\n" +
            "rice\n" +
            "4rt5\n" +
            "c4v35\n" +
            "maze3\n" +
            "me4t4\n" +
            "real7\n" +
            "tac04\n" +
            "bl0ck5\n" +
            "g4mm42\n" +
            "snakes\n" +
            "t0k3n7\n" +
            "world4\n";

    public static void main(String[] args) {

          Scanner in = new Scanner(System.in);
          String line = in.nextLine();
        String[] commonpw = commonPasswords.split("\\n");
         while(!line.isEmpty())
            {
                String encoded = "";
                for (int i = 0; i < commonpw.length; i++) {

                    encoded = encodeBase64(getSHA256("IEEE" + commonpw[i] + "Xtreme"));
                    //System.out.println(encoded);
                    if (line.equals(encoded)) System.out.println(commonpw[i]);
                    break;
                }

                line = in.nextLine();

            }


    }

    public static String getSHA256(String value) {
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        md.update(value.getBytes(Charset.forName("UTF-8")));
        return new String(md.digest());
    }


    public static String encodeBase64(String password) {

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(password.getBytes());

    }
}
