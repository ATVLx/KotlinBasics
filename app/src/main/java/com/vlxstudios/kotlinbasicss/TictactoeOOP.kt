package com.vlxstudios.kotlinbasicss

class GameMatrix {


  var board: Array<Array<String>> = arrayOf(
      arrayOf("1", "2", "3"),
      arrayOf("4", "5", "6"),
      arrayOf("7","8","9")
  )


    var recivedValue: Int? = 0
    var printed: Boolean = false

    fun initaliseMatrix(){
        var rowTemp = 0
        var rowcol = 0
        var placeHolder = 0
        for (columnMatrix in board){
            rowcol++
            for(rowMatrix in columnMatrix){
                rowTemp++
                placeHolder++
                foundValue(rowTemp,rowcol)
              //  placeElements(rowTemp,rowcol,placeHolder)

            }

        }
    }
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


    fun giveValue(number: Int) {
        recivedValue = number
        checkValue()
    }

    fun checkValue() {
        var rowTemp:Int = -1
        var rowcol:Int = -1

        printed = false
        for (columnArray in board) {
            rowcol++
            for (columnval in columnArray) {
                rowTemp++
                if (recivedValue == columnval.toInt()) {
                    println(" Found")

                    foundValue(rowTemp,rowcol)
                    board[rowcol][rowTemp] = "X"


                   displayMatrix()
                    return

                } else {
                   // rowTemp++
                  // foundValue(rowTemp,rowcol)
                        print("  Not Found!")

                }

            }
            rowcol =0
            rowTemp =0



        }
      //  println("found on row $recivedValue and column")

    }

    fun foundValue( rowVal: Int,colVal:Int){
        println("Found Values row: $rowVal and col: $colVal")
    }

}
 //class end

fun main() {
    var game: GameMatrix = GameMatrix()
   // game.initaliseMatrix()
    game.displayMatrix()
    println("Please Provide the input to check if it is existing or not")
    var userInputProvider: GetUserInput = GetUserInput(readLine()!!.toInt())
    userInputProvider.giveValuetoMatrix()


}

class GetUserInput(var inputNumber: Int) {
    var userInput = inputNumber
    var matrix: GameMatrix = GameMatrix()
    fun giveValuetoMatrix() {
        matrix.giveValue(userInput)

    }


}