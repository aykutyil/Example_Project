package com.example.exampleproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.exampleproject.model.Rockets
import com.example.exampleproject.retrofit.RetrofitInstance
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ListViewModel : ViewModel() {

    val rocketsList = MutableLiveData<Rockets>()
    val rocketListLoading = MutableLiveData<Boolean>()
    val rocketListError = MutableLiveData<Boolean>()

    private val disposable = CompositeDisposable()

    fun getDataFromList(){
        rocketListLoading.value = true
        disposable.add(
            RetrofitInstance.getAllRocketData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<Rockets>(){
                    override fun onSuccess(rocketList: Rockets) {
                        rocketsList.postValue(rocketList)
                        rocketListLoading.value = false
                    }

                    override fun onError(e: Throwable) {
                        rocketListLoading.value = false
                        rocketListError.value = true
                        Log.d("Hata","alooo" + e.message.toString())
                    }

                })
        )


    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}