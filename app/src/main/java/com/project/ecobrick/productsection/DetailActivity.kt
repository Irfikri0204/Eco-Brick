package com.project.ecobrick.productsection

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.project.ecobrick.R
import com.project.ecobrick.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnHubungi.setOnClickListener {
            val phoneNumber = "628114128024" // Format: 62 untuk Indonesia
            val message = "Halo, saya ingin bertanya mengenai produk Anda."

            // Buat URL WhatsApp dengan parameter nomor telepon dan pesan
            val url = "https://api.whatsapp.com/send?phone=$phoneNumber&text=$message"

            // Buat intent untuk membuka WhatsApp
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)

            try {
                // Mulai aktivitas intent
                startActivity(intent)
            } catch (e: Exception) {
                // Tampilkan pesan jika WhatsApp tidak ditemukan atau ada error lain
                Toast.makeText(baseContext, "WhatsApp tidak tersedia di perangkat ini", Toast.LENGTH_SHORT).show()
            }
        }
        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}