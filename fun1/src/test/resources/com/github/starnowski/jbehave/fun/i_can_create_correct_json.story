Given empty json freemarker template
When generate json based on template and model
!-- TODO check how to create json in freemarker without new line
Then the json should look like
{
}
Given empty json freemarker template
And json contains name property with value Simon
When generate json based on template and model
Then the json should look like
{
    "name": "Simon"
}
