import { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isOpen, setIsOpen] = useState(true);
  return (
    <View style={styles.container}>
      <Text>Hello from the app</Text>
      <SweetSheet isOpen={isOpen} detents={["medium", "large"]}>
        <View style={{ paddingHorizontal: 30 }}>
          <Text style={{ fontSize: 30, fontWeight: "bold" }}>Title</Text>
          <Button onPress={() => setIsOpen(false)} title="Close" />
        </View>
      </SweetSheet>
      <Text>Hello from the app</Text>
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
