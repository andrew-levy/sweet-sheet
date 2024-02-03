import ExpoModulesCore
import SwiftUI

class Props: ObservableObject {
  @Published var isPresented: Bool = false
  @Published var hideDragIndicator: Bool = false
  @Published var detents: [Any] = []
  @Published var cornerRadius: CGFloat? = nil
  @Published var children: UIView?
  @Published var onDismiss: EventDispatcher
  
  init(onDismiss: EventDispatcher) {
    self.onDismiss = onDismiss
  }
}

struct SweetSheetSwiftUIView: View {
  @ObservedObject var props: Props
  
  var body: some View {
    EmptyView()
      .sheet(isPresented: $props.isPresented, onDismiss: {
        props.onDismiss()
      }) {
        RepresentableView(view: props.children)
          .sheetDetents(props.detents)
          .hideDragIndicator(props.hideDragIndicator)
          .sheetCornerRadius(props.cornerRadius)
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

