package `as`.example.life.loginSignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import `as`.example.life.DashboardActivity
import `as`.example.life.R
import `as`.example.life.databinding.ActivityUserAllInfoBinding
import `as`.example.life.helper.UserPlantInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UserAllInfo : AppCompatActivity() {
    private lateinit var binding: ActivityUserAllInfoBinding
    private lateinit var userPlantImg:ImageView
    private lateinit var userPlantName:EditText
    private lateinit var userPlantLocation:EditText
    private lateinit var userPlantDesc:EditText
    private lateinit var goToDashboard:TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var dataBase : DatabaseReference
    private lateinit var skipToDashboard:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAllInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPlantImg = binding.userPlantImgUi

        userPlantName = binding.userPlantNameUi
        userPlantLocation = binding.userPlantLocationUi
        userPlantDesc = binding.userPlantInfoUi
        goToDashboard = binding.goToDashboardUi
        skipToDashboard = binding.skipToDashboard

        //initializing the firebase Instance
        auth = FirebaseAuth.getInstance()
        dataBase = FirebaseDatabase.getInstance().getReference("Users")

        //skip information
        skipToDashboard.setOnClickListener {
            val intent = Intent(this,DashboardActivity::class.java)
            startActivity(intent)
            finish()
        }

        goToDashboard.setOnClickListener {
            val userPlantNameSt  = userPlantName.text.toString()
            val userPlantLocationSt = userPlantLocation.text.toString()
            val userPlantDecSt = userPlantDesc.text.toString()

            if(userPlantDecSt.isNotEmpty() && userPlantLocationSt.isNotEmpty() && userPlantNameSt.isNotEmpty()){
                saveData(userPlantNameSt,userPlantLocationSt,userPlantDecSt)
            }else{
                Toast.makeText(this, "Please fill the Empty fields",Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun saveData(
        userPlantNameSt: String,
        userPlantLocationSt: String,
        userPlantDecSt: String
    ) {

        //Store the User Plant data to the data base with a new brach with the plant name
        val userPlantInfo = UserPlantInfo(userPlantNameSt,userPlantLocationSt,userPlantDecSt)

        dataBase.child(auth.currentUser!!.uid).child(userPlantNameSt).push().setValue(userPlantInfo)


        //Navigate to the DashBord Activity
        val intent = Intent(this,DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}