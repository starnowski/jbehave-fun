{
<#list jsonParameters?keys as prop>
    "${prop}": "${jsonParameters[prop]}"
</#list>
}