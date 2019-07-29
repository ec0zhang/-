// let Btn1 = document.getElementsByClassName('btn-1');

let btnsParent = document.getElementsByClassName('lll');
// 列表一的事件委托
// console.log(btnsParent[1]);
btnsParent[0].addEventListener('click', function (e) {
    var event = e || window.event;
    var target = event.target || event.srcElement;
    if (target.nodeName.toLocaleLowerCase() === 'a') {
        target.classList.add('btn-2');
        let huanyuan = siblings(target);
        for (let i = 0; i <= huanyuan.length; i++) {
                huanyuan[i].classList.remove('btn-2');
        }
    }
});


// 列表二的事件委托
btnsParent[1].addEventListener('click', function (e) {
    var event = e || window.event;
    var target = event.target || event.srcElement;
    if (target.nodeName.toLocaleLowerCase() === 'a') {
        target.classList.add('btn-2');
        let huanyuan = siblings(target);
        for (let i = 0; i <= huanyuan.length; i++) {
                huanyuan[i].classList.remove('btn-2');
        }
    }
});

function siblings(elm) {
    let a = [];
    let p = elm.parentNode.children;
    for (let i = 0, pl = p.length; i < pl; i++) {
        if (p[i] !== elm) a.push(p[i]);
    }
    return a;
}