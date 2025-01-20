function chexistId(){
    let url = 'http://localhost:8083/untitled/openExistChk?user_id='+$("#user_id").val();

    let width = 500;  // 팝업 창의 너비
    let height = 400; // 팝업 창의 높이
    // 화면의 너비와 높이를 구합니다.
    let screenWidth = window.innerWidth;
    let screenHeight = window.innerHeight;
    // 팝업을 화면 중앙에 배치하기 위한 좌표를 계산합니다.
    let left = (screenWidth - width) / 2;
    let top = (screenHeight - height) / 2;

    window.open(url, "중복확인", `width=${width},height=${height},top=${top},left=${left},resizable=yes`);
}

function updateId(){
    $("#existId").val(true);
    $("#user_id").attr("readonly", false);
    $("#chexistBtn").css("display","inline-block");
    $("#updateIdBtn").css("display","none");
}
