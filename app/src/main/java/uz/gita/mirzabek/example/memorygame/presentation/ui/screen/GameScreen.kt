package uz.gita.mirzabek.example.memorygame.presentation.ui.screen
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.supervisorScope
import uz.gita.mirzabek.example.memorygame.R
import uz.gita.mirzabek.example.memorygame.data.model.CardData
import uz.gita.mirzabek.example.memorygame.data.model.LevelEnum
import uz.gita.mirzabek.example.memorygame.databinding.ScreenGameBinding
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.GameViewModel
import uz.gita.mirzabek.example.memorygame.presentation.viewmodel.impl.GameViewModelImpl
import uz.infinity.memorygamebottcamp4.utils.closeAnimation
import uz.infinity.memorygamebottcamp4.utils.myApply
import uz.infinity.memorygamebottcamp4.utils.myLog
import uz.infinity.memorygamebottcamp4.utils.openAnim

@AndroidEntryPoint
class GameScreen :Fragment(R.layout.screen_game) {
    private val viewModel: GameViewModel by viewModels<GameViewModelImpl>()
    private val binding by viewBinding(ScreenGameBinding::bind)
    private val navArg by navArgs<GameScreenArgs>()
    private var level = LevelEnum.EASY
    private var _height = 0
    private var _width = 0
    private var isEnabled = true
    private var count = 0
    private var firstData: CardData? = null
    private var secondData: CardData? = null
    private var firstImage: ImageView? = null
    private var secondImage: ImageView? = null
    private val images = ArrayList<ImageView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.myApply {
        super.onViewCreated(view, savedInstanceState)
        level = navArg.level
        main.post {
            _height = space.height / level.verCount
            _width = space.width / level.horCount
            viewModel.getCardsByLevel(level)
        }
        viewModel.cardsFlow.onEach { describeImages(it) }.launchIn(lifecycleScope)
    }

    private fun describeImages(list: List<CardData>) {

        if (list.isEmpty()) return
        for (i in 0 until level.verCount) {
            for (j in 0 until level.horCount) {
                val imageView = ImageView(requireContext())
                imageView.tag = list[i * level.horCount + j]
                binding.container.addView(imageView)
                val lp = imageView.layoutParams as ConstraintLayout.LayoutParams
                lp.apply {
                    this.height = _height
                    this.width = _width
                }
                lp.setMargins(4, 4, 4, 4)
                imageView.layoutParams = lp
                imageView.x = (j * _width).toFloat()
                imageView.y = (i * _height).toFloat()
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                imageView.setImageResource(R.drawable.image_back)
                images.add(imageView)
                val data = list[i * level.horCount + j]
                myLog("($i: $j) ${data.amount} ->  ${data.imgUrl}")
            }
        }
        addClickListener()
    }

    private fun addClickListener() {
        images.forEach { view ->
            view.setOnClickListener {
                if (!isEnabled || it.rotationY == 180f) return@setOnClickListener
                isEnabled=false
                if (count == 0) {
                    firstData = view.tag as CardData
                    firstImage = view
                    count++
                } else {
                    secondData = view.tag as CardData
                    secondImage = view
                    count++
                    isEnabled = false
                }
                view.openAnim {
                    if (count == 2) {
                        if (secondData?.amount == firstData?.amount) {
                            firstImage?.visibility = View.INVISIBLE
                            secondImage?.visibility = View.INVISIBLE
                        } else {
                            firstImage?.closeAnimation {}
                            secondImage?.closeAnimation {}
                        }
                        firstImage = null; secondImage = null; firstData = null;secondData = null
                        count = 0
                    }
                    isEnabled=true
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        images.clear()
    }
}