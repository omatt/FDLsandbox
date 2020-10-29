//
//  ViewController.swift
//  fdlsandbox
//
//  Created by Omar Matthew Basco Reyes on 28/11/2018.
//  Copyright © 2018 Omar Matthe Reyes. All rights reserved.
//

import UIKit
import Firebase

class ViewController: UIViewController {
    
    @IBOutlet weak var longFDL: UILabel!
    @IBOutlet weak var shortFDL: UILabel!
    
    let dynamicLinksDomainURIPRefix = "https://fdlsandbox.page.link",
        deepLink = "https://google.com/?userId=sampleUserIdValue&setLng=en&customId=sampleCustomId",
        appBundleId = "com.omatt.fdlsandbox",
        appStoreId = "544007664",
        appPackageName = "com.omatt.fdlsandbox"
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }
    
    @IBAction func generateFDL(_ sender: UIButton) {
        guard let link = URL(string: deepLink) else { return }
        let linkBuilder = DynamicLinkComponents(link: link, domainURIPrefix: dynamicLinksDomainURIPRefix)
        linkBuilder?.iOSParameters = DynamicLinkIOSParameters(bundleID: appBundleId)
        linkBuilder?.androidParameters = DynamicLinkAndroidParameters(packageName: appPackageName)
        
        guard let longDynamicLink = linkBuilder?.url else { return }
        debugPrint("The long URL is: \(longDynamicLink)")
        
        longFDL.text = "\(longDynamicLink)"
        
        linkBuilder?.options = DynamicLinkComponentsOptions()
        linkBuilder?.options?.pathLength = .short
        linkBuilder?.shorten() { url, warnings, error in
            if (error != nil && url == nil) {
                debugPrint("shorten FDL error: \(error.debugDescription)")
                return
            }
            debugPrint("The short URL is: \(url!)")
            self.shortFDL.text = "\(url!)"
        }
    }
    
    
    @IBAction func openWebView(_ sender: UIButton) {
    }
}

