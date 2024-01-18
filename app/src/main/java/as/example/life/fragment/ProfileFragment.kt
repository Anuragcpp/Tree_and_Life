package `as`.example.life.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import `as`.example.life.R
import `as`.example.life.databinding.FragmentProfileBinding
import `as`.example.life.helper.UserInfo
import `as`.example.life.loginSignUp.UserAllInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProfileFragment : Fragment() {
    private lateinit var binding:FragmentProfileBinding
    private lateinit var userName:TextView
    private lateinit var userLocation:TextView
    private lateinit var userPlantName:TextView
    private lateinit var userPlantDesc:TextView
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container,false)

        userName = binding.userNameP
        userLocation = binding.userLocationP
        userPlantName = binding.userPlantNameP
        userPlantDesc = binding.userPlantDescP
        auth = FirebaseAuth.getInstance()

        val database = FirebaseDatabase.getInstance().getReference("Users").child(auth.currentUser!!.uid)

        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val data = snapshot.getValue(UserInfo::class.java)
                userName.text = data?.userEmail
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}