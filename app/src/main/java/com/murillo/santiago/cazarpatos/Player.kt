package com.murillo.santiago.cazarpatos

data class Player(var username:String, var huntedDucks:Int){
    // This constructor is used to create a Player with default values
    constructor(): this("", 0)
}
