package expo.modules.sweetsheet

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class SweetSheetModule : Module() {
  override fun definition() = ModuleDefinition {
    Name("SweetSheet")

    View(SweetSheetView::class) {
      Events("onClose")
      Prop("isOpen") { view: SweetSheetView, isOpen: Boolean ->
          view.updateIsOpen(isOpen)
      }
    }
  }
}
