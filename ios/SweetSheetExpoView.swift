import ExpoModulesCore
import SwiftUI

class SweetSheetView: ExpoView {
  let props: Props
  let onDismiss = EventDispatcher()
  
  override func didUpdateReactSubviews() {
    let subChildren = self.reactSubviews()
    props.children = subChildren?[0]
  }

  required init(appContext: AppContext? = nil) {
    props = Props(onDismiss: onDismiss)
    let hostingController = UIHostingController(rootView: SweetSheetSwiftUIView(props: props))

    super.init(appContext: appContext)
    hostingController.view.backgroundColor = .clear
    hostingController.view.frame = .zero
    addSubview(hostingController.view)
  }
}
