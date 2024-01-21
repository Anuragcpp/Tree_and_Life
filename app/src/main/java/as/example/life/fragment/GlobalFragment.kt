package `as`.example.life.fragment

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import `as`.example.life.adapter.GlobalPlantAdapter
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.databinding.FragmentGlobalBinding
import `as`.example.life.helper.GlobalHelperClass
import `as`.example.life.helper.GlobalItemsModel
import `as`.example.life.loginSignUp.UserAllInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class GlobalFragment : Fragment() {

    private lateinit var allPlantItems: RecyclerView
    private lateinit var allItemsAdapter: GlobalPlantAdapter
    private lateinit var dataList:ArrayList<GlobalItemsModel>
    private lateinit var context: Context
    private lateinit var globalAddBtn : ImageView
    private lateinit var binding: FragmentGlobalBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var dataBaseReference: DatabaseReference
    private lateinit var rootNode : FirebaseDatabase
    private lateinit var Adapter : GlobalPlantAdapter
    private lateinit var mList : MutableList<GlobalItemsModel>

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
        binding = FragmentGlobalBinding.inflate(inflater,container,false)


//        val view: View = inflater.inflate(R.layout.fragment_global, container, false)

//        allPlantItems = requireView().findViewById(R.id.all_plant_items)

        allPlantItems = binding.allPlantItems

//        auth = FirebaseAuth.getInstance()
//        rootNode = FirebaseDatabase.getInstance();
//        mList = mutableListOf()
//        Adapter = GlobalPlantAdapter(mList)
//        binding.allPlantItems.adapter = Adapter
//        binding.allPlantItems.layoutManager = LinearLayoutManager(context)

        //setting up the linear Layout manager for the recyclerView to populate
        allPlantItems.layoutManager = LinearLayoutManager(context)

//        view.findViewById<ImageView>(R.id.global_add_btn)
            binding.globalAddBtn
            .setOnClickListener {
            val intent = Intent (requireContext(), UserAllInfo::class.java)
            try {
                startActivity(intent)
            }catch (e : ActivityNotFoundException){
                Toast.makeText(context,e.message,Toast.LENGTH_SHORT).show()
            }
        }

//        getDataFromFireBase()
//        updateRecyclerView()


//         Initialize and populate data
        initializeData()
        populateData()


        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        //initializing the variable
//        init(view)
//        //geting the data from the dataBase to populate to the recyclereView
//
////        populateData()
//    }

//    private fun init(view: View) {
//
//
//    }

//    private fun getDataFromFireBase() {
//        dataBaseReference = rootNode.getReference("Users")
//        dataBaseReference.child(auth.currentUser?.uid.toString()).child("userPlantNameSt")
//            .addListenerForSingleValueEvent(object :ValueEventListener{
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    mList.clear();
//                    if (snapshot.exists()) {
//                        for (userSnapshot in snapshot.children) {
//                            val plantInfo = userSnapshot.getValue(GlobalHelperClass::class.java)
//                            val plantInfoSave = userSnapshot.key?.let {
//                                GlobalItemsModel(
//                                    plantInfo?.userPlantName.toString(),
//                                    plantInfo?.userPlantCredit.toString(),
//                                    plantInfo?.userPlantLocation.toString(),
//                                    plantInfo?.userPlantDec.toString()
//                                )
//                            }
//
//                            if (plantInfoSave != null) {
//                                mList.add(plantInfoSave)
//                            }
//                        }
//
//                        Adapter.notifyDataSetChanged()
//                    }else{
//                        Toast.makeText(context,"No data found", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Toast.makeText(context,"Exception Occured", Toast.LENGTH_SHORT).show()
//                }
//            })
//    }


//    private fun updateRecyclerView() {
//        dataBaseReference = rootNode.getReference("Users")
//        dataBaseReference.child(auth.currentUser?.uid.toString()).child("userPlantNameSt")
//            .addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    val updatedList: MutableList<GlobalItemsModel> = mutableListOf()
//
//                    if (snapshot.exists()) {
//                        for (userSnapshot in snapshot.children) {
//                            val plantInfo = userSnapshot.getValue(GlobalHelperClass::class.java)
//                            val plantInfoSave = userSnapshot.key?.let {
//                                GlobalItemsModel(
//                                    plantInfo?.userPlantName.toString(),
//                                    plantInfo?.userPlantCredit.toString(),
//                                    plantInfo?.userPlantLocation.toString(),
//                                    plantInfo?.userPlantDec.toString()
//                                )
//                            }
//
//                            plantInfoSave?.let {
//                                updatedList.add(it)
//                            }
//                        }
//
//                        // Assuming `mList` is a field in your class (presumably the RecyclerView adapter's dataset)
//                        mList.clear()
//                        mList.addAll(updatedList)
//
//                        // Notify the adapter about the data change
//                        Adapter.notifyDataSetChanged()
//                    } else {
//                        Toast.makeText(context, "No data found for this user", Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    Toast.makeText(context, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
//                }
//            })
//    }


    private fun initializeData() {
        dataList = ArrayList()
        dataList.add(
            GlobalItemsModel(
                R.drawable.guwava,
                "Guava",
                "800",
                "Meghalaya",
                "The most frequently eaten species, and the one often simply referred to as \"the guava\", is the apple guava (Psidium guayava). Guavas are typical Myrtoideae, with tough dark heavy leaves that are opposite, simple, elliptic to ovate, and 5–15 centimetres (2–6 in) long. "
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.rojoni_gandha,
                "RajniFandha",
                "900",
                "Assam, Tinsukia",
                "Rajnigandha also known as Tuberose in English is a bulbous perennial flower that belongs to the family agavaceae. It is also known as Nishigandha."
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.brahmi,
                "Bacopa monnieri",
                "1400",
                "Arunachal Pradhsh",
                "High blood pressure is a serious health concern, as it places strain on your heart and blood vessels. This can weaken your heart and increase your risk of heart disease (…\n" +
                        "Research suggests that Bacopa monnieri may help keep blood pressure within a healthy range. "
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.pusina,
                "Pudina",
                "1100",
                "Tripura",
                "Pudina, scientifically known as Mentha spicata, is an aromatic herb belonging to the mint family (Lamiaceae). It is called Spearmint in English and is widely used in Indian and Italian cooking. It is one of the best mints used for flavour. The herb originated in Europe."
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.thankuni,
                "Centella asiatica",
                "1100",
                "Rajasthan",
                "Thankuni is a creeping plant that belongs to the family Apiaceae and has a few different names. It is related to herbs like parsley and cilantro, which are more well-known. It is also called by its scientific name, Centella asiatica, which is the same as pen"
            )
        )
        dataList.add(
            GlobalItemsModel(
                R.drawable.tulsi,
                "Tulsi",
                "1800",
                "Assam",
                "Tulsi is called the queen of all herbs, it is used widely in Ayurvedic and naturopathic medicines which helps in the healing of the human body in a natural manner. Not only do Tulsi leaves benefit people, but their flowers too. Tulsi can help you get rid of many health problems ranging from fever to kidney stones."
            )
        )
        dataList.add(
            GlobalItemsModel(
                R.drawable.norosingho,
                "Curry Lief",
                "1300",
                "Arunachal",
                "The curry tree or Bergera koenigii (syn.Murraya koenigii), is a tropical and sub-tropical tree in the family Rutaceae (the rue family, which includes rue, citrus, and satinwood), native to Asia.[4] The plant is also sometimes called sweet neem, though M. koenigii is in a different family to neem, Azadirachta indica, which is in the related family Meliaceae."
            )
        )

        dataList.add(
            GlobalItemsModel(
                R.drawable.amla,
                "Amla",
                "1200",
                "Nagaland",
                "Amla is the medium size deciduous plant. It grows to the height of 8 -18 meter. It has a crooked trunk and spreading branches. Its flower is yellow greenish in colour. The fruit is spherical pale yellow with six vertical furrows. The mature fruits are hard and do not fall for the gentle touch."
            )
        )
        dataList.add(
            GlobalItemsModel(
                R.drawable.bamboo,
                "Bamboo",
                "1000",
                "Assam",
                "Bamboos are typically fast-growing perennials, with some species growing as much as 30 cm (1 foot) per day. The woody ringed stems, known as culms, are typically hollow between the rings (nodes) and grow in branching clusters from a thick rhizome (underground stem)."
            )
        )
        dataList.add(
            GlobalItemsModel(
                R.drawable.chandan,
                "Chandan",
                "1500",
                "Kerala",
                "Linn commonly known as East Indian sandalwood or chandan belongs to the family Santalaceae. It is highly valuable and becoming endangered species. It is distributed all over the country and more than 90% lies in Karnataka and Tamil Nadu covering 8300 sq kms."
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

//     fun onSavePlantInfo(
//        plantName: String,
//        plantCredit: String,
//        plantLocation: String,
//        plantDescription: String
//    ) {
//        dataBaseReference = rootNode.getReference("Users")
//
//        val addNewPlantInfo = GlobalHelperClass(plantName, plantCredit, plantLocation, plantDescription)
//
//        dataBaseReference.child(auth.currentUser?.uid.toString()).child("userPlantNameSt")
//            .push().setValue(addNewPlantInfo)
//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    Toast.makeText(context, "Plant information saved successfully", Toast.LENGTH_SHORT).show()
//
//                    // Clear input fields after saving
//                    // Assuming you have references to the input fields, clear them here
//
//
//                    // Update RecyclerView after saving the plant information
//                    updateRecyclerView()
//                } else {
//                    Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
//                }
//            }
//
//        Adapter.notifyDataSetChanged()
//    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GlobalFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }


}