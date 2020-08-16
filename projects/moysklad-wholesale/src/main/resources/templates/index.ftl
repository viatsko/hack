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
        body {
            padding-bottom: 100px;
        }

        #wholesale-table input {
            width: 5em;
        }

        #wholesale-table td:nth-child(4) {
            white-space: nowrap;
        }

        ul#menu, #menu li {
            list-style: none;
            padding: 0;
            margin: 0;
            font-size: 0.85em;
        }

        #menu li.level-1 {
            padding-left: 1em;
        }

        #menu li.level-2 {
            padding-left: 2em;
        }

        #menu li.level-3 {
            padding-left: 3em;
        }

        #menu li.level-4 {
            padding-left: 4em;
        }

        #menu li.level-5 {
            padding-left: 5em;
        }

        #order-form {
            background: #fff;
            box-shadow: 0 -3px 20px rgba(0,0,0,0.19), 0 6px 6px rgba(0,0,0,0.23);
        }

        .header-row td {
            padding-top: 1em;
        }

        #order-form {
            padding: 8px 0;
        }

        #order-form .total {
            display: flex;
            justify-content: center;
            flex-direction: column;
        }

        #order-form .button {
            text-align: right;
        }

        .catalog-text {
            font-size: 0.8em;
            font-weight: bold;
        }

        .hl {
            color: #ff2400;
        }
    </style>
</head>
<body>
<#setting url_escaping_charset='UTF-8'>
<div class="container">
    <h1>${catalogName}</h1>
    <p class="catalog-text">${catalogText}</p>
    <div class="row">
        <div class="col-2">
            <ul id="menu">
                <#list pathNames as pathName>
                    <li class="level-${pathName.depth}">
                        &mdash; <a href="#${pathName.fullPath?url}">${pathName.name}</a>
                    </li>
                </#list>
            </ul>
        </div>
        <div class="col">
            <table id="wholesale-table" class="table">
                <thead class="thead-inverse">
                    <tr>
                        <th scope="col"></th>
                        <th scope="col">Название</th>
                        <th scope="col">Артикул</th>
                        <th scope="col">Цена</th>
                        <th scope="col">Количество</th>
                    </tr>
                </thead>
                <tbody>
                    <#list products as product>
                        <#if currentPathName != product.pathName>
                            <tr class="header-row">
                                <td colspan="5">
                                    <a name="${product.pathName}"></a><h3>${product.pathName}</h3>
                                </td>
                            </tr>
                        </#if>
                        <tr>
                            <td scope="row">
                                <#if product.imageUrl! != "">
                                    <img width="100" src="${baseUrl}${product.imageUrl!}" />
                                </#if>
                            </td>
                            <td>
                                ${product.name}
                            </td>
                            <td>
                                ${product.code!}
                            </td>
                            <td>
                                ${(product.salePrices[0].value/100)?string("##0.00")} ₽
                            </td>
                            <td>
                                <input type="number" data-price="${(product.salePrices[0].value/100)}" class="form-control" id="quantity-${product.externalCode!}" value="0" min="0" max="9999" />
                            </td>
                        </tr>
                        <#assign currentPathName=product.pathName>
                    </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div id="order-form" class="fixed-bottom">
    <div class="container">
        <div class="row">
            <div class="col total">
                <div>
                    Общая стоимость: <strong><span id="total-price">0</span> ₽</strong>
                </div>
            </div>
            <div class="col-3 button">
                <button
                        type="button"
                        class="btn btn-primary"
                        data-toggle="modal"
                        data-target="#orderModal"
                >Оформить заказ</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="orderModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form action="/submitOrder" method="post" id="formSubmit">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Оформление заказа</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="order-contact-name" class="col-form-label">Ф. И. О. контактного лица:</label>
                        <input type="text" class="form-control" required id="order-contact-name">
                    </div>
                    <div class="form-group">
                        <label for="order-phone" class="col-form-label">Телефон:</label>
                        <input type="text" class="form-control" required id="order-phone">
                    </div>
                    <div class="form-group">
                        <label for="order-email" class="col-form-label">E-mail:</label>
                        <input type="text" class="form-control" required id="order-email">
                    </div>
                    <div class="form-group">
                        <label for="order-city" class="col-form-label">Город доставки:</label>
                        <input type="text" class="form-control" required id="order-city">
                    </div>
                    <div class="form-group">
                        <label for="order-address" class="col-form-label">Адрес доставки:</label>
                        <input type="text" class="form-control" required id="order-address">
                    </div>
                    <div class="form-group">
                        <label for="order-description" class="col-form-label">Комментарий (предпочитаемая ТК для отправки заказа):</label>
                        <textarea class="form-control" required id="order-description"></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Отмена</button>
                    <button type="submit" class="btn btn-primary">Закончить оформление</button>
                </div>
            </form>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script src="/main.js"></script>
</body>
</html>
