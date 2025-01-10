package kr.bit.beans;

import lombok.Data;

@Data
public class Page {
    private int min; //페이지 최소번호
    private int max; //페이지 최대번호
    private int prePage; //이전페이지
    private int currentPage; //다음페이지
    private int nextPage; //페이지당 게시글 수
    private int pageCnt; //
    //            전체게시글수        현재페이지         페이지당 게시글수      페이지버튼개수
    public Page(int contentCnt, int currentPage, int contentPageCnt, int pa) {
        this.currentPage = currentPage;

        pageCnt = contentCnt/contentPageCnt;

        if(contentCnt%contentPageCnt>0){
            pageCnt++;
        }

        min = ((currentPage-1)/pa) * pa+1;
        max = min+pa-1;

        if(max>pageCnt){
            max=pageCnt;
        }
        prePage = min-1;
        nextPage = max+1;

        if(nextPage>pageCnt){
            nextPage=pageCnt;
        }
    }
}
