package com.mycompany.fortune;

import org.robovm.apple.dispatch.DispatchQueue;
import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    private static FortuneStore fortuneStore = new FortuneStore();
    private static FortuneClient fortuneClient = new FortuneClient();

    private UILabel label;

    @IBOutlet
    public void setLabel(UILabel label) {
        this.label = label;
    }

    @IBAction
    private void clicked() {
        fortuneClient.getFortune(new FortuneClient.OnFortuneListener() {
            @Override
            public void onFortune(String fortune) {
                setFortune(fortune);
            }
        });
    }

    private void setFortune(String fortune) {
        DispatchQueue.getMainQueue().sync(new Runnable() {
            @Override
            public void run() {
                label.setText(fortune);
            }
        });
    }
}
