package `as`.example.life

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import `as`.example.life.fragment.EventFragment
import `as`.example.life.fragment.GlobalFragment
import `as`.example.life.fragment.HomeFragment
import `as`.example.life.fragment.ProfileFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class DashboardActivity : AppCompatActivity() {

    private lateinit var navContainer: LinearLayout
    private lateinit var chipNavigationBar: ChipNavigationBar
    private lateinit var homeFragment: Fragment
    private lateinit var eventFragment: Fragment
    private lateinit var globalFragment: Fragment
    private lateinit var profileFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)


        navContainer = findViewById(R.id.nav_container)
        chipNavigationBar = findViewById(R.id.bottom_nav)
        homeFragment = HomeFragment()
        eventFragment = EventFragment()
        globalFragment = GlobalFragment()
        profileFragment = ProfileFragment()

        chipNavigationBar.setItemSelected(R.id.menu_home,true)

        chipNavigationBar.setOnItemSelectedListener {
            when(it){
                R.id.menu_home -> showFragment(homeFragment)
                R.id.menu_global -> showFragment(globalFragment)
                R.id.menu_event -> showFragment(eventFragment)
                R.id.menu_profile -> showFragment(profileFragment)
            }
            true
        }
        showFragment(homeFragment)

    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.nav_container,fragment)
            .commit()
    }
}