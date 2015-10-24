import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Queativ-Idea on 24.10.2015.
 */
public class XtremeInSecurity {

    private static String values =
            "/PtjJboZGlsmTovvyOhBOoTVnQKUP/gJXxjLAW9Lppw=\n" +
                    "05HwH93tksb69U1ifesCQuYFP+gKPVH2L6W8JeBdXy0=\n" +
                    "0BkyqI3NHyjh0m20wNt6txW08dglSMP4/qzUEezq4Aw=\n" +
                    "1mT5cdKRz4BbfMdc8LAdnxfjsGO4lV0k0/V1IHtidmY=\n" +
                    "28AdfW0JHmCP4TbieGON8dafRaFpUgpzuX2bHZN6WsM=\n" +
                    "3hoie8omUyvM/9Qfx9dKfoptlwemYe2os8aohTGzoyw=\n" +
                    "3uDaglIdYUn11AadEhELBjE15A0L6hAaWnZmjCGtt+M=\n" +
                    "4D4NstIYSjVN826Q+SXUDDmXglJplpYWiJYf9rt7H8U=\n" +
                    "7FCsEXCDTAxyLh3EPnNx7YrJ44SzehQYv3GmPSA6pWk=\n" +
                    "81X3NN5JgTuGgqq3ErF0eL/l/wZFYkCwur6fZ06L2Us=\n" +
                    "8FzGA/nS7XizLrAVOr/FoeKSq4gaoQRq+kpBKNXHIzc=\n" +
                    "8OtpJ+E1XHv2RDsKIEwJc9KUFwPRzaqeHJ735Er6AVE=\n" +
                    "8cdgZu9dBOrcTBMqElM+y9Vh5FTBRQ7n9EGa/4qVHUk=\n" +
                    "8esDbw8ZVmUuUMEy2Scf5qGiZYiykevrvKpq2bVYHj4=\n" +
                    "9DS4orbhPFbjJcosEqQg+eg0Si5qSOnftfHiqK8sYug=\n" +
                    "9XDFIu4RPH0EL5XR+5VYILJ3UFAyltpfjONJKp/vcLk=\n" +
                    "B2E/K/DywbLEKutOKpS8HxHFrZwucwac4KjzYgsXg3g=\n" +
                    "BJQeqlV+4ejv0je5GpekzGdHHWHL5nnrbtD/170LZCA=\n" +
                    "BjQiH/A2FUNHlUwhBi8NWmj3HmhmAh6Ag0kRyVSaVo8=\n" +
                    "BwbAsOqPsxteVCpAwIjrhYogsUS1bF/bLns2QdcLYUI=\n" +
                    "CYDZabjeyTAwcEDEcvrX83514UmpjzvQUQ68DIZ/PXg=\n" +
                    "CornANxoZ5FJnlhwHmK42CDXf3h6jFr3g73YIRuoymQ=\n" +
                    "DDa2TJX20pPsNftfyJ3s6LBwSMSR3EADZGDxW2wThbs=\n" +
                    "FFXy3vru2D8rTWZRlh9lSMvtEusfWgO17OmJCTQTECs=\n" +
                    "FGkqFC/jLDqDZ10fql1nGw7AQNWioOrZ3ydEaJyXBwo=\n" +
                    "Fz+Y0H/R2rMZlc1C88Yx0A0xluYnVTinlw5qaSx8vWQ=\n" +
                    "GcJMWMDF6+f+onf6oi1FbpnN7dVrFEZnlXtHqmaygs4=\n" +
                    "GsXTQM0w+Clb1c9B7n28mADU2quLeI1n91KTyBboeHI=\n" +
                    "HLnuqQmCYetzrau3frCDEpZ52QCIby108gugsmwAwQ0=\n" +
                    "HWv9gx+GL/6g+0b0eOc+1Z/8BHse91/5T/DdiDwEknU=\n" +
                    "IDB/pOthrWobzapJ/N8HsraNhwfbExAa2uusdiKHFFI=\n" +
                    "IXYqlHbVeONERbxFe8SaEPEEKex45EihiC/l8CR52kk=\n" +
                    "Idvs4Al9YZsqPG8xkSxVqb6MOVhbw5k+qtF8UZKYVE8=\n" +
                    "IxQxcFXR51q8h8FLblPhYfUR30lIAt6hX8TjZWVa/GE=\n" +
                    "JCmqBN0MsW13tEmsQPYWg9Fj25MUrqFYvSK2arxTt0A=\n" +
                    "JOXxLH/i8i+fxDIWP2cts5Si/5En1A8M3s/vy6Aadic=\n" +
                    "KudA8vCEQdGaaCSxotpAcluXnVPS3MAZPkwI/lVupak=\n" +
                    "LGZEfbUr/tMREpJtsao/uuewcJXApmgfHDbh1zzfdhU=\n" +
                    "LZIzmWEqXDPJsnKttFGRaG/jUhHrbTEKt1XCO6XbdME=\n" +
                    "Lq0kV5M0HDSgB4m5KZbbn6BYRNlkKfaaAr3/11ueopY=\n" +
                    "Lqxt1UjT1ecV6ucgYn+yrGSUTxPWkZgdDtbygGwC/BA=\n" +
                    "MHQTB1MSsvhBxMpdRUiaM9Uj1QxU7zYq3FqDlW2HT2s=\n" +
                    "MKewBZryb2l36Y0tDyx+WuVeXUGfiSzcJplm9y1w9m0=\n" +
                    "N5aunKGHeN2WETLXLzfhfCxAfkwtGU/imziiTF3t7oY=\n" +
                    "NmrOUzHxKSfNT8UJ1YXbRL8I+HCAb+glJ0bBXcHfagE=\n" +
                    "NnSS+AuW1Z6zytSfqaiIVp4xxHHe70Av+IdhDlkoItQ=\n" +
                    "O9L1ZWYwuzgaImTjOwuogXfpC+C44zzcDhpt08LjR5c=\n" +
                    "R/ye+L9W+l6hyZ/v1POsWYboEGemIisARL8ohUvfBLI=\n" +
                    "R1v9fEb9VrZuU5xiYTKTqhHF03VtXg7+KtfFHPkQuCQ=\n" +
                    "RVfhsLovxa+/6tWgeSBASIIkzXkVtDPT4yYvjboHhIk=\n" +
                    "Rz38Ng2qI3mPkaRB6uDoCYmmfzbVTCzpt2sG1o+TZqo=\n" +
                    "S98FBzlv2vMVP/q+23m1wrHMJIrcy1rhoQGy338c4Bs=\n" +
                    "SzraQWWasG5ZO1tJq16DqU/7M/o/WRiAWRl1aFFvwr8=\n" +
                    "TInfNYwXvofBA+9QIe3+XEfDpO5ER+R+Jn3BOshhZWU=\n" +
                    "VDkcRd54BhYlK5Wg2PPDa/jzGrSkMepGIv6Tw3I2ksc=\n" +
                    "VjFTqTEY27V8lK2yCvhLhYm2Brh9bN1vWckVaevsiiY=\n" +
                    "Wau4ReopjFKk8SYYNq5lIBL+Rgg8aBR6h9UgTIv2u7I=\n" +
                    "XtEWsXf16y6Bc7vQxDy7hwRdBVWo3dV9C6CDVSf4PLs=\n" +
                    "Y5b6UztMueFYIFMl4a61jlD/ZhFG74/rVn8XaqqU+8c=\n" +
                    "YollqBlewcxE/kF6PKvv0r1CLZkKx82657bB0eQbiK0=\n" +
                    "YzSqlQTtq5j+Kd+hW1ISgBW0mn61vsQsxNeipq0sYCo=\n" +
                    "aJIH+q0YjYZCpierKtbue5JDtZSF8tKxVKuHYUPQ65k=\n" +
                    "bi6rh2HgTbJxR2GOTNWZLlxiiWZVnObptGj0KqOCSYo=\n" +
                    "cX7VyMvSYhuRvEfAUb3uNh8kmjpNFg0tatUPN562iOg=\n" +
                    "eSCTiCrzHPbngPu3F4ivPkLUv7MqLUlmWAhA4UO975Y=\n" +
                    "eUqkcVCbgIx1bGhhmnN5MxJFJhVruINmG65TjT/EQ1k=\n" +
                    "gE7PseB3mspPtYG3JROzT9FeqTfPFYQvBF2SJD9V19Y=\n" +
                    "gMi4hC4o7Fmv6yIrU48BVy8I1khXwkaD36G7bWiZHeo=\n" +
                    "h84yifAWGLj9sakEqxZ3QEjkXL42AoScP3L5Tdevm98=\n" +
                    "hEGKCiTZSA5x560hodRoIBBTE8pv4sP1VXG4D0fXWcI=\n" +
                    "ix+0IJIpLpHeSHEII+Q/IVY+FlRXn3xMA0ey6UITi34=\n" +
                    "j2GTUqtqZpotY8wF16zkvnbdCLTnX3oOZ30SjQUnIUk=\n" +
                    "jtUg00EsmzzFkk8JgKg3OpkmPRpN9xbwsdNXQSPczwo=\n" +
                    "k1J9Dv3EI442CO6A2FGN1H8JgFO2kjNBvkjDR0WIvkA=\n" +
                    "kuRpkIh9kaNz6XvG8U6GO/IARH/SqhRnTiJbZHXC0yQ=\n" +
                    "lFgqRrqTz1WXmO22u+Is1ZmWWUtuYrTJigsSB7I9NHI=\n" +
                    "lUfxHX9xH2aOHheMMqQF+f5BNh97avew2uOwEN3B7HE=\n" +
                    "m0IeuugWDOl9cFUFRYJhouCBT39T0dpp1xBOKPqHP94=\n" +
                    "mgA5kgALstQpGUBp4vZ8oiz0P4jjAGl0wjgls6kQyMA=\n" +
                    "nMAwaDYvEIAwoqtqWMpBAWdhuRgRq/fmwWbRM7cOMIU=\n" +
                    "opBtoC66YDRbLNqZAAu2FIeKfF0HMOGHCOCPYeNHdx4=\n" +
                    "ot/igM+me4e3UTT731qcBkSAcToyADMCddr7i7LCWGo=\n" +
                    "qrkd/8imuRtiDb9N1w2hQRxJAkdx3Wqh1HVXPS7dym8=\n" +
                    "r6BN0tdyAYZD0Nmc7bfV0WRcFBb1A2WIPPKHVRG59k8=\n" +
                    "rdALvOYVhA3hnUTBlaQXigWBSgMYzGTreSKyMoAoKfw=\n" +
                    "rjwtKqkPc7cfQ+zZ+E9c+fzQYhRvhVtaKEFb+srIHcQ=\n" +
                    "rwvmTDiJxIEETbsngvpxYGwZZK+FGo7527odGuQUjtQ=\n" +
                    "socJeO02bT2w+XZUrLoopbZvQ1lRhDfE88GVrJQ8p+g=\n" +
                    "tDdmKQpMiVDFA1YdblkHSFzL4Z9UIQ9FSouf3TybOu0=\n" +
                    "tojYiNtlWmq+7r1dSvxDk3W5at/NMAi1uxCHY61WAKk=\n" +
                    "tqpGCBzhR+0ONFk1sBiHPhz+kRiXmY3CGdUXqnMJwLg=\n" +
                    "uAZthS7b4ySZtWpM9pJ7ulYnhFdpFABpR2iPRQEmff0=\n" +
                    "uCG9dSBejCOrZWsX7+u8G340p74s8lDS/El8MIeOyMo=\n" +
                    "ugcIIpDID0R1uFqBAcN3PNXhwlhen77GdAccFgpbs+A=\n" +
                    "usg8BTtSfewL5M3OVg91TJCTc5vONLqgUCC/Si1Grsg=\n" +
                    "vs2sCU8qG0pDYQfcjlPzDzvcbJnhP1OgFRcXP4i3ffw=\n" +
                    "wEtqAs8JHjicWnXshAWF5Sg6NoswuG9qeJ7USw7YD7c=\n" +
                    "y+zbMpySKY+WF97KkgRQ+tBpM7iTqTj9guWmGJcqfyA=\n" +
                    "y1R6JQiUzUovgtdrvCkbeQAyMhFoupzhI5ZuQVPfCgw=\n" +
                    "zqKPAOt5ziHSeRxc0TgUZF3rJxzBHAKdJeccvt3F7Jg=";

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
            "anirbas\n";

