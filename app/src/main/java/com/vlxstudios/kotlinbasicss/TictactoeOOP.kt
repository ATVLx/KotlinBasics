package com.vlxstudios.kotlinbasicss
import java.lang.Double.parseDouble

class GameMatrix {

    var moves:Int =0
    var gameOver : Boolean = false
    var displayPlayer:Boolean = true
    var mainPlayer : String = "X"
    var board = initializeBoard()
    var numeric: Boolean =true



    private fun initializeBoard(): Array<Array<String>>{
        return arrayOf(
            arrayOf("1", "2", "3"),
            arrayOf("4", "5", "6"),
            arrayOf("7","8","9")
        )
    }


    
    fun isGameOver():Boolean = gameOver
    private var receivedValue: String = "0"

    fun displayMatrix() {
        displayPlayer = true
        for (columnArray in board) {
            for (columnval in columnArray) {
                  print(columnval)
                    print(" ")
                    }
                println("")
             }


        }

    fun printPlayerStatus(){
        if(displayPlayer){
        println("    Player: $mainPlayer's Turn please Enter the valid number from given Number Matrix ")
        }
    }


    fun giveValue(number:String) {



        receivedValue = number
        checkValue(mainPlayer)
        moves++
    }

    private fun checkValue(playerInitials:String) {



         var a = receivedValue.toCharArray()
         for(i in a){
             if(i>='a'){
                 numeric =false
             }else
                 if(i <='A'){
                     numeric = true
                 }
         }



        if (receivedValue!!.toInt() < 1 || receivedValue!!.toInt() >9){
            println("Please enter the valid number in available matrix")
            return
        }
        if(numeric){

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
                    printPlayerStatus()

                   return

                }


            }
            column = -1 //reset column when it completes

            }

        }else {
            println("Please enter the valid Number")
            return
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
            displayPlayer = true
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
                println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame() //; gameMgr.gameOver=gameOver
            } else// upperDeck
                if (board[1][0] == playerType && board[1][1] == playerType && board[1][2] == playerType) {
                    println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                } else // middle Deck
                    if (board[2][0] == playerType && board[2][1] == playerType && board[2][2] == playerType) {
                        println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                    } else// lower Deck
                        if (board[0][0] == playerType && board[1][1] == playerType && board[2][2] == playerType) {
                            println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                        } else// Left slash Deck
                            if (board[0][1] == playerType && board[1][1] == playerType && board[2][1] == playerType) {
                                println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                            } else// center vertical deck
                                if (board[0][2] == playerType && board[1][1] == playerType && board[2][0] == playerType) {
                                    println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                                } // Right Slash Deck
                                else// center vertical deck
                                    if (board[0][0] == playerType && board[1][0] == playerType && board[2][0] == playerType) {
                                        println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                                    }
                                    else
                                        if (board[0][2] == playerType && board[1][2] == playerType && board[2][2] == playerType) {
                                            println(""); println("$playerType Player wins"); displayPlayer =false  ; restartGame()//; gameMgr.gameOver=gameOver
                                        }
        }

    }



}
 //class end

fun main() {


    val mainGame = MainGame()
    mainGame.initializeGame()
    mainGame.runGame()


}

open class UserInput { // class remains closed by Default so we need to add open before class inorder to inherit





         var matrix: GameMatrix = GameMatrix()


        fun getUserInput(inputNumber:String) {
             matrix.giveValue(inputNumber)
         }



    
        





}

class  MainGame  : UserInput(){


    var gameOver : Boolean = false
     private val game: GameMatrix = GameMatrix()




    var value:Int = 0
    //var winPlayer = ""
    


    fun initializeGame(){
        println("Hello Players this is X and O ( TICTACTOE ) Game, made with respect to Tickled media Pvt Ltd")
        game.displayMatrix()

    }

    fun runGame() {

        gameOver = false
        game.printPlayerStatus()
        while(!gameOver){

                getUserInput(readLine()!!)

                gameOver = matrix.isGameOver()

        }

    }
}




