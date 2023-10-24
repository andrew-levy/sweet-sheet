import { useState } from "react";
import { Button, StyleSheet, Text, View } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isOpen, setIsOpen] = useState(false);
  return (
    <View style={styles.container}>
      <Button onPress={() => setIsOpen(true)} title="Open" />
      <SweetSheet
        isOpen={isOpen}
        detents={["medium", "large"]}
        cornerRadius={40}
        onClose={() => setIsOpen(false)}
      >
        <View
          style={{
            paddingHorizontal: 30,
            alignItems: "center",
          }}
        >
          <Text
            style={{ fontSize: 30, fontWeight: "bold", textAlign: "center" }}
          >
            This is a React Native View!
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
