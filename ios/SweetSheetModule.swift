import ExpoModulesCore
import SwiftUI

public class SweetSheetModule: Module {
  public func definition() -> ModuleDefinition {
    Name("SweetSheet")
    View(SweetSheetView.self) {
      Events("onDismiss")
      Prop("isPresented") { (view: SweetSheetView, isPresented: Bool?) in
        view.props.isPresented = isPresented ?? false
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


