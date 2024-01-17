package `as`.example.life.helper

import android.widget.ImageView

//data class UserPlantInfo(val userPlantImg : ImageView ,
//                         val userPlantNameD : CharSequence,
//                         val userPlantLocationD : CharSequence ,
//                         val userPlantDecD : CharSequence )


//Firebase Realtime Database expects simple data types for serialization, and ImageView is not a simple data type.
data class UserPlantInfo(val userPlantImgD : CharSequence,
                         val userPlantNameD : CharSequence,
                         val userPlantLocationD : CharSequence ,
                         val userPlantDecD : CharSequence )


