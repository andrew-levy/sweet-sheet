import ExpoModulesCore
import SwiftUI

class Props: ObservableObject {
  @Published var isOpen: Bool = false
  @Published var hideDragIndicator: Bool = false
  @Published var detents: [Any] = []
  @Published var cornerRadius: CGFloat? = nil
  @Published var children: UIView?
  @Published var onClose: EventDispatcher
  
  init(onClose: EventDispatcher) {
    self.onClose = onClose
  }
}

struct SweetSheetSwiftUIView: View {
  @ObservedObject var props: Props
  
  var body: some View {
    EmptyView()
      .sheet(isPresented: $props.isOpen, onDismiss: {
        props.onClose()
      }) {
        RepresentableView(view: props.children)
          .sheetDetents(props.detents)
          .hideDragIndicator(props.hideDragIndicator)
          .sheetCornerRadius(props.cornerRadius)
//            .fixedSize(horizontal: false, vertical: true)

      }
  }
}
  
struct RepresentableView: UIViewRepresentable {
  var view: UIView?
  func makeUIView(context: Context) -> UIView {
    return view ?? UIView()
  }
  func updateUIView(_ uiView: UIView, context: Context) {}
}
