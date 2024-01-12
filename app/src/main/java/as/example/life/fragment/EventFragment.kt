package `as`.example.life.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.adapter.EventAdapter
import `as`.example.life.databinding.FragmentEventBinding
import `as`.example.life.helper.EventItemModel

//import as .example.life.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EventFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EventFragment : Fragment() {

    private lateinit var binding: FragmentEventBinding
    private lateinit var allEventItem : RecyclerView
    private lateinit var eventItemAdapter : EventAdapter
    private lateinit var context : Context
    private lateinit var dataList: ArrayList<EventItemModel>

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentEventBinding.inflate(inflater,container,false)


        allEventItem = binding.allEventItems

        allEventItem.layoutManager = LinearLayoutManager(context)

        initializeData()
        populateData()


        return binding.root
    }



    private fun initializeData() {
        dataList = ArrayList()
        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )

        dataList.add(
            EventItemModel(
                R.drawable.app_icon,
                "Assam",
                "50000",
                "Habibi come to assam!!"
            )
        )
    }

    private fun populateData() {

        eventItemAdapter = EventAdapter(dataList)

        allEventItem.adapter = eventItemAdapter

        eventItemAdapter.notifyDataSetChanged()
    }


}