    public static void main(String[] args) {

//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(new File("C:\\Users\\Queativ-Idea\\IdeaProjects\\IEEExtreme2015\\src\\FoundedPWs.txt")));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }


//        int counter = 0;
//
//        String[] list = values.split("\\n");
//        String[] commonpw = commonPasswords.split("\\n");
//
//        String encoded = "";
//        for (int i = 0; i < commonpw.length; i++) {
//
//            encoded = encodeBase64(getSHA256("IEEE" + commonpw[i] + "Xtreme"));
//            System.out.println(encoded);
//            for (int j = 0; j < list.length; j++) {
//
//                if (encoded.equals(list[j])) {
//                    counter++;
//                    System.out.println(commonpw[i]);
//                }
//            }
//
////                String line;
////                try {
////                        while((line = br.readLine()) != null){
////                                encoded = encodeBase64(getSHA256("IEEE" + line + "Xtreme"));
////                                for (int j = 0; j < list.length; j++)
////                                if(encoded.equals(list[j])){
////                                        counter++;
////                                        System.out.println(line);
////                                }
////                        }
////                } catch (IOException e) {
////                        e.printStackTrace();
////                }
//
//        }
//
//        System.out.println("Founded: " + counter + " of " + list.length);
        words("", 0,chars.length-1,20);


        //System.out.println(encodeBase64(getSHA256("IEEE" + "password1" + "Xtreme")));
    }

    public static void test(String pw){
        String[] list = values.split("\\n");
        String encoded = "";
        encoded = encodeBase64(getSHA256("IEEE" + pw + "Xtreme"));
        //System.out.println(encoded);
        for (int j = 0; j < list.length; j++) {

            if (encoded.equals(list[j])) {
                System.out.println(pw);
            }
        }
    }

    static char chars[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9'};
    public static String words(String base, int min, int max, int n) {
        for (int i = 0; i <= n; i++) {
            wordsRecursive("",min,max,i);
        }
        return "";
    }

    public static void wordsRecursive(String base, int min,int max, int n){
        if(n == 0)
        //System.out.println(base);
        test(base);
        else
            for (int i = 0; i < max; i++) {
                wordsRecursive(base + chars[i],min,max,n-1);

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


    public static byte[] decodeBase64(String password) {

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return decoder.decodeBuffer(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encodeBase64(String password) {

        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(password.getBytes());

    }
}
