import ExpoModulesCore
import SwiftUI

public class SweetSheetModule: Module {
  public func definition() -> ModuleDefinition {
    Name("SweetSheet")
    View(SweetSheetView.self) {
      Events("onClose")
      Prop("isOpen") { (view: SweetSheetView, isOpen: Bool?) in
        view.props.isOpen = isOpen ?? false
      }
      Prop("detents") {(view: SweetSheetView, detents: [Any]?) in
        view.props.detents = detents ?? []
      }
      Prop("hideDragIndicator") {(view: SweetSheetView, hideDragIndicator: Bool?) in
        view.props.hideDragIndicator = hideDragIndicator ?? false
      }
      Prop("cornerRadius") {(view: SweetSheetView, cornerRadius: Double?) in
        view.props.cornerRadius = cornerRadius.map { CGFloat($0) }
      }
    }
  }
}


