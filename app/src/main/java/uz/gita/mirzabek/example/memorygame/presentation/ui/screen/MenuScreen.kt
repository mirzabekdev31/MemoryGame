package uz.gita.mirzabek.example.memorygame.presentation.ui.screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.mirzabek.example.memorygame.R
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum
import uz.gita.mirzabek.example.memorygame.databinding.ScreenMenuBinding
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.MenuViewModel
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl.MenuViewModelImpl
import uz.infinity.memorygamebottcamp4.utils.myApply

@AndroidEntryPoint
class MenuScreen :Fragment(R.layout.screen_menu){
    private val binding by viewBinding(ScreenMenuBinding::bind)
    private val viewModel: MenuViewModel by viewModels<MenuViewModelImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) =binding.myApply{
        super.onViewCreated(view, savedInstanceState)
        easy.setOnClickListener { viewModel.selectLevel(LevelEnum.EASY) }
        medium.setOnClickListener { viewModel.selectLevel(LevelEnum.MEDIUM) }
        hard.setOnClickListener { viewModel.selectLevel(LevelEnum.HARD) }
    }
}