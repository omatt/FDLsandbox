import 'package:flutter/material.dart';
import 'MainAppPage.dart';

class MainApp extends StatelessWidget {
  int clickCount = 0;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(home: MainAppPage()
    );
  }

  Text updatePrint(int clickCount) {
    return Text('Number of clicks: $clickCount');
  }
}

