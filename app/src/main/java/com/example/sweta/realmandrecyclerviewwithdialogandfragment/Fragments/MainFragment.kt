package com.example.sweta.realmandrecyclerviewwithdialogandfragment.Fragments

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sweta.realmandrecyclerviewwithdialogandfragment.PojoClass.MyPojo
import com.example.sweta.realmandrecyclerviewwithdialogandfragment.R
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.dialog_custom.*

class MainFragment : AppCompatActivity(), View.OnClickListener {

    private lateinit var nameString:String
    private var rollInteger:Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)

        setListener();
    }

    private fun setListener() {
        saveBtn.setOnClickListener(this);
        viewList.setOnClickListener(this);
    }

    override fun onClick(p0: View?) {

        if(p0==saveBtn){
            nameString= nameField.text.toString().trim()

            if(nameString.isEmpty()){
                val builder = AlertDialog.Builder(this)

                val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                val view1 = inflater.inflate(R.layout.dialog_custom, null)

                builder.setView(view1)

                val dialog = builder.create()
                val okBtn = view1.findViewById<Button>(R.id.btnOk)

                btnOk.setOnClickListener(){
                    val intent= Intent(this, MainFragment::class.java)
                            startActivity(intent)
                    finish()
                    dialog.dismiss()
                }
                dialog.show()
            }else {
                val rollString = rollText.text.toString().trim { it <= ' ' }
                if (rollString.isEmpty()) run {

                    val builder = AlertDialog.Builder(this)

                    val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

                    val view1 = inflater.inflate(R.layout.dialog_custom, null)

                    builder.setView(view1)

                    val dialog = builder.create()
                    val okBtn = view1.findViewById<Button>(R.id.btnOk)

                    btnOk.setOnClickListener(){
                        val intent= Intent(this, MainFragment::class.java)
                        startActivity(intent)
                        finish()
                        dialog.dismiss()
                    }
                    dialog.show()

                } else {
                    try {

                        this.rollInteger= rollString.toInt()

                        val myPojo = MyPojo(nameString, rollInteger)

                        insertToRealm()

                        Toast.makeText(this, "Successful", Toast.LENGTH_SHORT).show()

                    } catch (e: Exception) {
                        Toast.makeText(this, "Please Enter roll number in integer", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }

    }

    private fun insertToRealm(){


    }

}
