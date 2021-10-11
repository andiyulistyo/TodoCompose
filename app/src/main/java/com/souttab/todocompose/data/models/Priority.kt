package com.souttab.todocompose.data.models

import androidx.compose.ui.graphics.Color
import com.souttab.todocompose.ui.theme.HighPriorityColor
import com.souttab.todocompose.ui.theme.LowPriorityColor
import com.souttab.todocompose.ui.theme.MediumPriorityColor
import com.souttab.todocompose.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}