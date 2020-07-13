import 'package:fdlsandbox_flutter/firebase/DynamicLinksHelper.dart';
import 'package:firebase_dynamic_links/firebase_dynamic_links.dart';
import 'package:flutter/material.dart';
import 'MainAppPage.dart';

class MainAppState extends State<MainAppPage> {
  final String debugClass = 'DynamicLinksHelper';
  int clickCount = 0;
  String longLink = 'Long FDL will appear here',
      shortLink = 'Short FDL will appear here';

  // Initialize Firebase Dynamic Links
  @override
  void initState() {
    super.initState();
    this.initDynamicLinks();
  }

  void incrementClick() {
    setState(() {
      clickCount++;
    });
  }

  @override
  Widget build(BuildContext context) {
    DynamicLinksHelper FDLHelper = DynamicLinksHelper();
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blueAccent,
        title: Text('FDL Sandbox'),
      ),
      backgroundColor: Colors.white,
      body: Center(
          child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        crossAxisAlignment: CrossAxisAlignment.center,
        children: <Widget>[
          RaisedButton(
            onPressed: () {
              generateLongLink(FDLHelper.dynamicLinkParameters());
              debugPrint('Generate FDL clicked!');
            },
            child: Text('Generate FDL'),
          ),
          Padding(
            padding: const EdgeInsets.all(20),
            child: SelectableText(longLink),
          ),
          Padding(
            padding: const EdgeInsets.all(20),
            child: SelectableText(shortLink),
          ),
          RaisedButton(
            onPressed: () {
              incrementClick();
              debugPrint('$debugClass: WebView clicked!');
            },
            child: Text('WebView'),
          )
        ],
      )),
    );
  }

  /// Method generating long Firebase Dynamic Links
  Future<void> generateLongLink(DynamicLinkParameters parameters) async {
    final Uri longLink = await parameters.buildUrl();
    debugPrint('$debugClass: Long link: $longLink');
    setState(() {
      this.longLink = '$longLink';
    });
    generateShortLink(parameters, longLink);
  }

  /// Method generating short Firebase Dynamic Links
  Future<void> generateShortLink(
      DynamicLinkParameters parameters, Uri longLink) async {
    final ShortDynamicLink shortLinkUri =
        await DynamicLinkParameters.shortenUrl(
      longLink,
      DynamicLinkParametersOptions(
          shortDynamicLinkPathLength: ShortDynamicLinkPathLength.unguessable),
    );
    final ShortDynamicLink shortLinkParams = await parameters.buildShortLink();
    debugPrint('$debugClass: Short link via uri: ${shortLinkUri.shortUrl}');
    debugPrint(
        '$debugClass: Short link via params: ${shortLinkParams.shortUrl}');
    setState(() {
      this.shortLink = '${shortLinkParams.shortUrl}';
    });
  }

  void initDynamicLinks() async {
    final PendingDynamicLinkData data =
        await FirebaseDynamicLinks.instance.getInitialLink();
    final Uri deepLink = data?.link;

    if (deepLink != null) {
      Navigator.pushNamed(context, deepLink.path);
    }

    FirebaseDynamicLinks.instance.onLink(
        onSuccess: (PendingDynamicLinkData dynamicLink) async {
      final Uri deepLink = dynamicLink?.link;
      print('$debugClass: DEEP LINK: $deepLink');
      print('$debugClass: deep link null? ${deepLink == null}');

      if (deepLink != null) {
        Navigator.pushNamed(context, deepLink.path);
      }
    }, onError: (OnLinkErrorException e) async {
      print('$debugClass: onLinkError ${e.message}');
    });
  }
}
