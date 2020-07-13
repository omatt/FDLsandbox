import 'package:firebase_dynamic_links/firebase_dynamic_links.dart';
import 'package:flutter/material.dart';

class DynamicLinksHelper {
  final String debugClass = 'DynamicLinksHelper';
  Future<void> generateFDL() async {
    debugPrint('$debugClass: Generate FDL');
    DynamicLinkParameters parameters = DynamicLinkParameters(
      uriPrefix: 'https://fdlsandbox.page.link',
      link: Uri.parse('https://google.com/'),
      androidParameters: AndroidParameters(
        packageName: 'com.omatt.fdlsandbox',
      ),
      iosParameters: IosParameters(
        bundleId: 'com.omatt.fdlsandbox',
        appStoreId: '544007664',
      ),
//      googleAnalyticsParameters: GoogleAnalyticsParameters(
//        campaign: 'test_campaign',
//        medium: 'test_medium',
//        source: 'test_source',
//      ),
//      itunesConnectAnalyticsParameters: ItunesConnectAnalyticsParameters(
//        providerToken: '123456',
//    campaignToken: 'example-promo',
//      ),
//      socialMetaTagParameters:  SocialMetaTagParameters(
//        title: 'Example of a Dynamic Link',
//        description: 'This link works whether app is installed or not!',
//      ),
    );

    final Uri dynamicUrl = await parameters.buildUrl();
    debugPrint('$debugClass: Long link: $dynamicUrl');
  }

  // Return FDL parameters
  DynamicLinkParameters dynamicLinkParameters() {
    return DynamicLinkParameters(
      uriPrefix: 'https://fdlsandbox.page.link',
      link: Uri.parse('https://google.com/'),
      androidParameters: AndroidParameters(
        packageName: 'com.omatt.fdlsandbox',
      ),
      iosParameters: IosParameters(
        bundleId: 'com.omatt.fdlsandbox',
        appStoreId: '544007664',
      ),
//      googleAnalyticsParameters: GoogleAnalyticsParameters(
//        campaign: 'test_campaign',
//        medium: 'test_medium',
//        source: 'test_source',
//      ),
//      itunesConnectAnalyticsParameters: ItunesConnectAnalyticsParameters(
//        providerToken: '123456',
//    campaignToken: 'example-promo',
//      ),
//      socialMetaTagParameters:  SocialMetaTagParameters(
//        title: 'Example of a Dynamic Link',
//        description: 'This link works whether app is installed or not!',
//      ),
    );
  }
}
