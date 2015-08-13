package com.mycompany.remembr;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.uikit.*;
import org.robovm.objc.annotation.CustomClass;
import org.robovm.objc.annotation.IBAction;

import java.util.List;

@CustomClass("NameListController")
public class NameListController extends UITableViewController {
    private List<String> names;

    public void setNames(List<String> names) {
        this.names = names;
    }

    @Override
    public long getNumberOfSections(UITableView tableView) {
        return 1;
    }

    @Override
    public long getNumberOfRowsInSection(UITableView tableView, long section) {
        return names.size();
    }

    @Override
    public UITableViewCell getCellForRow(UITableView tableView, NSIndexPath indexPath) {
        int row = (int)indexPath.getRow();
        UITableViewCell cell = tableView.dequeueReusableCell("NameListCell");
        if(cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.Default, "NameListCell");
        }
        cell.getTextLabel().setText(names.get(row));
        return cell;
    }

    @Override
    public void prepareForSegue(UIStoryboardSegue segue, NSObject sender) {
        super.prepareForSegue(segue, sender);
        if(segue.getIdentifier().equals("EditName")) {
            int selectedRow = (int)getTableView().getIndexPathForSelectedRow().getRow();
            String name = names.get(selectedRow);
            UINavigationController navController = (UINavigationController)segue.getDestinationViewController();
            EditingController editingController = (EditingController)navController.getVisibleViewController();
            editingController.setNameToEdit(name, selectedRow);
        }
    }

    @IBAction
    public void unwindToNameList(UIStoryboardSegue segue) {
        if(segue.getIdentifier().equals("EditSave")) {
            EditingController editingController = (EditingController)segue.getSourceViewController();
            String name = editingController.getEditedName().trim();
            if(!name.isEmpty()) {
                names.set(editingController.getIndex(), name);
                getTableView().reloadData();
            }
        }
    }
}
