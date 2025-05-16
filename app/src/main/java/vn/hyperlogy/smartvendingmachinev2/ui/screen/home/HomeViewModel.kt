package vn.hyperlogy.smartvendingmachinev2.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow("Hello from ViewModel!")
    val uiState: StateFlow<String> = _uiState


    fun updateMessage(newMessage: String) {
        viewModelScope.launch {
            _uiState.value = newMessage
        }
    }
}