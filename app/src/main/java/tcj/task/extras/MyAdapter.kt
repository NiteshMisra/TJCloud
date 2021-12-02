package tcj.task.extras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tcj.task.R
import tcj.task.network.AllApiData

class MyAdapter(var list : List<AllApiData>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val nameTv : TextView = view.findViewById(R.id.name_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.element_data,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
       holder.nameTv.text = "${currentItem.firstName} ${currentItem.lastName}"
    }

    override fun getItemCount(): Int = list.size

}