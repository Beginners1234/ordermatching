<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="pojo.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://w...content-available-to-author-only...3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://w...content-available-to-author-only...3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <meta charsHomet="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>User | Dashboard</title>
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://o...content-available-to-author-only...n.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://o...content-available-to-author-only...n.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
      <!-- DataTables -->
  <link rel="stylesheet" href="./bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
 <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.js"></script>
 

  <!-- Google Font -->
  <link rel="stylesheet"
        href="https://f...content-available-to-author-only...s.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition skin-blue sidebar-mini" bgcolor="dark grey">
<div class="wrapper">

  <header class="main-header">

    <!-- Logo -->
    <a href="user" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>O</b>MS</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>User Dashboard</b></span>
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
              <img src="user.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">
              
              	<%
              
	              String name1 = (String) request.getAttribute("name");
	              out.println(name1 + "<br>");
              
          		%>
              </span>
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
        
                <div class="pull-left">
                  <button type  = "button" class = "btn" onclick="callProfileServlet();">Profile</button>
<!--                   <a href="openservlet" class="btn">Profile</a>
 -->                </div>
                <div class="pull-right">
                   <button type  = "button" class = "btn" onclick="callLogoutServlet();">Sign Out</button>

                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
      
       <script type="text/javascript">
	        function callProfileServlet() {
	            document.forms[0].action = "openservlet";
	            document.forms[0].submit();
	        }
	        
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
        <!-- Place order -->
        <li>
          <a href="user">
            <i class = "glyphicon glyphicon-home"></i> 
            <span>Home</span>
            <span class="pull-right-container">
            </span>
          </a>
          <br>
        </li>

        <!-- Place order -->
        <li>
          <a href="placeorder">
            <i class = "fa fa-pencil-square-o"></i> 
            <span>Place Order</span>
            <span class="pull-right-container">
              </span>
                       </a>
          <br>
        </li>


        
      
        <li class="treeview">
          <a href="#">
            <i class="fa fa-table"></i> <span>User History</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="userorder"><i class="fa fa-circle-o"></i> Order History</a></li>
            <li><a href="usertrades"><i class="fa fa-circle-o"></i> Trade History</a></li>
          </ul>
          <br>
        </li>


      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper" style="background-color: #F0F0F0">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1>
        Home	
      </h1>
      <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
      </ol>
    </section>

    <!-- Main content -->
    <section class="content">
      <!-- Info boxes -->
      <div class="row">
                 <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-aqua">
            <div class="inner">
              <h3>
              
              <%
              	int stats_order = (int)request.getAttribute("statistics_order");
              %>
              <%=stats_order %>
			 </h3>

              <p>Total Orders</p>
            </div>
            <div class="icon" style="margin-top:20px;">
              <i class="fa fa-pencil-square-o"></i>
            </div>
        </div>
        </div>
        <!-- /.col -->
        
        <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-yellow" >
            <div class="inner">
              <h3>
              
              <%
              int stats_trade = (int)request.getAttribute("statistics_trade");
              %>
              <%=stats_trade %>
			 </h3>

              <p>Total trades</p>
            </div>
            <div class="icon" style="margin-top:15px;">
              <i class="fa fa-user"></i>
            </div>
        </div>
        </div>
        
        <div class="col-md-4 col-sm-6 col-xs-12">
  
  		<div class="small-box bg-green">
            <div class="inner">
              <h3>
              
              <%
              String stats_pos = (String)request.getAttribute("statistics_position");
              %>
              <%=stats_pos %>
			 </h3>

              <p>Position</p>
            </div>
            <div class="icon" style="margin-top:15px;">
              <i class="fa fa-handshake-o"></i>
            </div>
        </div>
        </div>
        
        
        
         </div>        
        
        <%-- <div class="col-md-4">
          <div class="info-box"  style="border-style: outset;">
            <span class="info-box-icon bg-red" style="height: 84px !important"><i class="fa fa-money"></i></span>

            <div class="info-box-content">
              <span class="info-box-text" style="text-align: center; padding-top: 15px; font-size: 15px; font-weight: bold">POSITION</span>
              <span class="info-box-number"style="text-align: center">
              
              <%
              String position_stats = (String) request.getAttribute("statistics_position");
              out.println(position_stats + "<br>");
              %>
              
              </span>
            </div>
            <!-- /.info-box-content -->
          </div>
          <!-- /.info-box -->
        </div>
 --%>
      <!-- /.row -->

          <!-- TABLE: LATEST ORDERS -->
          <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">Order History</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
              </div>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div class="table-responsive">
              
              <%
              	List <Order> list_order = (List<Order>)request.getAttribute("list_orders");
              %>
              
                <table id= "orders" class="table table-bordered table-hover">
                  <thead>
                  <tr>
     	           <th>Time</th>
                    <th>Type</th>
                    <th>Category</th>
                    <th>All/None</th>
                    <th>Instrument</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Status</th>
                  </tr>
                  </thead>
                  <tbody>
                  
                  	<% for (Order o: list_order) {%>
                  	<tr>
                  	<td> <%= o.getOrderTime() %></td>
 
                  	<td> <%= o.getOrderType() %></td>
                  	<td> <%= o.getOrderCategory() %></td>
                  	<td> <%= o.isAon() %></td>
                  	<td>Facebook, Inc</td>
                  	<td> <%=(long) o.getOrderQuantity() %></td>
                  	<%
 
                  	if((o.getOrderType()).equalsIgnoreCase("MARKET"))
                  	{%>
                  		<td>NA</td>
                  	<%}
                  	else
                  	{%>
                  	<td><%=(long)o.getOrderPrice()%></td>
                  	<%} %>
                  	
                  	<%
                  		String status = new String();
                  		status = o.getOrderStatus();
                  		if (status.equalsIgnoreCase("REJECTED")){ %>
                  		
                  		<td> <div style="margin-top:5px;"> <small class = "label label-danger"><%=status %></small> </div></td> 
                  			
                  		<% 
                  		}
                  		else if (status.equalsIgnoreCase("PENDING")){%>
                  		
                  		<td><div style="margin-top:5px;"><small class = "label label-warning"><%=status %></small></div></td>

                  	<%
                  		}
                  	%>
                  	
                  	
                  	<%} %> 
                  	                  	
                  </tr>
                  </tbody>
                </table>
              </div>
              <!-- /.table-responsive -->
            </div>
            <!-- /.box-body -->
            
            <!-- /.box-footer -->
          </div>
          <!-- /.box -->
        </div>
        <!-- /.col -->

        <!--  aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa -->
            <!-- /.box-header -->
            <!-- /.footer -->
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
<script src="../../dist/js/adminlte.min.js"></script>
<script src="../../dist/js/demo.js"></script>
<!-- <script src = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
<script src = "https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css"></script> 

AdminLTE for demo purposes
DataTables-->
<script src="./bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="./bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>


<!-- page script -->
<script>
$(document).ready(function() {
    $('#orders').DataTable( {
        "lengthMenu": [[10, 25, 50, -1], [10, 25, 50, "All"]]
    } );
} );
</script>

</body>
</html>
	