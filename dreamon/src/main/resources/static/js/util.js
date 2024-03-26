function Cookie(){

    //전역으로 사용하기 위해 this를 붙임.
    //prototypedp서 정의된 getCookie 함수에서 사용하기 위함.
    //아래것들은 지역
    this.map = {};  //{}는 object 형식.

    var cookieDecoded = decodeURIComponent(document.cookie);    //url에는 한글이 들어갈 수 없어서 Encoded되기 때문에 Decoded 해주어야 함.
console.log("1.cookieDecoded : " , cookieDecoded);
    var cookieTokens  = cookieDecoded.split(";");               //;을 기준으로 잘려서 배열에 담김.
console.log("2.cookieTokens : " , cookieTokens);

    for(c of cookieTokens){

        var temp  = c.split("=");
console.log("3.temp : " , temp);
        var key   = temp[0];
        var value = JSON.parse(temp[1]);
        this.map[key] = value;
    }
}

Cookie.prototype = {

    getCookie : function(name){

        return this.map[name];
    }
}