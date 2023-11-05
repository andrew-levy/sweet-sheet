[!["Buy Me A Coffee"](https://www.buymeacoffee.com/assets/img/custom_images/orange_img.png)](https://www.buymeacoffee.com/hugemathguy)

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

Next, add the config plugin to your `app.json` or `app.config.js` (for Android only):

```json
{
  "expo": {
    "plugins": ["sweet-sheet"]
  }
}
```

Then rebuild your app:

```console 
# Using EAS? run a build in the cloud!
eas build --platform ios

# Otherwise, prebuild and run a local build
npx expo prebuild -p ios --clean
npx expo run:ios
```


> **_NOTE:_** This library will not work with Expo Go. Use a [custom dev client](https://docs.expo.dev/develop/development-builds/create-a-build/) instead!

## Usage

See the [example app](/example).

```tsx
import { useState } from "react";
import { Button, StyleSheet, Text, View, } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isPresented, setIsPresented] = useState(false);

  return (
    <View style={styles.container}>
      <Button onPress={() => setIsPresented(true)} title="Open" />
      <SweetSheet
        isPresented={isPresented}
        cornerRadius={30}
        detents={["medium", "large"]}
        onDismiss={() => setIsPresented(false)}
      >
        <View style={{ marginTop: 50, paddingHorizontal: 30 }}>
          <Text>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec
            aliquam, dolor ut aliquet placerat, diam magna placerat lacus, eget
            facilisis eros erat sit amet risus.
          </Text>
          <Button onPress={() => setIsPresented(false)} title="Dismiss" />
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

#### `isPresented`

#### `onDismiss`

#### `cornerRadius`

#### `detents`

#### `hideDragIndicator`

#### `children`

## TO DO 

- [ ] (Android) Get Compose bottom sheet to work
- [ ] (iOS) Make sure buttons in children can be pressed within the sheet (currently they can't)
