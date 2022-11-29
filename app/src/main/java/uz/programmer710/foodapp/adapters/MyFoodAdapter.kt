package uz.programmer710.foodapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_list.view.*
import uz.programmer710.foodapp.R
import uz.programmer710.foodapp.models.MyFood

class MyFoodAdapter(val list: ArrayList<MyFood>, context: Context) : ArrayAdapter<MyFood>(context, R.layout.item_list, list) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val itemView:View
        if (convertView==null){
            itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        }else{
            itemView = convertView
        }
        itemView.tv_item.text = getItem(position)?.name
        return itemView
    }
}