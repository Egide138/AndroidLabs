@file:OptIn(ExperimentalFoundationApi::class)
package com.example.newlab3.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.newlab3.R
import com.example.newlab3.model.Task
import com.example.newlab3.model.TaskViewModel
import com.example.newlab3.ui.theme.NewLab3Theme
import java.util.*

@Composable
fun TaskScreen() {
    val viewModel:TaskViewModel = viewModel()
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        backgroundColor = MaterialTheme.colors.primary,
        topBar = {
            TopAppBar(
                title = {Text(stringResource(id = R.string.Todo))
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, null)
                    }
                },
                actions = {
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Share, null)
                    }
                    IconButton(onClick = {/* Do Something*/ }) {
                        Icon(Icons.Filled.Settings, null)
                    }
                },
                backgroundColor = MaterialTheme.colors.secondaryVariant)  },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {showDialog = true}
            )
            {
                Icon(Icons.Filled.Add, contentDescription = "")
            }
        },
        content = {
            if (showDialog){
                addBookDialog(context, dismissDialog = {showDialog = false}, {viewModel.add(it)})
            }
            LazyColumn(
                contentPadding = PaddingValues(
                    vertical = 8.dp,
                    horizontal = 8.dp
                )
            )
            {
                items(viewModel.bookList, key={book -> book.id}) { book ->
                    BookItem(item = book, context, {viewModel.delete(it)})
                }
            }
        }
    )
}

@Composable
fun addBookDialog(context: Context, dismissDialog:() -> Unit, addBook: (Task) -> Unit){
    var TaskTextField by remember {
        mutableStateOf("")
    }

    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.addBook), style = MaterialTheme.typography.h6)},
        text = {
            Column(modifier = Modifier.padding(top=20.dp)) {
                TextField(label = {Text(text=stringResource(id = R.string.TaskName))}, value = TaskTextField, onValueChange = {TaskTextField=it})
            }
        },
        confirmButton = {
            Button(onClick = {
                if(TaskTextField.isNotEmpty()) {
                    val newID = UUID.randomUUID().toString();
                    addBook(Task(newID, TaskTextField))
                    Toast.makeText(
                        context,
                        context.resources.getString(R.string.bookAdded),
                        Toast.LENGTH_SHORT
                    ).show()
                }
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.add))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )
}

@Composable
fun deleteBookDialog(context: Context, dismissDialog:() -> Unit, item:Task, deleteBook: (Task) -> Unit){
    AlertDialog(
        onDismissRequest = { dismissDialog},
        title={Text(text = stringResource(id = R.string.delete), style = MaterialTheme.typography.h6)},
        confirmButton = {
            Button(onClick = {
                deleteBook(item)
                Toast.makeText(
                    context,
                    context.resources.getString(R.string.deleteBook),
                    Toast.LENGTH_SHORT
                ).show()
                dismissDialog()
            })
            {
                Text(text = stringResource(id = R.string.yes))
            }
        },dismissButton = {
            Button(onClick = {
                dismissDialog()
            }) {
                Text(text = stringResource(id = R.string.no))
            }
        }
    )
}
@Composable
fun CheckBoxDemo() {
    val checkedState = remember { mutableStateOf(false) }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it },

        )
}

@Composable
fun BookItem(item: Task, context: Context, deleteBook: (Task) -> Unit) {
    var showDeleteDialog by remember { mutableStateOf(false) }

    Card(
        elevation = 6.dp,
        shape = RoundedCornerShape(10.dp),
        backgroundColor = MaterialTheme.colors.primaryVariant,
        contentColor = MaterialTheme.colors.onPrimary,
        border = BorderStroke(2.dp, color = MaterialTheme.colors.secondary),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .combinedClickable(
                onClick = {
                    Toast
                        .makeText(
                            context,
                            context.resources.getString(R.string.readmsg) + " " + item.task,
                            Toast.LENGTH_SHORT
                        )
                        .show()
                },
                onLongClick = { showDeleteDialog = true }
            )
    ) {
        Row()
        {
            Column(modifier = Modifier
                .padding(top = 20.dp)
                .padding(start = 10.dp)) {
                Text(text = item.task, style = MaterialTheme.typography.h6)
                //Spacer(modifier = Modifier.width(150.dp))
            }
            //Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.padding(10.dp)) {
                CheckBoxDemo()
            }

        }
    }
    if (showDeleteDialog){
        deleteBookDialog(context, dismissDialog = {showDeleteDialog = false}, item, deleteBook)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NewLab3Theme {
        TaskScreen()
    }
}