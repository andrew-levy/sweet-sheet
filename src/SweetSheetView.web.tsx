import * as React from 'react';

import { SweetSheetViewProps } from './SweetSheet.types';

export default function SweetSheetView(props: SweetSheetViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
