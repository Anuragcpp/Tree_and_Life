package `as`.example.life.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.AppCompatButton
import androidx.drawerlayout.widget.DrawerLayout
import `as`.example.life.CameraActivity
import `as`.example.life.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var plantDiseaseDetect:AppCompatButton
    private lateinit var dewableIcon : ImageView
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        plantDiseaseDetect = binding.checkPlantDisease
        plantDiseaseDetect.setOnClickListener {
            val intent = Intent(context,CameraActivity::class.java)
            startActivity(intent)
        }

        //logic for drawable layout
        drawerLayout = binding.drawerLayout
        dewableIcon = binding.dwawableBtn
        dewableIcon.setOnClickListener {
//            val toggle = ActionBarDrawerToggle(this,drawerLayout)
        }
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}