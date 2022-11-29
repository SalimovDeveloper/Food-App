package uz.programmer710.foodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import uz.programmer710.foodapp.ui.AddFoodActivity
import uz.programmer710.foodapp.ui.AllFoodsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Menyu.setOnClickListener {

            startActivity(Intent(this, AllFoodsActivity::class.java))

        }

        btn_Qoshish.setOnClickListener {

            startActivity(Intent(this, AddFoodActivity::class.java))

        }

    }
}