const swiper = new Swiper(".swiper", {
    speed: 500,
    effect: "slide",
    loop: true,

    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },

    autoplay: {
        delay: 3000,
    },

    navigation: {
        nextEl: "#moveImgRightbtn",
        prevEl: "#moveImgLeftbtn",
    },
});

let scrolltopbtn = document.querySelector('#scrolltopbtn');
window.onscroll = function () {
    if (window.scrollY > window.innerHeight * 0.8) {
        scrolltopbtn.classList.remove("scrolltopHide");
        scrolltopbtn.classList.add("scrolltopShow");
    } else {
        scrolltopbtn.classList.remove("scrolltopShow");
        scrolltopbtn.classList.add("scrolltopHide");

    }
};

scrolltopbtn.addEventListener('click', function(){
    window.scrollTo({
        top: 0,
        behavior: 'smooth'
      });
});


let pagebtns = document.querySelectorAll(".swiper-pagination-bullet");

let swiperPagination = document.querySelector('.swiper-pagination');
let pausePlayButton = document.createElement('button');
pausePlayButton.id = 'pausePlay';  
let icon = document.createElement('i');
icon.classList.add('bi', 'bi-pause'); 
pausePlayButton.appendChild(icon);
swiperPagination.appendChild(pausePlayButton);

pausePlayButton.addEventListener('click', function (e) {
    if (swiper.autoplay.running) {
        let targetbtn = e.target.closest('button');
        targetbtn.querySelector('i').classList.toggle('bi-caret-right-fill');
        targetbtn.querySelector('i').classList.toggle('bi-pause');
        swiper.autoplay.stop();
    } else {
        let targetbtn = e.target.closest('button');
        targetbtn.querySelector('i').classList.toggle('bi-caret-right-fill');
        targetbtn.querySelector('i').classList.toggle('bi-pause');
        swiper.autoplay.start();
    }
});

let menutexts = document.querySelectorAll(".menutext");
let detailULs = document.querySelectorAll(".detailUL");
menutexts.forEach(function (menutext) {
    menutext.addEventListener('mouseover', function () {
        if (document.querySelector("#detailMenu").style.display != "block") {
            for (let i = 0; i < detailULs.length; i++) {
                let coordinates = menutexts[i].getBoundingClientRect();
                detailULs[i].style.left = (coordinates.left + 10) + 'px';
            }
            document.querySelector("#detailMenu").style.display = "block";
        }
    })
})

document.querySelector("#header").addEventListener('mouseleave', function () {
    document.querySelector("#detailMenu").style.display = "none";
})

let findshopbtn = document.querySelector("#findShopbtn");
findshopbtn.addEventListener('click', function(){
    window.location.href = "https://www.burgerking.co.kr/#/store";
})