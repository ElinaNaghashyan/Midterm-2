package com.example.midterm2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel



class MainActivity : ComponentActivity() {
    val ViewMod: ViewMod by viewModels()

    class ViewMod {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatherAndroidTasksTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    UserList(ViewMod)
                }
            }
        }
    }
}

@Composable
fun <ViewMod> UserList(viewModel: ViewMod = viewModel()) {
    val users by viewModel.users.observeAsState(initial = emptyList())

    LaunchedEffect(viewModel) {
        viewModel.fetchUsers()
    }

    LazyColumn {
        items(users) { user ->
            UserItem(user)
        }
    }
}

@Composable
fun UserItem(user: User1) {
    Text(text = "Name: ${user.name}, Username: ${user.username}")
}


@Composable
fun FeatherAndroidTasksTheme(content: @Composable () -> Unit) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize().padding(LocalContentPadding.current),
        ) {
            content()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun UserListPreview() {
    FeatherAndroidTasksTheme {
        UserList<Any>()
    }
}

@Preview(showBackground = true)
@Composable
fun UserItemPreview() {
    FeatherAndroidTasksTheme {
        UserItem(User1(1, "Elina", "elina17"))
    }
}


