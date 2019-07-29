let TelePhone = document.getElementById('telePhone');
let yzma = document.getElementById('yzma');
let myPasswords = document.getElementById('passWord');
let myREpasswords = document.getElementById('TpassWord');

// console.log(telePhone);
TelePhone.onblur = function () {
    // console.log('111');
    let telenum = telePhone.value;
    if (!(/^1[3|4|5|7|8][0-9]\d{4,8}$/.test(telenum))) {
        TelePhone.style.border = 'red 1.5px solid';
        alert("请确认手机号码是否正确~");
    }
    else {
        TelePhone.style.border = '0';
    }
};

yzma.onblur = function () {
    if (!(yzma.value === '000000')) {
        yzma.style.border = 'red 1.5px solid';
        alert('请输入000000');
    }
    else {
        yzma.style.border = '0';
    }
};

myPasswords.onblur = function () {
    if (!(/^(\w){6,20}$/.test(myPasswords.value))) {
        myPasswords.style.border = 'red 1.5px solid';
        alert("请确保密码在6-20位哦~");
    }
    else {
        myPasswords.style.border = '0';
    }
};
myREpasswords.onblur = function () {
    if (!(myPasswords.value === myREpasswords.value)) {
        myREpasswords.style.border = 'red 1.5px solid';
        alert("请确保两次密码完全一致哦~");
    }
    else {
        myREpasswords.style.border = '0';
    }
};


