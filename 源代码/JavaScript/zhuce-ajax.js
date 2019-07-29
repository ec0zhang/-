// let TelePhone = document.getElementById('telePhone');
// let myPasswords = document.getElementById('passWord');

document.getElementById('btn1').addEventListener('click', function f() {
    if (TelePhone.value && yzma.value && myPasswords.value && myREpasswords.value) {
        alert("注册成功，即将为您登陆跳转至首页~");
        window.location.href = "../首页.html";
    }
});
//1.原生js ajax

//点击 按钮 发出ajax请求

document.getElementById('btn1').addEventListener('click', function () {
    // console.log('111');
    //1.创建连接
    let req = new XMLHttpRequest();
    //前端发送给后台的数据
    let data = {
        "userPhoneNumber": TelePhone.value,
        "userPassword": myPasswords.value,
    };
    //请求的路由（路径）
    let url = "http://localhost:8080/add";
    //2.连接服务器
    req.open('post', url, true);
    //POST方式，必须加入如下头信息设定
    req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    if (req) {
        //3.发送数据
        req.send(JSON.stringify(data));
        //4.接收响应
        req.onreadystatechange = function () {
            //请求成功
            if (req.readyState === 4 && req.status === 200) {
                //后台响应的数据 req.responseText 200
                success(req.responseText);
            }
        };
    }
});

//请求成功后的操作  创建新元素  再添加到页面中
function success(data) {
    console.log('right');
    // console.log(data.split('"'));
    if (!window.localStorage) {
        alert("浏览器不支持localStorage")
    }
    else {
        let storage = window.localStorage;
        storage.setItem('userID', data.toString().slice(10, 13));
    }
}