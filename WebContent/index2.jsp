<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
    <%@ page import="pojo.Order"%>
    <%@ page import="pojo.Trade"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Admin | Dashboard</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- jvectormap -->
  <link rel="stylesheet" href="bower_components/jvectormap/jquery-jvectormap.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
     <!-- DataTables -->
  <link rel="stylesheet" href="./bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
 
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://o...content-available-to-author-only...n.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://o...content-available-to-author-only...n.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
 
  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://f...content-available-to-author-only...s.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
 
  <header class="main-header">
 
    <!-- Logo -->
    <a href="index2.jsp" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>O</b>MS</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Admin Dashboard</b></span>
    </a>
 
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="abc.jpg" class="user-image" alt="User Image">
              <% 
              String name1 = (String)request.getAttribute("name");
              %>
              <span class="hidden-xs"><%= name1%></span>
            </a>
             <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
              	<br>
              	<img src=user.jpg class="img-circle" alt="User Image">
                <br> <br>
				<b><%= name1 %></b>
				<br>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer" style="background-color: #383838;">
        	   <div class = "row">
        	   <div class ="col-md-4"></div>
                <div class = "col-md-4">
                   <button type  = "button" class = "btn" onclick="callLogoutServlet();">Sign Out</button>

                </div>
                <div class = "col-md-4"></div>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      
       <script type="text/javascript">
	        function callLogoutServlet() {
	            document.forms[0].action = "logout";
	            document.forms[0].submit();
	        }
	        
	        
	    </script>
 
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <br>
 <div class="user-panel">
        <div class="pull-left image">
          <img src="user.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p><%= name1%></p>
          <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
        </div>
        </div>
      <!-- search form -->
      <form action="#" method="get" class="sidebar-form">
 
      </form>
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
		<br> 
 
        <li>
          <a href="admin">
            <i class="fa fa-th"></i> <span>Dashboard</span>
            <span class="pull-right-container">
            </span>
          </a>
          <br>
        </li>
        
        
 
        <li class="treeview">
          <a href="#">
            <i class="fa fa-pencil-square-o "></i>
            <span>Orders</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
         
          <ul class="treeview-menu">
            <!-- <li><a href="./pages/tables/executedorders.jsp"><i class="fa fa-circle-o"></i> Executed Orders</a></li>-->
            <li><a href="aps"><i class="fa fa-circle-o"></i> Pending Orders</a></li>
            <li><a href="ars"><i class="fa fa-circle-o"></i> Rejected Orders</a></li>
          </ul>
          <br>
        </li>
 
 		<li>
          <a href="ats">
            <i class="fa fa-handshake-o"></i> <span>Trades</span>
            <span class="pull-right-container">
            </span>
          </a>
          <br>
        </li>
 
 
        <li>
          <a href="agu">
            <i class="fa fa-user"></i> <span>Users</span>
            <span class="pull-right-container">
            </span>
          </a>
          <br>
        </li>
 
        <li>
          <a href="load">
            <i class="glyphicon glyphicon-check"></i> <span>Test</span>
            <span class="pull-right-container">
            </span>
          </a>
          <br>
        </li>
 
        
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
 
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Admin Dashboard
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      </ol>
    </section>
 
    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      <div class="row">
          <%-- <div class="small-box" bg-aqua>
            <span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>
 
            <div class="inner">
              <span class="info-box-text" style = "text-align: center; padding-top: 15px; font-size: 15px; font-weight: bold">New Orders</span>
              <%
              int stats_order1 = (int)request.getAttribute("stats_order");
              %>
              <span class="info-box-number" style = "text-align: center"><%= stats_order1%></span>
            </div>
            <!-- /.info-box-content -->
          </div>
  --%>         <!-- /.info-box -->
  
         <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-aqua">
            <div class="inner">
              <h3>
              
              <%
              	int stats_order = (int)request.getAttribute("stats_order");
              %>
              <%=stats_order %>
			 </h3>

              <p>New Orders</p>
            </div>
            <div class="icon">
              <i class="fa fa-shopping-cart"></i>
            </div>
        </div>
        </div>
        <!-- /.col -->
        
        <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-red">
            <div class="inner">
              <h3>
              
              <%
              int stats_user = (int)request.getAttribute("stats_user");
              %>
              <%=stats_user %>
			 </h3>

              <p>New Registrations</p>
            </div>
            <div class="icon">
              <i class="fa fa-user"></i>
            </div>
        </div>
        </div>
        
        <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-green">
            <div class="inner">
              <h3>
              
              <%
              int stats_trade = (int)request.getAttribute("stats_trade");
              %>
              <%=stats_trade %>
			 </h3>

              <p>Trades done today</p>
            </div>
            <div class="icon">
              <i class="fa fa-handshake-o"></i>
            </div>
        </div>
        </div>
        
        
        
              </div>
      <!-- /.row -->
      
      <div class = "row">
      
      
      <div class = "col-md-6">
 
			<!-- TABLE: BUY ORDERS -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Buy Orders</h3>
 
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
              				<%
							List<Order> list=(List<Order>)request.getAttribute("buy_order");
							%>	
                <table id = "buy" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Time</th>
                    <th>Instrument</th>
                    <th>Quantity</th>
                    <th>Price</th>
                  </tr>
                  </thead>
                  <tbody>
 
                     <% 
							for(Order b:list)
							{
					%>
							<tr>
								<td><%= b.getOrderTime()%></td>	
								<td>Facebook, Inc.</td>	 
								<td><%= (long) b.getOrderQuantity()%></td>
								<td><%
								
								double x = b.getOrderPrice();
								String msg;
								
								if (x<150 || x>160) msg = "N/A";
								else msg = Double.toString(x);
								%>
								
								<%=msg %>
								
								</td>
							</tr>
 
					<% } %>  
 
 
                  </tbody>
                </table>
              <!-- /.table-responsive -->
            </div>
		<!-- ----------------------------------------------------------------------------------------------------------------- -->
		<!-- TABLE: SELL ORDERS -->
          <div class="box box-info" style = "margin-top:40px;">
            <div class="box-header with-border">
              <h3 class="box-title">Sell Orders</h3>
 
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
              				<%
							List<Order> list1=(List<Order>)request.getAttribute("sell_order");
							%> 
                <table id = "sell" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Time</th>
                    <th>Instrument</th>
                    <th>Quantity</th>
                    <th>Price</th>
                  </tr>
                  </thead>
                  <tbody>
 
                     <% 
							for(Order b1:list1)
							{
					%>
							<tr>
								<td><%= b1.getOrderTime()%></td>
								<td>Facebook, Inc.</td>		 
								<td><%= (long) b1.getOrderQuantity()%></td>
								<td><%
								
								double x = b1.getOrderPrice();
								String msg;
								
								if (x<150 || x>160) msg = "N/A";
								else msg = Double.toString(x);
								%>
								
								<%=msg %>
								
								</td>
							</tr>
 
					<% } %> 
 
 
                  </tbody>
                </table>
                
                <br>
              </div>
              <!-- /.table-responsive -->
            </div>
            
        </div>
        </div>
        </div>
		<!-- ------------------------------------------------------------------------------------------------------------- -->
		</div>
				
		
		<!-- TABLE: TRADE ORDERS -->
		<div class = "col-md-6">
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Trades</h3>
 
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
              				<%
							List<Trade> list2=(List<Trade>)request.getAttribute("trade_order");
							%>	
                <table id = "trade" class="table table-bordered table-hover">
                  <thead>
                  <tr>
                    <th>Trade ID</th>
                    <th>Instrument</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Time</th>
                  </tr>
                  </thead>
                  <tbody>
                      <% 
							for(Trade b2:list2)
							{
					%>
							<tr>
								<td><%= b2.getTradeId()%></td>
								<td>Facebook, Inc. </td>
								<td><%= (long) b2.getTradedQuantity()%></td>
								<td><%
								
								double x = b2.getTradedPrice();
								String msg;
								
								if (x<150 || x>160) msg = "N/A";
								else msg = Double.toString(x);
								%>
								
								<%=msg %>
								
								</td>
								<td><%= b2.getTradedTime()%></td>		 
							</tr>
					<% } %>  
 
 
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            </div>
		<!-- ---------------------------------------------------------------------------------------------------------- -->
 
 
          </div>
          </div>
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
 
        <!--  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa -->
            <!-- /.box-header -->
            <!-- /.footer -->
          </div>
          
      </div>
          <!-- /.box -->
            <!-- /.box-footer -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->
      
      </div>
      <!-- /.row -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
 
 
 
  <!-- /.control-sidebar -->
  <!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
  <div class="control-sidebar-bg"></div>
 
</div>
<!-- ./wrapper -->
 
<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>
<!-- Sparkline -->
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap  -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- SlimScroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- ChartJS -->
<script src="bower_components/chart.js/Chart.js"></script>
<!-- AdminLTE dashboard demo (This is only for demo purposes) -->
<script src="dist/js/pages/dashboard2.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="dist/js/demo.js"></script>
<script src="exportExcel.js"></script>
<!--  DataTables-->
<script src="./bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="./bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="./bower_components/datatables.net-bs/js/dataTables.bootstrap"></script>
<script>
$(document).ready(function() {
    $('#buy').DataTable( {
        "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]]
    } );
} );
</script>


<script>
$(document).ready(function() {
    $('#sell').DataTable( {
        "lengthMenu": [[5, 10, 20, -1], [5, 10, 20, "All"]]
    } );
} );
</script>


<script>
$(document).ready(function() {
    $('#trade').DataTable( {
        "lengthMenu": [[15, 25, 50, -1], [15, 25, 50, "All"]]
    } );
} );
</script>



</body>
</html>