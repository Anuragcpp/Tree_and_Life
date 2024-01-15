package `as`.example.life.SignIn_SignUp_Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import `as` .example.life.R
import `as`.example.life.databinding.FragmentEventBinding
import `as`.example.life.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {
    private lateinit var binding:FragmentSignUpBinding
    private lateinit var userName:AppCompatEditText
    private lateinit var userEmail:AppCompatEditText
    private lateinit var userPassword:AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        userName = binding.userUsername
        userEmail = binding.userEmail
        userPassword = binding.userPassword
        var userNameSt:String = userName.text.toString()
        var userEmailSt:String = userEmail.text.toString()
        var userPasswordSt:String = userPassword.text.toString()
        
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignUpFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}