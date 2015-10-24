import java.util.*;

/**
 * Created by BNS on 10/24/2015.
 */
public class SnakesAndBunnies {

    static String[][] board;
    static int boardSize;
    static int[] playerPos;
    static boolean[] playerHasJumped;
    static int[] playerHist;
    static int numPlayers = 0;
    static int deadCycle = -1;
    static boolean noMoreInput = false;
    static boolean doubleThrow = false;
    static Scanner in = new Scanner(System.in);

    public static void main (String[] args) {

        int n = Integer.parseInt(in.nextLine());
        if (n < 1 || n > 100) return;

        board = new String[n][n];
        boardSize = n * n;

        for (int i=0;i<n;i++)
        {
            String line = in.nextLine();
            for (int j=0;j<n;j++)
            {
                board[i][j] = ""+line.charAt(j);
            }
        }

        String numPlayersString = in.nextLine();
        if (n < 2 || n > 10) return;

        numPlayers = Integer.parseInt(numPlayersString);
        playerPos = new int[numPlayers];
        playerHist = new int[numPlayers];
        playerHasJumped = new boolean[numPlayers];

        for (int i=0;i<playerPos.length;i++)
        {
            playerPos[i] = 0;
            playerHist[i] = 0;
            playerHasJumped[i] = false;
        }

        while (!noMoreInput)
        {
            for (int i=0; i<numPlayers;i++)
            {
                movePlayer(i);
                while (doubleThrow) {
                    movePlayer(i);
                    //System.out.println("Player"+i+": "+playerPos[i]);
                }
                //System.out.println("Player"+i+": "+playerPos[i]);
            }
        }

        gameOver();

    }

    public static void movePlayer(int playerNum)
    {
        int sumThrow = 0;
        if (!doubleThrow)
        {
            int throw1 = getThrow();
            int throw2 = getThrow();

            if (throw1 == throw2) doubleThrow = true;
            sumThrow = throw1 + throw2;

        }
        else
        {
            doubleThrow = false;
            sumThrow = getThrow();

        }

        movePlayerTo(playerNum, playerPos[playerNum]+sumThrow);
    }

    public static void movePlayerTo(int playerNum, int fieldNr)
    {
        playerPos[playerNum] = fieldNr;
        checkConstraints(playerNum);
    }

    public static int getThrow()
    {

        String input = in.nextLine();
        if (input.isEmpty()) {
            gameOver();
        }
        int n = Integer.parseInt(input);
        if (n < 1 || n > 6) return -1;

        return n;
    }

    public static void checkConstraints(int playerNum)
    {

        if (playerPos[playerNum] >= boardSize) {
            playerPos[playerNum] = boardSize;
            gameOver();
            return;
        }

        if (playerHasJumped[playerNum])
        {
            if (playerHist[playerNum] < 1) playerHist[playerNum] = playerPos[playerNum];
            else
            {
                if (playerHist[playerNum] == playerPos[playerNum])
                {
                    deadCycle = playerNum;
                    gameOver();
                }

            }
        }


        String field = getBoardField(playerPos[playerNum]);

        if (field.equals("-")) {

            if (checkOccupied(playerNum))
            {
                playerHasJumped[playerNum] = true;
            }
            else
            {
                playerHist[playerNum] = 0;
            }
            return;
        }


        char fieldChar = field.charAt(0);

        int fieldCode = (int) fieldChar;

        // bunny
        if (fieldCode > 47 && fieldCode < 58)
        {
            if (handleBunnyJump(playerNum, field)) {
                playerHasJumped[playerNum] = true;
                return;
            }

        }

        // snake
        if (fieldCode > 96 && fieldCode < 123)
        {
            if (handleSnakeJump(playerNum, field))
            {
                playerHasJumped[playerNum] = true;
                return;
            }
        }

        // player
        checkOccupied(playerNum);

    }

    public static boolean checkOccupied(int playerNum)
    {
        for (int i=0; i<numPlayers;i++)
        {
            if ((i != playerNum) && (playerPos[playerNum] == playerPos[i]))
            {
                playerHasJumped[playerNum] = true;
                movePlayerTo(playerNum, playerPos[playerNum] + 1);
                return true;
            }
        }
        return false;
    }

    public static boolean handleSnakeJump(int playerNum, String field)
    {
        int fieldX = (board.length-1) - ((playerPos[playerNum]-1) / board.length);
        int fieldY = (playerPos[playerNum]-1) % board.length;
        if ((fieldX % 2) != 0) fieldY =  (board.length-1) - fieldY;

        for (int i=fieldX+1; i < board.length; i++)
        {
            int jEnd = board.length;
            if (i == fieldX) jEnd = fieldY;
            for (int j= 0; j<board.length; j++)
            {
                if (board[i][j].equals(field))
                {
                    movePlayerTo(playerNum, getPosFromFieldCoords(i, j));
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean handleBunnyJump(int playerNum, String field)
    {
        int fieldX = (board.length-1) - ((playerPos[playerNum]-1) / board.length);
        int fieldY = (playerPos[playerNum]-1) % board.length;
        if ((fieldX % 2) != 0) fieldY =  (board.length-1) - fieldY;

        for (int i=fieldX; i >= 0; i--)
        {
            int jStart = 0;
            if (i == fieldX) jStart = fieldY +1;
            for (int j= jStart; j<board.length; j++)
            {

                if (board[i][j].equals(field))
                {
                    movePlayerTo(playerNum, getPosFromFieldCoords(i, j));
                    return true;
                }
            }
        }

        return false;
    }

    public static String getBoardField(int fieldNr)
    {
        String field = "-";
        if (fieldNr < 0 || fieldNr > (boardSize-1)) return field;

        int fieldX = (board.length-1) - ((fieldNr-1) / board.length);

        int fieldY = (fieldNr-1) % board.length;

        if ((fieldX % 2) != 0) fieldY =  (board.length-1) - fieldY;

        field = board[fieldX][fieldY];

        return field;
    }

    public static int getPosFromFieldCoords(int x, int y)
    {
        if ((x % 2) == 0) return ((board.length-1) - x)*board.length + (y+1);
        else return ((board.length-1) - x)*board.length + (board.length - y);
    }

    public static void gameOver()
    {
        if (deadCycle > -1)
        {
            System.out.println("PLAYER "+(deadCycle+1)+" WINS BY EVIL CYCLE!");
        }
        else
        {
            for (int i=0;i<numPlayers;i++)
            {
                if (i== (numPlayers-1)) System.out.print(playerPos[i]);
                else System.out.print(playerPos[i]+ " ");
            }
            System.out.println();
        }
        System.exit(0);

    }

}
