package com.example.jetpack_training_400point

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var japanese by mutableStateOf("")
    var mathematics by mutableStateOf("")
    var science by mutableStateOf("")
    var socialStudies by mutableStateOf("")
    var totalAmount by mutableStateOf(0)
    var showText by mutableStateOf("")

    fun subjectTotalAmount() {
        val japanseAmount =  japanese.toIntOrNull() ?: 0
        val mathematicsAmount = mathematics.toIntOrNull() ?: 0
        val scienceAmount = science.toIntOrNull() ?: 0
        val socialStudiesAmount = socialStudies.toIntOrNull() ?: 0
        totalAmount = japanseAmount + mathematicsAmount + scienceAmount + socialStudiesAmount
        showText()
    }

    fun showText() {
        val zoroText = "${totalAmount}満点おめでとう!\n今日は祝杯だ！"
        val sanjiText = "${totalAmount}点\nとてもよく頑張った！！さらに上を目指せ！！"
        val usoppuText = "${totalAmount}点\nまだまだ頑張りが必要だ！!"
        val meriText = "${totalAmount}点\n全然勉強が足りない！!"

        if(totalAmount <= 100) showText = meriText
        if(totalAmount > 100 && totalAmount <= 200)  showText = usoppuText
        if(totalAmount > 200 && totalAmount < 400) showText = sanjiText
        if(totalAmount == 400) showText = zoroText

    }
}