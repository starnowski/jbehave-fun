package com.github.starnowski.jbehave.fun;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.hamcrest.core.IsEqual;
import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerSteps { // Look, Ma', I'm a POJO!

    private Map model = null;
    private String json = null;
    private Configuration configuration;

    @Given("empty json freemarker template")
//    @Aliases(values={"empty json freemarker template"})
    public void givenEmptyJsonFreemarkerTemplate() throws IOException, URISyntaxException {
        configuration = prepareConfiguration();
        model = new HashMap();
    }

    @When("generate json based on template and model")
//    @Aliases(values={"generate json based on template and model"})
    public void whenGenerateJsonBasedOnTemplate() throws IOException, TemplateException {
        Template template = configuration.getTemplate("jsonTemplate.ftl");
        // write the freemarker output to a StringWriter
        StringWriter stringWriter = new StringWriter();
        template.process(prepareData(), stringWriter);
// get the String from the StringWriter
        json = stringWriter.toString();
    }

    @Given("json contains $propertyName property with value $propertyValue")
    @Alias("And json contains $propertyName property with value $propertyValue")
    public void and(String propertyName, String propertyValue) {
        model.put(propertyName, propertyValue);
    }

    @Then("the json should look like $expectedJson")
//    @Aliases(values={"the json should look like $expectedJson"})
    public void theJsonShouldLookLike(String expectedJson) {
        Assert.assertThat(json, IsEqual.equalTo(expectedJson));
    }

    private Map<String, Object> prepareData() {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("jsonParameters", model);
        return data;
    }

    private Configuration prepareConfiguration() throws IOException, URISyntaxException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_23);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
//        FileTemplateLoader ftl1 = new FileTemplateLoader(new File("src/test/templates"));
//        FileTemplateLoader ftl1 = new FileTemplateLoader(new File(FreemarkerSteps.class.getClassLoader().getResource("templates").toURI()));
        configuration.setDirectoryForTemplateLoading(new File(FreemarkerSteps.class.getClassLoader().getResource("templates").toURI()));
        return configuration;
    }


}