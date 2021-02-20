package com.example.exampleproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleproject.model.RocketsItem
import com.example.exampleproject.retrofit.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DetailViewModel : ViewModel() {

    val rocketListLoading = MutableLiveData<Boolean>()
    val rocketItem = MutableLiveData<RocketsItem>()
    private val disposable = CompositeDisposable()

    fun getSingleItem(rocketId: String) {
        rocketListLoading.value = true
        disposable.add(
            RetrofitInstance.getSingleRocket(rocketId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<RocketsItem>(){
                    override fun onSuccess(rocketValue: RocketsItem) {
                        rocketItem.postValue(rocketValue)
                        rocketListLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Error",e.message.toString())
                    }

                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}