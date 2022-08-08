package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.demos.todos.screenplay.actions.JSClick;
import net.serenitybdd.demos.todos.screenplay.user_interface.TodoListItem;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.demos.todos.screenplay.user_interface.TodoListItem.ITEM_LABEL;
import static org.openqa.selenium.Keys.RETURN;

public class EditAnItem {

    public static Performable called(String itemName) {
        return Task.where("{0} edit the item " + oldItemName,
                JSClick.on(TodoListItem.EDIT_ITEM.of(oldItemName)),
                Enter.theValue(thingToDo)
                        .into(ITEM_LABEL)
                        .thenHit(RETURN)
        ).with("thingToDo").of(thingToDo));

    }
}