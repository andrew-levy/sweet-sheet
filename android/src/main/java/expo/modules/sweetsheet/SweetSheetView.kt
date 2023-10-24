package expo.modules.sweetsheet

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidView
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.views.ExpoView
import kotlinx.coroutines.launch

class SweetSheetView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private val onClose by EventDispatcher()

    internal val composeSheet = ComposeView(context).also {
        addView(it)
        it.layoutParams = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
        val child = getChildAt(0) as ViewGroup
        child.layoutParams = LayoutParams(
            child.measuredWidth, child.measuredHeight
        )

        it.setContent {
            SweetSheetComposeView(child, false)
        }
    }

    fun updateIsOpen(isOpen: Boolean) {
        composeSheet.setContent {
            SweetSheetComposeView(getChildAt(0), isOpen)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SweetSheetComposeView(child: View, isOpen: Boolean) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show bottom sheet") },
                icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                onClick = {
                    showBottomSheet = true
                }
            )
        }
    ) { contentPadding ->
        // Screen content

        if (showBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState
            ) {
                // Sheet content
                Button(onClick = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showBottomSheet = false
                        }
                    }
                }) {
                    Text("Hide bottom sheet")
                }
            }
        }
    }
//    val sheetState = rememberModalBottomSheetState()
//    var showBottomSheet by remember { mutableStateOf(true) }
//    if (showBottomSheet) {
//        ModalBottomSheet(
//            onDismissRequest = {
//                showBottomSheet = false
//            },
//            sheetState = sheetState
//        ) {
//            // Sheet content
//            AndroidView(
//                modifier = Modifier.fillMaxSize(),
//                factory = { context ->
//                    TextView(context).apply {
//                        // Customize the TextView
//                        textSize = 16f
//                        setTextColor(0xFF000000.toInt()) // Set text color
//                        // Set the text
//                        setText(text)
//                    }
//                }
//            )
//        }
//    }
}

