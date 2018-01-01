<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>教师基本信息改</title>
   <link href="/css/common/InfoModifyPage.css" rel="stylesheet" type="text/css"/>
     <link href="/css/common/HomePage.css" rel="stylesheet" type="text/css"/>

    <script>

        window.onload=function(){
            var userId=localStorage.getItem("userId");
            document.getElementById("tid").value=userId;
        }
    </script>

</head>
<body>
    	<div class="top">
        	<div class="font">
        		课堂管理系统
        	</div>
        	<div class="icon">
        		 <a href="/teacher/TeacherCourseHomePage"><img src="/images/home.png">首页</a>
                                <img src="/images/help.png">帮助
                                <a href="/common/AccountLoginPage"><img src="/images/exit.png">退出</a>
        	</div>
        	<div class="clear"></div>
    	</div>
        <div class="body">
           <div class="navigation">
                <div class="title">导航</div>
                <div class="line"></div>
                <div class="courseIntroduction"> <a class="guidefont" href="/teacher/TeacherHomePage">基本信息</a>
                                                                    <a class="guidefont" href="/teacher/TeacherCourseHomePage">课程信息</a>
                                                                    <a class="guidefont" href="/teacher/TeacherCreateCoursePage">新建课程</a>
                </div>
            </div>
                    <form  enctype="multipart/form-data" action="/me/modify/Teacher" method="POST">
            <div class="content">
              <div class="title">基本信息</div>
              <hr class="line"/>
                <div class="imgarea"><img class="img" src="/images/link.jpg"/><br/>
            <input type="file" name="profilePicture"
                accept="image/jpeg,image/png,image/gif" />
                 </div>
                <div class="info">
                    <input name="id" hidden  id="tid" />
                    <table class="table">
                        <tr class="itemName">
                            <td>用户名：<span>${(userVO.id)!null }</span></td>
                            <td>教工号：<input type="text" name="number"  value="${(userVO.number)!""}"/></td>
                        </tr>
                        <tr class="itemName">
                            <td>姓名：<input type="text" name="name" value="${userVO.name!""}"/></td>
                            <td>性别：<span>${userVO.gender!""}</span></td>
                        </tr>
                        <tr class="itemName">
                            <td>学校：</span>${userVO.school.name!""}</span></td>
                            <td>学历：<input type="text" name="education"  value="${userVO.education!""}"/></td>
                        </tr>
                        <tr class="itemName">
                            <td>E-mail：<input type="text" name="email"  value="${userVO.email!""}"/></td>
                            <td>联系方式：<input type="text" name="phone"  value="${userVO.phone!""}"/></td>
                        </tr>
                    </table>
                    <br/>
                    <br/>
                    <br/>
                    <br/>
                    <div >
                        <input type="submit"  class="button" value="提交"/>
                    </div>
                </div>
        </div>
            </form>
            <div class="clear"></div>
        </div>
</body>
</html>