package com.example.relativelayout

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.relativelayout.databinding.ActivityMain10Binding
import com.example.relativelayout.databinding.ActivityMainBinding

class MainActivity10 : AppCompatActivity() {
    lateinit var binding: ActivityMain10Binding
    lateinit var recyclerAdapter: RecyclerAdaptor
    var Noteslist= arrayListOf<recycler2>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Noteslist.add(recycler2(title = "My title", description = "My description"))
        Noteslist.add(recycler2(title = "My title", description = "My description"))
        Noteslist.add(recycler2(title = "My title", description = "My description"))
        recyclerAdapter= RecyclerAdaptor(Noteslist)
        binding.recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter=recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()  }
}