import SwiftUI

extension View {
  func sheetDetents(_ detents: [Any]) -> some View {
    modifier(DetentsModifier(detents: detents))
  }
  func hideDragIndicator(_ hideDragIndicator: Bool) -> some View {
    modifier(DragIndicatorModifier(hideDragIndicator: hideDragIndicator))
  }
  func sheetCornerRadius(_ cornerRadius: CGFloat?) -> some View {
    modifier(CornerRadiusModifier(cornerRadius: cornerRadius))
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

struct DragIndicatorModifier: ViewModifier {
  var hideDragIndicator: Bool
  func body(content: Content) -> some View {
    if #available(iOS 16.0, *) {
      return AnyView(content.presentationDragIndicator(hideDragIndicator ? .hidden : .visible))
    } else {
      return AnyView(content)
    }
  }
}

struct CornerRadiusModifier: ViewModifier {
  var cornerRadius: CGFloat?
  func body(content: Content) -> some View {
    if cornerRadius == nil {
      return AnyView(content)
    }
    if #available(iOS 16.4, *) {
      return AnyView(content.presentationCornerRadius(cornerRadius))
    } else {
      return AnyView(content)
    }
  }
}
