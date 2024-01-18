package `as`.example.life.helper

data class UserInfo(val userName:String?=null,
                    val userEmail:String?=null,
                    val userPassword:String?=null){

    constructor() : this("", "","")
}
