package com.example.cock_bar

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cock_bar.db.CockDbManager

class MainActivity : AppCompatActivity() {
    val cockDbManager = CockDbManager(context = this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        if (this.cockDbManager.readDbData() == null) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.activity_my_cocktails)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

    }

}


