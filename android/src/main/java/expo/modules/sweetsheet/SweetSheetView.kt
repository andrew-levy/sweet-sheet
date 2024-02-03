package expo.modules.sweetsheet

import android.content.Context
import android.graphics.Canvas
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.viewevent.ViewEventCallback
import expo.modules.kotlin.views.ExpoView

class SweetSheetView(context: Context, appContext: AppContext) : ExpoView(context, appContext) {
    private val onDismiss by EventDispatcher()
    private val uiState = mutableStateOf(SweetSheetState())
    private var isViewInvalidated = false

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (changed) { isViewInvalidated = true }
        return
    }

    override fun dispatchDraw(canvas: Canvas) {
        super.dispatchDraw(canvas)
        if (isViewInvalidated) {
            val child = getChildAt(0)
            removeView(child)
            uiState.value = uiState.value.copy(child = child)
            isViewInvalidated = false;
        }
    }

    init {
        ComposeView(context).also {
            addView(it)
            it.layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT)
            it.setContent {
                SweetSheetComposeView(
                    state = uiState,
                    onDismiss = onDismiss
                )
            }
        }
    }

    fun updateIsPresented(isPresented: Boolean) {
        uiState.value = uiState.value.copy(isPresented = isPresented)
    }
    fun updateHideDragIndicator(hideDragIndicator: Boolean) {
        uiState.value = uiState.value.copy(hideDragIndicator = hideDragIndicator)
    }
    fun updateCornerRadius(cornerRadius: Int?) {
        uiState.value = uiState.value.copy(cornerRadius = cornerRadius)
    }
}

data class SweetSheetState(
    var isPresented: Boolean = false,
    var hideDragIndicator: Boolean = false,
    var cornerRadius: Int? = null,
    var child: View? = null,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SweetSheetComposeView(
    state: MutableState<SweetSheetState>,
    onDismiss: ViewEventCallback<Map<String, Any>>
) {
    val sheetState = rememberModalBottomSheetState()
    if (state.value.isPresented) {
        ModalBottomSheet(
            onDismissRequest = {
                onDismiss(mapOf("dismissed" to true))
            },
            sheetState = sheetState,
            shape = if (state.value.cornerRadius == null) {
                BottomSheetDefaults.ExpandedShape
            } else {
                RoundedCornerShape(
                    topStart = state.value.cornerRadius?.dp ?: 0.dp,
                    topEnd = state.value.cornerRadius?.dp ?: 0.dp,
                )
            },
            dragHandle = {
                if (!state.value.hideDragIndicator) {
                    BottomSheetDefaults.DragHandle()
                } else null
            }
            ) {
            Column {
                state.value.child?.let { child ->
                    AndroidView(
                        modifier = Modifier.fillMaxHeight(),
                        factory = { child },
                    )
                }
            }
        }
    }
}

