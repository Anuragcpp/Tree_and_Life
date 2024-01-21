package `as`.example.life.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.databinding.PlantInfoCardBinding
import `as`.example.life.helper.GlobalItemsModel
import `as`.example.life.helper.PlantViewHolder



//updated code ->

//class GlobalPlantAdapter(private val dataList: ArrayList<GlobalItemsModel>) :
//    RecyclerView.Adapter<PlantViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
//        val itemBinding = PlantInfoCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return PlantViewHolder(itemBinding)
//    }
//
//    override fun getItemCount(): Int {
//        return dataList.size
//    }
//
//    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
//        val currentItem = dataList[position]
//
//        holder.binding.userPlantImgGb.setImageResource(currentItem.userPlantImg)
//        holder.binding.userPlantCreditGb.text = currentItem.userPlantCredit
//        holder.binding.userPlantInfoGb.text = currentItem.userPlantInfo
//        holder.binding.userPlantLocationGb.text = currentItem.userPlantLocation
//        holder.binding.userPlantNameGb.text = currentItem.userPlantName
//    }
//}


class GlobalPlantAdapter ( private val list : MutableList<GlobalItemsModel>) :
        RecyclerView.Adapter<GlobalPlantAdapter.PlantViewHolder>(){


    inner class PlantViewHolder(var binding: PlantInfoCardBinding):
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val binding = PlantInfoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlantViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.userPlantNameGb.text = this.userPlantName
                binding.userPlantLocationGb.text= this.userPlantLocation
                binding.userPlantCreditGb.text = this.userPlantCredit
                binding.userPlantInfoGb.text = this.userPlantInfo
            }
        }
    }


}


