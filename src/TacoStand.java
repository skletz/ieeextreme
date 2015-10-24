import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by BNS on 10/24/2015.
 */
public class TacoStand {
    public static void main(String [] args)
    {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if (n < 1 || n > 1000) return;

        for (int i=0; i<n; i++)
        {
            String ingredients = in.nextLine();
            System.out.println(makeTaco(ingredients));

        }

    }

    public static long makeTaco(String ingredients)
    {
        String[] parts = ingredients.split(" ");
        int [] partsInt = new int[parts.length-1];
        for (int i=1;i<parts.length;i++)
        {
            partsInt[i-1] = Integer.parseInt(parts[i]);
        }

        Arrays.sort(partsInt);


        long numTacos = 0;
        int maxTacos = Integer.parseInt(parts[0]);

        if (maxTacos < 1) return 0;

        if (partsInt[2] < 1) return 0;

        numTacos = partsInt[1];
        int remainder = partsInt[2] - partsInt[1];

        if (remainder > 0 && partsInt[0] > 0) {

            if (partsInt[0] >= remainder ) numTacos += remainder;
            else numTacos += partsInt[0];

        }

        if (numTacos > maxTacos) return maxTacos;
        else return numTacos;

    }

}
