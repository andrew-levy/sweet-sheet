import { requireNativeViewManager } from "expo-modules-core";
import * as React from "react";
import { SweetSheetViewProps } from "./SweetSheet.types";

const NativeView: React.ComponentType<SweetSheetViewProps> =
  requireNativeViewManager("SweetSheet");

export default function SweetSheetView(props: SweetSheetViewProps) {
  const { children, ...restProps } = props;
  return (
    <NativeView
      style={{
        position: "absolute",
        pointerEvents: "none",
      }}
      {...restProps}
    >
      {children}
    </NativeView>
  );
}
