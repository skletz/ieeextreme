import java.util.Scanner;

/**
 * Created by Queativ-Idea on 24.10.2015.
 */
public class BlockArt {

    String a = "a";
    String r = "r";
    String q = "q";


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String tmp;
        tmp = in.nextLine();
        String rc[] = tmp.split(" ");
        int r = Integer.parseInt(rc[0]);
        int c = Integer.parseInt(rc[1]);

        int n = Integer.parseInt(in.nextLine());


        int matrix[][] = new int[r][c];
        String commands[][] = new String[n][5];

        for (int i = 0; i < n; i++) {
            commands[i] = in.nextLine().split(" ");
            int x1,x2,y1,y2;
            x1 = Integer.parseInt(commands[i][1]);
            y1 = Integer.parseInt(commands[i][2]);
            x2 = Integer.parseInt(commands[i][3]);
            y2 = Integer.parseInt(commands[i][4]);

            switch(commands[i][0]){
                case "a":
                    matrix = addLayer(matrix,x1,y1,x2,y2);
                    break;
                case "r":
                    matrix = delLayer(matrix,x1,y1,x2,y2);
                    break;
                case "q":
                    System.out.println(getBlockhead(matrix,x1,y1,x2,y2));
                    break;
                default:
                    break;
            }
        }
    }


    public static int[][] addLayer(int matrix[][], int x1, int y1, int x2, int y2){

        for (int i = x1-1; i < x2; i++) {
            for (int j = y1-1; j < y2; j++) {
                matrix[i][j] += 1;
            }
        }

        return matrix;

    }

    public static int[][] delLayer(int matrix[][], int x1, int y1, int x2, int y2){

        for (int i = x1-1; i < x2; i++) {
            for (int j = y1-1; j < y2; j++) {
                matrix[i][j] -= 1;
            }
        }

        return matrix;

    }

    public static int getBlockhead(int matrix[][], int x1, int y1, int x2, int y2){
        int head = 0;
        for (int i = x1-1; i < x2; i++) {
            for (int j = y1-1; j < y2; j++) {
                head += matrix[i][j];
            }
        }
        return head;
    }

}
