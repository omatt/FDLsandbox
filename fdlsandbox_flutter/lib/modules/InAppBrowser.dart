import 'dart:io';

import 'package:flutter/material.dart';
import 'package:webview_flutter/webview_flutter.dart';

class InAppBrowser extends StatefulWidget {
  @override
  InAppBrowserState createState() => InAppBrowserState();
}

class InAppBrowserState extends State<InAppBrowser> {
  final debugClass = 'DynamicLinksHelper';
  @override
  void initState() {
    super.initState();
    // Enable hybrid composition.
    if (Platform.isAndroid) WebView.platform = SurfaceAndroidWebView();
  }

  @override
  Widget build(BuildContext context) {
    final dynamicLink = ModalRoute.of(context).settings.arguments;
    debugPrint('$debugClass Dynamic Link: $dynamicLink');
    return WebView(
      initialUrl: dynamicLink,
    );
  }
}
