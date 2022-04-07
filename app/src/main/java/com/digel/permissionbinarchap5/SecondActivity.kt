package com.digel.permissionbinarchap5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.digel.permissionbinarchap5.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : ActivitySecondBinding

    private val langLong by lazy {
        intent.getStringExtra("lat_long")
    }

    private val pagerAdapter by lazy {
        ViewPagerAdapter(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            imgBack.setOnClickListener { onBackPressed() }
            vp.offscreenPageLimit = 2
            pagerAdapter.also { viewPagerAdapter ->
                viewPagerAdapter.addFragment(FirstFragment(),"First Fragment")
                viewPagerAdapter.addFragment(SecondFragment(),"Second Fragment")
                vp.adapter = viewPagerAdapter
            }
        }
    }
}