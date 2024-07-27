

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game 
{
    String[][] myGrid; //the game grid is now visible to the whole program.
    int rows; //initiating variable rows in the data type integer
    int columns; //initiating variable columns in the data type integer
    String username; //initiating variable username in the data type string
    String password; //initiating variable password in the data type string
    String loginFilepath = "/Users/zoyaiza/NetBeansProjects/Connect4/logins.txt";
    String highscoreFilepath = "/Users/zoyaiza/NetBeansProjects/Connect4/scores.txt";
   //this is a constructor
   public Game()
   {
       //i am setting up the game grid in the constructor
       rows = 8; //store the value 8 inside the varieable rows which is an integer data type, this will mean there will be 8 rows for my game grid
       columns = 8; //store the value 8 inside the varieable columns which is an integer data type, this will mean there will be 8 columns for my game grid
       myGrid = new String[rows][columns];
       FillGameGrid(); //filling the empty grid with '*'
       DisplayGameGrid(); //displaying it to the user
   }

   public void FillGameGrid()
   {
       //this will create my game grid and fill it with '*'   
       for(int i = 0; i < rows; i ++) //this will loop through every row
       {   
           for (int j = 0; j < columns; j++) //this will loop through every column 
           {
               myGrid[i][j] = "*"; //this will store '*' in every element in the 2d array
           }
       }
   }
   
   private Scanner x;

   private void userLoginorRegisterChoice()
   {
       Scanner user_input = new Scanner(System.in);
       int userLoginorRegister;
       System.out.print("Please enter 1 to login, otherwise please enter 2 to create a new account:  "); 
       userLoginorRegister = user_input.nextInt(); 
       do
           if (userLoginorRegister == 1)
           {
               login();
               break;
           }
           else
           {
               register(username, password, loginFilepath);
               break;
           }
       while(userLoginorRegister != 1 || userLoginorRegister != 2);
      
   }
   
   public void login()
   {
       Scanner user_input = new Scanner(System.in);
       
       System.out.print("Please enter your username: "); //asking the player/user to enter their username
       username = user_input.nextLine(); //store the username the player/user has entered inside the variable username which is a string data type
       
        
       System.out.print("Please enter your password: "); //asking the player/user to enter their password
       password = user_input.nextLine(); //store the password the player/user has entered inside the variable password which is a string data type
       
       verifyLogin(username, password, loginFilepath);
   }
   
   public void verifyLogin(String username, String password, String filepath) //this method will take in a string username, a string password and a string filepath
   {           
       Scanner user_input = new Scanner(System.in);
       int userRegisterYorN;
       //the first string will take in the value of username, the sacond will take in the value of password and the third string will take in the value of thr filepath
       boolean found = false; //store the boolean 'false' inside the variable found which is a boolean data type. Will tell the program when the record has been found or not
       String tempUsername; //initiating variable tempUsername in the data type string
       String tempPassword; //initiating variable tempPassword in the data type string
       try
       {
           x = new Scanner(new File(filepath)); //this will read the text file
           x.useDelimiter("[,\n]"); //this will seperate each field by a comma and put a new line for each new username and password
           
           while(x.hasNext() && !found) //this while loop will loop through the file to be read
           {
               tempUsername = x.next(); //this will read the next thing and stop when there is a comma or a new line. It will store what it has read into the variable tempUsername which is a String variable type
               tempPassword = x.next(); //this will read the next thing and stop when there is a comma or a new line. It will store what it has read into the variable tempPassword which is a String variable type
               
               if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())) //.trim will remove all the spaces. This line will then check if the username they have entered is equal to the username they have registered with. The same will happen for password
               {
                   found = true; //if username and password is correct then the boolean 'true' will be stored in the variable found.
                   System.out.println("Sucesssful login!");
                   System.out.println();
                   x.close(); //this will close the file
                   break;
               }
           }
       }

       catch(Exception e) //this is to catch any logical/syntax errors 
       {
           System.out.println(e.getCause()); //instead of letting the program crash, it will just print out error
           System.out.println(e.getMessage()); 
       }
       
       if (found == false)
       {
           System.out.println("This username and password is either not registered or wrong.");
           System.out.println("You may either create a new account with the same details or try to login again");
           System.out.println();
           System.out.println("Please enter 1 to create a new account or 2 to login again: ");
           userRegisterYorN = user_input.nextInt();
           
           if (userRegisterYorN == 1)
           {
               x.close(); //this will close the file
               
               FileWriter wr;
               try 
               {
                  wr = new FileWriter(filepath, true);
                  wr.write(System.lineSeparator());
                  wr.write(username); 
                  wr.write(","); 
                  wr.write(password);
                  wr.flush();
                  wr.close(); 
               } 

               catch (IOException ex) 
               {
                   System.out.println(ex.getMessage());
               }
           }
           
           else
           {
               login();
               x.close(); //this will close the file
           }
           
           System.out.println("Account created!");
       }
   }
   
   public void register(String registerUsername, String registerPassword, String filepath)
   {
       Scanner user_input = new Scanner(System.in);
       
       System.out.print("Please enter a username: "); //asking the player/user to enter their username
       registerUsername = user_input.nextLine(); //store the username the player/user has entered inside the variable username which is a string data type
       username = registerUsername;
        
       System.out.print("Please enter a password: "); //asking the player/user to enter their password
       registerPassword = user_input.nextLine(); //store the password the player/user has entered inside the variable password which is a string data type
       password = registerPassword;
       
       FileWriter wr;
       try 
       {
          wr = new FileWriter(filepath, true);
          wr.write(System.lineSeparator());
          wr.write(registerUsername); 
          wr.write(","); 
          wr.write(registerPassword);
          wr.flush();
          wr.close(); 
          System.out.println("Account created!");
       }
        
       catch (IOException ex) 
       {
           System.out.println(ex.getMessage());
       }
       
       
   }
   
   public void RunProgram()
   {
       
       userLoginorRegisterChoice();
       int difficultyLevel = 0;
       Scanner userChoice = new Scanner(System.in);
    
       System.out.println("Hello " + username + "! Welcome to connect 4"); //welcome the player with their name
       
       String play; //initiating variable play in the data type string

       do //using a do while loop to make sure this loop runs at least once
       {
           System.out.print("\nPlease enter 'r' if you would like to read the rules.\n"
               + "Please enter 'l' if you would like to view the leaderboard.\n"
               + "Please press enter if you would like to play the game.\n"
               + "Enter here: ");//asking the players to enter "r" for rules, "c" for commands or press enter to continue playing the game
           
           play = userChoice.nextLine(); //store the users input inside the variable play which is a string data type
           
           
           //for the next few lines, i use selective statements to allow the program to correctly call the appropriate function
           if (play.equals("r")) //if statement states if the value stored inside the variable play (which is a data type string) is equal to the string 'r' then
           {
               DisplayRules(); //call the function 'DisplayRules()
           }
           
           else if (play.equals("l")) //else if statement states if the value stored inside the variable play (which is a data type string) is equal to the string 'c' then
           {
               DisplayLeaderBoard(); //call the function 'DisplayCommands()
           }
           
           else if (play.equals("")) //else if statement states if the value stored inside the variable play (which is a data type string) is equal to the string '' then
           {
               difficultyLevel = chooseDifficultyLevel();
               PlayGame(difficultyLevel, 0, 0); //call the function 'PlayGame()
           }
           
           else //else if none of the above if statements work then
           {
           System.out.print("\nPlease enter 'r' if you would like to read the rules.\n"
               + "Please enter 'l' if you would like to view the leaderboard.\n"
               + "Please press enter if you would like to play the game.\n"
               + "Enter here: "); //the first message will be printed out again hence the users will be forced to enter something valid else they will keep on seeing this message
           }

       }while(!"".equals(play)); //part of the do while loop, the user/player will only be able to break out of the loop if they decide to press enter to play the game
        
   }
   
   public void DisplayRules()
   {
       System.out.println("\nThe rules: "); //this is a print statement
       System.out.println("The objective of the game is to connect 4 of your tokens together in a 10 by 10 grid.\n"
           + "You will also have to stop the computer from connecting 4 tokens together.\n"
           + "You can connect them either vertically, horrizontally or diagonally.\n"
           + "The player will be playing against the computer and will have the ability to choose whether they want the game mode to be easy, medium or hard."); //this is a print statement which tells the users the rules of the game
       System.out.println("\nThe commands: "); //this is a print statement
       System.out.println("You will need to enter the number of the  column you want to enter your token in."); //this is a print statement which tells the users the commands of the game
   }
   
   public void DisplayLeaderBoard()
   {
       System.out.println();
       System.out.println("leaderboard");
       
       
       File directory = new File(highscoreFilepath);
       try
       {   
           Scanner s = new Scanner(new File("scores.txt"));
           ArrayList<String[]> list = new ArrayList<String[]>();
           while (s.hasNext())
           {
               String t = s.next();
               String[] temp = t.split(",");
               
               list.add(temp);
           }
           s.close();
           
           //sort by the value at element[0]  
           for(int i = 0; i > list.size()-1; i++)
           {
               String[] check1 = list.get(i);
               String[] check2 = list.get(i+1);
               
               //swaapping around if the score on the bottom is greater than the top
               if (Integer.parseInt(check1[0]) > Integer.parseInt(check2[0]))
               {
                   String[] temp = check1;
                   list.set(i, check2);
                   list.set(i+1, temp);
                     i++;
               }
           }
           
           
           System.out.println("SCORE - NAME ");
           for(String[] x : list)
           {
               System.out.print(x[0]);
               System.out.print(" - ");
               System.out.print(x[1]);
               System.out.println();
           }
           
       }
       catch(Exception ex)
       {
           System.out.println(ex.getMessage());
       }
   }
    
   private void PlayGame(int difficultyLevel, int userScoreCount, int compScoreCount) 
   {
       int compRowLocation = 0;
       int playerRowLocation = 0; //store the value '0' inside the variable rowlocation which is an integer data type 
       String playAgain;
       
       
       boolean connect4; //initiating variable connect4 in the data type boolean
       connect4 = false; //store the boolean 'false' inside the variable connect4 which is a boolean data type
       do //using a do while loop to make sure this loop runs at least once
       {

           boolean isUser = true; //store the boolean 'true' inside the variable isUser which is a boolean data type

           
           playerRowLocation = ChoosePositionNew(true); //getting the users position
           
           boolean validMove = false; //store the boolean 'false' inside the variable validMove which is a boolean data type
           
           do //using a do while loop to make sure this loop runs at least once
           {
              validMove = PlaceCounter(playerRowLocation, "X", true); //the function PlaceCounter with the following parameters will be stored in the variable validMove ****
              
              if(validMove == false) //this selective statement states if the boolean validMove is equal to 'false' then 
              {
                  System.out.println("this is not a valid move. The column is full."); //this print statement will state the move isnt valid as the column is full
                  playerRowLocation = ChoosePositionNew(true);                                   
              }
              
           }while (validMove == false);

           
           //get the computer random number  
          compRowLocation = ChoosePositionNew(false);
           if (difficultyLevel == 1)
           {
               compRowLocation = ChooseEasyPosition();
           }
           else if (difficultyLevel == 2)
           {
               compRowLocation = ChooseMediumPosition(playerRowLocation);
           }
           else
           {
               compRowLocation = ChooseDifficultPosition();
           }
           PlaceCounter(compRowLocation, "O", false);

           connect4 = CheckFourInARow("X");

       if (connect4 == true)
           {
               System.out.println("Well done you won this round");
               //in here i want to add a score to the user hence in the text file there should be score for each username
               
               userScoreCount+= 1;               
               if (userScoreCount >= 1)
               {
                   System.out.println("Your score is " + userScoreCount);  
                   System.out.println("The computers score is " + compScoreCount);  
                   System.out.println("Well done you won connect 4");
                   
                   Scanner user_input = new Scanner(System.in);
       
                   System.out.print("would you like to play again, please enter yes or no: "); //asking the player/user to enter their username
                   playAgain = user_input.nextLine(); //store the username the player/user has entered inside the variable username which is a string data type
                   
                   
                   if (playAgain.equals("yes"))
                   {
                       FillGameGrid();
                       difficultyLevel = chooseDifficultyLevel();
                       PlayGame(difficultyLevel, userScoreCount, compScoreCount);
                   }
                   else
                   {
                       System.out.print("Saving your scores to file");
                       //writes to file
                       FileWriter wr;
                       try 
                       {
                          wr = new FileWriter(highscoreFilepath, true);
                          wr.write(System.lineSeparator());
                          wr.write(username); 
                          wr.write(","); 
                          wr.write(Integer.toString(userScoreCount));
                          wr.flush();
                          wr.close(); 
                       } 

                       catch (IOException ex) 
                       {
                           System.out.println(ex.getMessage());
                       }
                       break;
                   }    
               }    
           }
           
           else
           {
               connect4 = CheckFourInARow("O");
               if (connect4 == true)
               {
                   System.out.println("You lost this round");
                   compScoreCount += 1;
                   if (userScoreCount == 3)
                   {
                       System.out.println("Your score is " + userScoreCount);  
                       System.out.println("The computers score is " + compScoreCount);  
                      
                       System.out.println("You lost connect 4");
                       break;
                   }
                   else
                   {
                       PlayGame(difficultyLevel, userScoreCount, compScoreCount);
                   }
               }
           }
           
           //reset
           isUser = false;

          // reset

           isUser = true;
            
           //CheckFourInARow();
       }while(connect4 == false);
       
   }

   private boolean CheckFourInARow(String counter)
   {
       boolean connect4 = false;

       connect4 = CheckNInARowHorizontal(counter, 4);
    
       if(connect4==false)
       {
           connect4 = CheckNInARowVertical(counter, 4);
           
           if (connect4 == false)
           {
               connect4 = CheckNInARowDiagonalLeft(counter, 4);
               
               if (connect4 == false)
               {
                   connect4 = CheckNInARowDiagonalRight(counter, 4);
               }
           } 
       }
       return connect4;
   }
   
   private boolean CheckNInARowVertical(String counter, int check)
   {
       boolean connect4 = false;
       for (int rows = 7; rows >= 3; rows --) //this will loop through every row
       {  
           for (int columns = 0; columns <= 7 ; columns++) //this will loop through every column  
           {
               int userCounter = 0;   
               int compCounter = 0;  
               String targetCell = myGrid[rows][columns];
               
               if(targetCell.contains(counter))
               {
                   userCounter += 1;
                   int checkRow = rows-1;
                   
                   for (int k = 0; k < check; k ++)
                   {
                       String checkCell = myGrid[checkRow][columns];
                       if(checkCell == targetCell)
                       {
                           userCounter += 1;
                           if (userCounter == 4)
                           {
                               connect4 = true;
                               break;
                           }
                           checkRow --;
                       }
                   }
               }
           }
       }
       return connect4;
   }
   
   private boolean CheckNInARowHorizontalBlockMedium(String counter)
   {
       boolean blocked = false;
       
       for (int rows = 7; rows >= 0; rows --) //this will loop through every row
       {  
           for (int columns = 7; columns >=  1; columns--) //this will loop through every column  
           {
               int userCounter = 0;   
               int compCounter = 0;  
               String targetCell = myGrid[rows][columns];
               
               if(targetCell.contains(counter))
               {
                   userCounter += 1;
                   int checkColumns = columns-1;
                   
                   for (int k = 0; k < 2; k ++)
                   {
                       String checkCell = myGrid[rows][checkColumns];
                       if(checkCell == targetCell)
                       {
                           userCounter += 1;
                           if (userCounter == 2)
                           {
                               blocked = true;
                               break;
                           }
                           checkColumns --;
                       }
                   }
               }
           }
       }
       return blocked;
   }
    
   private boolean CheckNInARowHorizontal(String counter, int check)
   {
       boolean connect4 = false;
       
       for (int rows = 7; rows >= 0; rows --) //this will loop through every row
       {  
           for (int columns = 7; columns >= 3; columns--) //this will loop through every column  
           {
               int userCounter = 0;   
               int compCounter = 0;  
               String targetCell = myGrid[rows][columns];
               
               if(targetCell.contains(counter))
               {
                   userCounter += 1;
                   int checkColumns = columns-1;
                   
                   for (int k = 0; k < check; k ++)
                   {
                       String checkCell = myGrid[rows][checkColumns];
                       if(checkCell == targetCell)
                       {
                           userCounter += 1;
                           if (userCounter == 4)
                           {
                               connect4 = true;
                               break;
                           }
                           checkColumns --;
                       }
                   }
               }
           }
       }
       return connect4;
   }

   private boolean CheckNInARowDiagonalLeft(String counter, int check)
   {
       boolean connect4 = false;
       for (int rows = 7; rows >= 3; rows --) //this will loop through every row
       {
           for (int columns = 7; columns >= 3; columns--) //this will loop through every column
           {
               //checks every cell in your grid.
               int userCounter = 0;   
               int compCounter = 0;   
               String targetCell = myGrid[rows][columns]; 
               
               if(targetCell.contains(counter))
               {
                   //add one to the counter
                   userCounter += 1;
                   //get the next cell up diagonally to the left
                   int checkRow = rows-1;
                   int checkColumn = columns-1;   
                   
                   for (int k = 0; k < 4; k ++)
                   {   
                       //get the next cell
                       String checkCell = myGrid[checkRow][checkColumn];
                       
                       //check the contents of the cell
                       if(checkCell == targetCell)
                       {
                           userCounter += 1;
                           if (userCounter == 4)
                           {
                               connect4 = true;
                               break;
                           }
                           //take one off the check co-ordinates in the loop.
                           checkRow --;
                           checkColumn --;
                       }
                       else
                       {
                           //if you only have 2 or 3 in a row
                           //this will stop the code from looping through all 4
                           //this makes the code efficient.
                           break;
                       }    
                   }      
               }
           }
       }
       return connect4;
   }

   private boolean CheckNInARowDiagonalRight(String counter, int check)
   {
       boolean connect4 = false;
       for (int rows = 7; rows >= 3; rows --) //this will loop through every row
       {
           for (int columns = 0; columns <=4 ; columns++) //this will loop through every column  
           {
               int userCounter = 0;   
               int compCounter = 0;    
               String targetCell = myGrid[rows][columns]; 
               if(targetCell.contains(counter))
               {
                   //add one to the counter
                   userCounter += 1;
                   //get the next cell up diagonally to the right
                   int checkRow = rows-1;
                   int checkColumn = columns+1;   
                   
                   for (int k = 0; k < 4; k ++)
                   {   
                       //get the next cell
                       String checkCell = myGrid[checkRow][checkColumn];
                       
                       //check the contents of the cell
                       if(checkCell == targetCell)
                       {
                           userCounter += 1;
                           if (userCounter == 4)
                           {
                               connect4 = true;
                               break;
                           }
                           //take one off the check co-ordinates in the loop.
                           checkRow --;
                           checkColumn ++;
                       }
                       else
                       {
                           //if you only have 2 or 3 in a row
                           //this will stop the code from looping through all 4
                           //this makes the code efficient.
                           break;
                       } 
                   } 
               }
           }     
       }
       return connect4;
   }
    
   private void DisplayGameGrid() // this will create my game grid        
   {
       System.out.println("| 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |"); //this is a print statement which will be shown above the grid to let the user know the number of each column
       System.out.println("---------------------------------"); //this is a print statement
       for(int i = 0; i < rows; i ++) //this will loop through every row
       {   
           for (int j = 0; j < columns; j++) //this will loop through every column 
           {
               System.out.print("| "+myGrid[i][j] + " "); //this will print out | to create the grid and the 2d array
           }
           System.out.println(); //after the row is done it will go on a new line so it can create a new row on the next line
       }
       System.out.println("---------------------------------"); //this is a print statement
   }
   
   public int ChoosePositionNew(boolean isUser)
   {
       int level = 0;
       int input = 0; //storing the value 0 inside the variable input which is an integer data type
       if(isUser == true) //selective statement, it will only run if the users turn is true
       {          
           boolean validNumber = false; //storing the boolean false inside the variable validNumber which is a datatype boolean
           System.out.println(""); //print statement
           System.out.print("Please enter a position 1 to 8: "); //print statement asking the users to enter a position

           do //using a do while loop to make sure this loop runs at least once
           {
               input = CheckInputNumberIsValid(); //storing the return statement from the checkinputisvalid function inside the variable input which is an integer data type
               //this deals with non-numeric inputs       
               if(input == -1) //selective statement, the follwoing will run if the variable input is equal to -1
               {
                   System.out.print("Please enter a whole number 1 to 8: "); //print statement asking the users to enter a valid a position
                   validNumber = false; //storing the boolean false inside the variable validNumber which is a datatype boolean
               }
               else if ((input < 1) || (input > columns)) //checks for numbers outside of the range.
               {
                   System.out.print("You must enter a between 1 to 8: "); //print statement asking the users to enter a valid a position
                   validNumber = false; //storing the boolean false inside the variable validNumber which is a datatype boolean
               }
               else //selective statement, otherwise run this
               {
                   validNumber = true; //storing the boolean true inside the variable validNumber which is a datatype boolean
               }
           }while (validNumber == false); //keep running this do while statement if the variable validNumber has the boolean flase stored inside of it
       }
       return input; // return whatever value the variable input has stored inside of it
   }
     
   public int chooseDifficultyLevel()
   {
       
       int level_choice = 0;
       Scanner levelChoice = new Scanner(System.in);
       do
       {
           System.out.print("Please enter '1' for easy mode, '2' for medium mode or '3' for difficult mode: "); //asking the player/user to enter their name
           level_choice = levelChoice.nextInt(); 
           
       }while(level_choice < 0 || level_choice > 3);
       
       return level_choice;
   } 
   
   private int ChooseEasyPosition()
   {
           int CompInput = 0;
           Random rand = new Random(); //this is to allow the program to generate a random number
           CompInput = rand.nextInt(8)+1; //a random number from 1 to 8 will be generated for the computer. This is for easy mode
           do
           {
               CompInput = rand.nextInt(8)+1;
           }while (rand.equals(CompInput));  
           
           return CompInput;
   }

   private int ChooseMediumPosition(int playerLocation)
   {
           boolean verticalBlock = false;
           boolean horizontalBlock = false;
           boolean diagonalLeftBlock = false;
           boolean diagonalRightBlock = false;
           
           String[][] blockedList;
           int row; 
           int column;
           row = 0;
           column = 0;
           blockedList = new String[row][column];

           
           
           int CompInput = 1;
           horizontalBlock = CheckNInARowHorizontalBlockMedium("X");
           if (horizontalBlock == true)
           {
               CompInput = playerLocation+1;
               horizontalBlock = false;
           }
           
           else
           {
//               verticalBlock = CheckNInARowVertical("X", 1);
//               if (verticalBlock == true)
//               {
                   CompInput = playerLocation;
//               }   
           }
           

       return CompInput;
   }
   
   private int ChooseDifficultPosition()
   {
       return 0;
   }
       
   private int CheckInputNumberIsValid()
   {
       Scanner user_input = new Scanner(System.in); 
       int UserNumber = -1; //setting a number to -1

       try
       {
          UserNumber = user_input.nextInt(); //try to get the input
       }
       
       catch(Exception e)
       {
           UserNumber = -1; //if anything goes wrong, leave the number at -1
       }
       return UserNumber; //return it to the calling code.
   }
   
   private boolean PlaceCounter(int colNumber, String counter, boolean isUser)
   {
       boolean validMove = false; //storing the boolean false inside the variable validMove which is a datatype boolean

       for (int i = rows-1; i >= 0; i --) //iterative statement, this will loop through every row
       {
           String targetCell = myGrid[i][colNumber-1]; //the position the user has entered will be stored in the variable targetCell which is a string datatype 
           if (targetCell.contains("*")) //selective statement, if position on the grid of where the user has chosen has a "*" then execute the following line
           {
               myGrid[i][colNumber-1] = counter; //the position the user has entered will be stored in the position of myGrid[i][colNumber-1]
               System.out.println(); //print statement
               
               int Column = colNumber; //store the value of colNumber inside the variable Column which is an integer datatype
               int Row = i+1; //store the value of i+1 inside the variable Row which is an integer datatype
               if (isUser == true) //selective statement, if the variable isUser is equal true then execute the following
               {
                   System.out.println(); //print statement
                   System.out.println("You dropped your token in column: " + Column); //print statement, tells the user in what column they have dropped their token in
                   System.out.println("You dropped your token in row: " + Row); //print statement, tells the user on what row their token has landed on
                   System.out.println(); //print statement
               }
               
               else
               {
                   System.out.println(); //print statement
                   System.out.println("The computer placed it's token in column: " + Column); //print statement, tells the user in what column the computer has dropped its token in
                   System.out.println("The computer placed it's token in row: " + Row); //print statement, tells the user on what row the computer's token has landed on
                   System.out.println(); //print statement
               }
               validMove = true; //store the boolean true inside the variable validMove which is a dataype boolean
               break; //break out of the statement
           }

           if (i == 0) //selective statement, if i is equal to 0 then
           {
               if (!targetCell.contains("*")) //selective statement, if the position does not contain a "*" then
               {
                   System.out.println("Column is full"); //print statement, tells the user the column is full
                   validMove = false; //storing the boolean false inside the variable validMove which is a datatype boolean
                   break; //break out of the statement
               }
           }   
       }
       DisplayGameGrid(); //call the function DisplayGameGrid
       return validMove; //return the value of validMove
   }
}







