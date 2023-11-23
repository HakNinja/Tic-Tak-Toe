// import Scanner class for input data from keyboard
import java.util.Scanner;
// class name TTT
class TTT{
    // Scanner object :- sign
    Scanner sign=new Scanner(System.in);
    // store player's name
    String []Players=new String[2];
    // store player input as 'X' or '0'
    char []P=new char[2];
    //  print table of tic tac toe as a array with some values as position
    char []arr={'1','2','3','4','5','6','7','8','9'}; 

    // welcome function for welcoming players into the games
    void Welcome(){
        System.out.println("\n\n\t----------------------WELCOME---------------------\n"); 
        System.out.println("\t-----------------TIC TAC TOE GAMES----------------\n\n"); 
        }
    
        // called when user input invalid input
    void WrongInput(){
        System.out.println("\n\tWrong Choice....Try again!!!\n");
        }
    
        //start the game function
    int StartGame(){
        System.out.println("\n\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\n\tWHO WANT TO START THE GAMES FIRST:");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        // called Choice function
        Choice();
        int UserEnter=sign.nextInt();
        if(UserEnter==1)
            return 0;
        else if(UserEnter==2)
            return 1;
        else{
            WrongInput();
            return(StartGame());
            }
        }

        // input (user or player)'s name 
    void Info(){
        System.out.print("\tPlease Entered Player 1\'s name:");
        Players[0]=sign.next();
        System.out.print("\tPlease Entered Player 2\'s name:");
        Players[1]=sign.next();
        }

        // Choice from some set of information
    void Choice(){
        System.out.println("\n\t\t1. "+Players[0]);
        System.out.println("\t\t2. "+Players[1]);
        System.out.print("\n\tEnter 1 or 2:-");
        }

        // display players choices 
    void Choose(){
        System.out.println("\t\t"+Players[0]+" choose \""+P[0]+"\" and "+Players[1]+" choose \""+P[1]+"\"");
        }

        // called when player have to choose the symbols
    void ChoiceSymbol(){
        System.out.println("\n\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\tWHO WANT TO CHOICE SYMBOL");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        Choice();
        int UserEnter=sign.nextInt();
        if(!(UserEnter==1 || UserEnter==2)){
            WrongInput();
            ChoiceSymbol();
            }
            
        System.out.println("\n\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\t"+Players[UserEnter-1]+", ENTER YOUR SYMBOL =>");
        System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\n\t\t1. X");
        
        System.out.println("\t\t2. 0");
        System.out.print("\n\tEnter 1 or 2:-");
        int UserEnterSymbol=sign.nextInt();
        if((UserEnterSymbol==1 && UserEnter==1) || (UserEnterSymbol==2 && UserEnter==2 )){
            P[0]='X';
            P[1]='0';
            }
        else if((UserEnterSymbol==2 && UserEnter==1) || (UserEnterSymbol==1 && UserEnter==2)){
            P[0]='0';
            P[1]='X';
            }
        else{
            WrongInput();
            //call itself if wrong input is entered by the user
            ChoiceSymbol();
            }
        Choose();
    }
    
    // display the table update 
    void Display(){
        System.out.println("\n\n\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\tPlease remember the following positions\n");
        System.out.println("\t\t "+arr[0]+" | "+arr[1]+" | "+arr[2]);
        System.out.println("\t\t---+---+---");
        System.out.println("\t\t "+arr[3]+" | "+arr[4]+" | "+arr[5]);
        System.out.println("\t\t---+---+---");
        System.out.println("\t\t "+arr[6]+" | "+arr[7]+" | "+arr[8]);
    }

    // check user position as they entered valid-input or not 
    int checkpos(int pos){
        if((pos>=0 && pos<=8) &&(!(arr[pos]=='X' || arr[pos]=='0')))
                return 0;
        else
            return 1;
    }

    // here the actual code of game that how the game works
    void PlayGame(int Player){
        int playerChance=0;
        // loop as how many time they input or change the position
        while(playerChance<9){
            Display();
            int pos=100;
            int solve=0;
            ch_label:
            // solve = 0 as the they continue the game till the end
            while(solve==0){
                System.out.print("\n\n\t"+Players[Player]+", Enter position:");
                pos=sign.nextInt();
                int invalid=checkpos(pos-1);
                solve=0;
                if(invalid==1){
                System.out.println("\n\tCan\'t change the position again!!!\n\tChoose another left position \n\t\tother than position contain \'0\' and \'X\'\n\n");
                Display();
                continue ch_label;
                }
                solve=1;
            }
            // initial value change by user choice as position
            arr[pos-1]=P[Player];
            winner();
            if(Player==1)
                Player=0;
            else
                Player=1;
            playerChance++;
            }
            System.out.println("Tie");
        }

    int winCheck(){
        if((arr[0]==P[0] && arr[1]==P[0] && arr[2]==P[0]) || (arr[3]==P[0] && arr[4]==P[0] && arr[5]==P[0]) || (arr[6]==P[0] && arr[7]==P[0] && arr[8]==P[0]) || (arr[0]==P[0] && arr[4]==P[0] && arr[8]==P[0]) || (arr[2]==P[0] && arr[4]==P[0] && arr[6]==P[0]) || (arr[0]==P[0] && arr[3]==P[0] && arr[6]==P[0]) || (arr[1]==P[0] && arr[4]==P[0] && arr[7]==P[0]) || (arr[2]==P[0] && arr[5]==P[0] && arr[8]==P[0]))
            return 0;
        else if((arr[0]==P[1] && arr[1]==P[1] && arr[2]==P[1]) || (arr[3]==P[1] && arr[4]==P[1] && arr[5]==P[1]) || (arr[6]==P[1] && arr[7]==P[1] && arr[8]==P[1]) || (arr[0]==P[1] && arr[4]==P[1] && arr[8]==P[1]) || (arr[2]==P[1] && arr[4]==P[1] && arr[6]==P[1]) || (arr[0]==P[1] && arr[3]==P[1] && arr[6]==P[1]) || (arr[1]==P[1] && arr[4]==P[1] && arr[7]==P[1]) || (arr[2]==P[1] && arr[5]==P[1] && arr[8]==P[1]))
            return 1;
        else
            return 100;
        }


    void winner(){
        int w=winCheck();
        if (w==0 || w==1)
            {   Display();
                System.out.println("\n\t\t"+Players[w]+" is the winner!!!\n\t\t-----GAME OVER-----");
                System.exit(0);
                }
    }
    //main function 
    public static void main(final String[] args) {
            // TTT class object is GameObject, allow to called TTT instance function 
        TTT GameObject=new TTT();
        GameObject.Welcome();
        GameObject.Info();
        GameObject.ChoiceSymbol();
        GameObject.PlayGame(GameObject.StartGame());
        GameObject.Display();
        // game end 
        }
    }