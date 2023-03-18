package uz.gita.mirzabek.example.memorygame.domain.usecase.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.gita.mirzabek.example.memorygame.data.model.CardData
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum
import uz.gita.mirzabek.example.memorygame.domain.repository.AppRepository
import uz.gita.mirzabek.example.memorygame.domain.usecase.GameUseCase
import javax.inject.Inject

class GameUseCaseImpl @Inject constructor(
    private val repository: AppRepository
) :GameUseCase{
    override fun getCardsByLevel(level: LevelEnum): Flow<List<CardData>> = flow{
        val mustCardCount=(level.horCount*level.verCount)/2
        val list=repository.getCardDataByCount(mustCardCount)
        val result=ArrayList<CardData>()
        result.addAll(list)
        result.addAll(list)
        result.shuffle()
        emit(result)
    }
}