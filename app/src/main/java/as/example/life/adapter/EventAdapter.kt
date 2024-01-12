package `as`.example.life.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import `as`.example.life.databinding.EventInfoCardBinding
import `as`.example.life.helper.EventItemModel
import `as`.example.life.helper.EventViewHolder

class EventAdapter (private val dataList : ArrayList<EventItemModel>) :
    RecyclerView.Adapter<EventViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val itemBinding = EventInfoCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EventViewHolder(itemBinding)
    }


    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.binding.eventItemImgGb.setImageResource(dataList[position].eventImg)
        holder.binding.eventItemLocation.text = dataList[position].location
        holder.binding.eventItemDiscription.text = dataList[position].description
        holder.binding.eventItemPrizePool.text = dataList[position].prizePool

    }
}