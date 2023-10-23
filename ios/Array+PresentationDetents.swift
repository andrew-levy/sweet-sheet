import SwiftUI

extension Array where Element == Any {
  @available(iOS 16.0, *)
  func toPresentationDetents() -> Set<PresentationDetent> {
    var validDetents: Set<PresentationDetent> = []
    for item in self {
      if let stringValue = item as? String {
        // Handle strings (e.g., "medium", "large")
        if stringValue == "medium" {
          validDetents.insert(PresentationDetent.medium)
        } else if stringValue == "large" {
          validDetents.insert(PresentationDetent.large)
        }
      } else if let dictionary = item as? [String: Any] {
        // Handle dictionaries with fraction or height values
        if let fraction = dictionary["fraction"] as? CGFloat {
          validDetents.insert(PresentationDetent.fraction(fraction))
        } else if let height = dictionary["height"] as? CGFloat {
          validDetents.insert(PresentationDetent.height(height))
        }
      }
    }
    return validDetents
  }
}
