window.addEventListener("load", function(){

    //1.뉴스 Source Table 클릭 시 발생 이벤트.
    var newtilTable = document.querySelector(".n-table");
    newtilTable.onclick = function(e){

        var target      = e.target;
        var targetTagNm = target.tagName;
        if(targetTagNm != "TD")
                return;

        var targetId = target.dataset.id;
        console.log("targetId : ", targetId);
        var url = `http://localhost:8082/api/news/data?id=${targetId}`;

        request(url, function(data){

            bind(data);
        });
    };

    //데이터 단건 요청.
    function request(url, callback, method){

        method = method || "GET";

        var xhr = new XMLHttpRequest();
            xhr.withCredentials = true;

        xhr.onload = function(){

            var data = this.responseText; //
            var jsonData = JSON.parse(data)[0];
            callback(jsonData);
        };

        xhr.open(method, url, false);
        xhr.send();
    };

    //데이터 세팅.
    function bind(data){

        var id   = data.id;
        var name = data.name;
        var url  = data.url;

        var inputId  = document.querySelector("input[name='id']"); 
        var inputNm  = document.querySelector("input[name='name']"); 
        var inputUrl = document.querySelector("input[name='url']"); 
        
        inputId.value = id;
        inputNm.value       = name;
        inputUrl.value      = url;
    };

    //초기화 버튼 기능.
    //var btnList    = this.document.querySelector("#btn-list");
    //var inputs     = newtilForm.querySelectorAll("input");  
    // btnList.onclick = function(e){
    //     var target = e.target;
    //     var targetTagNm = target.tagName;
    //     var targetId = target.id;
    //     alert("sdfasdfasdf : " + targetId);

    //     if(targetTagNm != "BUTTON")
    //         return;

    //     if(targetId == "reg")
    //         return;

    //     e.preventDefault();
    //     inputs.forEach((input) => {
    //         input.value = "";
    //     });
    // };
});