package com.mycompany.remembr;

import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.UIStoryboardSegue;
import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;
import org.robovm.objc.annotation.IBOutlet;

import java.util.ArrayList;
import java.util.List;


@CustomClass("MainSceneController")
public class MainSceneController extends UIViewController {
    private UITextField textField;
    private List<String> names;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        names = new ArrayList<String>();
    }

    @IBOutlet
    public void setTextField(UITextField textField) {
        this.textField = textField;
    }

    @IBAction
    public void rememberName() {
        String name = textField.getText().trim();
        if(!name.isEmpty()) {
            names.add(name);
            this.textField.setText("");
        }
    }

    @Override
    public void prepareForSegue(UIStoryboardSegue segue, NSObject sender) {
        super.prepareForSegue(segue, sender);
        if(segue.getIdentifier().equals("ShowNames")) {
            NameListController nameListController = (NameListController)segue.getDestinationViewController();
            nameListController.setNames(names);
        }
    }
}
