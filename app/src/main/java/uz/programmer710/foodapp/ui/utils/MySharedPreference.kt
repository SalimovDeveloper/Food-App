package uz.programmer710.foodapp.ui.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.programmer710.foodapp.models.MyFood

object MySharedPreference {
    private const val NAME = "catch_file_name"
    private const val MODE = Context.MODE_PRIVATE

    private lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var list: ArrayList<MyFood>
        get() = stringToList(preferences.getString("list", "[]")!!)
        set(value) = preferences.edit {
            if (value != null) {
                it.putString("list", listToString(value))
            }
        }

    fun stringToList(str:String):ArrayList<MyFood>{
        val gson = Gson()
        val list = ArrayList<MyFood>()

        val type = object : TypeToken<ArrayList<MyFood>>(){}.type
        list.addAll(gson.fromJson(str, type))

        return list
    }

    fun listToString(list: ArrayList<MyFood>):String{
        return Gson().toJson(list)
    }
}