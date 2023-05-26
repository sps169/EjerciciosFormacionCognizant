package org.example;

import org.example.The_Internet_Exercises.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String page = menu();
        Parent_Page usedPage;
        switch (page){
            case "Add/Remove Elements":
                usedPage = addRemoveActions(page);
                break;
            case "Checkboxes":
                usedPage = checkboxActions(page);
                break;
            case "Context Menu":
                usedPage = contextMenuActions(page);
                break;
            case "Drag and Drop":
                usedPage = dragDropActions(page);
//                usedPage = null;
//                System.out.println("Does not support!");
                break;
            case "Dropdown":
                usedPage = dropdownActions(page);
                break;
            case "Form Authentication":
                usedPage = formAuthActions(page);
                break;
            case "Hovers":
                usedPage = hoversActions(page);
                break;
            case "JavaScript Alerts":
                usedPage = javascriptActions(page);
                break;
            case "Multiple Windows":
                usedPage = multipleWindowsActions(page);
                break;
            case "Nested Frames":
                usedPage = nestedFramesActions(page);
                break;
            case "Redirect Link":
                usedPage = redirectLinkActions(page);
                break;
            default:
                System.out.println("Pending for implementation");
                usedPage = null;
        }
        assert usedPage != null;
        usedPage.sleep();
        usedPage.quit();
    }

    public static Add_Remove addRemoveActions(String page) {
        Add_Remove addRemove = new Add_Remove();
        addRemove.findPage(page);
        addRemove.add_element();
        addRemove.add_element();
        addRemove.remove_element();
        addRemove.remove_element();
        return addRemove;
    }

    private static Checkbox checkboxActions(String page){
        Checkbox checkbox = new Checkbox();
        checkbox.findPage(page);
        int size = checkbox.countCheckboxes();
        for (int i = 1; i <= size; i++){
            checkbox.interactCheckbox(i);
            checkbox.isSelected();
            checkbox.interactCheckbox(i);
            checkbox.isNotSelected();
        }
        return checkbox;
    }

    private static Context_Menu contextMenuActions(String page){
        Context_Menu cntMenu = new Context_Menu();
        cntMenu.findPage(page);
        cntMenu.rightClick();
        cntMenu.manageAlert();
        return cntMenu;
    }

    private static Drag_Drop dragDropActions(String page) {
        Drag_Drop dragDrop = new Drag_Drop();
        dragDrop.findPage(page);
        dragDrop.dragAndDrop();
        dragDrop.checkResult("A");
//        dragDrop.dragAndDrop();
//        dragDrop.checkResult("B");
        return dragDrop;
    }

    public static Dropdown dropdownActions(String page) {
        Dropdown dropdown = new Dropdown();
        dropdown.findPage(page);
        int size = dropdown.getOptionsSize();
        for (int i = 0; i < size; i++) {
            dropdown.selectDropdown();
            Boolean isSelectable = dropdown.selectOption(i);
            if (isSelectable) dropdown.checkSelected("Option " + i);
        }
        return dropdown;
    }

    private static Form_Authentication formAuthActions(String page){
        Form_Authentication formAuth = new Form_Authentication();
        formAuth.findPage(page);
        formAuth.findUsername();
        formAuth.findPassword();
        formAuth.enterField("username"); // ID of the element
        formAuth.enterField("password"); // ID of the element
        formAuth.submit();
        formAuth.checkResult();
        return formAuth;
    }

    private static Hover hoversActions(String page){
        Hover hover = new Hover();
        hover.findPage(page);
        hover.getAllDivs();
        return hover;
    }

    private static Javascript_Alerts javascriptActions(String page){
        Javascript_Alerts js = new Javascript_Alerts();
        js.findPage(page);
        js.acceptAlert();
        js.catchResult();
        js.okConfirm("Ok");
        js.catchResult();
        js.okConfirm("Cancel");
        js.catchResult();
        js.inputPrompt();
        js.catchResult();
        return js;
    }

    // TODO fix this crappy method to be escalable - nah
    private static Multiple_Windows multipleWindowsActions(String page) {
        Multiple_Windows mltp = new Multiple_Windows();
        mltp.findPage(page);
        mltp.clickHere();
        mltp.clickHere();
        mltp.catchText();
        mltp.closeWindow();
        mltp.catchText();
        mltp.closeWindow();
        return mltp;
    }

    private static Nested_Frames nestedFramesActions(String page) {
        Nested_Frames nst = new Nested_Frames();
        nst.findPage(page);
        nst.switchToFirstFrame();
        nst.recursiveSearch();
        return nst;
    }

    private static Redirect_Link redirectLinkActions(String page) {
        Redirect_Link link = new Redirect_Link();
        link.findPage(page);
        link.clickLink();
        link.changeWindow();
        link.catchUrl();
        link.closeWindow();
        return link;
    }

    // TODO include a ☑ when the option is implemented
    public static String menu(){
        Scanner sc = new Scanner(System.in);
        File_Manager fm = new File_Manager("src/PageList.txt");
        List<String> options = fm.getContent();
        for (int i = 1; i <= options.size(); i++){
            System.out.println(i + ". " +  options.get(i-1));
        }
        System.out.print("Select a page: ");
        int selection = sc.nextInt();
        return options.get(selection-1);
    }

}
