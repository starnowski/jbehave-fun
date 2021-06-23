Given empty json freemarker template
When generate json based on template and model
Then the json should look like
{}
Given empty json freemarker template
And json contains name property with value Simon
When generate json based on template and model
Then the json should look like
{
"name": "Simon"
}
Given empty json freemarker template
And json contains name property with value John
And json contains surname property with value Doe
When generate json based on template and model
Then the json should look like
{
"surname": "Doe",
"name": "John"
}
Given empty json freemarker template
And json contains name property with value John
And json contains composite object with text property with value xxx
When generate json based on template and model
Then the json should look like
{
"surname": "Doe",
"inner": {
"text": "xxx"
}
}