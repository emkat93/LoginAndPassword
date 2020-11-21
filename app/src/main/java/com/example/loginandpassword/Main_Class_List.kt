package com.example.loginandpassword

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class Main_Class_List : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main__class__list)

        val swDegreeCert = findViewById<Switch>(R.id.switch1)
        val spnDegree = findViewById<Spinner>(R.id.idSpinCert)
        val spnCertificate = findViewById<Spinner>(R.id.idSpinMajor)
        val txtCertificate = findViewById<TextView>(R.id.txtCert)
        val txtDegree = findViewById<TextView>(R.id.txtMajor)
        val btnNext = findViewById<Button>(R.id.idBtn)

        val firstName = findViewById<EditText>(R.id.idFirstName)
        val lastName = findViewById<EditText>(R.id.idLastName)
        val phone = findViewById<EditText>(R.id.idPhoneNumber)

        val spnMonth = findViewById<Spinner>(R.id.idSpinMonth)
        val txtDay = findViewById<EditText>(R.id.idDay)
        val txtYear = findViewById<EditText>(R.id.idYear)

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                spnDegree.visibility = View.VISIBLE
                txtDegree.visibility = View.VISIBLE
                spnCertificate.visibility = View.VISIBLE
                txtCertificate.visibility = View.VISIBLE
            } else{
                spnDegree.visibility = View.GONE
                txtDegree.visibility = View.GONE
                spnCertificate.visibility = View.GONE
                txtCertificate.visibility = View.GONE
            }

        }

        btnNext.setOnClickListener {
            if (checkData()){
                var doBirth = ""
                doBirth = spnMonth.selectedItem.toString() + "/" + txtDay.text.toString() + "/" + txtYear.text.toString()

                val nextScreen = Intent(this@Main_Class_List, activity_choose_class::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("BirthDate", doBirth)

                if(spnDegree.visibility == View.VISIBLE){
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("DegreeCert", spnDegree.selectedItem.toString())
                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("isDegreeCert", spnCertificate.selectedItem.toString())
                }

                //Start Activity
                startActivity(nextScreen)
            }
        }

        }

    private fun checkData(): Boolean {
        val firstName = findViewById<EditText>(R.id.idFirstName)
        val lastName = findViewById<EditText>(R.id.idLastName)
        val phone = findViewById<EditText>(R.id.idPhoneNumber)
        val txtDay = findViewById<EditText>(R.id.idDay)
        val txtYear = findViewById<EditText>(R.id.idYear)

        if (firstName.text.toString().isEmpty()){
            //error
            firstName.error = "Invalid First Name"
            firstName.requestFocus()
            return false
        }

        if (lastName.text.toString().isEmpty()){
            //error
            lastName.error = "Invalid Last Name"
            lastName.requestFocus()
            return false
        }

        if (phone.text.toString().isEmpty()){
            //error
            phone.error = "Invalid Phone Number"
            phone.requestFocus()
            return false
        }

        if (txtDay.text.toString().isEmpty()){
            //error
            txtDay.error = "Invalid Date Selection"
            txtDay.requestFocus()
            return false
        }

        if (txtYear.text.toString().isEmpty()){
            //error
            txtYear.error = "Invalid Year Selection"
            txtYear.requestFocus()
            return false
        }

        return true
    }

    }
