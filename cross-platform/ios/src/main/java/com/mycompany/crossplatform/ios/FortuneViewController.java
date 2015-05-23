package com.mycompany.crossplatform.ios;

import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

import com.mycompany.crossplatform.core.FortuneStore;

@CustomClass("FortuneViewController")
public class FortuneViewController extends UIViewController {
    private static FortuneStore fortunes = new FortuneStore();

    private UILabel fortuneLabel;

    @IBOutlet
    public void setLabel(UILabel label) {
        this.fortuneLabel = label;
    }

    @IBAction
    private void clicked() {
        fortuneLabel.setText(fortunes.getFortune());
    }
}