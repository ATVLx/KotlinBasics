package com.vlxstudios.kotlinbasicss
import java.lang.Double.parseDouble

class GameMatrix {

    var moves:Int =0
    var gameOver : Boolean = false
    var mainPlayer : String = "X"
    var board = initMatrix()



    fun isGameOver():Boolean = gameOver
    private var receivedValue: String = "0"

   private fun initMatrix(): ArrayList<ArrayList<String>> {
       var tempBoardParentArray = ArrayList<ArrayList<String>>()

       tempBoardParentArray.add(arrayListOf("", "", ""))
       tempBoardParentArray.add(arrayListOf("", "", ""))
       tempBoardParentArray.add(arrayListOf("", "", ""))

        var count=0
        var row = -1
        var column = -1
        for (i in tempBoardParentArray) {
            row++
           // count++
            for (j in i) {
                column++
                count++
                tempBoardParentArray[row][column] = count.toString()

                }

            column = -1 //reset column when it completes
            }

            return tempBoardParentArray
        }



        fun displayMatrix() {

        for (columnArray in board) {
            for (columnVal in columnArray) {
                  print(columnVal)
                    print(" ")
                    }
                println("")
             }


        }




    fun giveValue(number:String) {



        receivedValue = number
        checkValue(mainPlayer)
        moves++
    }

    private fun checkValue(playerInitials:String) {

         var row:Int = -1
         var column:Int = -1


         for (i in board) {
            row++


            for (j in i) {


                column++


                if (receivedValue == j) {
                   //found
                    playerSwitcher()
                    board[row][column] = playerInitials
                   displayMatrix()
                    checkWinner(playerInitials)
                      return

                    }


                }
            column = -1 //reset column when it completes

         }

    }




   private fun playerSwitcher() = when (mainPlayer) {
        "X" -> mainPlayer = "O"
        "O" -> mainPlayer = "X"
        else -> mainPlayer = "X"
    }



   private fun restartGame(){
        var wrongInput:Boolean
        board = initMatrix()
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

  private fun checkWinner( playerType : String){


        if( moves >=3) {
            if (board[0][0] == playerType && board[0][1] == playerType && board[0][2] == playerType) {
                println(""); println("$playerType Player wins");  restartGame() //; gameMgr.gameOver=gameOver
            } else// upperDeck
                if (board[1][0] == playerType && board[1][1] == playerType && board[1][2] == playerType) {
                    println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                } else // middle Deck
                    if (board[2][0] == playerType && board[2][1] == playerType && board[2][2] == playerType) {
                        println(""); println("$playerType Player wins"); restartGame()//; gameMgr.gameOver=gameOver
                    } else// lower Deck
                        if (board[0][0] == playerType && board[1][1] == playerType && board[2][2] == playerType) {
                            println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                        } else// Left slash Deck
                            if (board[0][1] == playerType && board[1][1] == playerType && board[2][1] == playerType) {
                                println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                            } else// center vertical deck
                                if (board[0][2] == playerType && board[1][1] == playerType && board[2][0] == playerType) {
                                    println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                                } // Right Slash Deck
                                else// center vertical deck
                                    if (board[0][0] == playerType && board[1][0] == playerType && board[2][0] == playerType) {
                                        println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                                    }
                                    else
                                        if (board[0][2] == playerType && board[1][2] == playerType && board[2][2] == playerType) {
                                            println(""); println("$playerType Player wins");  restartGame()//; gameMgr.gameOver=gameOver
                                        }
        }

    }



}
 //class end

fun main() {



    val userGame = UserGame()
    userGame.initializeGame()
    userGame.runGame()


}

open class MainGame { // class remains closed by Default so we need to add open before class inorder to inherit

    var matrix: GameMatrix = GameMatrix()
    var gameOver : Boolean = false

    fun initializeGame()
    {
        println("Hello Players this is X and O ( TICTACTOE ) Game, made with respect to Tickled media Pvt Ltd")
        println("--------------------------------------------------------------------------------------------")
        println("")
        matrix.displayMatrix()

    }

    fun checkUserInput(inputValue:String) {  // check If it character or Integer or floating value


        var numeric = true
        try {

            val num = parseDouble(inputValue)
        } catch (e: NumberFormatException) {
            numeric = false
        }
        if (numeric)
                checkNumberProvided(inputValue)  // check Number type
        else
            println("$inputValue is not a number")


    }

    private fun checkNumberProvided( inputNumber:String   ){
        if (inputNumber.toInt() < 1 || inputNumber.toInt() >9){
            println("Please enter the valid number in available matrix")
            return
        }else {
            matrix.giveValue(inputNumber)
        }
    }
}

class  UserGame  : MainGame(){


    fun runGame() {

        gameOver = false

        while(!gameOver){
           var player = matrix.mainPlayer
                println("")
                println("Player $player's turn, Please enter the available number from the above Matrix")
                checkUserInput(readLine()!!)

                gameOver = matrix.isGameOver()

        }

    }
}




