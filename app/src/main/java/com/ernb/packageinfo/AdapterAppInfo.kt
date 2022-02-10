package com.ernb.packageinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.itemview.view.*
import java.util.*
import kotlin.collections.ArrayList

class AdapterAppInfo(private val listData:ArrayList<Date>, private val dataPackage:ArrayList<String>):RecyclerView.Adapter<AdapterAppInfo.AppInfoViewHolder>() {

    class AppInfoViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val packageName = itemView.packagename
        val date = itemView.Installed_Date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppInfoViewHolder {
       val view =  LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
        return AppInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: AppInfoViewHolder, position: Int) {
        holder.packageName.text = dataPackage[position]
        holder.date.text = listData[position].toString()
    }

    override fun getItemCount(): Int = listData.size
}