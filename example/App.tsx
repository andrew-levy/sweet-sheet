import { useState } from "react";
import { Button, StyleSheet, Text, View, } from "react-native";

import SweetSheet from "sweet-sheet";

export default function App() {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <View style={styles.container}>
      <Button onPress={() => setIsOpen(true)} title="Open" />
      <SweetSheet
        isPresented={isOpen}
        cornerRadius={30}
        detents={["medium", "large"]}
        onDismiss={() => setIsOpen(false)}
      >
        <View
          style={{
            marginTop: 50,
            paddingHorizontal: 30,
          }}
        >
          <Text
            style={{
              fontSize: 30,
              fontWeight: "bold",
              paddingBottom: 10,
            }}
          >
            Sheet Content!
          </Text>
   
          <Text>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec
            aliquam, dolor ut aliquet placerat, diam magna placerat lacus, eget
            facilisis eros erat sit amet risus.
          </Text>
          
          <Button onPress={() => setIsOpen(false)} title="Close b" />
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
