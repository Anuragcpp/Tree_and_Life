package `as`.example.life.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import `as`.example.life.adapter.GlobalPlantAdapter
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.helper.GlobalItemsModel




class GlobalFragment : Fragment() {

    private lateinit var allPlantItems: RecyclerView
    private lateinit var allItemsAdapter: GlobalPlantAdapter
    private lateinit var dataList:ArrayList<GlobalItemsModel>
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_global, container, false)

        allPlantItems = view.findViewById(R.id.all_plant_items)

        dataList.add(
            GlobalItemsModel(R.drawable.app_icon,"Harshal verma","1500",
                "Rajasthan,Suratgarh","This is a unique breed of plant"))
        dataList.add(GlobalItemsModel(R.drawable.app_icon,"Harshal verma","1500",
            "Rajasthan,Suratgarh","This is a unique breed of plant"))
        dataList.add(GlobalItemsModel(R.drawable.app_icon,"Harshal verma","1500",
            "Rajasthan,Suratgarh","This is a unique breed of plant"))
        dataList.add(GlobalItemsModel(R.drawable.app_icon,"Harshal verma","1500",
            "Rajasthan,Suratgarh","This is a unique breed of plant"))
        dataList.add(GlobalItemsModel(R.drawable.app_icon,"Harshal verma","1500",
            "Rajasthan,Suratgarh","This is a unique breed of plant"))

        allItemsAdapter = GlobalPlantAdapter(dataList,context)

        return view
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