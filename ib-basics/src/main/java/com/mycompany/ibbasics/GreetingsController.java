package com.mycompany.ibbasics;

import org.robovm.apple.uikit.UILabel;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("GreetingsController")
public class GreetingsController extends UIViewController {
    private UILabel label;
    private UITextField textField;

    @IBOutlet
    public void setLabel(UILabel label) {
        this.label = label;
    }

    @IBOutlet
    public void setTextField(UITextField textField) {
        this.textField = textField;
    }

    @IBAction
    private void clicked() {
        String name = textField.getText();
        if (name.isEmpty()) {
            name = "Unknown";
        }
        label.setText("Hello " + name + "!");
    }

    @IBAction
    private void textChanged() {
        label.setText("I see you typing!");
    }
}
