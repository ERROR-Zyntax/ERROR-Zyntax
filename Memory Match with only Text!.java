import java.util.concurrent.TimeUnit; //so i can use delay
import java.util.*; //so the code will work maybe
public class MyProgram
{   
    
    // prob gonna do a memory match game
    
    //Delay function
    
    public static void delay(int num)
    {
        try{Thread.sleep(num);}catch(InterruptedException ex){ex.printStackTrace();}
    }
    
    //Shortened clear screen function
    
    public static void clearScreen() 
    {  
        System.out.print("\033[H\033[2J"); //special command to wipe screen
        System.out.flush();  
    }  
    
    //Shortened println function

    public static void sayln(String text)
    {
        System.out.println(text);
    }
    
    //Shortened print function

    public static void say(String text)
    {
        System.out.print(text);
    }
    
    //Shortened new line function
    
    public static void newLine()
    {
        System.out.println();
    }
    
    public static void main(String[] args)
    {   
        //variables
        Scanner scan = new Scanner(System.in); //Created a Scanner object
        boolean game = true;
        int matches = 0;
        boolean TOS = false;
        //TITLE SCREEN
        sayln("Welcome to Memory Match!");
        sayln("========================");
        newLine();
        delay(2000);
        sayln("This is a game where you match two of the same words under each 'card'.");
        sayln("You will use only the numbers 1-5 or the game will error.");
        sayln("Your goal is to match all the cards with as little attempts as possible.");
        sayln("You will input the row first and then the column using numbers only. ");
        sayln("You may NOT input the same two 'cards' or I will find you...");
        delay(5000);
        clearScreen();
        sayln("Welcome to Memory Match!");
        sayln("========================");
        newLine();
        sayln("This is a game where you match two of the same words under each 'card'.");
        sayln("You will use only the numbers 1-5 or the game will error.");
        sayln("Your goal is to match all the cards with as little attempts as possible.");
        sayln("You will input the row first and then the column using numbers only. ");
        sayln("Type 'Okay' to agree to my terms and conditions.");
        newLine();
        //haha read the rules
        while (TOS == false)
        {
            String sayOkayNOW = scan.nextLine();
            if (sayOkayNOW.equals("Okay"))
            {
                TOS = true;
            } else {
                clearScreen();
                say("I said");
                delay(1000);
                say(" type 'Okay'.");
                delay(3000);
                say(" Got it?");
                delay(1000);
                clearScreen();
                sayln("Welcome to Memory Match!");
                sayln("========================");
                newLine();
                sayln("This is a game where you match two of the same words under each 'card'.");
                sayln("You will use only the numbers 1-5 or the game will error.");
                sayln("Your goal is to match all the cards with as little attempts as possible.");
                sayln("You will input the row first and then the column using numbers only. ");
                sayln("Type 'Okay' to agree to my terms and conditions.");
                newLine();
            }
        }
        newLine();
        sayln("Good luck!");
        delay(1000);
        clearScreen();
        newLine();
        delay(1000);
        //difficulty
        sayln("Choose a Difficulty: ");
        newLine();
        sayln("1.Easy (Set 1: Pets) (Set 2: Fruits) (Set 3: Devices)");
        sayln("2.Medium (Set 1: Car Brands) (Set 2: Christmas) (Set 3: Icecream Flavors)");
        sayln("3.Hard (Set 1: Words that look the same: 'Homo____') (Set 2: Words that look the same: '_____phobia') (Set 3: Harry Potter Spells)");
        newLine();
        int playerDifficulty = scan.nextInt();
        delay(1000);
        //match sets
        newLine();
        sayln("Choose a Match Set: ");
        newLine();
        sayln("1. Match Set 1");
        sayln("2. Match Set 2");
        sayln("3. Match Set 3");
        newLine();
        int playerMatchSet = scan.nextInt();
        //creates the grid that the player will see
        String[][] seenEasyGrid = {
                {"X", "X", "X"},
                {"X", "X", "X"}
        };
        String[][] seenMediumGrid = {
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"},
                {"X", "X", "X", "X"}
            };
        String[][] seenHardGrid = {
                {"X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X"},
                {"X", "X", "X", "X", "X"}
        };
        delay(1000);
        clearScreen();
        //main part of the thing
        if (playerDifficulty == 1) // easy mode
        {
            while (game == true)
            {
                for (int i = 0; i < seenEasyGrid.length; i++) // prints row
                { 
                    for (int j = 0; j < seenEasyGrid[i].length; j++) // prints column
                    { 
                        System.out.print(seenEasyGrid[i][j] + "  ");
                    }
                    newLine();
                }
                if (matches==3)
                {
                    newLine();
                    newLine();
                    newLine();
                    sayln("You won. But was it really that hard?");
                    game=false;
                    break;
                }
                say("Type the row number for word 1: ");
                int playerRow1 = scan.nextInt();
                newLine();
                say("Type the column number for word 1: ");
                int playerColumn1 = scan.nextInt();
                GridParam playerResponse1 = new GridParam(playerRow1, playerColumn1, playerDifficulty, playerMatchSet);
                String word1=playerResponse1.gridWord();
                sayln(playerResponse1.gridWord());
                newLine();
                say("Type the row number for word 2: ");
                int playerRow2 = scan.nextInt();
                newLine();
                say("Type the column number for word 2: ");
                int playerColumn2 = scan.nextInt();
                GridParam playerResponse2 = new GridParam(playerRow2, playerColumn2, playerDifficulty, playerMatchSet);
                String word2=playerResponse2.gridWord();
                sayln(playerResponse2.gridWord());
                newLine();
                delay(500);
                if (word1.equals(word2))
                {
                    sayln("Great job!");
                    matches++;
                    seenEasyGrid[playerRow1-1][playerColumn1-1] = "✅";
                    seenEasyGrid[playerRow2-1][playerColumn2-1] = "✅";
                } else {
                    sayln("Aww, try again!");
                }
                delay(1000);
                clearScreen();
            }
        } else if (playerDifficulty == 2) // normal mode
        {
            while (game == true)
            {
                for (int i = 0; i < seenMediumGrid.length; i++) // prints row
                { 
                    for (int j = 0; j < seenMediumGrid[i].length; j++) // prints column
                    { 
                        System.out.print(seenMediumGrid[i][j] + "  ");
                    }
                    newLine();
                }
                if (matches==6)
                {
                    newLine();
                    newLine();
                    newLine();
                    sayln("You won! Wow, that was fun right?");
                    game=false;
                    break;
                }
                say("Type the row number for word 1: ");
                int playerRow1 = scan.nextInt();
                newLine();
                say("Type the column number for word 1: ");
                int playerColumn1 = scan.nextInt();
                GridParam playerResponse1 = new GridParam(playerRow1, playerColumn1, playerDifficulty, playerMatchSet);
                String word1=playerResponse1.gridWord();
                sayln(playerResponse1.gridWord());
                newLine();
                say("Type the row number for word 2: ");
                int playerRow2 = scan.nextInt();
                newLine();
                say("Type the column number for word 2: ");
                int playerColumn2 = scan.nextInt();
                GridParam playerResponse2 = new GridParam(playerRow2, playerColumn2, playerDifficulty, playerMatchSet);
                String word2=playerResponse2.gridWord();
                sayln(playerResponse2.gridWord());
                newLine();
                delay(500);
                if (word1.equals(word2))
                {
                    sayln("Great job!");
                    matches++;
                    seenMediumGrid[playerRow1-1][playerColumn1-1] = "✅";
                    seenMediumGrid[playerRow2-1][playerColumn2-1] = "✅";
                } else {
                    sayln("Aww, try again!");
                }
                delay(1000);
                clearScreen();
            }
        } else {
            while (game == true) // insane hard mode
            {
                for (int i = 0; i < seenHardGrid.length; i++) // prints row
                { 
                    for (int j = 0; j < seenHardGrid[i].length; j++) // prints column
                    { 
                        System.out.print(seenHardGrid[i][j] + "  ");
                    }
                    newLine();
                }
                if (matches==10)
                {
                    newLine();
                    newLine();
                    newLine();
                    sayln("YOU WON!!!!!!! How did you like it? ( ͡° ͜ʖ ͡°)");
                    game=false;
                    break;
                }
                say("Type the row number for word 1: ");
                int playerRow1 = scan.nextInt();
                newLine();
                say("Type the column number for word 1: ");
                int playerColumn1 = scan.nextInt();
                GridParam playerResponse1 = new GridParam(playerRow1, playerColumn1, playerDifficulty, playerMatchSet);
                String word1=playerResponse1.gridWord();
                sayln(playerResponse1.gridWord());
                newLine();
                say("Type the row number for word 2: ");
                int playerRow2 = scan.nextInt();
                newLine();
                say("Type the column number for word 2: ");
                int playerColumn2 = scan.nextInt();
                GridParam playerResponse2 = new GridParam(playerRow2, playerColumn2, playerDifficulty, playerMatchSet);
                String word2=playerResponse2.gridWord();
                sayln(playerResponse2.gridWord());
                newLine();
                delay(500);
                if (word1.equals(word2))
                {
                    sayln("Great job!");
                    matches++;
                    seenHardGrid[playerRow1-1][playerColumn1-1] = "✅";
                    seenHardGrid[playerRow2-1][playerColumn2-1] = "✅";
                } else {
                    sayln("Aww, try again!");
                }
                delay(1000);
                clearScreen();
            }
        }
        delay(10000);
        clearScreen();
        sayln("Thanks for playing! You can reset and play a different set if you'd like! :D");
    }
}
