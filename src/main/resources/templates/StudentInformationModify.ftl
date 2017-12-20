<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>学生基本信息改</title>
   <link href="/css/common/InfoModifyPage.css" rel="stylesheet" type="text/css"/>
     <link href="/css/common/HomePage.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    	<div class="top">
        	<div class="font">
        		课堂管理系统
        	</div>
        	<div class="icon">
        		 <a href="../../html/student/StudentCourseHome.html"><img src="../../images/home.png">首页</a>
                                <img src="../../images/help.png">帮助
                                <a href="../../html/common/WechatLoginPage.html"><img src="../../images/exit.png">退出</a>
        	</div>
        	<div class="clear"></div>
    	</div>
        <div class="body">
           <div class="navigation">
                <div class="title">导航</div>
                <div class="line"></div>
                <div class="courseIntroduction"><a class="guidefont" href="/html/student/StudentHomePage.html">基本信息</a>
                                                                    <a class="guidefont" href="/html/student/StudentCourseHome.html">课程信息</a>
                                                                    <a class="guidefont" href="/html/student/StudentChooseCoursePage.html">选择课程</a>
                </div>
            </div>
                    <div enctype="multipart/form-data">
            <div class="content">
              <div class="title">基本信息</div>
              <hr class="line"/>
                <div class="imgarea"><img class="img" src="${(userVO.avatar)!null}"/><br/>
            <input type="file" name="profilePicture"
                accept="image/jpeg,image/png,image/gif" />
                 </div>

                 <div class="info">

        <table class="table">
        <tr class="itemName">
        <td>用户名：<span>${(userVO.id)!null }</span></td>
        <td>学号：<input type="text" name="idnum" value="${(userVO.number)!""}"/></td>
        </tr>
        <tr class="itemName">
        <td>姓名：<input type="text" name="name" value="${userVO.name!""}"/></td>
        <td>性别：<input type="text" name="sex" value="${userVO.gender!""}" /></td>
        </tr>
        <tr class="itemName">
        <td>学校：<input type="text" name="school" value="${userVO.school.name!""}"/></td>
        <td>职称：<input type="text" name="title" value="${userVO.title!""}"/></td>
        </tr>
        <tr class="itemName">
        <td>E-mail：<input type="text" name="e-mail" value="${userVO.email!""}"/></td>
        <td>联系方式：<input type="text" name="phone" value="${userVO.phone!""}"/></td>
        </tr>
         </table>
         <br/>
        <br/>
        <br/>
        <br/>
     <div >
                <a href="../../html/student/StudentHomePage.html"> <input class="button" type="button" name="submit" value="提交"></input></a>
             </div>
           </div>
        </div>
            </div>
            <div class="clear"></div>
        </div>
</body>
</html>