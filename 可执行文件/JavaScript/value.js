if (!window.localStorage) {
    alert("浏览器不支持localStorage")
}
else {
    let storage = window.localStorage;
    let values = document.getElementsByClassName('tiaomu');
    document.getElementsByClassName('vot')[0].onclick = function () {
        storage.setItem('value', values[0].innerText);
    };
    document.getElementsByClassName('vot')[1].onclick = function () {
        storage.setItem('value', values[1].innerText);
    };
    document.getElementsByClassName('vot')[2].onclick = function () {
        storage.setItem('value', values[2].innerText);
    };
}
