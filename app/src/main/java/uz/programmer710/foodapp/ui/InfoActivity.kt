package uz.programmer710.foodapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_info.*
import uz.programmer710.foodapp.R
import uz.programmer710.foodapp.models.MyFood
import uz.programmer710.foodapp.ui.utils.MySharedPreference

class InfoActivity : AppCompatActivity() {
    private lateinit var myFood: MyFood
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val index = intent.getIntExtra("keyIndex", 0)
        MySharedPreference.init(this)

        myFood = MySharedPreference.list[index]

        tv_name.text = myFood.name.toString().capitalize()
        tv_mahsulotlar.text = myFood.kerakliMahsulotlar.toString().capitalize()
        tv_tayyorlanish.text = myFood.tayyorlashTartibi.toString().capitalize()
    }

}