window.onload = function () {

    const holes = document.querySelectorAll('.hole');
    const scoreBoard = document.querySelector('.score');
    const moles = document.querySelectorAll('.mole');
    const startBtn = document.getElementById('start_btn');
    let titleH1 = document.getElementById('title');


    let lastHole;//上一次的洞口
    let timeUp = false;
    let score = 0;
    let gameTime = 10000;


    startBtn.addEventListener('click', function () {
        showBtnAnimation();
        startGame();
    }, false);

    function showBtnAnimation() {
        event.preventDefault();

        startBtn.classList.add('animate');
        // 按钮动画延时，按钮动画结束后发生的事：换为正常状态（class中的animate去掉），开始按钮消失
        setTimeout(() => {
            startBtn.classList.remove('animate');
            startBtn.style.display = 'none';
        }, 700);
    }


    function startGame() {
        resetScoreAndTime();
        peep();

        setTimeout(() => {
            // TODO: 写当游戏时间结束后要发生的事
            timeUp = true;
            startBtn.style.display = 'inline-block';
            startBtn.innerText = 'Replay';
            titleH1.innerHTML = 'TIME UP';
        }, gameTime)
    }

    /**
     * 初始化设置.
     */
    function resetScoreAndTime() {
        // TODO: 写游戏的初始化设置
        scoreBoard.innerHTML = '0';
        titleH1.innerHTML = 'WHACK-A-MOLE!';
        timeUp = false;
    }

    /**
     * 出洞.
     */
    function peep() {
        const time = randomTime(0, 500);
        const hole = randomHole(holes);
        comeOutAndStop(hole, time);
    }

    /**
     * 随机生成地鼠出洞的停留时间. 该时间其实是[min, max]间的随机数.
     *
     * @param min 随机数的下界.
     * @param max 随机数的上界.
     * @returns {number}
     */
    function randomTime(min, max) {
        // TODO: 写生成随机数的逻辑，
        return Math.floor(Math.random()*(max-min) + min);
    }

    /**
     * 随机选择地鼠钻出的地洞，如果与上一个是相同地洞，则重新选择一个地洞.
     *
     * @param holes
     * @returns {*}
     */
    function randomHole(holes) {
        // TODO: 写地鼠随机选择钻出地洞的逻辑，如果与上一个是相同地洞，则重新选择一个地洞.
        // let i = Math.floor(Math.random()*6);
        // if (holes[i] === holes[i-1]){}
        do {
            var i = Math.floor(Math.random()*6);
        }while (i === lastHole);
        lastHole = i;
        return holes[i];
    }

    /**
     * 地鼠出洞并停留相应时间，如果游戏时间未结束(timeUp)，继续出洞(peep).
     *
     * @param hole 地鼠所出地洞.
     * @param time 地鼠停留时间.
     */
    // function comeOutAndStop(hole, time) {
    //     // TODO: 写地鼠出洞并停留相应时间，如果游戏时间未结束(timeUp)，继续出洞(peep).
    //     for(let i = 100; !timeUp && i>=0; i--){
    //         console.log(hole.firstElementChild);
    //         hole.firstElementChild.style.top = i + "%";
    //     }
    //     setTimeout(function () {
    //         for(let i = 100; !timeUp && i>=0;i--){
    //             hole.firstElementChild.style.top = i + "%";
    //         }
    //         if (!timeUp) peep();
    //     },time);
    // }
    function comeOutAndStop(hole, time) {
        // console.log(hole.firstChild);
        // console.log(hole.firstElementChild);
        // TODO: 写地鼠出洞并停留相应时间，如果游戏时间未结束(timeUp)，继续出洞(peep).
        for (let i=100; !timeUp && i>=0; i--) {
            hole.firstElementChild.style.top = i+"%";
        }
        setTimeout(function(){
            for (let i=0; i<=100; i++) {
                hole.firstElementChild.style.top = i+"%";
            }
            if (!timeUp) peep();
        }, time);
    }

    /**
     * 打地鼠。为每个moles添加点击事件，点击后分数显示+1，地鼠入洞。
     */
    moles.forEach(mole => mole.addEventListener('click', function (e) {
        // TODO: 在这里写用户点击地鼠发生的事.
        // console.log(scoreBoard.innerHTML);
        let score = eval(scoreBoard.innerHTML);
        scoreBoard.innerHTML = score + 1;
    }));

};