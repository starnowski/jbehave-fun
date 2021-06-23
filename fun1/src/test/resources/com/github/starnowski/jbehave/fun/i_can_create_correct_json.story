Narrative:
As a developer I would like to know how to good is my freemarker template for json document

Scenario: Template should generate empty json with brackets
Given empty json freemarker template
When generate json based on template and model
Then the json should look like
{}

Scenario: Template should generate json with single property
Given empty json freemarker template
And json contains name property with value Simon
When generate json based on template and model
Then the json should look like
{
"name": "Simon"
}

Scenario: Template should generate json with two properties
Given empty json freemarker template
And json contains name property with value John
And json contains surname property with value Doe
When generate json based on template and model
Then the json should look like
{
"surname": "Doe",
"name": "John"
}

Scenario: Template should generate json with embedded json
Given empty json freemarker template
And json contains name property with value John
And json contains composite object with text property with value xxx
When generate json based on template and model
Then the json should look like
{
"name": "John",
"inner": {
"text": "xxx"
}
}