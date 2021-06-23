<#compress>
{<#list jsonParameters?keys as prop>
    "${prop}": "${jsonParameters[prop]}"<#if prop?has_next>,</#if>
</#list>}
</#compress>