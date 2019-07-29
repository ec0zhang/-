window.onload = function () {
    waterfall("big", "ele");
    var dataInt = {
        "data": [
            {"src": '“大”人物.jpg'},
            {"src": '一个母亲的复仇.jpg'},
            {"src": '何以为家.jpg'},
            {"src": '动物出击.jpg'},
            {"src": '双生.jpg'},
            {"src": '地久天长.jpg'},

            {"src": '复仇者联盟4.jpg'},
            {"src": '天上再见.jpg'},
            {"src": '小飞象.jpg'},
            {"src": '惊奇队长.jpg'},
            {"src": '我想吃掉你的胰脏.jpg'},
            {"src": '撞死了一只羊.jpg'},
            {"src": '新喜剧之王.jpg'},
            {"src": '朝花夕誓-于离别之朝束起约定之花.jpg'},
            {"src": '死侍2：我爱我家.jpg'},
            {"src": '波西米亚狂想曲.jpg'},
            {"src": '流浪地球.jpg'},
            {"src": '海市蜃楼.jpg'},
            {"src": '狗眼看人心.jpg'},
            {"src": '猫公主苏菲.jpg'},
            {"src": '疯狂外星人.jpg'},
            {"src": '白蛇：缘起.jpg'},
            {"src": '祈祷落幕时.jpg'},
            {"src": '绿皮书.jpg'},
            {"src": '罗马.jpg'},
            {"src": '调音师.jpg'},
            {"src": '阿丽塔：战斗天使.jpg'},
            {"src": '雷霆沙赞.jpg'},
            {"src": '飞驰人生.jpg'},
            {"src": '驯龙高手3.jpg'},
        ]
    };
    var dataInt1 = {
        "data1": [
            '“大”人物',
            '一个母亲的复仇',
            '何以为家',
            '动物出击',
            '双生',
            '地久天长',

            '复仇者联盟4',
            '天上再见',
            '小飞象',
            '惊奇队长',
            '我想吃掉你的胰脏',
            '撞死了一只羊',
            '新喜剧之王',
            '朝花夕誓',
            '死侍2：我爱我家',
            '波西米亚狂想曲',
            '流浪地球',
            '海市蜃楼',
            '狗眼看人心',
            '猫公主苏菲',
            '疯狂外星人',
            '白蛇：缘起',
            '祈祷落幕时',
            '绿皮书',
            '罗马',
            '调音师',
            '阿丽塔：战斗天使',
            '雷霆沙赞',
            '飞驰人生',
            '驯龙高手3',
        ]
    };
    window.onscroll = function () {
        if (checkScroll()) {
            var myPCls = document.getElementById("big");
            for (var i = 0; i < dataInt.data.length; i++) {
                var oele1 = document.createElement('div');
                oele1.className = 'ele';
                myPCls.appendChild(oele1);
                var opic = document.createElement('pic');
                opic.className = 'pic';
                oele1.appendChild(opic);
                var oa = document.createElement('a');
                oa.href = "filmdetail1.html";
                opic.appendChild(oa);
                var oimg = document.createElement('img');
                oimg.src = '../images/common/' + dataInt.data[i].src;
                oa.appendChild(oimg);
                var otxt = document.createElement('div');
                otxt.className = 'filmName';
                otxt.innerText = dataInt1.data1[i];
                opic.parentNode.appendChild(otxt);
            }
            waterfall('big', 'ele');
        }
    }
}


function waterfall(parent, box) {
//取出所有元素
    var myPCls = document.getElementById(parent);
    var all = getClass(myPCls, box);
    //计算给出浏览器一个固定的列数
    var oneW = all[0].offsetWidth;
    var cols = Math.floor(document.documentElement.clientWidth / oneW);
    //该函数的意思是获取浏览器当前文档部分的宽度。不包含滚动条
    //实际列数并不固定，因为最大的盒子的宽度会随着浏览器窗口的大小的改变而变化
    //所以接下来设置父盒子的W
    myPCls.style.cssText = "width:" + oneW * cols + "px";
    var myArr = [];
    for (var i = 0; i < all.length; i++) {
        if (i < cols) {
            myArr.push(all[i].offsetHeight);
        }
        else {
            var minH = Math.min.apply(null, myArr);
            var Loc = getMinL(myArr, minH);//获取最小值的位置

            all[i].style.position = "absolute";
            all[i].style.top = minH + "px";
            all[i].style.left = oneW * Loc + "px";
            //all[i].style.left = myArr[Loc].offsetLeft +"px";
            //为什么不行
            myArr[Loc] += all[i].offsetHeight;
        }
    }
}

function getClass(parent, cls) {
    var boxArr = new Array();
    var oelements = parent.getElementsByTagName('*');
    for (var i = 0; i < oelements.length; i++) {
        if (oelements[i].className === cls) {
            boxArr.push(oelements[i]);
        }
    }
    return boxArr;
}

function getMinL(arr, val) {
    for (var i in arr) {
        if (arr[i] === val) {
            return i;
        }
    }
}

function checkScroll() {
    var myPCls = document.getElementById("big");
    var oele = getClass(myPCls, "ele");
    var lastH = oele[oele.length - 1].offsetTop + oele[oele.length - 1].offsetHeight / 2;
    var scrolled = document.body.scrollTop || document.documentElement.scrollTop;
    var win = document.body.clientHeight || document.documentElement.clientHeight;
    return (lastH < (scrolled + win)) ? true : false;
}