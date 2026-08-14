<g:if test="${flash.message}">
    <div class="alert alert-success" up-flashes role="alert"><i class="bi bi-info-circle"></i>${flash.message}</div>
</g:if>

<table id="contacts" class="table table-bordered table-hover">
    <thead>
        <tr>
            <g:each in="${['id', 'firstName', 'lastName']}" var="p" status="i">
                <g:sortableColumn property="${p}" titleKey="contact.${p}.label" />
            </g:each>
            <th width="15%" class="text-center">Operations</th>
        </tr>
    </thead>
    <tbody class="contacts">
        <g:each in="${contactList}" var="bean" status="i">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link class="btn btn-link" method="GET" controller="contact" action="show" id="${bean.id}">
                        <f:display bean="${bean}" property="id" />
                    </g:link>
                </td>
                <td><f:display bean="${bean}" property="firstName" /></td>
                <td><f:display bean="${bean}" property="lastName" /></td>
                <td class="text-center">
                    <g:link method="GET" controller="contact" action="show" id="${bean.id}"
                        up-layer="new"
                        up-mode="modal"
                        up-size="medium"
                        up-animation="move-from-top"
                        up-content="#modal-contact">
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
</table>
