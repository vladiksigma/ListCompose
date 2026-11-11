package com.example.listcompose

import androidx.compose.ui.graphics.Color
import kotlin.math.abs


private val avatarColors = listOf(
    Color(0xFFEF5350), // Красный
    Color(0xFFAB47BC), // Фиолетовый
    Color(0xFF5C6BC0), // Индиго
    Color(0xFF29B6F6), // Голубой
    Color(0xFF26A69A), // Бирюзовый
    Color(0xFF66BB6A), // Зеленый
    Color(0xFFFFA726), // Оранжевый
    Color(0xFF8D6E63), // Коричневый
    Color(0xFFEC407A), // Розовый
    Color(0xFF42A5F5)  // Синий
)


fun getAvatarColor(id: String): Color {
    val index = abs(id.hashCode()) % avatarColors.size
    return avatarColors[index]
}