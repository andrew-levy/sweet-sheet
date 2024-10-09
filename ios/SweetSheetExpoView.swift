import ExpoModulesCore
import SwiftUI

class SweetSheetView: ExpoView {
  let props: Props
  let onDismiss = EventDispatcher()
  private var touchHandler: RCTTouchHandler?

  override func insertReactSubview(_ subview: UIView!, at atIndex: Int) {
    self.touchHandler?.attach(to: subview)
    props.children = subview
  }

  required init(appContext: AppContext? = nil) {
    props = Props(onDismiss: onDismiss)
    let hostingController = UIHostingController(rootView: SweetSheetSwiftUIView(props: props))
    super.init(appContext: appContext)
    self.touchHandler = RCTTouchHandler(bridge: appContext?.reactBridge)
    addSubview(hostingController.view)
  }
  

}

