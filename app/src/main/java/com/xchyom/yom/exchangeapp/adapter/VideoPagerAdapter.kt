package com.xchyom.yom.exchangeapp.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.xchyom.yom.exchangeapp.dto.VideosDTO
import com.xchyom.yom.exchangeapp.ui.ExchangeFragment
import com.xchyom.yom.exchangeapp.ui.FavoriteFragment
import com.xchyom.yom.exchangeapp.ui.VideoFragment

class VideoPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    private var videoList: List<VideosDTO> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ExchangeFragment()
            }

            1 -> {
                FavoriteFragment()
            }

            else -> {
                VideoFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    fun setVideoList(videoList: List<VideosDTO>) {
        this.videoList = videoList
        notifyDataSetChanged()
    }
}