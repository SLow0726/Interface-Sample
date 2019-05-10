package com.example.aninterface

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = arrayListOf("A", "B", "C", "D", "E")
    val list2 = arrayListOf<String>()
    var count = 0
    val colorNormal = "#B3B0B0"
    val colorSelect = "#000000"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MyAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(
            applicationContext, RecyclerView.HORIZONTAL, false
        )
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.OnButtonClickListener {
            override fun onItemClick(btnName: String,btn: Button) {

                if (list2.contains(btnName)) {

                    setButtonColor(colorNormal,btn)
                    list2.remove(btnName)
                } else {
                    setButtonColor(colorSelect,btn)
                    list2.add(btnName)
                }
                println("*******$list2")
            }

        })

    }

    fun setButtonColor( color: String,btn :Button) {

        val backgroundDrawable =
            ContextCompat.getDrawable(applicationContext, R.drawable.select_shape)
        backgroundDrawable?.let {
            it.setTint(Color.parseColor(color))
            btn.background = it
        } ?: kotlin.run {
            btn.setBackgroundResource(R.drawable.select_shape)
        }

    }
}
