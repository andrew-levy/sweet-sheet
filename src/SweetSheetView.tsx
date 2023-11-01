import { requireNativeViewManager } from "expo-modules-core";
import * as React from "react";

import { View } from "react-native";
import { SweetSheetViewProps } from "./SweetSheet.types";

const NativeView: React.ComponentType<SweetSheetViewProps> =
  requireNativeViewManager("SweetSheet");

export default function SweetSheetView(props: SweetSheetViewProps) {
  const { style, children, ...restProps } = props;
  return (
    <NativeView
      pointerEvents="none"
      style={{
        position: "absolute",
        top: 0,
        bottom: 0,
        left: 0,
        right: 0,
        zIndex: -1000,
      }}
      {...restProps}
    >
      <View style={{backgroundColor: "transparent"}}>{children}</View>
    </NativeView>
  );
}
