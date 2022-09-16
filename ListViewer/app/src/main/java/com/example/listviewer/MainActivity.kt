package com.example.listviewer

import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.isNotEmpty
import com.example.listviewer.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private val duration = Toast.LENGTH_SHORT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            val config = resources.configuration
            val locale = Locale("en")
            Locale.setDefault(locale)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1)
                config.setLocale(locale)
            else
                config.locale = locale

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
                createConfigurationContext(config)
            resources.updateConfiguration(config, resources.displayMetrics)

            this.setContentView(R.layout.activity_main)
        }
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        val list = ArrayList<String>()
        list.add(getString(R.string.Kirill))
        list.add(getString(R.string.Dmitry))
        list.add(getString(R.string.Danila))

        supportActionBar?.hide()

        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, list
        )
        bindingClass.mainViewer.adapter = adapter;



        bindingClass.addBtn.setOnClickListener(){
            if(bindingClass.enterName.text.toString().isNotEmpty()){
                list.add(bindingClass.enterName.text.toString())
            } else{
                val toast = Toast.makeText(applicationContext, getString(R.string.enterEmpty), duration)
                toast.show()
            }
            adapter.notifyDataSetChanged();
        }

        bindingClass.enterAll.setOnClickListener(){
            for (item in list) {
                bindingClass.mainViewer.setItemChecked(list.indexOf(item), true)
            }
        }
        bindingClass.reset.setOnClickListener(){
            for (item in list) {
                bindingClass.mainViewer.setItemChecked(list.indexOf(item), false)
            }
            bindingClass.mainViewer.checkedItemPositions.clear()
        }

        bindingClass.seeEnters.setOnClickListener(){
            val checkedItemsList = ArrayList<String>()
            var resToast = ""
            val positions =  bindingClass.mainViewer.checkedItemPositions
            var i = 0
            if(positions.isNotEmpty()){
                while(i < positions.size()){
                    if(positions.valueAt(i)){
                        checkedItemsList.add(positions.indexOfKey(i).toString())
                        resToast += list[positions.keyAt(i)] + " "
                    }
                    i++
                }
                val toast = Toast.makeText(applicationContext, resToast, duration)
                toast.show()
            } else{
                val toast = Toast.makeText(applicationContext, getString(R.string.checkboxEmpty), duration)
                toast.show()
            }

        }
    }
}