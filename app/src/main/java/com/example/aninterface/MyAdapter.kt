package com.example.aninterface

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_btn.view.*

class MyAdapter(val list: ArrayList<String>) : RecyclerView.Adapter<MyAdapter.ViewHodler>() {

    interface OnButtonClickListener {
        fun onItemClick(btnName: String,btn:Button)
    }

    var mOnButtonClickListener: OnButtonClickListener? = null

    fun setOnItemClickListener(mOnButtonClickListener: OnButtonClickListener) {
        this.mOnButtonClickListener = mOnButtonClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHodler {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_btn, parent, false)

        return ViewHodler(view)
    }

    override fun getItemCount() = this.list.count()

    override fun onBindViewHolder(holder: MyAdapter.ViewHodler, position: Int) {
        holder.bind(list[position])
        holder.btn.setOnClickListener {
            mOnButtonClickListener?.onItemClick(list[position],holder.btn)
        }
    }

    inner class ViewHodler(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val btn = itemView.btn_rv
        fun bind(checked: String) {
            btn.text = checked
        }
    }
}