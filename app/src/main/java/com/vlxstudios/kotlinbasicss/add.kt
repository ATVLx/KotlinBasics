package com.vlxstudios.kotlinbasicss



   // fun addition(a:Int,b:Int):Int{
       // return a+b;

        class employee(emp_id : Int , emp_name: String) {
            var id: Int
            var name: String


            // initializer block
            init {
                id = emp_id
                name = emp_name

            }

            fun getdata(employeename:String,employeeid:Int){
                name = employeename
                id= employeeid
            }
            fun showData(){
                println("employee name: "+name)
                println("employee id: "+id)
            }
        }

