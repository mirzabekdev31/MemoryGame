package uz.gita.mirzabek.example.memorygame.presentation.ui.screen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.memorygame.R
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.SplashViewModel
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl.SplashViewModelImpl

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashScreen :Fragment(R.layout.screen_splash){
    private val viewModel: SplashViewModel by viewModels<SplashViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel
    }
}