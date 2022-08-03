<%-- 
    Document   : Mytag
    Created on : Apr 26, 2022, 10:26:48 PM
    Author     : LapTop
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>
<%@variable variable-class="java.util.Date"  name-given="c"   %>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>
<label class="" > </label>