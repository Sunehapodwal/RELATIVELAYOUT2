package com.example.relativelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(var list :ArrayList<recycler2>,var clickInterface: OnClick
)
    :RecyclerView.Adapter<RecyclerAdapter.Viewholder>(){
    class Viewholder (var view: View):RecyclerView.ViewHolder(view){
        var name=view.findViewById<TextView>(R.id.text1)
        var update=view.findViewById<Button>(R.id.btnupdate)
        var delete=view.findViewById<Button>(R.id.btndelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.Viewholder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)
        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.Viewholder, position: Int) {
        holder.apply {
            name.setText(list[position].title)
            update.setOnClickListener {
                clickInterface.update(position)
            }
            delete.setOnClickListener {
                clickInterface.delete(position)
            }
            view.setOnClickListener {
                clickInterface.onItemClick(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return  list.size
    }
    interface OnClick{

        fun update(position: Int)
        fun delete(position: Int)
        //Click on particular item
        fun onItemClick(position: Int)
    }
}

