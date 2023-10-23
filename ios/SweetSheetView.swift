import ExpoModulesCore
import SwiftUI

class Props: ObservableObject {
  @Published var isOpen: Bool = false
  @Published var detents: [Any] = []
  @Published var children: UIView?
}

struct SweetSheetSwiftUIView: View {
  @ObservedObject var props: Props
  
  var body: some View {
    EmptyView()
      .sheet(isPresented: $props.isOpen) {
        RepresentableView(view: props.children ?? UIView())
          .fixedSize(horizontal: false, vertical: true)
          .conditionalDetents(props.detents)
      }
  }
}

struct RepresentableView: UIViewRepresentable {
  var view: UIView
  func makeUIView(context: Context) -> UIView {
    return view
  }
  func updateUIView(_ uiView: UIView, context: Context) {}
}
