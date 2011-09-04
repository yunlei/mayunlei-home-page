 $(document).ready(function(){
	 $("#Query").click(function(){
		 var str=$("#textArea").val();
		 
		 $.ajax({
				url:"DBQuery.action?queryStr="+str,
				dataType:'html',
				error: function(){$("#errorinfo").text("查询失败");},
				success:function(hml){
					 
					$("#outputArea").html(hml);
				}
		 }
		);
	 });
 });
  