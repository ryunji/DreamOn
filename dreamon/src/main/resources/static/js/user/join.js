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
        var msg             = "이름은 22글자를 넘길 수 없습니다.";
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
    var inputPhone = joinSection.querySelector(".input[name='phone']"); 
    inputPhone.onkeypress = numberToFormatting;
    function numberToFormatting(event){
    
        //숫자 입력이 아닐 시 리턴.
        var lastKeyPressed = event.key;
        if(isNaN( lastKeyPressed)){
            return;
        }

        inputPhoneNumber(event.target);
        function inputPhoneNumber( phone ) {
            if( event.keyCode != 8 ) {
                const regExp = new RegExp( /^[0-9]{2,3}-^[0-9]{3,4}-^[0-9]{4}/g );
                if( phone.value.replace( regExp, "").length != 0 ) {                
                    if( checkPhoneNumber( phone.value ) == true ) {
                        let number = phone.value.replace( /[^0-9]/g, "" );
                        let tel = "";
                        let seoul = 0;
                        if( number.substring( 0, 2 ).indexOf( "02" ) == 0 ) {
                            seoul = 1;
                            phone.setAttribute("maxlength", "12");
                            console.log( phone );
                        } else {
                            phone.setAttribute("maxlength", "13");
                        }
                        if( number.length < ( 4 - seoul) ) {
                            return number;
                        } else if( number.length < ( 7 - seoul ) ) {
                            tel += number.substr( 0, (3 - seoul ) );
                            tel += "-";
                            tel += number.substr( 3 - seoul );
                        } else if(number.length < ( 11 - seoul ) ) {
                            tel += number.substr( 0, ( 3 - seoul ) );
                            tel += "-";
                            tel += number.substr( ( 3 - seoul ), 3 );
                            tel += "-";
                            tel += number.substr( 6 - seoul );
                        } else {
                            tel += number.substr( 0, ( 3 - seoul ) );
                            tel += "-";
                            tel += number.substr( ( 3 - seoul), 4 );
                            tel += "-";
                            tel += number.substr( 7 - seoul );
                        }
                        phone.value = tel;
                    } else {
                        const regExp = new RegExp( /[^0-9|^-]*$/ );
                        phone.value = phone.value.replace(regExp, "");
                    }
                }
            }
        }
    
        function checkPhoneNumber( number ) {
            const regExp = new RegExp( /^[0-9|-]*$/ );
            if( regExp.test( number ) == true ) { return true; }
            else { return false; }
        }
    }

    //5.이메일
    var inputEmail    = joinSection.querySelector(".input[name='email']"); 
    inputEmail.onblur = validationEmail;
    function validationEmail(){
        
        //이메일 주소
        var emailAddr        = inputEmail.value;
        var emailDBColumByte = 45;
        var emailLength      = inputEmail.value.length;
        var emailByte        = emailLength * 2;

        //5.1.이메일 길이 체크.
        var emailLength = inputEmail.value.length;
        var printSpan   = inputEmail.name;
        var msgLength   = "이메일은 22자를 넘길 수 없습니다.";
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
            focusName.textContent = "";   //정보 출력 빈 값으로 초기화.    
        }    

    }//failValidated



    //저장 버튼 클릭 시 
    function aa(){

        var nm = "b"
        var ns = "a";
        var isall = nm && ns; 
        if(isall){

        }
        //form.SubmitEvent;
    }




})//window.addEventListener 이벤트 영역 종료.

 /*var html   = "<p>이름은 23글자를 넘길 수 없습니다.</p>";
   var width  = 300;
   var height = 100;
   var left   = (screen.width - width)   / 2;
   var top    = (screen.height - height) / 2;
   window.open("", "_blank", "width=" + width + ",height=" + height + ",left=" + left + ",top=" + top).document.write(html);*/