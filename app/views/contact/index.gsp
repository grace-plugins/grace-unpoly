<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'contact.label', default: 'Contact')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <div id="content" role="main">
        <div class="container">
            <section class="row">
                <a href="#list-contact" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
                <div class="col-12" role="navigation">
                    <ul class="nav nav-pills">
                        <li class="nav-item">
                            <a class="nav-link" href="${createLink(uri: '/')}">
                                <i class="bi bi-house-fill"></i><g:message code="default.home.label"/>
                            </a>
                        </li>
                        <li class="nav-item">
                            <g:link class="nav-link" action="create">
                                <i class="bi bi-journal-plus"></i><g:message code="default.new.label" args="[entityName]" />
                            </g:link>
                        </li>
                    </ul>
                </div>
            </section>
            <section class="row">
                <div id="list-contact" class="col-12 scaffold scaffold-list" role="main">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                        <div class="alert alert-success" role="alert"><i class="bi bi-info-circle"></i>${flash.message}</div>
                    </g:if>
                    <g:else>
                        <div up-flashes></div>
                    </g:else>
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
                </div>
                <div id="loadMore" class="text-center">
                    <g:link class="btn btn-primary"
                        method="GET" controller="contact" action="list" params="[page: nextPage]"
                        up-target=".contacts:after">
                        Load More Contacts...
                    </g:link>
                </div>
            </section>
        </div>
    </div>
    <main></main>
    </body>
</html>