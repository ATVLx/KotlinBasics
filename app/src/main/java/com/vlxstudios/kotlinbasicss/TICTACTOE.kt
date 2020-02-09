package com.vlxstudios.kotlinbasicss

import java.util.function.ToIntFunction

var Xando = arrayOf("1","2","3","4","5","6","7","8","9")
var Winner:String? = null
var gameOver: Boolean = false
var count:Int=0
var player:String? = "X"
var placed: Boolean = false

fun main()
{
    displayMatrix()
    getuserinnut()
}


fun displayMatrix(){
    println( " "+  Xando[0] +" "+Xando[1]+" "+Xando[2])
    println( " "+  Xando[3] +" "+Xando[4]+" "+Xando[5])
    println( " "+  Xando[6] +" "+Xando[7]+" "+Xando[8])
}
fun getuserinnut()
{

    while(!gameOver)
    {

        println("Please Enter your Number in which you want to place $player")
         var a:Int = readLine()!!.toInt()
        if(Xando[a-1] == "X" || Xando[a-1] == "O")
        {
            while (!placed)
            { println("$a is already Occupied Please feed into another Place")
                a = readLine()!!.toInt()
                placed = !(Xando[a-1] == "X" || Xando[a-1] == "O")

                /*
                same StateMEnt as Above
                 if(Xando[a-1] == "X" || Xando[a-1] == "O")
                {
                    placed = false

                } else {
                    placed =true
                }
        }
                 */
            }
        }
         Xando[a-1] = player.toString();
         displayMatrix()
        SwitchPlayer()
         count++
            if(count > 2)
            {
                checkX()
                checkO()
            }

    }


    if(Winner == "X" || Winner == "O")
    {
        println("Winner is $Winner")
    }

}

fun SwitchPlayer( )
{
    if(player == "X")
    {
     player = "O"
    }
   else if (player == "O")
    {
        player = "X"
    } else {
        player = "X"
    }


}


fun  checkX()
{
    if(Xando[0]=="X" && Xando[1] =="X"  && Xando[2]=="X")
    { Winner = "X"
        gameOver=true }
    if(Xando[3]=="X" && Xando[4] =="X"  && Xando[5]=="X"){ Winner = "X"
        gameOver=true }
    if(Xando[6]=="X" && Xando[7] =="X"  && Xando[8]=="X") { Winner = "X"
        gameOver=true }
    if(Xando[0]=="X" && Xando[3] =="X"  && Xando[6]=="X"){ Winner = "X"
        gameOver=true }
    if(Xando[1]=="X" && Xando[4] =="X"  && Xando[7]=="X") { Winner = "X"
        gameOver=true }
    if(Xando[2]=="X" && Xando[5] =="X"  && Xando[8]=="X"){ Winner = "X"
        gameOver=true }
    if(Xando[0]=="X" && Xando[4] =="X"  && Xando[8]=="X") { Winner = "X"
        gameOver=true }
    if(Xando[2]=="X" && Xando[4] =="X"  && Xando[6]=="X") { Winner = "X"
        gameOver=true }
}
fun  checkO()
{
    if(Xando[0]=="O" && Xando[1] =="O"  && Xando[2]=="O") { Winner = "O"
        gameOver=true }
    if(Xando[3]=="O" && Xando[4] =="O"  && Xando[5]=="O")  { Winner = "O"
        gameOver=true }
    if(Xando[6]=="O" && Xando[7] =="O"  && Xando[8]=="O") { Winner = "O"
        gameOver=true }
    if(Xando[0]=="O" && Xando[3] =="O"  && Xando[6]=="O")  { Winner = "O"
        gameOver=true }
    if(Xando[1]=="O" && Xando[4] =="O"  && Xando[7]=="O") { Winner = "O"
        gameOver=true }
    if(Xando[2]=="X" && Xando[5] =="X"  && Xando[8]=="O")  { Winner = "O"
        gameOver=true }
    if(Xando[0]=="O" && Xando[4] =="O"  && Xando[8]=="O") { Winner = "O"
        gameOver=true }
    if(Xando[2]=="O" && Xando[4] =="O"  && Xando[6]=="O") { Winner = "O"
        gameOver=true }
}
