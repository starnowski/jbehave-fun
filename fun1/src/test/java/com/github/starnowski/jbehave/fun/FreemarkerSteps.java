package com.github.starnowski.jbehave.fun;

import org.hamcrest.core.IsEqual;
import org.jbehave.core.annotations.Aliases;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

public class FreemarkerSteps { // Look, Ma', I'm a POJO!

    private Map model = null;

    @Given("empty json freemarker template")
    public void givenEmptyJsonFreemarkerTemplate(int width, int height) {
        model = new HashMap();
    }

    @When("I toggle the cell at ($column, $row)")
    public void iToggleTheCellAt(int column, int row) {
        game.toggleCellAt(column, row);
    }

    @Then("the grid should look like $grid")
    @Aliases(values={"the grid should be $grid"})
    public void theGridShouldLookLike(String grid) {
        Assert.assertThat(renderer.asString(), IsEqual.equalTo(grid));
    }

}