package uz.gita.mirzabek.example.memorygame.domain.repository

import uz.gita.mirzabek.example.memorygame.data.model.CardData

interface AppRepository {
    suspend fun getCardDataByCount(count : Int) : List<CardData>
}