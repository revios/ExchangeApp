package com.xchyom.yom.exchangeapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.xchyom.yom.exchangeapp.entity.ExchangeEntity
import com.xchyom.yom.exchangeapp.repository.ExchangeRepository

class ExchangeViewModel(application: Application) : AndroidViewModel(application) {

    private var mRepository: ExchangeRepository = ExchangeRepository(application)
    internal var allList: LiveData<List<ExchangeEntity>>

    init {
        allList = mRepository.allList
    }

    fun getItemCounts(code: String): Int {
        return mRepository.getCountItem(code)
    }

    fun updateDatas() {
        mRepository.updateDatas()
        allList = mRepository.allList
    }

    fun insert(exchangeEntity: ExchangeEntity) {
        mRepository.insert(exchangeEntity)
    }
}