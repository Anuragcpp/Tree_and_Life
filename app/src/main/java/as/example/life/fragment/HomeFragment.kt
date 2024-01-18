package `as`.example.life.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `as`.example.life.R
import `as`.example.life.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_home, container, false)
        return view
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