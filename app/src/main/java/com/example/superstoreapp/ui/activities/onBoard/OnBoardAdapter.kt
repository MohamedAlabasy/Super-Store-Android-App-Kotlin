package com.example.superstoreapp.ui.activities.onBoard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
 import com.example.superstoreapp.R

class OnBoardAdapter(context: Context?) : PagerAdapter() {

    lateinit var context: Context

    init {
        if (context != null) {
            this.context = context
        }
    }

    //Arrays
    private var slid_img = intArrayOf(
        R.drawable.ic_onboard_img_1,
        R.drawable.ic_onboard_img_2,
        R.drawable.ic_onboard_img_3
    )

    private var slid_main_tv = intArrayOf(
        R.string.onBoard_main_tv1,
        R.string.onBoard_main_tv2,
        R.string.onBoard_main_tv3
    )
    private var slid_sup_tv = intArrayOf(
        R.string.onBoard_sub_tv1,
        R.string.onBoard_sub_tv2,
        R.string.onBoard_sub_tv3
    )

    override fun getCount(): Int {
        return slid_main_tv.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.items_onboard_slid, container, false)

        val slideImageView = view.findViewById<ImageView>(R.id.items_onBoard_img)
        val slideHeading = view.findViewById<TextView>(R.id.items_onBoard_main_tv)
        val slideDescription = view.findViewById<TextView>(R.id.items_onBoard_sub_tv)


        slideImageView.setImageResource(slid_img[position])
        slideHeading.setText(slid_main_tv[position])
        slideDescription.setText(slid_sup_tv[position])

        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }


}