import { ViewProps } from "react-native";

export type SweetSheetViewProps = {
  isOpen: boolean;
  detents?: ("medium" | "large" | { fraction: number } | { height: number })[];
  hideDragIndicator?: boolean;
  cornerRadius?: number;
  onClose?: () => void;
  children?: React.ReactElement | React.ReactElement[];
} & ViewProps;

