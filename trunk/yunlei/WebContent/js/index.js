 $(document).ready(function(){
 
 });
 
 function changeLang(num)
 {
	  
 
	   $.ajax({
		   type:'POST',
		   url:"/yunlei/changeLang.action?langindex="+num,
		   success:function(){
		   		window.location.reload();
	   	   },
	   	   error:function(){
	   		   alert("error");
	   	   }
	   });
 }