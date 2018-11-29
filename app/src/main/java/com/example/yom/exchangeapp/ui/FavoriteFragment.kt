package com.example.yom.exchangeapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yom.exchangeapp.R
import com.example.yom.exchangeapp.adapter.FavoriteAdapter
import com.example.yom.exchangeapp.entity.ExchangeEntity
import com.example.yom.exchangeapp.model.ExchangeViewModel
import kotlinx.android.synthetic.main.fragment_favourite.*


class FavoriteFragment : Fragment() {


    lateinit var adapter: FavoriteAdapter
    private lateinit var exchangeViewModel: ExchangeViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updateFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    private fun updateFragment() {
        exchangeViewModel = ViewModelProviders.of(this).get(ExchangeViewModel::class.java)
        exchangeViewModel.updateDatas()
        var list: List<ExchangeEntity>
        exchangeViewModel.allList.observe(this, Observer<List<ExchangeEntity>> {
            list = it
            rcyFavorite.setHasFixedSize(true)
            rcyFavorite.layoutManager = LinearLayoutManager(activity)
            adapter = FavoriteAdapter(rcyFavorite.context, list)
            rcyFavorite.adapter = adapter
        })
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser)
            updateFragment()
    }

}
