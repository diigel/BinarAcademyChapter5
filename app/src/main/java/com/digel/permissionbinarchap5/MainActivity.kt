package com.digel.permissionbinarchap5

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.digel.permissionbinarchap5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnShowImage.setOnClickListener {
                loadImage()
            }

            btnNext.setOnClickListener {
                checkPermission()
            }
        }
    }

    private fun loadImage() = binding.run {
        Glide.with(this@MainActivity)
            .load(Constant.IMAGE_URL)
            .placeholder(R.drawable.ic_launcher_background)
            .circleCrop()
            .into(image)
    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val permissionCheck = checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)

            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                val langLong = getLangLot()
                startActivity(
                    Intent(this, SecondActivity::class.java)
                        .putExtra("lat_long", langLong)
                )
            } else {
                requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 201)
            }
        } else {
            Toast.makeText(this, "Your Version Android Not Support", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 201) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED && permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION) {
                Toast.makeText(this, "Permission for Location GRANTED", Toast.LENGTH_SHORT).show()
                val latLong = getLangLot()
                startActivity(
                    Intent(this, SecondActivity::class.java)
                        .putExtra("lat_long", latLong)
                )
            } else {
                Toast.makeText(this, "Permission for Location Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    @SuppressLint("MissingPermission")
    private fun getLangLot(): String {
        val locationManager = applicationContext.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        val location: Location? = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)

        val latLong =  "Lat : ${location?.latitude} Long : ${location?.longitude}"
        Log.i("LATLONG", "getLangLot: $latLong")
        return  latLong
    }

    override fun onStart() {
        super.onStart()
        Log.i("ON START", "is Activity Start")
        Toast.makeText(this, "this Activity Start", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.i("ON RESUME", " is Activity Resume")
        Toast.makeText(this, "this Activity Resume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.i("ON PAUSE", " is Activity Pause")
        Toast.makeText(this, "this Activity Pause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.i("ON STOP", "is Activity Stop")
        Toast.makeText(this, "this Activity Stop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ON Restart", "is Activity Restart")
        Toast.makeText(this, "this Activity Restart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ON DESTROY", "is Activity Destroy")
        Toast.makeText(this, "this Activity Destroy", Toast.LENGTH_SHORT).show()
    }

}