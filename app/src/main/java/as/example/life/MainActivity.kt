package `as`.example.life

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.os.Handler
import android.view.Window
import android.view.WindowManager

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import `as`.example.life.databinding.ActivityMainBinding
import `as`.example.life.loginSignUp.LoginActivity
import `as`.example.life.loginSignUp.SignUpActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()
        if (Build.VERSION.SDK_INT >= 21) {
            val window : Window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.app_bg));}

        Handler().postDelayed({

            if (auth.currentUser!=null){
                val intent = Intent(this,DashboardActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        },3000)

    }

}