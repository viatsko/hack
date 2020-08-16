<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Wholesale portal</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" crossorigin="anonymous">
    <style>
        #users-table tr td:last-child {
            text-align: right;
        }
    </style>
</head>
<body>
<#setting url_escaping_charset='UTF-8'>
<div class="container">
    <h1>Пользователи</h1>

    <table id="users-table" class="table">
        <thead class="thead-inverse">
        <tr>
            <th scope="col">email</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td scope="row">
                    ${user.email!}
                </td>
                <td>
                    <a href="/userDelete?email=${user.email!?url}">удалить</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>

    <hr />

    <h3>Добавление пользователя</h3>

    <form method="post" action="/userAdd">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" name="email" class="form-control" id="email" placeholder="Email">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>

    <hr />

    <h3>Обновить пароль администратора</h3>

    <form method="post" action="/adminPassChange">
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" class="form-control" id="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary">Обновить</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" crossorigin="anonymous"></script>
</body>
</html>
