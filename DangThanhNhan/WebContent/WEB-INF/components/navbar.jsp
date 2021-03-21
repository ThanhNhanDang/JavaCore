<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.java.util.URL"%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="javascript:void(0)">Logo</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navb">
            <ul class="navbar-nav mr-auto">
               <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/<%=URL.INDEX_PROJECT%>">Dự án</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/<%=URL.INDEX_TASK%>">Task</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/<%=URL.INDEX_ROLE%>">Quyền</a>
                </li>
                 <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/<%=URL.INDEX_USER%>">Nhân viên</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/<%=URL.INDEX_STATUS%>">Trạng thái</a>
                </li>
            </ul>
        </div>
    </nav>