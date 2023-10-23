import SwiftUI

extension View {
  func conditionalDetents(_ detents: [Any]) -> some View {
    modifier(DetentsModifier(detents: detents))
  }
}

struct DetentsModifier: ViewModifier {
  var detents: [Any]
  func body(content: Content) -> some View {
    if #available(iOS 16.0, *) {
      return AnyView(content.presentationDetents(detents.toPresentationDetents()))
    } else {
      return AnyView(content)
    }
  }
}
