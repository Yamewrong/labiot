package com.yamewrong.labiot.adpater

import android.content.Context
import android.content.Intent
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.yamewrong.labiot.ContentModel
import com.yamewrong.labiot.DataAugmentation
import com.yamewrong.labiot.R

class RVAdapter(val context : Context, val List:MutableList<ContentModel>):RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v= LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(List[position])
        holder.setimage(List[holder.adapterPosition].ImageUrl)
    }

    override fun getItemCount(): Int {
        return List.size
    }
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindItem(item: ContentModel){
                val ri_img = itemView.findViewById<ImageView>(R.id.ri_iv)
                val ri_text = itemView.findViewById<TextView>(R.id.ri_tv)
                val id = itemView.findViewById<LinearLayout>(R.id.root)
            id.setOnClickListener(){
                val intent= Intent(context, DataAugmentation::class.java)
                intent.putExtra("data",item.ImageUrl)
                context.startActivity(intent)
            }
            ri_text.text=item.titleText
//            Glide.with(context)
//                .load(Uri.parse(item.ImageUrl))
//                .into(ri_img)

//            Glide.with(context)
//                .load(Base64.decode(, Base64.DEFAULT))
//                .asBitmap()
//                .placeholder(R.drawable.ic_broken)
//                .into(imageView);
        }

        fun setimage (data:String){
            Glide.with(context)
                .load(Base64.decode(data, Base64.DEFAULT))
                .into(itemView.findViewById(R.id.ri_iv));
        }
    }
    class itemclicklistener(){
    }
}