package `as`.example.life.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.databinding.PlantInfoCardBinding
import `as`.example.life.helper.GlobalItemsModel
import `as`.example.life.helper.PlantViewHolder

//class GlobalPlantAdapter(var dataList:ArrayList<GlobalItemsModel>,var context: Context):RecyclerView.Adapter<PlantViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
////        val  view = LayoutInflater.from(context).inflate(R.layout.plant_info_card,parent,false)
////        return PlantViewHolder(view)
//
//        //setting up dinging for use in the PlantViewHolder
//        var binding = PlantInfoCardBinding.inflate(LayoutInflater.from(context),parent,false)
//        return PlantViewHolder(binding)
//
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
//         holder.binding.userPlantImgGb.setImageResource(dataList[position].userPlantImg)
//        holder.binding.userPlantCreditGb.text = dataList[position].userPlantCredit
//        holder.binding.userPlantInfoGb.text = dataList[position].userPlantInfo
//        holder.binding.userPlantLocationGb.text = dataList[position].userPlantLocation
//        holder.binding.userPlantNameGb.text = dataList[position].userPlantName
//    }
//
////    inner class MyViewHolder (var binding: PlantInfoCardBinding) : RecyclerView.ViewHolder(binding.root)
//
//
////    inner class PlantViewHolder(var binding: PlantInfoCardBinding): RecyclerView.ViewHolder(binding.root) {
////    }
//}



////////////////////////////////

//updated code ->

class GlobalPlantAdapter(private val dataList: ArrayList<GlobalItemsModel>) :
    RecyclerView.Adapter<PlantViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val itemBinding = PlantInfoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PlantViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        val currentItem = dataList[position]

        holder.binding.userPlantImgGb.setImageResource(currentItem.userPlantImg)
        holder.binding.userPlantCreditGb.text = currentItem.userPlantCredit
        holder.binding.userPlantInfoGb.text = currentItem.userPlantInfo
        holder.binding.userPlantLocationGb.text = currentItem.userPlantLocation
        holder.binding.userPlantNameGb.text = currentItem.userPlantName
    }
}
