package `as`.example.life.loginSignUp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import `as`.example.life.DashboardActivity
import `as`.example.life.R
import `as`.example.life.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding
    private lateinit var userEmailLa:AppCompatEditText
    private lateinit var userPasswordLa:AppCompatEditText
    private lateinit var goToSignUp:TextView
    private lateinit var signInBtn:TextView
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userEmailLa = binding.userEmailLa
        userPasswordLa = binding.userPasswordLa
        goToSignUp = binding.signUpGt
        signInBtn = binding.signInBtn
        auth = FirebaseAuth.getInstance()

        signInBtn.setOnClickListener {
            val userEmail_:String = userEmailLa.text.toString()
            val userPassword_:String = userPasswordLa.text.toString()
            if (userEmail_.isEmpty() || userPassword_.isEmpty()){
                Toast.makeText(this,"field is empty",Toast.LENGTH_SHORT).show()
            }else{
                signInWithEmailPassword(userEmail_,userPassword_)
            }
        }
        goToSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signInWithEmailPassword(userEmail_: String, userPassword_: String) {
        auth.signInWithEmailAndPassword(userEmail_,userPassword_)
            .addOnCompleteListener {
                if (it.isComplete){
                    val intent = Intent(this,DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this,it.exception?.message,Toast.LENGTH_SHORT).show()
                }
            }
    }
}