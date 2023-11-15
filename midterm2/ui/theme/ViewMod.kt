package com.example.midterm2.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewMod(private val apiService: Service) : ViewModel() {

    private val _users = MutableLiveData<List<User1>>()
    val users: LiveData<List<User1>> = _users

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val userList = apiService.getUsers()
                _users.postValue(userList)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
