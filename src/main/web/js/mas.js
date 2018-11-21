$(document).ready(function() {
    var delval = 0;
    $("#button_add").click(function () {
        $('#buttonModal').text('Добавить');
        $('#modal_id').text('Добавить запись');
        $('#buttonModal').data('type', 'add');
        $('#Modal').modal('show');
    });
    $('.button_editmodal').click(function () {
        $('#buttonModal').text('Изменить');
        $('#buttonModal').data('type', 'edit');
        $('#modal_id').text('Изменить запись');
        delval = $(this).data('id');
        $('#editName').val($(this).data('name'));
        $('#editCost').val($(this).data('cost'));
        $('#editCount').val($(this).data('count'));
        $('#Modal').modal('show');
    });
    $('.button_delmodal').on('click', function () {
        $('#modaldeletep').text($(this).data('name'));
        delval = $(this).data('id');
        $('#ModalDelete').modal('show');
    });
    $("#Modal").on('hidden.bs.modal', function () {
        $('#editName').val('');
        $('#editCost').val('');
        $('#editCount').val('');
    });
    $('#buttonModalDelete').on('click', function () {
        $('#ModalDelete').modal('hide');
        $.ajax({
            type: 'POST',
            url: 'delete',
            data: {
                Id: delval
            },
            success: function () {
                location.reload();
            },
            error: function () {
                alert("Запись не удалена!")
            }
        });

    });

    $('.btn-modal').on('click', function () {
        var name = $('#editName').val();
        var cost = $('#editCost').val();
        var count = $('#editCount').val();

        if ($(this).data('type') == 'add') {
            $("#Modal").modal("hide");
            $.ajax({
                type: 'POST',
                url: 'add',
                data: {
                    Name: name,
                    Cost: cost,
                    Count: count
                },
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("Запись не добавлена!")
                }
            });
        } else if ($(this).data('type') == 'edit') {
            var name = $('#editName').val();
            var cost = $('#editCost').val();
            var count = $('#editCount').val();

            $("#Modal").modal("hide");
            $.ajax({
                type: 'POST',
                url: 'edit',
                data: {
                    Id: delval,
                    Name: name,
                    Cost: cost,
                    Count: count
                },
                success: function () {
                    location.reload();
                },
                error: function () {
                    alert("Запись не изменена!")
                }
            });
        }

    });
});