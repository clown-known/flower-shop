<%-- 
    Document   : modal_create_plant
    Created on : Apr 27, 2022, 1:59:07 PM
    Author     : LapTop
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>


<div class="d-flex justify-content-between">
    <p class="nav-item nav-link">Name</p>
    <input class="form-control" name="txtname" value="${requestScope.txtname}" type="text" placeholder="John">
</div>
<div class=" d-flex justify-content-between">
    <p class="nav-item nav-link">Price</p>
    <input class="form-control" name="txtprice" value="${requestScope.txtprice}"  type="number" min="0">
</div>
<div class=" d-flex justify-content-between">
    <p class="nav-item nav-link">Image</p>
    <input class="form-control" name="txtimg" type="file" required="">
</div>
<div class=" d-flex justify-content-between">
    <p class="nav-item nav-link">Description</p>
    <textarea class="form-control" name="txtdes" style="resize: none; height: 130px;width: 300px;"></textarea>
</div>
<div class=" d-flex justify-content-between">
    <p class="nav-item nav-link">Status</p>
    <select name="txtstatus" style="width:300px; height: 30px; ">
        <option value="1">open</option>
        <option value="0">not yet</option>        
    </select>
</div>