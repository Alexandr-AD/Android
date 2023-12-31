package com.practicum.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.practicum.dessertclicker.data.Datasource.dessertList
import com.practicum.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {

    private val _dessertUiState = MutableStateFlow(DessertUiState())
    val dessertUiState: StateFlow<DessertUiState> = _dessertUiState.asStateFlow()

    fun onDessertClicked() {
        _dessertUiState.update { cupcakeUiState ->
            val dessertsSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for(index in dessertList.indices) {
            if(dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            }
            else
                break

        }
        return dessertIndex
    }
}