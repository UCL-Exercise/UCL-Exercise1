<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報</title>
<link rel="stylesheet" href="index.css">
</head>
<body>
		<div class="header">
        <ul class="header_info">
            <li>名前：
                <input type="text">
            </li>
            <li>得意言語：
                <input type="text">
            </li>
            <li>住所：
                <input type="text">
            </li>
            <li>仕事年数：
                <input type="text">
            </li>
            <li>国籍：
                <input type="text">
            </li>
        </ul>
    </div>
    <div class="info_menu">
        <span>名前</span>
        <span>年齢</span>
        <span>得意言語</span>
        <span>仕事年数</span>
        <span>性別</span>
        <span class="adress">住所</span>
        <span class="prepare">備考</span>
        <span>操作</span>
    </div>
    <div class="employee">
        <div class="employee_info">
            <span>AA</span>
            <span>30</span>
            <span>JAVA</span>
            <span>10</span>
            <span>男</span>
            <span class="adress">東京都渋谷区</span>
            <span class="prepare">通勤一時間以内</span>
            <span>
                <button class="b1" onclick="window.location.href='resume.jsp'">詳細</button>
                <button class="b2">更新</button>
            </span>
        </div>
    </div>
</body>
</html>