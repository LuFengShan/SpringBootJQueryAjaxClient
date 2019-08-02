$(document).ready(function () {

    // 提交表单
    $("#customerForm").submit(function (event) {
        // 防止表单通过浏览器提交。
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost() {

        // 准备表格数据
        var formData = {
            firstname: $("#firstname").val(),
            lastname: $("#lastname").val()
        }

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "/save2",
            data: JSON.stringify(formData),
            dataType: 'json',
            success: function (result) {
                if (result.code == 1) {
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "提交成功! <br>" +
                        "---> 消费者信息: 名字 = " +
                        result.data.firstname + " ,姓氏 = " + result.data.lastname + "</p>");
                } else {
                    $("#postResultDiv").html("<strong>出错！</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // 提交后重置表单数据
        resetData();

    }

    function resetData() {
        $("#firstname").val("");
        $("#lastname").val("");
    }
})