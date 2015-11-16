package com.mycompany.myapp;

import org.robovm.apple.foundation.NSIndexPath;
import org.robovm.apple.uikit.UITableView;
import org.robovm.apple.uikit.UITableViewCell;
import org.robovm.apple.uikit.UITableViewCellStyle;
import org.robovm.apple.uikit.UITableViewController;
import org.robovm.objc.annotation.CustomClass;

import java.util.List;

@CustomClass("CallHistoryController")
public class CallHistoryController extends UITableViewController {
    private static String callHistoryCellId = "CallHistoryCell";
    private List<String> phoneNumbers;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public long getNumberOfSections(UITableView tableView) {
        return 1;
    }

    @Override
    public long getNumberOfRowsInSection(UITableView tableView, long section) {
        return phoneNumbers.size();
    }

    @Override
    public UITableViewCell getCellForRow(UITableView tableView, NSIndexPath indexPath) {
        int row = (int)indexPath.getRow();
        UITableViewCell cell = tableView.dequeueReusableCell(callHistoryCellId);
        if(cell == null) {
            cell = new UITableViewCell(UITableViewCellStyle.Default, callHistoryCellId);
        }
        cell.getTextLabel().setText(phoneNumbers.get(row));
        return cell;
    }
}