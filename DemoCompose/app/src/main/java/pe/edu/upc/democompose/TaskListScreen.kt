package pe.edu.upc.democompose

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Preview
@Composable
fun TaskListScreen(modifier: Modifier = Modifier) {

    val tasks = listOf(
        Task(
            title = "Estudiar",
            createdAt = Calendar.getInstance().time,
            dueDate = Calendar.getInstance().time,
            isCompleted = false
        ),
        Task(
            title = "Asistir a clases",
            createdAt = Calendar.getInstance().time,
            dueDate = Calendar.getInstance().time,
            isCompleted = true
        )
    )

    Scaffold { paddingValues ->
        LazyColumn(modifier = modifier.padding(paddingValues)) {
            items(tasks) { task ->
                TaskListItem(task)
            }
        }
    }
}

@Composable
fun TaskListItem(task: Task){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            Text(task.title, modifier = Modifier.padding(8.dp))
            Checkbox(
                task.isCompleted,
                onCheckedChange = {

                }
            )
        }
    }
}