<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Registration Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="plugins/iCheck/square/blue.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://o...content-available-to-author-only...n.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://o...content-available-to-author-only...n.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

  <!-- Google Font -->
  <link rel="stylesheet" href="https://f...content-available-to-author-only...s.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>
<body class="hold-transition register-page" style="background-image:url(http://farm6.static.flickr.com/5245/5686483330_71ebed75af_b.jpg); background-size:cover; height:80%; right:2000">
<div class="register-box">
  <div class="register-logo">
    <a href="index2.jsp"><b>Order</b>MatchingSystem</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">Register a new membership</p>

    <form action="RegisterUser" method="post">
      <div class="form-group has-feedback">
        <input type="text" name = "fullname" class="form-control" placeholder="Full name">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      
      <div class="form-group has-feedback">
        <input type="email" name = "email" class="form-control" placeholder="Email">
        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name = "password" class="form-control" placeholder="Password">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password"  name = "repassword" class="form-control" placeholder="Retype password">
        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="tel" name = "contact" class="form-control" placeholder="Contact Number" onkeypress="return isNumberKey(event)">
          
          <script>
            function isNumberKey(evt){
              var charCode = (evt.which) ? evt.which : event.keyCode
              if (charCode > 31 && (charCode < 48 || charCode > 57))
                  return false;
              return true;
          }
          </script>

        <span class="glyphicon glyphicon-phone form-control-feedback"></span>
      </div>
          
      
      <!-- <div class="row">
       <div class="col-xs-8"> -->
         <!--  <div class="checkbox icheck">
            <label>
              <input name = "agreeterms" type="checkbox">    I agree to the <a href="#">terms and conditions</a>
            </label>
          </div> -->
        <!--</div> -->
        <!-- /.col -->
          <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
        
        <!-- /.col 
      </div> -->
    </form>
	<% 
		String message = (String) request.getAttribute("errorString");
		if(message!=null) 
			{
			
			if (message.equals("Success!! Please Login ")){
			
			%>
			
			<div id = "successful" class = "alert" style = "margin:10px 0px; text-align:center; vertical-align:middle; padding-bottom:20px; line-height:5px; height:10px;  color: #008000; background-color: #98FB98;" >
				<p> <%out.println(message + "<br>"); %></p>
			
			</div>
			
			<% } 
			
			else{ %>
			
		    <div id="noEntry" class = "alert" style = "margin:10px 0px; text-align:center; vertical-align:middle; padding-bottom:20px; line-height:5px; height:10px;  color: #D8000C; background-color: #FFD2D2;">
		        <p> <% out.println(message + "<br>"); %>   </p>
		    </div>
		    
		<%	} 
		}%>
    <br>
    Already registered? <a href="login.jsp" class="text-center">Sign in</a>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="plugins/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
</script>
</body>
</html>
