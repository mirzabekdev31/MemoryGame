package uz.gita.mirzabek.example.memorygame.presentation.viewmodel

import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum

interface MenuViewModel {
    fun selectLevel(level: LevelEnum)
}