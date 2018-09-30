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
  <title>Admin | Test </title>
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
    <link rel="stylesheet" href="./bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
 
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
<!-- Site wrapper -->
<div class="wrapper">

  <header class="main-header">
    <!-- Logo -->
    <a href="admin" class="logo">
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
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- Messages: style can be found in dropdown.less-->
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
 
  <!-- =============================================== -->

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h2>
        Test Random Orders
      </h2>
    </section>

    <!-- Main content -->
    <section class="content">

      <!-- Default box -->
      
        
        <div class="container">
          <div class = "box" style=" height:60px; width: 900px ">
            <div class = "row">
              <div class = "col-md-3" style="margin-top:8px; margin-bottom: 10px; text-align: center;"> <h4> Generate random orders </h4></div>
                <form class = "form-inline" action="grow" method="post">
                   <div class = "col-md-4"> 
                
                  <input type="number" name="number" min = 1 placeholder="No. of orders" style = "margin-top: 15px;">
                  &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                  <button type="submit" class="btn btn-primary btn-sm " style = "margin-bottom: 2px; width: 80px;">Add</button>
                  </div>
                  
                </form>
              
       
              
               <div class = "col-md-2">
               <button type="button" class="btn btn-primary btn-sm" style="width:120px; margin-top:14px; align-items:center; justify-content:center" onclick="displayForm(this);">Add Custom Order</button>
              </div>
              
              <div class = "col-md-3">
              			 &nbsp; &nbsp;
              
                  <button type="button" class="btn btn-success btn-sm" style="width:120px; margin-top:14px; align-items:center; justify-content:center" onclick="generateTable(this);">Show</button>
              </div>
              

            </div>

          </div>
          
        </div>

        <div id= "tableDiv" class="row" style="display: none;">
        <div class="col-xs-12">
          <div class="box">
            <div class="box-header">
              <h3 class="box-title">Orders Generated</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
            
            		<!-- change the input of getAttribute -->
							<%
							List<Order> list=(List<Order>)request.getAttribute("order");
							%>							 
							<table id="order" class="table table-bordered table-striped" border="120">			
							<thead>
			                <tr>
			                  <th>Time</th>
			                  <th>Instrument</th>
			                  <th>Buy/Sell</th>
			                  <th>Type</th>
			              	  <th>All/None</th>
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
								<td><%= b.getOrderCategory()%></td>
								<td><%= b.getOrderType()%></td>
								<td><%= b.isAon()%></td>
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
              
                   </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
      </div>
        <!-- /.col -->
      </div>

     
        <div style = "float: right;">
        <button type="button" class="btn btn-info" onclick="exportTableToExcel('order')"> <i class = "glyphicon glyphicon-download-alt"></i>      Export Table Data To Excel File</button>
        </div>
        
        <br><br>
        
    <div style = "text-align:center">
        <form action="placeAll" method="get">
   		 <input class = "btn btn-success" type="submit" value="Send Orders to Exchange" />
			</form>
        </div>    
        

      <div id = "addOrder" class="nav-tabs-custom" style="display: none;">
            <ul class="nav nav-tabs">
              <li class="active"><a href="#tab_buy" data-toggle="tab">BUY</a></li>
              <li><a href="#tab_sell" data-toggle="tab">SELL</a></li>
            </ul>
            <div class="tab-content">
              <div class="tab-pane active" id="tab_buy">
                  <div class="register-box">
                    <div class="register-logo">
                      <h1> Place a <b>BUY</b> order </h1>
                    </div>

                    <div class="register-box-body">

                      <form action="manAdd" method="post">
						<input type="hidden" id="hidden" class="hidden" name="ordercatbs" value="buy">
                        <div class="form-group has-feedback" style = "display: inline; text-align: center; vertical-align: middle">
                          <label> ORDER TYPE </label> <br>
                          <label class="radio-inline">
                              <input type="radio" name="ordertypeml" value = "mkt" onclick="checkmkt(this)"> MKT &nbsp;
                          </label>
                          <label class="radio-inline">
                              <input type="radio" name="ordertypeml" value = "lmt" onclick="checklmt(this)"> LMT
                          </label>  

                          <br>
                          <!--
                          <input type="radio" name = "Order Type" value = "mkt"  > &nbsp; MKT 
                          &nbsp; &nbsp;
                          <input type="radio" name = "Order Type" value = "lmt"> &nbsp; LMT -->
                        </div>

                        <br>
                        <div id = "qtyDiv" class="form-group has-feedback" style = "display: none;">
                          <input type="number" name ="quantitybuy" class="form-control" placeholder="Quantity" min=1 required>
                          <span class = "fa fa-facebook-f form-control-feedback"></span>
                          <br>
                        </div>

                        <div id = "priceDiv" class="form-group has-feedback" style = "display: none;">
                          <input type="number" name="pricebuy" class="form-control" placeholder="Price" min = 150 max = 160 >
                          <span class="fa fa-inr form-control-feedback"></span>
                          <br>
                        </div>

                        <div id="aon" class="form-group has-feedback" style = "display: none;">
                          <label> All or None: &nbsp;
                              <input type="checkbox" name="aonbuy" >
                          </label>
                         </div>
                        

                          <script>
                            function checklmt(eventSelect){

                                if (eventSelect.value = "lmt"){
                                  document.getElementById("priceDiv").style.display = "block";
                                  document.getElementById("qtyDiv").style.display = "block";
                                  document.getElementById("aon").style.display = "block";
                                }
                          }
                          </script>


                          <script>
                            function checkmkt(evt){
                              document.getElementById("priceDiv").style.display = "none";
                              document.getElementById("priceDiv").value = "150";
                              document.getElementById("qtyDiv").style.display = "block";
                              document.getElementById("aon").style.display = "none";
							console.log("MKT");
                                
                          }
                          </script>
                        
                        <!-- <div class="row">
                         <div class="col-xs-8"> -->
                        
                          <!--</div> -->
                          <!-- /.col -->
                          <br>
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Place Order</button>
                          
                          <!-- /.col 
                        </div> -->
                      </form>
                </div>
                <!-- /.form-box -->
              </div>

              </div>
              <!-- /.tab-pane-----------------------------------------------------SELL below---------------------------------------------- -->
              <div class="tab-pane" id="tab_sell">
                <div class="register-box">
                    <div class="register-logo">
                      <h1> Place a <b>SELL</b> order </h1>
                    </div>

                    <div class="register-box-body">

                      <form action="placeorder" method="post">
						<input type="hidden" id="hidden" class="hidden" name="ordercatbs" value="sell">
                        <div class="form-group has-feedback" style = "display: inline; text-align: center; vertical-align: middle">
                          <label> ORDER TYPE </label> <br>
                          <label class="radio-inline">
                              <input type="radio" name="ordertypeml" value = "mkt" onclick="checkmkt2(this)"> MKT &nbsp;
                          </label>
                          <label class="radio-inline">
                              <input type="radio" name="ordertypeml" value = "lmt" onclick="checklmt2(this)"> LMT
                          </label>  

                          <br>
                          <!--
                          <input type="radio" name = "Order Type" value = "mkt"  > &nbsp; MKT 
                          &nbsp; &nbsp;
                          <input type="radio" name = "Order Type" value = "lmt"> &nbsp; LMT -->
                        </div>

                        <br>
                        <div id = "qtyDiv2" class="form-group has-feedback" style = "display: none;">
                          <input type="number" name ="quantitysell" class="form-control" placeholder="Quantity" required>
                          <span class = "fa fa-facebook-f form-control-feedback"></span>
                          <br>
                        </div>

                        <div id = "priceDiv2" class="form-group has-feedback" style = "display: none;">
                          <input type="number" name="pricesell" class="form-control" placeholder="Price" min = 150 max = 160 >
                          <span class = "fa fa-inr form-control-feedback"></span>
                          <br>
                        </div>

                        <div id="aon2" class="form-group has-feedback" style = "display: none;">
                         <label> All or None: &nbsp;
                              <input type="checkbox" name="aonsell">
                          </label>
                          

                        </div>
                        

                          <script>
                            function checklmt2(eventSelect){

                                if (eventSelect.value = "lmt"){
                                  document.getElementById("priceDiv2").style.display = "block";
                                  document.getElementById("qtyDiv2").style.display = "block";
                                  document.getElementById("aon2").style.display = "block";
                                }
                          }
                          </script>


                          <script>
                            function checkmkt2(evt){
                              document.getElementById("priceDiv2").style.display = "none";
                              document.getElementById("priceDiv2").value = "150";
                              document.getElementById("qtyDiv2").style.display = "block";
                              document.getElementById("aon2").style.display = "none";

                                
                          }
                          </script>
                        
                        <!-- <div class="row">
                         <div class="col-xs-8"> -->
                        
                          <!--</div> -->
                          <!-- /.col -->
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Place Order</button>
                          
                          <!-- /.col 
                        </div> -->
                      </form>
                      
                      
                </div>
                <!-- /.form-box -->
                
        
                
              </div>
              </div>
              
        
       
        

        <script>

          function generateTable(eventSelect){
            document.getElementById("tableDiv").style.display = "block";
          }
          
        </script>

        <script>
          function displayForm(event){
            document.getElementById("addOrder").style.display = "block";
          }
        </script>
      
        <!-- /.box-body -->
        
        <!-- /.box-footer-->
      </div>
      <!-- /.box -->
      
        

      

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
    $('#order').DataTable( {
        "lengthMenu": [[10, 20, 50, -1], [10, 20, 50, "All"]]
    } );
} );
</script>

</body>
</html>


</body>
</html>