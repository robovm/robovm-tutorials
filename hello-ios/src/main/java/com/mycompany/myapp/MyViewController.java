package com.mycompany.myapp;

import org.robovm.apple.foundation.NSURL;
import org.robovm.apple.uikit.*;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    @IBOutlet private UITextField textField;
    @IBOutlet private UIButton callButton;

    private String translatedNumber;

    @IBAction
    private void clickedTranslate() {
        translatedNumber = PhoneTranslator.toNumber(textField.getText());

        textField.resignFirstResponder();

        if (translatedNumber.equals("")) {
            callButton.setTitle("Call ", UIControlState.Normal);
            callButton.setEnabled(false);
        } else {
            callButton.setTitle("Call " + translatedNumber, UIControlState.Normal);
            callButton.setEnabled(true);
        }
    }

    @IBAction
    private void clickedCall() {
        NSURL url = new NSURL("tel:" + translatedNumber);

        if (!UIApplication.getSharedApplication().openURL(url)) {
            UIAlertController alert = new UIAlertController("Not supported", "Scheme 'tel:' is not supported on this device", UIAlertControllerStyle.Alert);
            alert.addAction(new UIAlertAction("Ok", UIAlertActionStyle.Default, null));
            presentViewController(alert, true, null);
        }
    }
}
