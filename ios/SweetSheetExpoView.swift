import ExpoModulesCore
import SwiftUI

class SweetSheetView: ExpoView {
  let props = Props()
  
  override func didUpdateReactSubviews() {
    let subChildren = self.reactSubviews()
    props.children = subChildren?[0]
  }

  required init(appContext: AppContext? = nil) {
    let hostingController = UIHostingController(rootView: SweetSheetSwiftUIView(props: props))

    super.init(appContext: appContext)
    hostingController.view.backgroundColor = .clear
    hostingController.view.frame = .zero
    addSubview(hostingController.view)
  }
}
