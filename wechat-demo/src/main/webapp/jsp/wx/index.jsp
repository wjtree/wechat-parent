<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>JS测试页</title>
	<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
	<script type="text/javascript" >
		//页面加载完成时执行的JS代码
		function load(){
			document.getElementById('test2').style.display='none';
			document.getElementById('test4').style.display='none';
		}
	
		//点击隐藏网页底部导航栏
		function hideBar(){
			WeixinJSBridge.call('hideToolbar');
			document.getElementById('test1').style.display="none";
			document.getElementById('test2').style.display="block";
		}
		//点击显示网页底部导航栏
		function showBar(){
			WeixinJSBridge.call('showToolbar');
			document.getElementById('test1').style.display="block";
			document.getElementById('test2').style.display="none";
		}
		
		//点击隐藏网页右上角按钮
		function hideMenu(){
			WeixinJSBridge.call('hideOptionMenu');
			document.getElementById('test3').style.display="none";
			document.getElementById('test4').style.display="block";
		}
		//点击显示网页右上角按钮
		function showMenu(){
			WeixinJSBridge.call('showOptionMenu');
			document.getElementById('test3').style.display="block";
			document.getElementById('test4').style.display="none";
		}
		
		//点击显示用户网络状态
		function getNet(){
			WeixinJSBridge.invoke('getNetworkType',{},
				function(e){
					var k = e.err_msg;
					k = k.substring(13);
					alert('您当前的网络状态是：'+k);
				}
			);
		}
	</script>
  </head>
  
  <body onload="load()">
  	<div align="center">
		<div id="test1"><input type="button" value="点击隐藏网页底部导航栏" onclick="hideBar()" ></div>
		<div id="test2"><input type="button" value="点击显示网页底部导航栏" onclick="showBar()" ></div>
		
		<div id="test3"><input type="button" value="点击隐藏网页右上角按钮" onclick="hideMenu()" ></div>
		<div id="test4"><input type="button" value="点击显示网页右上角按钮" onclick="showMenu()" ></div>
		
		<div id="test5"><input type="button" value="点击获取用户网络状态" onclick="getNet()" ></div>
  	</div>
  </body>
</html>
