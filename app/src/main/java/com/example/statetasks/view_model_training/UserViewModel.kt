package com.example.statetasks.view_model_training

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class UserViewModel : ViewModel() {

    private val _userName: MutableStateFlow<String> = MutableStateFlow("")

    val userName: StateFlow<String> = _userName

    fun upName(newName: String){
      _userName.update { currentName ->
          if (newName.isEmpty()) {
              newName
          } else {
              val firstChar = newName[0].uppercase()
              val rest = newName.substring(1).lowercase()
              firstChar + rest
          }
      }
    }
}