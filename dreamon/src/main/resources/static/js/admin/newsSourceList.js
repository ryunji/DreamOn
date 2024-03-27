window.addEventListener("load", function(){

    var newtilForm = this.document.querySelector(".n-form");
    
    //var btnModify = newtilForm.getElementsByClassName(".btn-modify")[0];
    //var btnDelete = newtilForm.getElementsByClassName(".btn-regist")[0];

    var btnModify = this.document.querySelector(".btn-modify");
    var btnDelete = this.document.querySelector(".btn-regist");
    
    //1.뉴스 Source Table 클릭 시 발생 이벤트.
    var newtilTable = document.querySelector(".n-table");
    newtilTable.onclick = function(e){

        btnModify.classList.remove("d:none");
        btnDelete.classList.add("d:none");

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

        var id     = data.id;
        var code   = data.code;
        var name   = data.name;
        var domain = data.domain;
        var url    = data.url;
        var useYn  = data.useYn;
        
        var inputId     = document.querySelector("input[name='id']"); 
        var inputCode   = document.querySelector("input[name='code']"); 
        var inputYn     = document.querySelector("input[name='use-yn']"); 
        var inputNm     = document.querySelector("input[name='name']"); 
        var inputDomain = document.querySelector("input[name='domain']"); 
        var inputUrl    = document.querySelector("input[name='url']"); 

        /*if(useYn == "Y")
            inputYn.click();*/
        
        //연형 쌤이 알려준 방법.
        inputYn.checked = useYn;    //checked에 Y, N 값 바인딩하면 알아서 토글처리 됨.

        inputId.value     = id;
        inputCode.value   = code;
        inputNm.value     = name;
        inputYn.value     = useYn;
        inputDomain.value = domain;
        inputUrl.value    = url;
    };

    //초기화 버튼 기능.
    var btnList    = this.document.querySelector("#btn-list");
  //var inputs     = newtilForm.querySelectorAll("input");  
    btnList.onclick = function(e){

        var target  = e.target;
        var targetTagNm = target.tagName;
        var targetId    = target.id;

         if(targetTagNm != "BUTTON")
             return;

         e.preventDefault();
         
       //var url = `http://localhost:8082/api/news/regist`;
         var url = `regist`;
         if(target.classList.contains("btn-modify"))
            url = `modify`;                                     //url = `http://localhost:8082/api/news/modify?id=${targetId}`;
    
        newtilForm.action = url;   
         /*inputs.forEach((input) => {
             input.value = "";
         });*/

         newtilForm.submit();
    };
});