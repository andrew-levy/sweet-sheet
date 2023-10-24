import { ViewProps } from "react-native";

export type SweetSheetViewProps = {
  isOpen: boolean;
  detents?: Detents[];
  hideDragIndicator?: boolean;
  cornerRadius?: number;
  onClose?: () => void;
  children?: React.ReactElement;
} & ViewProps;

type Detents = "medium" | "large" | { fraction: number } | { height: number };
