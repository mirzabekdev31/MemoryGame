package uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.mirzabek.example.memorygame.data.model.CardData
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum
import uz.gita.mirzabek.example.memorygame.domain.usecase.GameUseCase
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.GameViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModelImpl
    @Inject constructor(private val useCase: GameUseCase)
    :GameViewModel,ViewModel(){
    override val cardsFlow= MutableStateFlow<List<CardData>>(emptyList())

    override fun getCardsByLevel(level: LevelEnum) {
        useCase.getCardsByLevel(level).onEach {
            cardsFlow.emit(it)
        }.launchIn(viewModelScope)
    }
}