package `as`.example.life.loginSignUp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import `as`.example.life.R
import `as`.example.life.databinding.ActivityUserAllInfoBinding

class UserAllInfo : AppCompatActivity() {
    private lateinit var binding: ActivityUserAllInfoBinding
    private lateinit var userPlantImg:ImageView
    private lateinit var userPlantName:EditText
    private lateinit var userPlantLocation:EditText
    private lateinit var userPlantDesc:EditText
    private lateinit var goToDashboard:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserAllInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userPlantImg = binding.userPlantImgUi
        userPlantName = binding.userPlantNameUi
        userPlantLocation = binding.userPlantLocationUi
        userPlantDesc = binding.userPlantInfoUi
        goToDashboard = binding.goToDashboardUi

        goToDashboard.setOnClickListener {

        }
    }
}