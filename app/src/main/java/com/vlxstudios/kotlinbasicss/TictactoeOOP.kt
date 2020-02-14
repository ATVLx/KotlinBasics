package com.vlxstudios.kotlinbasicss

class GameMatrix {


  var board: Array<Array<String>> = arrayOf(
      arrayOf("1", "2", "3"),
      arrayOf("4", "5", "6"),
      arrayOf("7","8","9")
  )


    var recivedValue: Int? = 0
    var printed: Boolean = false



    fun placeElements(row:Int,col:Int,value:Int){
        board[row][col] = value.toString()
    }

    fun displayMatrix() {

        for (columnArray in board) {
            for (columnval in columnArray) {
                  print(columnval)
                print(" ")
                }
            println("")
            }

        }


    fun giveValue(number: Int, playerType:String) {
        recivedValue = number
        println("REcived number is : $number")
       checkValue(playerType)
    }

    fun checkValue(playerInitials:String) {

        var row:Int = -1
        var column:Int = -1
        printed = false
        for (i in board) {

            row++
            for (j in i) {
                column++
                if (recivedValue == j.toInt()) {
                    println(" Found")

                   DebugfoundValue(row,column)
                    board[row][column] = playerInitials
                   displayMatrix()
                   return

                } else {

                      //  println("  Not Found!")

                }

            }
            column = -1



        }


    }

    fun DebugfoundValue( rowVal: Int,colVal:Int){
        println("Found Values row: $rowVal and col: $colVal")
    }

}
 //class end

fun main() {


var maingame:MainGame = MainGame()
    maingame.initializeGame()
    maingame.runGame()


    var userInputProvider: UserInput = UserInput()
    userInputProvider.giveValuetoMatrix()


}

open class UserInput { // class remains closed by Default so we need to add open before class inorder to inherit

    private var userInput:Int = 0
    var playerName:String =""
    var matrix: GameMatrix = GameMatrix()
        fun getUserInput(inputNumber:Int, player:String) {

            userInput = inputNumber
            playerName = player;

         }


         fun giveValuetoMatrix() {
             matrix.giveValue(userInput.toInt(),playerName)

        }

            fun applyInputToMatrix(){
               // matrix.checkValue()
            }



}

class  MainGame  : UserInput(){


    var gameOver : Boolean = false
    var game: GameMatrix = GameMatrix()
    var mainPlayer : String = "X"
    var value:Int = 0


    fun initializeGame(){
        println("Hello Players this is X and O ( TICTACTOE ) Game, made with respect to Tickled media Pvt Ltd")
        game.displayMatrix()

    }



    fun playerSwitcher() = when (mainPlayer) {
        "X" -> mainPlayer = "O"
        "O" -> mainPlayer="X"
        else -> mainPlayer="X"



    }

    fun runGame() {

        gameOver = false
        while(!gameOver){
            println("Player: $mainPlayer's Turn please Enter the valid number from given Number Matrix ")
            getUserInput(readLine()!!.toInt(),mainPlayer)
            playerSwitcher()
            giveValuetoMatrix()
            //applyInputToMatrix()



        }
    }
}