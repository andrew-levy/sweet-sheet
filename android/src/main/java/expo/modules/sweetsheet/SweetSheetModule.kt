package expo.modules.sweetsheet

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class SweetSheetModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("SweetSheet")

    View(SweetSheetView::class) {
      Events("onDismiss")
      Prop("isPresented") { view: SweetSheetView, isPresented: Boolean ->
          view.updateIsPresented(isPresented)
      }
    }
  }
}
