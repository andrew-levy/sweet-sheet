import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to SweetSheet.web.ts
// and on native platforms to SweetSheet.ts
import SweetSheetModule from './SweetSheetModule';
import SweetSheetView from './SweetSheetView';
import { ChangeEventPayload, SweetSheetViewProps } from './SweetSheet.types';

// Get the native constant value.
export const PI = SweetSheetModule.PI;

export function hello(): string {
  return SweetSheetModule.hello();
}

export async function setValueAsync(value: string) {
  return await SweetSheetModule.setValueAsync(value);
}

const emitter = new EventEmitter(SweetSheetModule ?? NativeModulesProxy.SweetSheet);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { SweetSheetView, SweetSheetViewProps, ChangeEventPayload };
