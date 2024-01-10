package `as`.example.life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import `as`.example.life.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setting up bonding for use
        binding = ActivityMainBinding.inflate(layoutInflater)

        //setting up the setContentView() using the binding object
        setContentView(binding.root)

        navHostFragment = supportFragmentManager
    }
}