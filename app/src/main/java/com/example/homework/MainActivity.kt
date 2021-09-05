package com.example.homework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager
    private lateinit var dot1: DotsIndicator
    private lateinit var viewAdapter: ViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        initView()
    }

    private fun initView() {
        viewPager = findViewById(R.id.view_pager)
        dot1 = findViewById(R.id.dot1)
        viewAdapter = ViewAdapter(this)
        viewPager.adapter = viewAdapter
        dot1.setViewPager(viewPager)
    }
}