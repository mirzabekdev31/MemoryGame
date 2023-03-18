package uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.memorygame.navigation.NavigationHandler
import uz.gita.mirzabek.example.memorygame.presentation.ui.screen.SplashScreenDirections
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.SplashViewModel
import javax.inject.Inject


@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val navigationHandler: NavigationHandler
    ) :SplashViewModel,ViewModel(){
        init {
            viewModelScope.launch(Dispatchers.IO) {
                delay(1000)
                navigationHandler.navigationTo(SplashScreenDirections.actionSplashScreenToMenuScreen())
            }
        }
}