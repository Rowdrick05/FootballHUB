package com.example.jetpackcomposelearning.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    // --- Logic for the Splash Screen ---
    private val _isLoading = MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(2000) // Your 2-second delay
            _isLoading.value = false
        }
    }

    // --- Logic for the Main Screen Search ---
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    private val _players = MutableStateFlow<List<Player>>(emptyList())
    val players = _players.asStateFlow()

    fun onSearchQueryChanged(query: String) {
        _searchQuery.value = query
    }

    fun performSearch() {
        val query = _searchQuery.value
        if (query.isBlank()) {
            _players.value = emptyList()
        } else {
            _players.value = allPlayers.filter {
                it.name.contains(query, ignoreCase = true)
            }
        }
    }
}