package com.example.relativelayout

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.relativelayout.databinding.ActivityMain10Binding
import com.example.relativelayout.databinding.ActivityMainBinding
import com.example.relativelayout.databinding.DialogopenBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity10 : AppCompatActivity(), RecyclerAdapter.OnClick {
    lateinit var binding: ActivityMain10Binding
    lateinit var recyclerAdapter: RecyclerAdapter
    var recycler2List = arrayListOf<recycler2>()
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recycler2List.add(recycler2(title = "title2", description = "My description"))
        recycler2List.add(recycler2(title = "extra", description = "My description"))
        recycler2List.add(recycler2(title = "this", description = "My description"))
        recyclerAdapter = RecyclerAdapter(recycler2List, this)
        binding.recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recycler.adapter = recyclerAdapter
        recyclerAdapter.notifyDataSetChanged()


    binding.flotbtn.setOnClickListener{
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.dialogopen)
        var tile = dialog.findViewById<EditText>(R.id.text2)
        dialog.window?.setLayout(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT,
        )
        dialog.show()
        var floatAction = dialog.findViewById<Button>(R.id.flotbtn)

        floatAction.setOnClickListener {

            recycler2List.add(recycler2(title = tile.text.toString()))
            Toast.makeText(this@MainActivity10, "${title.toString()}", Toast.LENGTH_SHORT).show()
            dialog.show()
        }
    }
}

    override fun update(position: Int) {
        Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun delete(position: Int) {
        recycler2List.removeAt(position)
        Toast.makeText(this, "Update Clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onItemClick(position: Int) {
        var intent = Intent(this, navigateactivity::class.java).apply {
            putExtra("key",recycler2List[position].title.toString())
        }
        startActivity(intent)
            }
        }









