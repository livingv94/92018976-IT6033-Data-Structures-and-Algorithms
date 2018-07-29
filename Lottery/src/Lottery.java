// Practical Task #4

import java.util.ArrayList;
import java.util.Random;

public class Lottery {

    private static final int MAX_WINNING_NUMBER = 49; // start at 0?

    public static int[] tamasTickets = { 3, 33, 17, 46, 47, 27 };
    public static int[] bobsTickets = { 7, 19, 22, 23 };
    public static int[] caesarsTickets = { 33, 13 };

    public static void main(String[] args) {
        System.out.println("\n**** Welcome to the Simple Lotto ****\n");

        ArrayList<Player> lotteryPlayers = new ArrayList();
        lotteryPlayers.add(new Player("Tama",-1, tamasTickets));
        lotteryPlayers.add(new Player("Bob",8, bobsTickets));
        lotteryPlayers.add(new Player("Caesar", -1, caesarsTickets));

        boolean foundWinner = false;
        while (foundWinner == false) {
            int winningTicket = generateWinningTicket();
            System.out.println("Announcing this week's winning ticket.... the number is " + winningTicket);

            // Cycle through remaining players
            for (Player player : lotteryPlayers) {

                // Asks for fee
                if (player.money == 0) {
                    System.out.println(player.name + " has run out of money, so he no longer plays the lottery.");
                    lotteryPlayers.remove(player);
                    // Asks for fee from next player
                    break;
                } else {
                    // Collects Money from players
                    player.money = player.money - 1;
                }

                // Winner
                if (contains(player.tickets, winningTicket)) {
                    System.out.println("\n****** WINNER ****** \nCongratulations " + player.name + "\nYou have won!");
                    foundWinner = true;
                    break;
                } else {
                }
            }
        }
    }

    public static int generateWinningTicket() {
        Random rand = new Random();
        return rand.nextInt(MAX_WINNING_NUMBER) + 1;
    }

    public static boolean contains(int[] array, int key) {
        for (int i : array) {
            if (i == key) {
                return true;
            }
        }
        return false;
    }
}
