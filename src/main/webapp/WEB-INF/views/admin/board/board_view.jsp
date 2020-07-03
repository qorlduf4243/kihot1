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
						<div class="col-sm-12">
							<h1 class="m-0 text-dark">DashBoard Management</h1>
						</div>
						<!-- /.col -->
						<div class="col-sm-12">
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
							<h3 class="card-title">READ BOARD</h3>
						</div>
						<!-- /.card-header -->
						<div class="card-body">
							<form role="form" action="/admin/board/delete" method="post">
								<div class="row">
									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>Title</label> <br> ${boardVO.title}
										</div>
									</div>

									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>Content</label>
											 <br>
											 <textarea name="content" class="form-control" rows="3"
												placeholder="Enter Writer">${boardVO.content}</textarea>
										</div>
									</div>

									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>Writer</label> <br> ${boardVO.writer}
										</div>
									</div>
									
									<div class="col-sm-12">
										<!-- text input -->
										<div class="form-group">
											<label>FileDownload</label> <br> 
											<a href="/download?filename=${boardVO.files[0]}">${boardVO.files[0]}</a>
											
										</div>
									</div>
									
									<div class="buttons">
										<a href="/admin/board/update?bno=${boardVO.bno}" class="btn btn-warning">UPDATE</a>
										<button type="submit" class="btn btn-danger">DELETE</button>
										<a href="/admin/board/list" class="btn btn-primary">LIST ALL</a>
									</div>
								</div>
							<input type="hidden" name="bno" value="${boardVO.bno}">
							</form>
						</div>
						<!-- /.content-header -->


						<div class="col-md-12">
							<!-- general form elements disabled -->
							<div class="card card-default">
								<div class="card-header">
									<h3 class="card-title">ADD NEW REPLY</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<form role="form">
										<div class="row">
											<div class="col-sm-12">
												<!-- text input -->
												<div class="form-group">
													<label>Writer</label> <input type="text"
														class="form-control" placeholder="USER ID">
												</div>
											</div>

											<div class="col-sm-12">
												<!-- text input -->
												<div class="form-group">
													<label>Reply Text</label> <input type="text"
														class="form-control" placeholder="REPLY TEXT">
												</div>
											</div>
											<button type="submit" class="btn btn-info">ADD REPLY</button>
										</div>

									</form>
								</div>


								<div class="col-md-12">
									<!-- general form elements disabled -->
									<div class="timeline">
										<!-- timeline time label -->
										<div class="time-label">
											<span class="bg-green">Replies List[1]</span>
										</div>
										<!-- /.timeline-label -->
										<!-- timeline item -->
										<div>
											<i class="fas fa-comments bg-blue"></i>
											<div class="timeline-item">
												<h3 class="timeline-header">
													<a href="#">26-test</a> 												</h3>
												<div class="timeline-body">댓글 테스트입니다.</div>
												<div class="timeline-footer">
													<a class="btn btn-primary btn-sm">Modify</a>
												</div>
											</div>
										</div>
										<!-- END timeline item -->
									</div>
								</div>

								</form>
							</div>

							<td>
								<nav aria-label="Contacts Page Navigation">
									<ul class="pagination justify-content-center m-0">
										<li class="page-item active"><a class="page-link"
											href="#">1</a></li>
									</ul>
								</nav>
							</td>
							<!-- Main content -->
							<div class="content"></div>
							<!-- .content  -->
						</div>
						
					</div>
				</div>
			</div>
			</div>
			<!-- //Content Wrapper -->
<%@ include file="../include/footer.jsp" %> 