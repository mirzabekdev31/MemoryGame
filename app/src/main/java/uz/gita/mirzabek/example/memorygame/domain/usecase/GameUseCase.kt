package uz.gita.mirzabek.example.memorygame.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.mirzabek.example.memorygame.data.model.CardData
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum

interface GameUseCase {
    fun getCardsByLevel(level: LevelEnum): Flow<List<CardData>>
}