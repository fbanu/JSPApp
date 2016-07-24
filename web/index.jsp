
<%@page import="com.leapfrog.jspapp.productdao.impl.ProductDAOImpl"%>
<%@page import="com.leapfrog.jspap.productdao.ProductDAO"%>
<%@page import="com.leapfrog.jspapp.entity.Product" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="shared/header.jsp" %>

            <h1>Products</h1>
            <div class="pull-right">
                <p>
                    <a href="add.jsp" class="btn btn-primary btn-sm"><span class="glyphicon glyphicon-plus"></span></a>
                </p>
            </div>
            <table class="table table-bordered table-condensed table-hover table-striped">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                </tr>
                <% ProductDAO productDAO = new ProductDAOImpl();
                    for (Product p : productDAO.getAll()) {
                %>
                <tr>
                    <td><%= p.getProductId()%></td>
                    <td><%= p.getProductName()%></td>
                    <td><%= p.getProductDescription()%></td>
                    <td><%= p.getProductPrice()%></td>
                </tr>
                <% } %>
            </table>
                <%@include file="shared/footer.jsp" %>