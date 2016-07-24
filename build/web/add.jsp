
<%@page import="com.leapfrog.jspapp.productdao.impl.ProductDAOImpl"%>
<%@page import="com.leapfrog.jspap.productdao.ProductDAO"%>
<%@page import="com.leapfrog.jspapp.entity.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/header.jsp" %>
<h1>Add Product</h1>
<form action="save.jsp" method ="post">
  <div class="form-group">
    <label>Product Name</label>
    <input type="text" name="productName" class="form-control" required="required" placeholder="Enter Product Name">
  </div>
  <div class="form-group">
    <label>Product Description</label>
    <input type="text" class="form-control" required="required" placeholder="Enter Product Description">
  </div>
   <div class="form-group">
    <label>Product Price</label>
    <input type="text" class="form-control" required="required" placeholder="Enter Product Price">
  </div>
 

  <button type="submit" class="btn btn-success">Save</button>
  <a href="index.jsp" class="btn bg-danger">Cancel</a>
</form>
<%@include file="shared/footer.jsp" %>
