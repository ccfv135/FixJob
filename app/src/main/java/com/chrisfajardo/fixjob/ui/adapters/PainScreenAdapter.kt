package com.chrisfajardo.fixjob.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chrisfajardo.fixjob.R
import com.chrisfajardo.fixjob.ui.listeners.Listeners
import com.chrisfajardo.fixjobjob.ui.users.UserPaintScreenActivity
import kotlinx.android.synthetic.main.item_row.view.*

class PainScreenAdapter(private val context: Context,private val listener: Listeners): RecyclerView.Adapter<PainScreenAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<UserPaintScreenActivity>()

    fun setListData(data:MutableList<UserPaintScreenActivity>){
        dataList =data
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_row,parent,false)
        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return if (dataList.size > 0){
            dataList.size
        }else{0
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val user = dataList[position]
        holder.bindView(user)
        holder.itemView.llamaruno.setOnClickListener {
            val phone = user.phone
            listener.callPhoneApp(phone)
        }
        holder.itemView.buttomWS.setOnClickListener {
            val phone = user.phone
            listener.whatsappButoom(phone)
        }
    }

    inner class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bindView(userActivity: UserPaintScreenActivity){
            Glide.with(context).load(userActivity.url).into(itemView.circleImageView)
            itemView.name.text=userActivity.name
            itemView.txt_tittle.text = userActivity.phone
            itemView.descripccion.text = userActivity.description


        }
    }

}