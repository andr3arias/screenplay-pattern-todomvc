package net.serenitybdd.demos.todos.screenplay.user_interface;

import net.serenitybdd.screenplay.targets.Target;

public class TodoListItem {

    public static Target ITEM_LABEL    =  Target.the("the item label")
            .locatedBy("//*[@class='view' and contains(.,'{0}')]//label");

    public static final Target
            COMPLETE_ITEM = Target.the("the complete item tick box")
            .locatedBy("//*[@class='view' and contains(.,'{0}')]//input[@type='checkbox']");

    public static final Target INDEX_ITEM     = Target.the("the edit item field")
            .locatedBy("//li[@ng-repeat][1]//button[@class='destroy']");
    public static final Target DELETE_ITEM   = Target.the("the delete item button")
            .locatedBy("//*[@class='view' and contains(.,'{0}')]//button[@class='destroy']");
}