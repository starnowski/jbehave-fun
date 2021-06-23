<#compress>
{<#list jsonParameters?keys as prop>
    <#if prop=='inner'>
        "inner": {
            <#list jsonParameters['inner']?keys as innerKey>
            "${innerKey}": "${jsonParameters['inner'][innerKey]}"
            </#list>
        }<#if prop?has_next>,</#if>
    <#else>
    "${prop}": "${jsonParameters[prop]}"<#if prop?has_next>,</#if>
    </#if>
</#list>}
</#compress>