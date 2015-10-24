import java.util.*;
import java.util.Scanner;

/**
 * Created by BNS on 10/24/2015.
 */
public class BonVoyage {

    public static void main (String[] args)
    {

        int totalTickets = 0;

        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        if (n < 1 || n > 15) return;

        for (int i=0; i<n; i++)
        {
            totalTickets = 0;
            HashMap<String, Integer> roomMap = new HashMap<String, Integer>();

            int numRooms = Integer.parseInt(in.nextLine());

            if (numRooms < 2 || numRooms > 200) return;

            int numPeople = Integer.parseInt(in.nextLine());

            if (numPeople < 0 || numPeople > 500) return;

            for (int k=0; k<numPeople; k++)
            {
                //System.out.println("k: "+k);
                String inputRooms = in.nextLine();
                String[] currentRooms = inputRooms.split(" ");
                int room1 = Integer.parseInt(currentRooms[0]);
                int room2 = Integer.parseInt(currentRooms[1]);

                if (room1 < 1 || room1 > numRooms ) return;
                if (room2 < 1 || room2 > numRooms ) return;

                if (roomMap.containsKey(inputRooms))  roomMap.put(inputRooms, roomMap.get(inputRooms)+1);
                else roomMap.put(inputRooms, 1);
            }

            for(Map.Entry<String, Integer> entry : roomMap.entrySet()){
                //System.out.printf("Key : %s and Value: %s %n", entry.getKey(), entry.getValue());
                if (entry.getValue() > 2) totalTickets += 2;
                else totalTickets += entry.getValue();
            }
            System.out.println(totalTickets);

        }

    }

}
