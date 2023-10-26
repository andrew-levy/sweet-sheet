# Sweet Sheet

A native Sheet component built with Expo's Module API

## Highlights

- :fire: Built with [Expo's Module API](https://docs.expo.dev/modules/module-api/)
- :art: Built with SwiftUI and Jetpack Compose

## Installation (Coming Soon!)

Sweet Sheet likely requires Expo SDK 46+.

### Expo

Install the library:

```console
npx expo install ?????
```

Then rebuild your app. If you are using EAS Build, simply run a build using eas-cli.

```
eas build --platform ios
```

If not, you'll need to rebuild your dev client.

```console
npx expo prebuild -p ios --clean
npx expo run:ios
```

> **_NOTE:_** This library will not work with Expo Go. Use a [custom dev client](https://docs.expo.dev/develop/development-builds/create-a-build/) instead!

## Usage

```tsx
import { useState } from "react";
import { Button, StyleSheet, Text, View, } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <View style={styles.container}>
      <Button onPress={() => setIsOpen(true)} title="Open" />
      <SweetSheet
        isOpen={isOpen}
        cornerRadius={30}
        detents={["medium", "large"]}
        onClose={() => setIsOpen(false)}
      >
        <View style={{ marginTop: 50,paddingHorizontal: 30 }}>
          <Text>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec
            aliquam, dolor ut aliquet placerat, diam magna placerat lacus, eget
            facilisis eros erat sit amet risus.
          </Text>
          <Button onPress={() => setIsOpen(false)} title="Close" />
        </View>
      </SweetSheet>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});

```

## `<SweetSheet />`

The `SweetSheet` component uses SwiftUI's `.sheet()` modifier to render a native sheet on iOS and Jetpack Compose's `BottomSheet` view on Android.

### `Props`

#### `isOpen`

#### `onClose`

#### `cornerRadius`

#### `detents`

#### `hideDragIndicator`

#### `children`

