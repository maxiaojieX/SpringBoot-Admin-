<!DOCTYPE html>
<html class="no-js">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Spring Boot Admin</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png" />
    <link rel="stylesheet" type="text/css" href="core.css" />
    <link rel="stylesheet" type="text/css" href="all-modules.css" />
</head>

<body>
<header class="navbar header--navbar desktop-only">
    <div class="navbar-inner">
        <div class="container-fluid">

            <div class="spring-logo--container">
                <a class="spring-logo" href="#"><span></span></a>
            </div>
            <div class="spring-logo--container">
                <a class="spring-boot-logo" href="#"><span></span></a>
            </div>
            <ul class="nav pull-right">
                <li class="navbar-link ng-scope" >
                    <a class="ng-binding" href="/#/" target="_blank" onclick="history.go(0)">应用详细</a>
                </li>
                <li class="navbar-link ng-scope active">
                    <a class="ng-binding" href="/warn" id="test">应用维护</a>
                </li>
                <li class="navbar-link ng-scope" >
                    <a class="ng-binding" href="/status" target="_blank" onclick="history.go(0)">接口信息</a>
                </li>
            </ul>
        </div>
    </div>
</header>
<div ui-view="" class="ng-scope"><div class="container-fluid ng-scope">
    <h3>Spring Boot applications Maintain</h3>
    <table class="table application-list">
        <thead>
        <tr>
            <th class="name-column"><span class="sortable">Application/Group</span></th>
            <th class="status-column">Status</th>
            <th class="status-column" style="width: 100px">operation</th>
        </tr>
        </thead>
        <tbody>
        <#list apps as app>
        <tr>
            <td class="name-column ng-binding">${app.name}</td>
            <td class="version-column">
                <span class="status-${app.statusInfo.status}">${app.statusInfo.status}</span>
            </td>
            <td class="version-column"><div class="btn-group">
                <a class="btn btn-warning maining  <#if app.maintain == 0>hide</#if>" rel="${app.name}">正在维护</a>
                <a class="btn btn-success main <#if app.maintain == 1>hide</#if>" rel="${app.name}">点击维护</a>
                <a class="btn btn-danger clear" rel="${app.name}"><i class="fa fa-times"></i></a>
            </td>
        </tr>
        </#list>
        </tbody>
    </table>
</div></div>
<script src="/static/js/jQuery/jquery-2.2.3.min.js" type="text/javascript"></script>
<script src="/static/js/layer/layer.js" type="text/javascript"></script>
<script src="/static/js/monitor/maintain.js" type="text/javascript"></script>
</body>
</html>