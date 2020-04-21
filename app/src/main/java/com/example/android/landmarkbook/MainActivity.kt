package com.example.android.landmarkbook

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var landmarkNames = ArrayList<String>()
        landmarkNames.add("Leaning Tower of Pisa")
        landmarkNames.add("Eiffel Tower")
        landmarkNames.add("Statue of Liberty")
        landmarkNames.add("Sydney Opera House")
        landmarkNames.add("London Bridge")


        val pisa=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.pisa)
        val eiffel=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.eiffel)
        val liberty=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.statue_liberty)
        val opera=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.sydneyopera)
        val bridge=BitmapFactory.decodeResource(applicationContext.resources,R.drawable.londonbridge)

        val landmarkImages=ArrayList<Bitmap>()

        landmarkImages.add(pisa)
        landmarkImages.add(eiffel)
        landmarkImages.add(liberty)
        landmarkImages.add(opera)
        landmarkImages.add(bridge)

        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkNames)

        listView.adapter=arrayAdapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(applicationContext,DetailActivity::class.java)
            intent.putExtra("name",landmarkNames[position])
            val bitmap=landmarkImages[position]
            val chosen=Globals.chosen
            chosen.chosenImage=bitmap
            startActivity(intent)

        }

    }


}
