<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="x-admin-sm">

<head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.2</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv=“Content-Type” content=“multipart/form-data; charset=utf-8”>
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <script type="text/javascript" src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]--></head>

<body>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
    <div class="layui-fluid">
        <div class="layui-row">

            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>招生简章</label>
                <div class="layui-input-inline">
                    <input type="text" id="name" name="name" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>学校简介</label>
                <div class="layui-input-inline">
                    <input type="text" id="school_overview" name="school_overview" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="phone" class="layui-form-label">
                    <span class="x-red">*</span>项目介绍</label>
                <div class="layui-input-inline">
                    <input type="text" id="project_introduction" name="project_introduction" required="" lay-verify="phone" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>招生专业</label>
                <div class="layui-input-inline">
                    <input type="text" id="enrollment_major" name="enrollment_major" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>招生对象</label>
                <div class="layui-input-inline">
                    <input type="text" id="enrollment_target" name="enrollment_target" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>报名资料</label>
                <div class="layui-input-inline">
                    <input type="text" id="registration_materials" name="registration_materials" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>
            <div class="layui-form-item">
                <label for="username" class="layui-form-label">
                    <span class="x-red">*</span>上传图片</label>
                <div class="layui-input-inline">
                    <input type="file" id="file" name="file" required="" lay-verify="required" autocomplete="off" class="layui-input"></div>
            </div>

    <input type="submit" value="上传"/>
        </div>
    </div>
</form>

</body>
</html>