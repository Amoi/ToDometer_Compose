/*
 * Copyright 2020 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sergiobelda.todometer.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.sergiobelda.todometer.R
import com.sergiobelda.todometer.model.Task
import com.sergiobelda.todometer.model.TaskState
import com.sergiobelda.todometer.ui.components.ProjectSelector
import com.sergiobelda.todometer.ui.components.TextField
import com.sergiobelda.todometer.ui.theme.MaterialColors
import com.sergiobelda.todometer.viewmodel.MainViewModel

@Composable
fun AddTaskScreen(
    mainViewModel: MainViewModel,
    navigateUp: () -> Unit
) {
    var taskTitle by rememberSaveable { mutableStateOf("") }
    var taskTitleInputError by remember { mutableStateOf(false) }
    var taskDescription by rememberSaveable { mutableStateOf("") }
    val radioOptions = mainViewModel.projectList
    val (selectedProject, onProjectSelected) = remember { mutableStateOf(radioOptions[0]) }
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialColors.surface,
                contentColor = contentColorFor(MaterialColors.surface),
                elevation = 0.dp,
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                },
                title = { Text(stringResource(id = R.string.add_task)) }
            )
        },
        bodyContent = {
            Column {
                TextField(
                    value = taskTitle,
                    onValueChanged = {
                        taskTitle = it
                        taskTitleInputError = false
                    },
                    label = { Text(stringResource(id = R.string.title)) },
                    isErrorValue = taskTitleInputError,
                    errorMessage = stringResource(id = R.string.field_not_empty),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Next
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = taskDescription,
                    onValueChanged = { taskDescription = it },
                    label = { Text(stringResource(id = R.string.description)) },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Sentences,
                        imeAction = ImeAction.Done
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                ProjectSelector(radioOptions, selectedProject, onProjectSelected)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    if (taskTitle.isBlank()) {
                        taskTitleInputError = true
                    } else {
                        mainViewModel.insertTask(
                            Task(
                                title = taskTitle,
                                description = taskDescription,
                                state = TaskState.DOING,
                                projectId = selectedProject.id,
                                tagId = null
                            )
                        )
                        navigateUp()
                    }
                },
            ) {
                Icon(Icons.Rounded.Check, contentDescription = "Add task")
            }
        }
    )
}
