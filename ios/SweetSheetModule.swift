import ExpoModulesCore
import SwiftUI

public class SweetSheetModule: Module {
  public func definition() -> ModuleDefinition {
    Name("SweetSheet")
    View(SweetSheetView.self) {
      Prop("isOpen") { (view: SweetSheetView, isOpen: Bool?) in
        view.props.isOpen = isOpen ?? false
      }
      Prop("detents") {(view: SweetSheetView, detents: [Any]?) in
        view.props.detents = detents ?? []
      }
    }
  }
}


