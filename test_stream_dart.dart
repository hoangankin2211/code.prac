import 'dart:ffi';

void main() async {
  var future = await testStream().length;
  print(future);
}

Stream<int> testStream() async* {
  yield 1;
  yield 2;
  yield 3;
  yield 4;
}

extension StreamExtension on Stream<int> {
  Future<int> sum() async {
    var sum = 0;
    await for (final value in this) {
      sum += value;
    }
    return sum;
  }
}

extension DoubleExtension on Double {
  bool isInteger() {
    return false;
  }
}
