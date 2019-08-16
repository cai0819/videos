<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta charset="utf-8">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content="Web前端视频教程,大数据视频教程,HTML5视频教程,UI视频教程,PHP视频教程,java视频教程,python基础教程">
    <meta name="description" content="Y先生教育在线课程视频,为您提供java,python,HTML5,UI,PHP,大数据等学科经典视频教程在线浏览学习,精细化知识点解析,深入浅出,想学不会都难,Y先生教育,学习成就梦想！">
    <meta name="author" content="尚忠祥">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/base.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/profile.css">
    <link rel="icon" href="favicon.png" type="image/png">
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <title>在线公开课-Y先生教育|java|大数据|HTML5|python|UI|PHP视频教程</title>
    <script type="text/javascript">
       
       var regIsCommitOldPass=false;
       var regIsCommitPsw=false;
       
       $(function(){
          
          $("#oldPassword").blur(function(){
               
                
                var oldPass= $("#oldPassword").val();
                if(null!=oldPass && oldPass!=""){
                       
                       var params={"password":oldPass};
		                 // alert(params);
		                  $.post("${pageContext.request.contextPath}/user/validatePassword.do",params,function(data){
		                      if(data.code==1){
		                         regIsCommitOldPass=true;
		                         $("#oldMsg").text("原密码正确").css("color","green");
		                      }else{
		                         regIsCommitOldPass=false;
		                         $("#oldMsg").text("原密码错误").css("color","red");
		                      }
		                  });
                }
          });
          
          $("#newPassword02").blur(function(){
               var pass01= $("#newPassword").val();
                var pass02= $("#newPassword2").val();
                if(null==pass01 || ""==pass01 || null==pass02 || ""==pass02){
                    $("#passMsg").text("密码不能为空").css("color","red");
                    regIsCommitPsw =false;
                }else{
                    if(pass01!=pass02){
                        regIsCommitPsw=false;
                        $("#passMsg").text("两次密码输入不一致，请重新输入").css("color","red");
                    }else{
                        regIsCommitPsw=true;
                        $("#passMsg").text("");
                    }
                }
                
          });
          
       
       });
       
    </script>
</head>

<body class="w100">
    <header>
        <div class="container top_bar clearfix">
            <img src="${pageContext.request.contextPath}/img/logo.png" alt="小禅院">
            <div id="tele">
                <span>0375-208-9092</span>
                <span>0375-208-9051</span>
            </div>
        </div>
        <menu>
            <div class="container clearfix">
                <ul class="clearfix f_left">
                    <li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
                    <li><a href="${pageContext.request.contextPath}/index.jsp">课程</a></li>
                    <li><a href="#">关于我们</a></li>
                    <li class="menu_active"><a href="${pageContext.request.contextPath}/my_profile.jsp">个人中心</a></li>
                </ul>
                <div id="search_group">
                    <input type="text" placeholder="搜索课程">
                    <span id="search"></span>
                </div>
                <div id="user_bar">
                    <a href="user/showMyProfile.action">
                      <c:if test="${empty userLogin.imgUrl}">
                         <img id="avatar" src="${pageContext.request.contextPath}/img/avatar_lg.png" alt="">
                      </c:if>
                      
                      <c:if test="${not empty userLogin.imgUrl}">
                         <img id="avatar" src="${userLogin.imgUrl}" alt="">
                      </c:if>
                       
                    </a>
                    <a href="${pageContext.request.contextPath}/user/logout2.do" id="lay_out">退出</a>
                </div>
            </div>
        </menu>
    </header>
    <main>
        <div class="container">
            <h2>我的资料</h2>
            <div id="profile_tab">
                <ul class="profile_tab_header f_left clearfix">
                    <li><a href="${pageContext.request.contextPath}/change_profile.jsp">更改资料</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/change_avatar.jsp">更改头像</a></li>
                    <li class="profile_tab_line">|</li>
                    <li><a href="${pageContext.request.contextPath}/password_safe.jsp">密码安全</a></li>
                </ul>
                <div class="proflle_tab_body">
                    <h3><a href="${pageContext.request.contextPath}/my_profile.jsp">返回个人中心</a></h3>
                    <div class="proflle_tab_workplace clearfix">
                        <div class="profile_avatar_area">
                        
                           <c:if test="${empty userLogin.imgUrl}">
		                         <img id="avatar" src="${pageContext.request.contextPath}/img/avatar_lg.png" alt="">
		                      </c:if>
		                      
		                      <c:if test="${not empty userLogin.imgUrl}">
		                         <img id="avatar" width="180px" height="180px" src="${userLogin.imgUrl}" alt="">
		                      </c:if>
                           
                        </div>
                        <div class="profile_ifo_area">
                            <form action="user/updatePassword.do">
                                <div class="form_group">
                                    <span class="dd">旧&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="oldPassword" name="oldPassword"><span id="oldMsg"></span>
                                </div>
                                <div class="form_group">
                                    <span class="dd">新&#x3000;密&#x3000;码：</span>
                                    <input type="password" id="newPassword"  name="newPassword">
                                </div>
                                <div class="form_group">
                                    <span class="dd">确认新密码：</span>
                                    <input type="password" id="newPassword2" name="newPassword2"><span id="passMsg"></span>
                                </div>
                                <div class="form_submit dd">
                                    <input type="submit" value="保&#x3000;存">
                                    <a href="#">取消</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <div class="container">
            <ul>
                <li><img src="${pageContext.request.contextPath}/img/footer_logo.png" alt="" id="foot_logo"></li>
                <li>版权所有：Y先生教育&#x3000;&#x3000;&#x3000;&copy;&nbsp;www.chengjian100.com</li>
                <li><img src="${pageContext.request.contextPath}/img/微信公众号.png" alt="" id="wxgzh"></li>
            </ul>
        </div>
    </footer>
</body>
<script>
    $("form").submit(function () {
        $.ajax({
            type: "post",
            url: "/QFVideos/user/updatePassword.do",
            data: $("form").serialize(),
            dataType: "json",
            success: function (data) {
                if (data.code == 1) {
                    alert("修改成功,请重新登录");
                    window.location.href = "index.jsp";
                } else {
                    alert(data.info);
                }
            }
        });
        return false;
    })
</script>
</html>