package com.vlxstudios.kotlinbasicss

class GameMatrix {

    var moves:Int =0
    var gameOver : Boolean = false
    var printed:Boolean= false
    var mainPlayer : String = "X"
    var board: Array<Array<String>> = arrayOf(
         arrayOf("1", "2", "3"),
         arrayOf("4", "5", "6"),
        arrayOf("7","8","9")
     )
   


    
    fun isGameOver():Boolean = gameOver
    private var receivedValue: Int? = 0

    fun displayMatrix() {

        for (columnArray in board) {
            for (columnval in columnArray) {
                  print(columnval)
                print(" ")
                }
            println("")
            }

        }


    fun giveValue(number: Int) {
        receivedValue = number
        println("REcived number is : $number")
       checkValue(mainPlayer)

        moves++
    }

    private fun checkValue(playerInitials:String) {

         var row:Int = -1
         var column:Int = -1
         printed = false
         for (i in board) {
            row++
            for (j in i) {
                column++


                if (receivedValue.toString() == j) {
                   //found
                    board[row][column] = playerInitials
                   displayMatrix()
                    playerSwitcher()

                   return

                } else {
                    if(!printed){
                        println("Please enter into Another space")
                        printed = true
                       // playerSwitcher()
                    }

                     }

            }
            column = -1 //reset column when it completes



        }






        }

    fun playerSwitcher() = when (mainPlayer) {
        "X" -> mainPlayer = "O"
        "O" -> mainPlayer = "X"
        else -> mainPlayer = "X"
    }

     fun checkWinner( ){

        println("Moves $moves")
        if( moves >=3) {
            if (board[0][0] == "X" && board[0][1] == "X" && board[0][2] == "X") {
                print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
            } else// upperDeck
                if (board[1][0] == "X" && board[1][1] == "X" && board[1][2] == "X") {
                    print(" Player win") ; gameOver=true;// gameMgr.gameOver=gameOver
                } else // middle Deck
                    if (board[2][0] == "X" && board[2][1] == "X" && board[2][2] == "X") {
                        print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                    } else// lower Deck
                        if (board[0][0] == "X" && board[1][1] == "X" && board[2][2] == "X") {
                            print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                        } else// Left slash Deck
                            if (board[0][1] == "X" && board[1][1] == "X" && board[2][1] == "X") {
                                print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                            } else// center vertical deck
                                if (board[0][2] == "X" && board[1][1] == "X" && board[2][0] == "X") {
                                    print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                                } // Right Slash Deck
                                else// center vertical deck
                                    if (board[0][0] == "X" && board[1][0] == "X" && board[2][0] == "X") {
                                        print(" Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                                    }
        }

        if( moves >=3) {
            if (board[0][0] == "O" && board[0][1] == "O" && board[0][2] == "O") {
                print("O Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
            } else// upperDeck
                if (board[1][0] == "O" && board[1][1] == "O" && board[1][2] == "O") {
                    print(" O Player win") ; gameOver=true;// gameMgr.gameOver=gameOver
                } else // middle Deck
                    if (board[2][0] == "O" && board[2][1] == "O" && board[2][2] == "O") {
                        print("O Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                    } else// lower Deck
                        if (board[0][0] == "O" && board[1][1] == "O" && board[2][2] == "O") {
                            print(" O Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                        } else// Left slash Deck
                            if (board[0][1] == "O" && board[1][1] == "O" && board[2][1] == "O") {
                                print(" O Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                            } else// center vertical deck
                                if (board[0][2] == "O" && board[1][1] == "O" && board[2][0] == "O") {
                                    print(" O Player win") ; gameOver=true ; //gameMgr.gameOver=gameOver
                                } // Right Slash Deck
        }
    }



}
 //class end

fun main() {


    var maingame:MainGame = MainGame()
    maingame.initializeGame()
    maingame.runGame()


    var userInputProvider: UserInput = UserInput()
    userInputProvider.giveValueToMatrix()


}

open class UserInput { // class remains closed by Default so we need to add open before class inorder to inherit

    private var userInput:Int


    init {

        userInput = 0
    }
    var matrix: GameMatrix = GameMatrix()
        fun getUserInput(inputNumber:Int) {

            userInput = inputNumber


         }


         fun giveValueToMatrix() {
             matrix.giveValue(userInput.toInt())
        }
    
        





}

class  MainGame  : UserInput(){


    var gameOver : Boolean = false
    var game: GameMatrix = GameMatrix()
    var playerMain = game.mainPlayer

    var value:Int = 0
    //var winPlayer = ""
    


    fun initializeGame(){
        println("Hello Players this is X and O ( TICTACTOE ) Game, made with respect to Tickled media Pvt Ltd")
        game.displayMatrix()

    }








    fun runGame() {

        gameOver = false
        while(!gameOver){

                playerMain = game.mainPlayer
                println("Player: $playerMain's Turn please Enter the valid number from given Number Matrix ")
                getUserInput(readLine()!!.toInt())
                game.playerSwitcher()
                giveValueToMatrix()
                matrix.checkWinner()
                gameOver = matrix.isGameOver()





        }

    }
}




