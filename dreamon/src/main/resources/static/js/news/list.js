window.addEventListener("load", function(e){


    var nItem = this.document.querySelector(".n-item");
    nItem.onclick = function(e){

        var target = e.target;
        if(target.tagName != "BUTTON")                       //a 태그를 의미 : 대문자로 써야하나 봄. a태그가 아닌 녀석(ul, li)은 return
            return;
        
        alert("1.target.tagName : " + target.tagName);    
        e.preventDefault();

        var categoryId = target.dataset.id;
        var url        = `http://localhost:8082/api/menus?c=${categoryId}`;
        var method     = "GET";
        request(url, method);
   
    }
});