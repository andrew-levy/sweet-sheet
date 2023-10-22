import { StyleSheet, Text, View } from 'react-native';

import * as SweetSheet from 'sweet-sheet';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>{SweetSheet.hello()}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
