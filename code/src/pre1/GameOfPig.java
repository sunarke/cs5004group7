package pre1;

import java.util.Random;
import java.util.Scanner;

public class GameOfPig {
    public static int humanScore;
    public static int computerScore;

    public static int getHumanScore() {
        return humanScore;
    }

    public static int getComputerScore() {
        return computerScore;
    }

    public static int getRandom(){
        Random rm = new Random();
        return 1 + rm.nextInt(5);
    }



    public static void humansTurn(){
        System.out.println("Your total score is "+ getHumanScore());
        System.out.println("Computer`s total score is " + getComputerScore());
        int count = 0;
        while(getHumanScore() < 100) {
            int dice = getRandom();
            System.out.println("Your number is : " + dice);
            if(dice == 1){
                humanScore -= count;                                        //
                System.out.println("You lose all points this round.");
                break;
            }
            else if(dice >= 2 && dice <= 6){
                Scanner s = new Scanner(System.in);
                System.out.println("Roll or Hold? (please type r or h): ");
                String choice = s.next();
                if (choice.equals("r")){
                    count += dice;
                    humanScore += dice;
                    continue;
                }
                else if(choice.equals("h")){
                    count += dice;
                    humanScore += dice;
                    System.out.printf("You earn %d points this round", count).println();
                    break;
                }
            }
        }
        System.out.println("Your total score is " + getHumanScore() + "\n");
    }

    public static void computerTurn(){
        System.out.println("Now is computer`s turn...");
        int count = 0;
        while(count < 20 && getComputerScore() < 100){
            int dice = getRandom();
            System.out.println("Computer number is " + dice);
            if(dice == 1){
                computerScore -= count;
                count = 0;
                break;
            }
            else if(dice >= 2 && dice <= 6){
                count += dice;
                computerScore += dice;
                continue;
            }
        }
        System.out.printf("Computer earns %d points this round", count).println();
        System.out.println("Computer`s total score is " + getComputerScore() + "\n");

    }

    public static void main(String[] args) {
        while(humanScore < 100 && computerScore < 100){
            humansTurn();
            if(humanScore >= 100 && computerScore < 100){
                System.out.println("You win !!!!! (*^▽^*)");
                break;
            }
            computerTurn();
            if(humanScore < 100 && computerScore >= 100){
                System.out.println("Computer win. o(╥﹏╥)o");
                break;
            }
        }
    }
}
