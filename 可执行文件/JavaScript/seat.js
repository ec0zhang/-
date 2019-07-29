var seatCount = 0;
let rows = document.getElementsByClassName('seat');
// console.log(rows);

rows[0].parentNode.parentNode.addEventListener('click', function (e) {
    let event = e || window.event;
    let target = event.target || event.srcElement;
    if (target.nodeName.toLowerCase() === 'span' && target.style.background ==='red'){
        this.removeEventListener();
    }

    if (target.nodeName.toLowerCase() === 'span') {
        // target.setAttribute('class','btn-selection');
        var pic = document.createElement('img');
        pic.style.display = 'inline-block';
        pic.src = '../images/index/checkbox-checked.png';
        pic.style.marginLeft = '10px';
        pic.style.width = '28px';
        pic.style.height = '28px';
        // console.log(pic);
        target.parentNode.replaceChild(pic, target);
        seatCount++;
        // console.log(seatCount);

    }
    if (target.nodeName.toLowerCase() === 'img') {
        let spanS = document.createElement('span');

        spanS.className = 'seat';
        target.parentNode.replaceChild(spanS,target);
        seatCount--;

        // console.log(seatCount);
    }
    document.getElementById('price').innerText = seatCount * 33;


});

