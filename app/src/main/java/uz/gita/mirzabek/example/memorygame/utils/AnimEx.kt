package uz.infinity.memorygamebottcamp4.utils

import android.widget.ImageView
import uz.gita.mirzabek.example.memorygame.R
import uz.gita.mirzabek.example.memorygame.data.model.CardData

fun ImageView.openAnim(block: () -> Unit) {
    this.animate().setDuration(250).rotationY(89f).withEndAction {
        this.rotationY = 91f
        val data = this.tag as CardData
        this.setImageResource(data.imgUrl)
        this.animate().setDuration(250).rotationY(180f).withEndAction {
            block.invoke()
        }.start()
    }.start()
}

fun ImageView.closeAnimation(block: () -> Unit){
    this.animate().setDuration(250).rotationY(91f).withEndAction{
        this.rotationY=89f
        this.setImageResource(R.drawable.image_back)
        this.animate().setDuration(250).rotationY(0f).withEndAction{
            block.invoke()
        }.start()
    }.start()
}
