package com.mycompany.remembr;

import org.robovm.apple.uikit.UITextField;
import org.robovm.apple.uikit.UIViewController;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBOutlet;

@CustomClass("EditingController")
public class EditingController extends UIViewController {
    private UITextField textField;
    private String nameToEdit;
    private int index;

    public void setNameToEdit(String nameToEdit, int index) {
        this.nameToEdit = nameToEdit;
        this.index = index;
    }

    public String getEditedName() {
        return textField.getText();
    }

    public int getIndex() {
        return index;
    }

    @IBOutlet
    public void setTextField(UITextField textField) {
        this.textField = textField;
    }

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
        textField.setText(nameToEdit);
    }
}
