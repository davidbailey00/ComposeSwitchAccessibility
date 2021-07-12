package co.zimly.switchaccessibility

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.zimly.switchaccessibility.ui.theme.SwitchAccessibilityTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwitchAccessibilityTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var pineappleOnPizza by remember { mutableStateOf(true) }

    Row(
        Modifier
            .padding(16.dp)
            .toggleable(
                role = Role.Switch,
                value = pineappleOnPizza,
                onValueChange = { pineappleOnPizza = it },
            )
    ) {
        Text("Pineapple on pizza?")
        Spacer(Modifier.width(8.dp))
        Switch(checked = pineappleOnPizza, onCheckedChange = null)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SwitchAccessibilityTheme {
        Greeting()
    }
}
