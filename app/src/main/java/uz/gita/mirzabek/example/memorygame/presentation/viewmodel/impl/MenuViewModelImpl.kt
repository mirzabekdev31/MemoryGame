package uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum
import uz.gita.mirzabek.example.memorygame.navigation.NavigationHandler
import uz.gita.mirzabek.example.memorygame.presentation.ui.screen.MenuScreenDirections
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.MenuViewModel
import javax.inject.Inject


@HiltViewModel
class MenuViewModelImpl
    @Inject constructor(
        private val navigationHandler: NavigationHandler
        ):MenuViewModel,ViewModel(){

    override fun selectLevel(level: LevelEnum) {
        viewModelScope.launch {
            val direction=MenuScreenDirections.actionMenuScreenToGameScreen()
            direction.level=level
            navigationHandler.navigationTo(direction)
        }
    }
}