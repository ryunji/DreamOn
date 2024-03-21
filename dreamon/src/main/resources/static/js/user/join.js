window.addEventListener("load", function(e){

    //1.이름 길이 체크.
    var joinSection = this.document.getElementById("join-info");
    var inputName   = joinSection.querySelector(".input[name='name']");         //joinSection.getElementsByClassName("input");//.namedItem("name");

    inputName.onblur = checkNameLength;
    function checkNameLength(){

        var nameDBColumByte = 45;
        var nameLength      = inputName.value.length;
        var nameByte        = nameLength * 2;
        var printSpan       = inputName.name;
        var msg             = "이름은 23글자를 넘길 수 없습니다.";
        inputLengthCheck(nameDBColumByte, nameByte, msg, inputName, printSpan);  
    }

    inputName.onclick = removeWaringClass;
    function removeWaringClass(){
        
        var hasClassList = inputName.classList.contains("n-field-textbox-status:warning");
        if(hasClassList)
            inputName.classList.remove("n-field-textbox-status:warning");
    }

    //2.아이디 길이 체크
    //3.비밀번호 체크
    //4.연락처

    //5.이메일
    var inputEmail    = joinSection.querySelector(".input[name='email']"); 
    inputEmail.onblur = validationEmail;
    function validationEmail(){
        
        //이메일 주소
        var emailAddr        = inputEmail.value;
        var emailDBColumByte = 25;
        var emailLength      = inputEmail.value.length;
        var emailByte        = emailLength * 2;

        //5.1.이메일 길이 체크.
        var emailLength = inputEmail.value.length;
        var printSpan   = inputName.name;
        var msgLength   = "이메일은 13자를 넘길 수 없습니다.";
        inputLengthCheck(emailDBColumByte, emailByte, msgLength, inputEmail, printSpan);  

        //5.2.이메일 형식 체크(정규식)
        var msgRegExp  = "이메일 형식이 유효하지 않습니다.";
        var emailRegex = new RegExp('[a-z0-9]+@[a-z]+\.[a-z]{2,3}');
        checkEmailRegex(emailAddr, msgRegExp, emailRegex);
    }

    //공통 길이 체크
    function inputLengthCheck(dbLen, iputLen, msg, inputObj, printSpan){

        if(dbLen < iputLen){
            
            var result = confirm(msg);
            Invalid(msg, result, inputObj, printSpan);
        }
    }//inputLengthCheck function

    //유효성 검사
    function checkEmailRegex(emailAddr, msgRegExp, emailRegex){

        var Validated  = emailRegex.test(emailAddr);
        if(!Validated)
        Invalid(msgRegExp, iputLen, msgRegExp);  
    }

    //밸리데이션 실패 시 관련 텍스트 출력.
    function Invalid(msg, result, inputObj, printSpan){

        inputObj.classList.add("n-field-textbox-status:warning");
        var focusName   = joinSection.querySelector(".span[name='focus-" + printSpan + "']");
        if(result){
                
            focusName.textContent = msg;
        }else{
            
            inputObj.value        = "";   //입력된 내용 빈 값으로 초기화.
            focusName.textContent = "";  //정보 출력 빈 값으로 초기화.    
        }    

    }//failValidated
})//window.addEventListener 이벤트 영역 종료.

 /*var html   = "<p>이름은 23글자를 넘길 수 없습니다.</p>";
   var width  = 300;
   var height = 100;
   var left   = (screen.width - width)   / 2;
   var top    = (screen.height - height) / 2;
   window.open("", "_blank", "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top).document.write(html);*/