package uz.programmer710.foodapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_all_foods.*
import uz.programmer710.foodapp.R
import uz.programmer710.foodapp.adapters.MyFoodAdapter
import uz.programmer710.foodapp.models.MyFood
import uz.programmer710.foodapp.ui.utils.MySharedPreference

class AllFoodsActivity : AppCompatActivity() {
    private lateinit var list: ArrayList<MyFood>
    private lateinit var myFoodAdapter: MyFoodAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_foods)

        MySharedPreference.init(this)
        list = MySharedPreference.list

        myFoodAdapter = MyFoodAdapter(list, this)
        list_view_Foods.adapter = myFoodAdapter

        list_view_Foods.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra("keyIndex", i)
            startActivity(intent)
        }

    }
}