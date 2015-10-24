import java.util.Scanner;

/**
 * Created by Queativ-Idea on 24.10.2015.
 */
public class XtremeDriving {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int traces = 4;
        int K;
        int cows;

        String tmp[];
        tmp = in.nextLine().split(" ");
        K = Integer.parseInt(tmp[0]);
        cows = Integer.parseInt(tmp[1]);

        //int highway[][] = new int[traces][length];

        int constraints[][] = new int[cows][2]; //x,y of cows
        int v = 0;
        for (int i = 0; i < cows; i++) {
            tmp = in.nextLine().split(" ");
//            constraints[i][0] = Integer.parseInt(tmp[0]);
//            constraints[i][1] = Integer.parseInt(tmp[1]);
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);

            v = binCoeff(traces/4 + K,traces/2);
            //v -= binCoeff(x+y,x);

        }

        System.out.println(v);



    }

    //n over k recursive
    public static int binCoeff(int n, int k){
        if(k == 0) return 1;
        else if(k > n) return 0;
        else return binCoeff(n-1,k-1) + binCoeff(n-1,k-1);
    }
}
