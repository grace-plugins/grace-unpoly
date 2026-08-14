<tbody class="contacts">
<g:each in="${contactList}" var="bean" status="i">
    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
        <td>
            <g:link method="GET" controller="contact" action="show" id="${bean.id}"
                up-layer="new"
                up-mode="modal"
                up-size="medium"
                up-animation="move-from-top"
                up-content="#modal-contact">
                <f:display bean="${bean}" property="id" />
            </g:link>
        </td>
        <td><f:display bean="${bean}" property="firstName" /></td>
        <td><f:display bean="${bean}" property="lastName" /></td>
        <td class="text-center">
            <g:link class="btn btn-link" method="GET" controller="contact" action="show" id="${bean.id}">
                Show
            </g:link>
                | 
            <g:link class="btn btn-link" data-method="delete" controller="contact" action="delete" id="${bean.id}"
                up-follow="true" 
                up-confirm="Really delete?"
                up-target="#contacts">
                Delete
            </g:link>
        </td>
    </tr>
</g:each>
</tbody>
<div id="loadMore" class="text-center">
<g:if test="${hasNext}">
    <g:link class="btn btn-primary"
        method="GET" controller="contact" action="list" params="[page: nextPage]"
        up-target=".contacts:after">
        Load More Contacts...
    </g:link>
</g:if>
</div>