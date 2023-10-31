package expo.modules.sweetsheet

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.viewevent.ViewEventCallback
import expo.modules.kotlin.views.ExpoView

class SweetSheetView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private val onDismiss by EventDispatcher()

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

//        (child.parent as ViewGroup).removeView(child)

        it.setContent {
            SweetSheetComposeView(
                child = child,
                isPresented = false,
                detents = true,
                cornerRadius = 40,
                hideDragIndicator = false,
                onDismiss = onDismiss
            )
        }
    }

    fun updateIsPresented(isPresented: Boolean) {
        composeSheet.setContent {
            SweetSheetComposeView(
                child = getChildAt(0),
                isPresented = isPresented,
                detents = true,
                cornerRadius = 40,
                hideDragIndicator = false,
                onDismiss = onDismiss
            )
        }
    }
}

class SweetSheetState {
    var isPresented: Boolean = false
    var hideDragIndicator: Boolean = false
    var detents: Boolean = false
    var cornerRadius: Int = 0
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SweetSheetComposeView(
    child: View,
    isPresented: Boolean,
    hideDragIndicator: Boolean,
    detents: Boolean,
    cornerRadius: Int,
    onDismiss: ViewEventCallback<Map<String, Any>>
) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(isPresented) }

    DisposableEffect(isPresented) {
        showBottomSheet = isPresented
        onDispose { }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                onDismiss(mapOf("dismissed" to true))
                showBottomSheet = false
            },
            sheetState = sheetState,
            shape = RoundedCornerShape(
                topStart = cornerRadius.dp,
                topEnd = cornerRadius.dp
            ),
            dragHandle = {
                if (hideDragIndicator) {
                    null
                } else {
                    BottomSheetDefaults.DragHandle()
                }
            },

            ) {
            Column(modifier = Modifier.height(300.dp)) {
                Text("Sheet content")
            }
        }
    }
}

