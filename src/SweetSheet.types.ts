import { ViewProps } from "react-native";

export type SweetSheetViewProps = {
  isOpen: boolean;
  detents?: Detents[];
} & ViewProps;

type Detents = "medium" | "large" | { fraction: number } | { height: number };
