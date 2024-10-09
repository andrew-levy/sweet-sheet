import { hideAsync } from "expo-splash-screen";
import { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isOpen, setIsOpen] = useState(true);

  return (
    <View style={styles.container}>
      <Button onPress={() => setIsOpen(true)} title="Open" />
      <SweetSheet
        isPresented={isOpen}
        cornerRadius={20}
        hideDragIndicator={false}
        detents={["medium", "large", { height: 100 }, { fraction: 0.1 }]}
        onDismiss={() => setIsOpen(false)}
      >
        <View style={{ padding: 20, marginTop: 20 }}>
          <Text
            style={{
              fontSize: 30,
              fontWeight: "bold",
              paddingBottom: 10,
              textAlign: "center",
            }}
          >
            Sheet Content!!
          </Text>
          <Text>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec
            aliquam, dolor ut aliquet placerat, diam magna placerat lacus, eget
            facilisis eros erat sit amet risus.
          </Text>
          <Button
            onPress={() => {
              setIsOpen(false);
              console.log("dismissed");
            }}
            title="Dismiss"
          />
          <View style={{ height: 20 }} />
        </View>
      </SweetSheet>
      <Text>Open up App.tsx to start working on your app!</Text>
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
