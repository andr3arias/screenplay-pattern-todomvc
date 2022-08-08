package net.serenitybdd.demos.todos.cucumber.steps.edit_Todo_List;

import com.google.common.base.Splitter;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.annotations.events.AfterExample;
import net.serenitybdd.demos.todos.screenplay.model.TodoStatusFilter;
import net.serenitybdd.demos.todos.screenplay.tasks.DeleteAllTheItems;
import net.serenitybdd.demos.todos.screenplay.tasks.Start;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class EditTodoItemSteps {

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
    @Given("that {actor} has a todo list that contains {items}")
    public void that_jane_has_a_todo_list_that_contains_buy_milk_wash_the_car_take_the_dog_out(Actor actor, List<String> items) {
        actor.wasAbleTo(Start.withATodoListContaining(items));
    }
    @When("she tries to change the task Buy milk, to Buy bread")
    public void she_tries_to_change_the_task_buy_milk_to_buy_bread() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("filters her list to show only active tasks")
    public void filters_her_list_to_show_only_active_tasks() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("her todo list should show Buy bread, Wash car, take out dog")
    public void her_todo_list_should_show_buy_bread_wash_car_take_out_dog() {

    }

}
