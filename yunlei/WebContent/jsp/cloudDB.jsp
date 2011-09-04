 
 <%@include file="lang.jsp" %>
 <script src="<%=request.getContextPath()%>/js/jquery-1.4.4.min.js"></script>
 <script src="<%=request.getContextPath()%>/js/CloudDB.js"></script>
 <div id="expmle">
SQL example:
<br/>*******************************
<br/>use   db; 
<br/>select * from Product;
<br/>select * from Product, Printer;
<br/>select model, price from Laptop;
<br/>select model as MODEL, color as COLOR, type as TYPE from Printer;
<br/>*******************************
<br/>
 <br/> put the above sql example into the textarea , and then press the button to see the result.
 <br/> REMEMBER THAT EVERY SQL MUST BE ENDED WITH  ";".
 <br/> AN EMPTY INPUT WILL CAUSE ERROR;
 <br/>source code is <a href="http://code.google.com/p/sjtu-database-mla/">here</a>
 </div>
 <div id="inputArea">
 <textarea id="textArea" rows="5" cols="60">
 
 </textarea>
 <br/>
 <button id="Query"><%=query[langindex] %></button>
 <label id="errorinfo"></label>
 </div>
 <div id="outputArea">
 </div> 
 <div>

<br/>************************
<br/>  the flowing commands are support:
 <br/>create table Product(maker char, model int, type char(8)) ;
 <br/>select * from Product where (maker = 'A' or maker = 'B' or maker = 'C' or maker = 'D' or maker = 'E' or maker = 'F' or maker = 'G' or maker = 'H') and (type = 'pc' or type = 'laptop');
 <br/>describe Product;
 <br/>create table Product1(
maker char, 
model int, 
type char(8),
check (model = 1002 or model=1001 or model > 1005)
);
<br/>select distinct maker, model, type from Product;
<br/>create view view5 as select maker ,speed from Product, PC
<br/>select * from liketest where v1 like 'ab%';
<br/>select SUM(price), model from PC where 1=1 group by model;
<br/>select MIN(price), MAX(price) from PC where 1=1; 
<br/>select *  from  printer where price>=all(select price from printer where price>100);
<br/>select MIN(model), type from Product group by type;
<br/>select maker, model, type from Product where model in(select model from Printer);
<br/>select price,model from printer  where price>99 order by price   asc,model asc;
<br/>select pricer from Printer1 where exists (select PC1.price from PC1 where pricer=price);
 
 </div>
 <%
 	if(session.getAttribute("init")==null)
 	{	
 		 
 		session.setAttribute("init","init");
 	 
%>
<script type="text/javascript">
$(document).ready(function(){
	 $.ajax({
		 type:"POST",
		 url:"init.action?"		 
	 });
});
</script>
<%	}
%>