document.getElementById('tougao').onclick = function () {
    window.location.href = 'game.html';
    // console.log(document.getElementById('tougao'));
    if (!window.localStorage){
    }
    else {
        let storage = window.localStorage;
        storage.setItem('word','分数达到20将为您转接VIP人工客服ㄟ( ▔, ▔ )ㄏ');
    }
    let sayWords = localStorage.getItem('word');
    alert(sayWords);
};
// console.log(userID);
//如果用户有id ，则返回用户id显示在页面上
if (localStorage.getItem('userID') === null){}
else{
    document.getElementById('denglu').innerText = localStorage.getItem('userID');
    document.getElementById('denglu').href = '';
    // let pic0 = document.createElement('img');
    // pic0.src = "images/index/lala.gif";
    // pic0.style.width = '100px';
    // document.getElementById('zhuce').parentNode.appendChild(pic0);
    document.getElementById('zhuce').href = '';
    document.getElementById('zhuce').innerText = '退出登陆';
}
document.getElementById('zhuce').onclick = function () {
    localStorage.removeItem('userID');
    document.getElementById('denglu').innerText = '登陆';
    document.getElementById('denglu').href = '../pages/PDL登陆.html';
    document.getElementById('zhuce').innerText = '注册';
    // window.location.href = '首页.html';
    document.getElementById('zhuce').href = '../pages/PDL注册.html';
};
