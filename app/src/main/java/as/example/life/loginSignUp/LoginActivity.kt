package `as`.example.life.loginSignUp

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import `as`.example.life.DashboardActivity
import `as`.example.life.R
import `as`.example.life.databinding.ActivityLoginBinding
import `as`.example.life.fragment.HomeFragment
import com.google.android.gms.tasks.OnCompleteListener
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
            val userEmail_:String = userEmailLa.text.toString().trim()
            val userPassword_:String = userPasswordLa.text.toString().trim()
//            if (userEmail_.isEmpty() || userPassword_.isEmpty()){
//                Toast.makeText(this,"field is empty",Toast.LENGTH_SHORT).show()
//            }else{
//                signInWithEmailPassword(userEmail_,userPassword_)
//            }

            if(userEmail_.isNotEmpty() && userPassword_.isNotEmpty()){
                signInWithEmailPassword(userEmail_,userPassword_)

            }else{
                Toast.makeText(this,"field is empty",Toast.LENGTH_SHORT).show()
            }
        }
        goToSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun signInWithEmailPassword(userEmail_: String, userPassword_: String) {
//        auth.signInWithEmailAndPassword(userEmail_,userPassword_)
//            .addOnCompleteListener {
//                if (it.isComplete){
//                    val intent = Intent(this,DashboardActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                }else{
//                    Toast.makeText(this,it.exception?.message,Toast.LENGTH_SHORT).show()
//                }
//            }

        auth.signInWithEmailAndPassword(userEmail_,userPassword_).addOnCompleteListener(
            OnCompleteListener {
                if(it.isSuccessful){
                    //Toast a Successfully messagem
                    Toast.makeText(this,"Login Successfull" , Toast.LENGTH_SHORT).show()

                    //navigate to the DashBord Activity
                    val intent : Intent = Intent(this, HomeFragment::class.java)
                    try {
                        startActivity(intent)
                        finish()
                    }catch (e : ActivityNotFoundException){
                        Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this,it.exception?.message , Toast.LENGTH_SHORT).show()
                }
            })
    }
}