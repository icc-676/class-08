package com.abs.clase_08

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.country_info.*

class MainActivity : AppCompatActivity() {

    var countryList = mutableListOf<CountryInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addCountryToList()
        showCases()
    }

    private fun addCountryToList() {
        countryList.add(CountryInfo(name ="Italy",			cases = "203.591", death = "71.252"))
        countryList.add(CountryInfo(name ="Spain",			cases = "236.899",  death ="132.929"))
        countryList.add(CountryInfo(name ="United Kingdom", cases = "166.440", death = "847"))
        countryList.add(CountryInfo(name ="United States", 	cases = "1.030.487",  death ="116.811"))
        countryList.add(CountryInfo(name ="China", 			cases = "83.940", death = "78.455"))
    }

    private fun showCases() {
        countryList.forEach {
            val countryInfoView = layoutInflater.inflate(R.layout.country_info,null)
            val cases = countryInfoView.findViewById<TextView>(R.id.cases_text_field)
            cases.text = it.cases
            val countryFlag = countryInfoView.findViewById<ImageButton>(R.id.country_flag_image_view)
            val flagNameId = this.resources.getIdentifier(it.name.toLowerCase().replace(" ", ""), "drawable", packageName)
            countryFlag.setImageResource(flagNameId)

            countryFlag.setOnClickListener { _ ->
                 Toast.makeText(this,"La cantidad de muertes: " + it.death , LENGTH_LONG).show()
            }
            country_grid_layout.addView(countryInfoView)
        }
    }
}

data class CountryInfo(val name: String, val cases: String,val death: String){}
