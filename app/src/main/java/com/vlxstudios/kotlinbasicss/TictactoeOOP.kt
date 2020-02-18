package com.vlxstudios.kotlinbasicss

class GameMatrix {

    var moves:Int =0
    var gameOver : Boolean = false
    var printed:Boolean= false
    var mainPlayer : String = "X"
    var board = initializeBoard()


    private fun initializeBoard(): Array<Array<String>>{
        return arrayOf(
            arrayOf("1", "2", "3"),
            arrayOf("4", "5", "6"),
            arrayOf("7","8","9")
        )
    }


    
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

   private fun restartGame(){
        var wrongInput:Boolean
        board = initializeBoard()
        println("Do you want to Restart the Game? Y/N")
        var value = readLine()
        if(value == "y" || value == "Y"){
            displayMatrix()
            mainPlayer = "X"
        }
        else if(value == "n" || value == "N"){
            println("Thankyou for playing")
            println("Code by Vishal Lakhani")
            gameOver = true
        } else {
            wrongInput = true
            while(wrongInput){
                println("Please Enter the Correct Value in 'Y' or 'N'")
                value = readLine()
                if(value == "y" || value == "Y"){
                    //displayMatrix()
                    wrongInput = false
                }
                else if(value == "n" || value == "N"){
                    gameOver = true
            }

        }

        }
    }

     fun checkWinner( playerType : String){


        if( moves >=3) {
            if (board[0][0] == playerType && board[0][1] == playerType && board[0][2] == playerType) {
                println(""); println("$playerType Player wins")  ; restartGame() //; gameMgr.gameOver=gameOver
            } else// upperDeck
                if (board[1][0] == playerType && board[1][1] == playerType && board[1][2] == playerType) {
                    println("");  println("$playerType Player wins")  ; restartGame()//; gameMgr.gameOver=gameOver
                } else // middle Deck
                    if (board[2][0] == playerType && board[2][1] == playerType && board[2][2] == playerType) {
                        println("");  println("$playerType Player wins")  ; restartGame()//; gameMgr.gameOver=gameOver
                    } else// lower Deck
                        if (board[0][0] == playerType && board[1][1] == playerType && board[2][2] == playerType) {
                            println("");  println("$playerType Player wins") ; restartGame()//; gameMgr.gameOver=gameOver
                        } else// Left slash Deck
                            if (board[0][1] == playerType && board[1][1] == playerType && board[2][1] == playerType) {
                                println(""); println("$playerType Player wins")  ; restartGame()//; gameMgr.gameOver=gameOver
                            } else// center vertical deck
                                if (board[0][2] == playerType && board[1][1] == playerType && board[2][0] == playerType) {
                                    println(""); println("$playerType Player wins")  ; restartGame()//; gameMgr.gameOver=gameOver
                                } // Right Slash Deck
                                else// center vertical deck
                                    if (board[0][0] == playerType && board[1][0] == playerType && board[2][0] == playerType) {
                                        println(""); println("$playerType Player wins")  ;  restartGame()//; gameMgr.gameOver=gameOver
                                    }
                                    else
                                        if (board[0][2] == playerType && board[1][2] == playerType && board[2][2] == playerType) {
                                            println(""); println("$playerType Player wins")  ; restartGame()//; gameMgr.gameOver=gameOver
                                        }
        }

    }



}
 //class end

fun main() {


    val mainGame = MainGame()
    mainGame.initializeGame()
    mainGame.runGame()


  //  var userInputProvider: UserInput = UserInput()
   // userInputProvider.giveValueToMatrix()


}

open class UserInput { // class remains closed by Default so we need to add open before class inorder to inherit





         var matrix: GameMatrix = GameMatrix()


        fun getUserInput(inputNumber:Int) {
             matrix.giveValue(inputNumber)
         }



    
        





}

class  MainGame  : UserInput(){


    var gameOver : Boolean = false
    var game: GameMatrix = GameMatrix()
    var playerName = game.mainPlayer


    var value:Int = 0
    //var winPlayer = ""
    


    fun initializeGame(){
        println("Hello Players this is X and O ( TICTACTOE ) Game, made with respect to Tickled media Pvt Ltd")
        game.displayMatrix()

    }

    fun runGame() {

        gameOver = false
        while(!gameOver){

                playerName = game.mainPlayer
                println("    Player: $playerName's Turn please Enter the valid number from given Number Matrix ")
                getUserInput(readLine()!!.toInt())
                game.playerSwitcher()
                matrix.checkWinner(playerName)
                gameOver = matrix.isGameOver()





        }

    }
}




