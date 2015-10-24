import java.util.Scanner;

/**
 * Created by Queativ-Idea on 24.10.2015.
 */
public class DigitFun {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String tmp = "";

        while(in.hasNext()){
            tmp = in.nextLine();
            if(tmp.equals("END"))
                break;

            System.out.println(findMe(tmp, 0));

        }


    }

    private static int findMe(String input, Integer index  ){

        index++;
        int nD = input.length();

        if(nD < 2){
            Integer value = Integer.parseInt(input);
            if(value == nD){
                return index;
            } else {
                return findMe(String.valueOf(nD), index);
            }
        } else {
            return findMe(String.valueOf(nD), index);
        }

    }
}
