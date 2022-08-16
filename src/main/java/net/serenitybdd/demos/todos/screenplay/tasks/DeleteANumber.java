package net.serenitybdd.demos.todos.screenplay.tasks;

import net.serenitybdd.demos.todos.screenplay.actions.JSClick;
import net.serenitybdd.demos.todos.screenplay.user_interface.TodoListItem;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class DeleteANumber {
    public static Performable ofItems() {
        return Task.where("{0} deletes a number of items ",
                JSClick.on(TodoListItem.INDEX_ITEM)
        );
    }
}