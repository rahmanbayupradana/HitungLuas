package com.bayupradana.hitungluas

import android.annotation.SuppressLint
import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.core.view.get

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    lateinit var edtSisi: EditText
    lateinit var btnHasil: Button
    lateinit var tvResult: TextView
    lateinit var spinner: Spinner

    private var luas1 = arrayListOf("Luas Persegi", "Luas Kubus")

    private var namaLuas: Array<String> = arrayOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtSisi = findViewById(R.id.edt_angka)
        btnHasil = findViewById(R.id.btn_hasil)
        tvResult = findViewById(R.id.tv_hasil)
        spinner = findViewById(R.id.spinner)
        spinner.onItemSelectedListener = this

        namaLuas = resources.getStringArray(R.array.luas)

        ArrayAdapter.createFromResource(
            this,
            R.array.luas,
            android.R.layout.simple_spinner_item
        ).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = arrayAdapter

        }

        btnHasil.setOnClickListener {
            if (edtSisi.text.isEmpty()) {
                Toast.makeText(this, "Kolom tidak boleh kosong", Toast.LENGTH_SHORT).show()

            } else if (spinner.selectedItem.toString().equals(namaLuas[0])) {
                val sisi = edtSisi.text.toString().toDouble()
                val hasil = hitungLuas(sisi)
                tvResult.text = hasil.toString()
            } else if (spinner.selectedItem.toString().equals(namaLuas[1])) {
                val sisi1 = edtSisi.text.toString().toDouble()
                val hasil1 = hitungLuasKubus(sisi1)
                tvResult.text = hasil1.toString()

            }
        }


        // data spinner
        /*   var adapter =
               ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, luas)
           spinner.adapter = adapter

           btnHasil.setOnClickListener {
               if (spinner.selectedItem.toString().equals(luas[0])) {
                   val sisi: Double = edtSisi.text.toString().toDouble()
                   val hasil = hitungLuas(sisi.toInt())
                   tvResult.text = hasil.toString()
               } else if (spinner.selectedItem.toString().equals(luas[1])) {
                   val sisi1: Double = edtSisi.text.toString().toDouble()
                   val hasil1 = hitungLuasKubus(sisi1.toInt())
                   tvResult.text = hasil1.toString()
               }
           }

           spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
               override fun onNothingSelected(parent: AdapterView<*>?) {
                   TODO("Not yet implemented")
               }

               override fun onItemSelected(
                   parent: AdapterView<*>?,
                   view: View?,
                   position: Int,
                   id: Long
               ) {
                   Toast.makeText(
                       this@MainActivity,
                       parent?.getItemAtPosition(position).toString(),
                       Toast.LENGTH_LONG
                   ).show()
               }
           }
       }

       fun hitungLuas(sisi: Int): Int {
           return sisi * sisi
       }

       fun hitungLuasKubus(sisi: Int): Int {
           return 6 * sisi * sisi */
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(this, parent?.getItemAtPosition(position).toString(), Toast.LENGTH_LONG)
            .show()

    }

    fun hitungLuas(sisi: Double): Double {
        return sisi * sisi
    }

    fun hitungLuasKubus(sisi: Double): Double {
        return sisi * sisi * 6
    }
}


