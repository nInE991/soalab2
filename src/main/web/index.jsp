<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Cake</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
    <link href="open-iconic/font/css/open-iconic-bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="js/mas.js"> </script>
</head>
<body>
    <div class="container" style="width:60%; margin:auto; position: center;">
        <div class="shadow p-3 mb-2 bg-white">
            <div class ="row" >
                <div class="col"><h2>Торты</h2></div>
                <div class="col" style="text-align:right;">
                    <div class ="mt-1">
                    <button type="button" id ="button_add" class="btn btn-outline-dark">
                        <span class="oi oi-plus"></span>
                        <span class = "mt-1">Добавить</span>
                    </button>
                </div>
                </div>
            </div>
        </div>


        <table class="table" style="text-align: center ;margin-top: 30px ">
            <thead>
                <tr>
                    <th scope="col">Наименование</th>
                    <th scope="col">Цена</th>
                    <th scope="col">Количество</th>
                    <th scope="col">Действия</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cakeList}" var="cake">
                    <tr>
                        <td><div class = "mt-1">${cake.getName()}</div></td>
                        <td><div class = "mt-1">${cake.getCost()}</div></td>
                        <td><div class = "mt-1">${cake.getCount()}</div></td>
                        <td>
                            <div class="btn-group">
                                <button type="button" data-id="${cake.getId()}" data-name="${cake.getName()}" data-cost="${cake.getCost()}" data-count="${cake.getCount()}" class="btn btn-outline-light text-dark button_editmodal"><span class="oi oi-pencil"></span></button>
                                <button type="button" data-id="${cake.getId()}" data-name="${cake.getName()}" class="btn btn-outline-light text-dark button_delmodal" ><span class="oi oi-trash"></span></button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="modal fade" id="Modal">
            <div class="modal-dialog modal-dialog-centered">
                <div class="modal-content">
                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title" id="modal_id">Изменить запись</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body" style="text-align:left">
                        <div class ="row" id="row1">
                            <div class="col-3 m-2" ><strong><h6>Наименование</h6></strong></div>
                            <div class="col"><input type="text"  step = 'any' class="form-control" id = "editName"></div>
                        </div>
                        <div class ="row" id="row2">
                            <div class="col-3 m-2"><strong><h6>Цена</h6></strong></div>
                            <div class="col"><input type="number"  class="form-control" id = "editCost"></div>
                        </div>
                        <div class ="row" id="row3">
                            <div class="col-3 m-2"><strong><h6>Количество</h6></strong></div>
                            <div class="col"><input type="number"  class="form-control" id = "editCount"></div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" data-type="edit" class="btn btn-secondary btn-modal" id ="buttonModal">Изменить</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal" id="ModalDelete">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Удалить запись</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    <div class="modal-body">
                        <p>Вы уверены что хотите удалить <b><span id="modaldeletep"> </span></b>!</p>
                    </div>

                    <!-- Modal footer -->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary btn-delete" id ="buttonModalDelete" data-id="">Удалить</button>
                        <button type="button" class="btn btn-danger"  data-dismiss="modal">Close</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
