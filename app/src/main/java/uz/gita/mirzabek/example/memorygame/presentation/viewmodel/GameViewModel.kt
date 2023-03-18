package uz.gita.mirzabek.example.memorygame.presentation.viewmodel

import kotlinx.coroutines.flow.StateFlow
import uz.gita.mirzabek.example.memorygame.data.model.CardData
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum

interface GameViewModel {
    val cardsFlow : StateFlow<List<CardData>>

    fun getCardsByLevel(level : LevelEnum)
}