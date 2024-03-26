window.addEventListener("load", function(e){

    // "https:"
    var protoCol = window.location.protocol;
    // "hianna.tistory.com"
    var host = window.location.host;
    // "hianna.tistory.com"window.location.hostname // ""window.location.port
    var port = window.location.port;

    //var domainUrl = protoCol + host;

    //this.alert(domainUrl);

    var nItem = this.document.querySelector(".n-item");
    nItem.onclick = function(e){

        var target = e.target;
        if(target.tagName != "BUTTON")                       //a 태그를 의미 : 대문자로 써야하나 봄. a태그가 아닌 녀석(ul, li)은 return
            return;
        
//alert("1.target.tagName : " + target.tagName);    
        e.preventDefault();

        var id         = target.dataset.id;
        var url        = `http://localhost:8082/api/news/scrap-news?id=${id}`;
        var method     = "POST";
        request(url, function(){
        
            console.log("스크랩 완료");
            //target. 
            //icon icon:bookmark_simple_fill
        }
        , method);
   
    }

    function request(url, callback, method){

        method = method || "GET";                              //undefined이면 GET 세팅.

        var xhr        = new XMLHttpRequest();                 //자바스크립트가 사용하는 도구, var xhr = new window.XMLHttpRequest(); : 윈도우 객체 소속.
        xhr.withCredentials = true;

        xhr.onload = function(){

            callback();
        } 
    
        //얘 위치는 onload 뒤여야 햠.
        xhr.open(method, url, false);  
        xhr.send();
    }

    // function bind(list){
           
    //     menuContent.classList.add("fade-out");
        
    //     //fade-out 끝난 후. menuContent에 이벤트가 걸려있어서 두번 호출 됨.
    //     console.log("fade-out 시작");
    //     menuContent.ontransitionend = function(){


    //         menuContent.ontransitionend = null;
    //         console.log("fade-out 종료");
    //     //일정 시간이 지나고 난 후, 윈도우 객체의 함수.
    //     //setTimeout(function() {

    //         menuContent.classList.remove("fade-out");
    //     //}, 1500);

    //         menuContent.innerHTML = "";
    //         //서버에서 전달받은 list는 array 형식이고 그 중에서 하나만 꺼내준 것. 이름은 어떤걸 해도 상관 없으나 인식하기 쉽게 menu로 적은 듯.
    //         for(var menu of list){
                
    //             var sectionHTML = `<section class="menu-card">
    //                                 <h1>
    //                                 <!--<a class="heading-3" href="detail.html" >카페라떼1</a></h1>-->
    //                                     <a class="heading-3" href="detail.html">${menu.korName}</a></h1>
    //                                     <h2 class="heading-2 font-weight:normal color:base-5">Cafe Latte</h2>
    //                                     <div class="price-block d:flex align-items:flex-end"><span class="font-weight:bold">${menu.price}</span>원<span class="soldout-msg ml:auto mr:auto md:d:none">SOLD OUT</span></div>
    //                                     <div class="img-block">
    //                                         <a href="detail.html?id=1">
    //                                         <img src="/image/menu/8.jpg"></a>
    //                                     </div>
    //                                     <div class="like-block d:flex justify-content:flex-end">
    //                                 <!-- <a class="icon icon-heart-fill icon-color:base-4" href="">좋아요</a> -->
    //                                         <a class="icon icon-heart icon-color:base-4" href="">좋아요</a>
    //                                         <span class="font-weight:bold ml:1" >2</span>
    //                                     </div>
    //                                     <div class="pay-block d:flex">
    //                                 <!-- <a class="icon md:icon:none icon-cart icon-color:base-0 color:base-0 btn-type:icon btn-cart md:btn-type:text" href="">담기</a> -->
    //                                 <!-- <form action="addMenu" method="post"> -->
    //                                         <form action="/cart/add-menu" method="post">
    //                                             <input type="hidden" name="id" ></input>
    //                                             <button class="icon md:icon:none icon-cart icon-color:base-0 color:base-0 btn-type:icon btn-cart md:btn-type:text">
    //                                                 담기
    //                                             </button>
    //                                         </form>
    //                                         <a class="icon md:icon:none icon-card icon-color:base-0 color:base-0 btn-type:icon btn-card md:btn-type:text" href="">주문하기</a>
    //                                     </div>
    //                                 </section>`;

                    
    //             menuContent.insertAdjacentHTML("beforeend", sectionHTML);

    //     };
    // }
});