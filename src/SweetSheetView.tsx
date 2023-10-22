import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { SweetSheetViewProps } from './SweetSheet.types';

const NativeView: React.ComponentType<SweetSheetViewProps> =
  requireNativeViewManager('SweetSheet');

export default function SweetSheetView(props: SweetSheetViewProps) {
  return <NativeView {...props} />;
}
