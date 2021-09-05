package com.example.homework

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager

class ViewAdapter: PagerAdapter{
    private lateinit var context: Context
    private lateinit var layoutInflater: LayoutInflater
    private val item = arrayOf(R.mipmap.gruppo_di_maschere_4, R.mipmap.gruppo_di_maschere_3, R.mipmap.gruppo_di_maschere_5)

    constructor(context: Context) {
        this.context = context
    }
    override fun getCount(): Int {
        return item.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater;
        val view: View = layoutInflater.inflate(R.layout.onboard_1, null)
        val imageView: ImageView = view.findViewById(R.id.imgLogin)
        val txtSkip: TextView = view.findViewById(R.id.txtSkip)
        val imageBack: ImageView = view.findViewById(R.id.img_back)
        val txt2: TextView = view.findViewById(R.id.txt2)
        val txt3: TextView = view.findViewById(R.id.txt3)
        val txt4: TextView = view.findViewById(R.id.txt4)
        val btnNext: Button = view.findViewById(R.id.next_start)
        when(position){
            0 -> {
                txt2.text = "Start to invest"
                txt3.text = "for your future!"
                txt4.text = "Ex totam praesentium incidunt aut."
                btnNext.text = "Next"
            }
            1 -> {
                txt2.text = "Follow our tips"
                txt3.text = "to achieve success!"
                txt4.text = "Ex totam praesentium incidunt aut."
                imageBack.setImageResource(R.drawable.ic_back)
                btnNext.text = "Next"
                val param1 = txt2.layoutParams as ConstraintLayout.LayoutParams
                param1.topToTop = txtSkip.id
                val param2 = imageView.layoutParams as ConstraintLayout.LayoutParams
                param2.topToTop = txt4.id
            }
            2 -> {
                btnNext.text = "Start"
                txt2.text = "Keep your"
                txt3.text = "investment safe"
                txt4.text = "Ex totam praesentium incidunt aut."
                imageBack.setImageResource(R.drawable.ic_back)
            }
        }
        txtSkip.text = "Skip"
        imageView.setImageResource(item[position])
        val viewPager: ViewPager = container as ViewPager
        viewPager.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager: ViewPager = container as ViewPager
        val view: View = `object` as View
        viewPager.removeView(view)
    }
}
