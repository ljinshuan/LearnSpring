function test(argument) {
    console.log($);

    var url = "http://localhost:8080/api/conf/http/catalogs/addOrEdit.do";


    var jsonData = {
        "thisKey": "thisValue"
    };

    var data = {
        "app": "tmall",
        "platform": "iphone",
        "clientVersion": "5.16.49",
        "moduleName": "zhisuTest",
        "memo": "test1",
        "content": $.toJSON(jsonData)
    }

    var encode = $.toJSON(data);
    console.log(encode);
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        data: encode,
        contentType: 'application/json'
    })
        .done(function() {
            console.log("success");
        })
        .fail(function() {
            console.log("error");
        })
        .always(function() {
            console.log("complete");
        });
}



console.log("hehe");


;
(function() {
    var url = "http://localhost:8080/api/Home/update.json";

    var data = {
        "userId": 123,
        "userName": "wangdachui"
    };
    $.ajax({
        url: url,
        type: 'POST',
        dataType: 'json',
        data: $.toJSON(data),
        contentType: 'application/json'
    }).done(function(result) {
        console.log("success");
        console.log(result);
    }).fail(function() {
        console.log("error");
    })


})()