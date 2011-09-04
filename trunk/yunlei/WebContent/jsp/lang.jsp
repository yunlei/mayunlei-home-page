<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%String[] lang={"English","汉语","日本語","Монгол Хэл"};
String[] welcome={"Welcome to Ma Yunlei's Home page","欢迎来到马云雷的个人主页","私の個人的なホームページへようこそ","Маюнлайний вэб"};
String[] cloudDB={"Cloud DB","云DB"," やめで","чжа"};
String[] query={"execute","执行"," やめで","чжа"};
Integer langindex=(Integer)session.getAttribute("langindex");
if(langindex==null)
{
	langindex=0;
	session.setAttribute("langindex",langindex);
}
%> 