import { ViewProps } from "react-native";

export type SweetSheetViewProps = {
  isPresented: boolean;
  detents?: ("medium" | "large" | { fraction: number } | { height: number })[];
  hideDragIndicator?: boolean;
  cornerRadius?: number;
  onDismiss?: () => void;
  children?: React.ReactElement | React.ReactElement[];
} & ViewProps;

