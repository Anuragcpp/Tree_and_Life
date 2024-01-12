package `as`.example.life.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import `as`.example.life.adapter.GlobalPlantAdapter
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.helper.GlobalItemsModel




class GlobalFragment : Fragment() {

    private lateinit var allPlantItems: RecyclerView
    private lateinit var allItemsAdapter: GlobalPlantAdapter
    private lateinit var dataList:ArrayList<GlobalItemsModel>
    private lateinit var context: Context

    //initializing the context before using in the allItemAdopter ,
    // as it was showing me error ->kotlin.UninitializedPropertyAccessException: lateinit property context has not been initialized
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }



    //Updated code ->


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_global, container, false)

        allPlantItems = view.findViewById(R.id.all_plant_items)

        //setting up the linear Layout manager for the recyclerView to populate
        allPlantItems.layoutManager = LinearLayoutManager(context)

        // Initialize and populate data
        initializeData()
        populateData()

        return view
    }

    private fun initializeData() {
        dataList = ArrayList()
        dataList.add(
            GlobalItemsModel(
                R.drawable.app_icon,
                "Harshal verma",
                "1500",
                "Rajasthan, Suratgarh",
                "This is a unique breed of plant"
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.app_icon,
                "Harshal verma",
                "1500",
                "Rajasthan, Suratgarh",
                "This is a unique breed of plant"
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.app_icon,
                "Harshal verma",
                "1500",
                "Rajasthan, Suratgarh",
                "This is a unique breed of plant"
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.app_icon,
                "Harshal verma",
                "1500",
                "Rajasthan, Suratgarh",
                "This is a unique breed of plant"
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.app_icon,
                "Harshal verma",
                "1500",
                "Rajasthan, Suratgarh",
                "This is a unique breed of plant"
            )
        )

    }

    private fun populateData() {
        allItemsAdapter = GlobalPlantAdapter(dataList)
        // Set up RecyclerView and adapter
        allPlantItems.adapter = allItemsAdapter
        //Reinitializing the recyclerView every time it got changed
        allItemsAdapter.notifyDataSetChanged()

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GlobalFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}