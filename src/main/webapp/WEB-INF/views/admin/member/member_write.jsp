<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../include/header.jsp" %>

<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0 text-dark">DashBoard Management</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Starter Page</li>
							</ol>
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
				<div class="col-md-12">
					<!-- general form elements disabled -->
					<div class="card card-warning">
						<div class="card-header">
							<h3 class="card-title">회원등록</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<form role="form" action="/admin/member/write" method="post">
								<div class="row">
									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>user_id</label> 
											<input name="user_id" type="text" class="form-control"
												placeholder="Enter user_id">
										</div>
									</div>

									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>user_pw</label> 
											<input name="user_pw" type="text" class="form-control"
												placeholder="Enter user_pw">
										</div>
									</div>

									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>user_name</label> 
											<input name="user_name" type="text" class="form-control"
												placeholder="Enter user_name">
										</div>
									</div>

									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>email</label> 
											<input name="email" type="text" class="form-control"
												placeholder="Enter email">
										</div>
									</div>
										<div class="col-sm-12">
										<div class="form-group">
											<label>point</label> 
											<input name="point" type="text" class="form-control"
												placeholder="0">
										</div>
									</div>
									<div class="form-group">
                        <label>enabled</label>
                        <select name="enabled" class="form-control">
                          <option value="0">false</option>
                          <option value="1" selected>true</option>
                        </select>
                        <label>level</label>
                        <select name="levels" class="form-control">
                          <option value="ROLE_USER">ROLE_USER</option>
                          <option value="ROLE_ADMIN">ROLE_ADMIN</option>
                        </select>
                     <br>
                     <div class = "buttons">
									<button type="submit" class="btn btn-warning">Submit</button>
									<a href="/admin/member/list?page=${pageVO.page}" class="btn btn-primary">LIST ALL</a>
								</div>
								</div>
								</div>
							</form>
						</div>
						<!-- /.content-header -->

						<!-- Main content -->
						<div class="content"></div>
						<!-- .content  -->
					</div>
					
				</div>
			</div>
		</div>
		<!-- ./Content Wrapper -->

<%@ include file="../include/footer.jsp" %> 