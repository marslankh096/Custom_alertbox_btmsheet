package com.app.custom

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import androidx.appcompat.app.AppCompatActivity
import com.app.custom.CustomAlertboxActivity

class CustomBottomSheetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_alertbox)

        val btnLogOut: Button = findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            val message = "Are you sure you want to log out"
            showCustomBottomSheet(message)
        }
    }

    private fun showCustomBottomSheet(message: String) {
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.layout_custom_bottomsheet, null)
        bottomSheetDialog.setContentView(view)

        // 🔥 This removes the white background
        bottomSheetDialog.setOnShowListener { dialog ->
            val d = dialog as BottomSheetDialog
            val bottomSheet = d.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.setBackgroundResource(android.R.color.transparent)
        }

        val tvMessage: TextView = view.findViewById(R.id.tvMessage)
        val btnYes: Button = view.findViewById(R.id.btnYes)
        val btnNo: Button = view.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener {
            Toast.makeText(this, "Click on Yes", Toast.LENGTH_LONG).show()
            bottomSheetDialog.dismiss()
        }

        btnNo.setOnClickListener {
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CustomAlertboxActivity::class.java)
    }

}
