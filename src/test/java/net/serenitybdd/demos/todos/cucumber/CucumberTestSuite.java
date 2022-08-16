package net.serenitybdd.demos.todos.cucumber;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/record_todos/deleting_a_number_of_tasks.feature"
)
public class CucumberTestSuite {}
