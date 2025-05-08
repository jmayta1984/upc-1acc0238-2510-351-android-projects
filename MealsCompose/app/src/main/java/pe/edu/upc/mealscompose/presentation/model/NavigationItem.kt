package pe.edu.upc.mealscompose.presentation.model

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val icon: ImageVector,
    val title: String,
    val route: String
)
