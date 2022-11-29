package uz.programmer710.foodapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_food.*
import kotlinx.android.synthetic.main.activity_main.*
import uz.programmer710.foodapp.R
import uz.programmer710.foodapp.models.MyFood
import uz.programmer710.foodapp.ui.utils.MySharedPreference

class AddFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food)

        MySharedPreference.init(this)

        btn_saqlash.setOnClickListener {
            val name = edit_Name.text.toString().trim()
            val mahsulotlar = edit_Mahsulot.text.toString().trim()
            val tayyorlash = edit_Tayyorlash.text.toString().trim()

            if (name!="" && mahsulotlar!="" && tayyorlash!=""){

                val myFood = MyFood(name, mahsulotlar, tayyorlash)
                val list = MySharedPreference.list
                list.add(myFood)
                MySharedPreference.list = list

                Toast.makeText(this, "Saqlandi!!!", Toast.LENGTH_SHORT).show()

                finish()

            }else{
                Toast.makeText(this, "Kerakli maydonlarni to'ldiring!!!", Toast.LENGTH_SHORT).show()
            }

        }

    }
}