package com.example.exampleproject.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.exampleproject.R
import com.example.exampleproject.databinding.SplashLayoutBinding
import kotlinx.android.synthetic.main.splash_layout.*

class SplashFragment:Fragment() {

    private lateinit var binding:SplashLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.splash_layout,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var animation = AnimationUtils.loadAnimation(this.context, R.anim.rocket_anim)
        binding.imgLogo.animation = animation
    }

    override fun onResume() {
        object : CountDownTimer(7000,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToListFragment())
            }

        }.start()

        super.onResume()
    }
}