package `as`.example.life.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.R
import `as`.example.life.helper.GlobalItemsModel
import `as`.example.life.helper.PlantViewHolder

class GlobalPlantAdapter(var dataList:ArrayList<GlobalItemsModel>,var context: Context):RecyclerView.Adapter<PlantViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val  view = LayoutInflater.from(context).inflate(R.layout.plant_info_card,parent,false)
        return PlantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {

    }


}