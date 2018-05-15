<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <script language="javascript" type="text/javascript" src="page/jquery-1.10.2.min.js"></script>
</head>
<body>
<a href="second.html">second</a><a href="third.html">third</a><a href="test.html">test</a>
<div>
<table style="border:1px solid black" border="1">
	
	<tr>
		<td><a href="#" onclick="getboxaccesstoken();">get box access token</a></td>
	<td><a href="#" onclick="getcloudaccesstoken();">get cloud access token</a></td>
	</tr>
</table>
 
   <iframe src="https://www.ustream.tv/embed/recorded/113875912?html5ui" style="border: 0 none transparent;"  webkitallowfullscreen allowfullscreen frameborder="no" width="480" height="270"></iframe><div>
<!--  <embed src="https://www.ustream.tv/recorded/113875912"/> -->
 <form method="post" enctype="multipart/form-data" id="uploadform">
					<input type="file" name="file" size="50" />
					<br />
					<input type="submit" value="Upload" id="btnSubmit"/>
				</form>
				
				<div id="channelListArea">
            
        </div>
</body>
</html>
<script type="text/javascript">

  var form = $('#uploadform')[0];

    var data = new FormData(form);
$(function() {


	 $("#btnSubmit").click(function (event) {
 
        event.preventDefault();
 
        var form = $('#uploadform')[0];
 
        var data = new FormData(form);
  
        $("#btnSubmit").prop("disabled", true);

        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "page/UploadFilService.jsp",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {

                $("#channelListArea").text(data);
                console.log("SUCCESS : ", data);
                $("#btnSubmit").prop("disabled", false);

            },
            error: function (e) {

                $("#channelListArea").text(e.responseText);
                console.log("ERROR : ", e);
                $("#btnSubmit").prop("disabled", false);

            }
        });

    });
	 
	 
});
function getWindowSpecs() {
	var windowConfiguration = {
			height : 520,
			width : 590
		};
	var dualScreenLeft = window.screenLeft !== undefined ? window.screenLeft
			: screen.left;
	var dualScreenTop = window.screenTop !== undefined ? window.screenTop
			: screen.top;
	var width = screen.width;
	if (window.innerWidth) {
		width = window.innerWidth;
	} else if (document.documentElement.clientWidth) {
		width = document.documentElement.clientWidth;
	}
	var height = screen.height;
	if (window.innerHeight) {
		height = window.innerHeight;
	} else if (document.documentElement.clientHeight) {
		height = document.documentElement.clientHeight;
	}
	var left = ((width / 2) - (windowConfiguration.width / 2))
			+ dualScreenLeft;
	var top = ((height / 2) - (windowConfiguration.height / 2))
			+ dualScreenTop;
	left = left > 0 ? left : 0;
	top = top > 0 ? top : 0;
	var specs = 'width=' + windowConfiguration.width + ',height='
			+ windowConfiguration.height + ',top=' + top + ',left='
			+ left;
	return specs;
}
function getboxaccesstoken(){
	var currenturl = window.location.href;//zz0msfvizm524a9de326upq6sxtq9vef   3expyvyk8piden5ui5ecm4kb1qps34go h11dmt34wn5x7vf71ghmozxszjftj21l
 	var specs = getWindowSpecs();
	var url = "https://account.box.com/api/oauth2/authorize?response_type=code&client_id=k3o2fx1ly70vlc37no6wtcxofln98ov1";
	window.open(url,"boxlocalauth",specs); 
	
}


function getcloudaccesstoken(){
	var currenturl = window.location.href;//zz0msfvizm524a9de326upq6sxtq9vef   3expyvyk8piden5ui5ecm4kb1qps34go h11dmt34wn5x7vf71ghmozxszjftj21l
 	var specs = getWindowSpecs();
	var url = "https://www.ustream.tv/oauth2/authorize?response_type=token&client_id=9704eadd82441b37f7e1846b7a4fc9475d7f89ed&redirect_uri=http://127.0.0.1:8080";
	window.open(url,"cloudlocalauth",specs); 
	
}
 function openmyboxwindow() {
	var options = {
		    clientId: "3expyvyk8piden5ui5ecm4kb1qps34go",
		    linkType: "direct",
		    multiselect: "false"
		};
    var boxSelect = new BoxSelect(options);
    boxSelect.launchPopup();
    // Register a success callback handler
    boxSelect.success(function(response) {
     console.log(response);
        $.each(response,function(index,comment) {
        	   $("#fileinfodiv").html(comment.id+comment.name);
        });
     
         
    });
    // Register a cancel callback handler
    boxSelect.cancel(function() {
        console.log("The user clicked cancel or closed the popup");
    });
} 
 
</script>