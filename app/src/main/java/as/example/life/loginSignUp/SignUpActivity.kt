package `as`.example.life.loginSignUp

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import `as`.example.life.databinding.ActivitySignUpBinding
import `as`.example.life.fragment.HomeFragment
import `as`.example.life.helper.UserInfo
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding
    private lateinit var userName: AppCompatEditText
    private lateinit var userEmail: AppCompatEditText
    private lateinit var userPassword: AppCompatEditText
    private lateinit var signUpBtn: TextView
    private lateinit var auth: FirebaseAuth
    private lateinit var backBtn:ImageView
    private lateinit var goToLogin:TextView
    private lateinit var database:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        FirebaseApp.initializeApp(this)
        userName = binding.userUsername
        userEmail = binding.userEmail
        userPassword = binding.userPassword
        signUpBtn = binding.signUpBtn
        auth = FirebaseAuth.getInstance()
        backBtn = binding.backBtn
        goToLogin = binding.userLoginGt
        database = FirebaseDatabase.getInstance().getReference("Users")

        goToLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        backBtn.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        signUpBtn.setOnClickListener {
            val userNameSt:String = userName.text.toString().trim()
            val userEmailSt:String = userEmail.text.toString().trim()
            val userPasswordSt:String = userPassword.text.toString()
            if (userEmailSt.isEmpty() || userNameSt.isEmpty() || userPasswordSt.isEmpty()){
                Toast.makeText(this,"field is empty", Toast.LENGTH_SHORT).show()
            } else{
                signUpWithEmailPassword(userEmailSt,userPasswordSt,userNameSt)
            }
        }
    }

    private fun signUpWithEmailPassword(userEmailSt: String, userPasswordSt: String,userNameSt:String) {

        if(userEmailSt.isNotEmpty() && userPasswordSt.isNotEmpty() && userNameSt.isNotEmpty()){

            auth.createUserWithEmailAndPassword(userEmailSt,userPasswordSt).addOnCompleteListener(
                OnCompleteListener {
                    if (it.isSuccessful){
                        //Create user
                        Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show()

                        //passing the uid to the storeInfo function
                        storeUserInfo(auth.currentUser?.uid,userNameSt,userEmailSt,userPasswordSt)

                        //Navigate to the AllUserInfo Activity
                        val intent = Intent(this,HomeFragment::class.java)
                        try {
                            startActivity(intent)
                            finish()
                        }catch (e: ActivityNotFoundException){
                            Toast.makeText(this,e.message, Toast.LENGTH_SHORT).show()
                        }

                    }else{
                        Toast.makeText(this, "Sign up failed: ${it.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                })
        }

    }

    private fun storeUserInfo(userId: String?, userEmailSt: String, userNameSt: String, userPasswordSt: String) {
        val userInfo = UserInfo(userNameSt, userEmailSt,userPasswordSt)
//        database.child(userId.orEmpty()).setValue(userInfo)
        database.child(userId!!).setValue(userInfo)
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}