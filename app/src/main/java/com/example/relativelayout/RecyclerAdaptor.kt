package com.example.relativelayout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdaptor(var list :ArrayList<recycler2>)
    : RecyclerView.Adapter<RecyclerAdaptor.Viewholder>() {
    class Viewholder(var view: View) : RecyclerView.ViewHolder(view) {
        var name = view.findViewById<TextView>(R.id.text1)
        var update = view.findViewById<Button>(R.id.btnupdate)
        var delete = view.findViewById<Button>(R.id.btndelete)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout, parent, false)
        return Viewholder(view)

    }

    override fun onBindViewHolder(holder: RecyclerAdaptor.Viewholder, position: Int) {
        holder.apply {
            name.setText(list[position].title)
            update.setOnClickListener {
            }
            delete.setOnClickListener {
            }
        }
    }


    override fun getItemCount(): Int {
        return list.size
    }

    interface OnClick {
        fun update(position: Int)
        fun delete(position: Int)
    }

}