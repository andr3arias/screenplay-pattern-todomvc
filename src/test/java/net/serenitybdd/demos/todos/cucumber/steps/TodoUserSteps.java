package net.serenitybdd.demos.todos.cucumber.steps;

import com.google.common.base.Splitter;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.AfterExample;
import net.serenitybdd.demos.todos.cucumber.MissingTodoItemsException;
import net.serenitybdd.demos.todos.screenplay.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.screenplay.questions.TheItems;
import net.serenitybdd.demos.todos.screenplay.tasks.*;
import net.serenitybdd.demos.todos.screenplay.user_interface.TodoList;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import java.util.List;
import static java.util.Collections.EMPTY_LIST;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TodoUserSteps {

    @Before
    public void set_the_stage() {
        setTheStage(new OnlineCast());
    }

    @AfterExample
    public void deleteAllTheTasks() {
        theActorInTheSpotlight().attemptsTo(
                DeleteAllTheItems.onThePage()
        );
    }

    @ParameterType(".*")
    public Actor actor(String actor) {
        return OnStage.theActorCalled(actor);
    }

    @ParameterType("All|Active|Completed")
    public TodoStatusFilter filter(String filter) {
        return TodoStatusFilter.valueOf(filter);
    }

    @ParameterType(".*")
    public List<String> items(String listOfItems) {
        return Splitter.on(",").trimResults().omitEmptyStrings().splitToList(listOfItems);
    }

    @Given("that {actor} has an empty todo list")
    public void that_James_has_an_empty_todo_list(Actor actor) {
        actor.wasAbleTo(Start.withAnEmptyTodoList());
    }

    @Given("that {actor} has a todo list containing {items}")
    public void that_James_has_an_empty_todo_list(Actor actor, List<String> items) {
        actor.wasAbleTo(Start.withATodoListContaining(items));
    }
    @When("{actor} adds {string} to his/her list")
    public void adds_to_his_list(Actor actor, String item) {

        actor.attemptsTo(AddATodoItem.called(item));
    }

    @When("{actor} deletes the task called {string}")
    public void deletes_an_item(Actor actor, String item) {
        actor.attemptsTo(DeleteAnItem.called(item));
    }

    @Then("{string} should be recorded in his/her list")
    public void item_should_be_recorded_in_the_list(String expectedItem) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), hasItem(expectedItem))
                .orComplainWith(MissingTodoItemsException.class, "Missing todo " + expectedItem));
    }

    @Then("his/her todo list should contain {items}")
    public void todo_list_should_contain(List<String> expectedItems) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(expectedItems))
                .orComplainWith(MissingTodoItemsException.class, "Missing todos " + expectedItems));
    }

    @Then("{actor}'s todo list should contain {items}")
    public void a_users_todo_list_should_contain(Actor actor, List<String> expectedItems) {
        actor.should(seeThat(TheItems.displayed(), equalTo(expectedItems))
                .orComplainWith(MissingTodoItemsException.class, "Missing todos " + expectedItems));
    }

    @Then("his/her todo list should be empty")
    public void todo_list_should_be_empty() {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(EMPTY_LIST)));
    }

    @Then("^s?he (?:completes|has completed) the task called '(.*)'$")
    public void completes_task_called(String item) {
        theActorInTheSpotlight().attemptsTo(
                CompleteItem.called(item)
        );
    }

    @When("{actor} filters her list to show only {filter} tasks")
    public void filters_tasks_by(Actor actor, TodoStatusFilter status) {
        actor.attemptsTo(
                FilterItems.toShow(status)
        );
    }

    @Given("that {actor} has a todo list that contains {items}")
    public void that_jane_has_a_todo_list_that_contains_buy_milk_wash_the_car_take_the_dog_out(Actor actor, List<String> items) {
        actor.wasAbleTo(Start.withATodoListContaining(items));
    }

    @When("{actor} tries to change the task {string} to {string}")
    public void she_tries_to_change_the_task_buy_milk_to_buy_bread(Actor actor, String oldItem, String newItem) {
        actor.attemptsTo(
                UpdateTask.from(oldItem).to(newItem)
        );
    }

    @Then("her todo list should show {items}")
    public void her_todo_list_should_show_buy_bread_wash_car_take_out_dog(List<String> expectedItems) {
        theActorInTheSpotlight().should(seeThat(TheItems.displayed(), equalTo(expectedItems))
                .orComplainWith(MissingTodoItemsException.class, "Missing todos " + expectedItems));
    }

    @When("{actor} deletes the first {int} tasks")
    public void she_deletes_the_first_tasks(Actor actor, int numberItems) {
        while (numberItems > 0) {
            actor.attemptsTo(
                    DeleteANumber.ofItems()
            );
            numberItems-=1;
        }
    }

    @Then("the number of items left should be {int}")
    public void theNumberOfItemsLeftShouldBe(Integer itemsLeft) {
        withCurrentActor(
                Ensure.that(TodoList.ITEMS_LEFT).text().asAnInteger().isEqualTo(itemsLeft)
        );
    }
}
