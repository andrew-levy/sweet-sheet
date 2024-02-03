import ExpoModulesCore
import SwiftUI

class SweetSheetView: ExpoView {
  let props: Props
  let onDismiss = EventDispatcher()

  override func insertReactSubview(_ subview: UIView!, at atIndex: Int) {
//    super.insertReactSubview(subview, at: atIndex)
    props.children = subview
  }

  required init(appContext: AppContext? = nil) {
    props = Props(onDismiss: onDismiss)
    let hostingController = UIHostingController(rootView: SweetSheetSwiftUIView(props: props))
    super.init(appContext: appContext)
    addSubview(hostingController.view)
  }

}

