package kr.bit.controller;

import com.oreilly.servlet.MultipartRequest;
import kr.bit.entity.Member;
import kr.bit.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;

@Controller
@RequestMapping("member")
public class MemberController {
    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/join")
    public String memberJoin() {
        return "member/join";
    }

    @RequestMapping("/doubleCheck")
    @ResponseBody
    public int memberDoubleCheck(@RequestParam("memberID") String memberID) {
        Member member = memberMapper.memberDoubleCheck(memberID);
        if (member != null || memberID.equals("")) {
            return 0;
        }
        return 1;
    }

    @PostMapping(value = "/register")
    public String memberRegister(@ModelAttribute Member member, @RequestParam("memberPw1") String memberPw1, @RequestParam("memberPw2") String memberPw2,
                                 RedirectAttributes rttr, HttpSession session) {
        if (member.getMemberID() == null || member.getMemberID().isEmpty() ||
                memberPw1 == null || memberPw2 == null || memberPw1.isEmpty() || memberPw2.isEmpty() ||
                member.getMemberName() == null || member.getMemberName().isEmpty() ||
                member.getMemberID().equals("") || member.getMemberID().isEmpty() ||
                member.getMemberEmail() == null || member.getMemberEmail().isEmpty() || member.getMemberAge() == 0 ||
                member.getMemberGender() == null || member.getMemberGender().isEmpty()) {
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "모든 내용을 입력해야한다");
            return "redirect:/member/join";
        } else if (!memberPw1.equals(memberPw2)) {
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "비밀번호와 비빌번호 확인이 일치하지 않는다");
            return "redirect:/member/join";
        } else {
            if (memberMapper.memberDoubleCheck(member.getMemberID()) == null) {
                memberMapper.register(member);
                rttr.addFlashAttribute("messageType", "성공");
                rttr.addFlashAttribute("message", "회원가입에 성공했다");
                session.setAttribute("loginMemSession", member);
                return "redirect:/";
            } else {
                rttr.addFlashAttribute("messageType", "실패");
                rttr.addFlashAttribute("message", "이미 존재하는 회원이다");
                return "redirect:/member/join";
            }
        }
    }

    @GetMapping("logout")
    public String logout(RedirectAttributes rttr, HttpSession session) {
        session.invalidate();
        rttr.addFlashAttribute("messageType", "로그아웃 성공");
        rttr.addFlashAttribute("message", "로그아웃 되었습니다");
        return "redirect:/";
    }

    @GetMapping("login")
    public String login() {
        return "member/login";
    }

    @PostMapping("/loginPro")
    public String loginPro(@ModelAttribute Member member, RedirectAttributes rttr, HttpSession session) {
        Member temp = memberMapper.getLogibMember(member);
        if (temp != null) {
            session.setAttribute("loginMemSession", temp);
            rttr.addFlashAttribute("messageType", "성공");
            rttr.addFlashAttribute("message", "로그인 성공");
            return "redirect:/";
        }else{
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "로그인 실패");
            return "redirect:/member/login";
        }
    }

    @GetMapping("update")
    public String updateMember() {
        return "member/update";
    }

    @PostMapping("/updatePro")
    public String memberUpdate(Member member, String memberPw1, String memberPw2,
                               RedirectAttributes rttr, HttpSession session) {
        if (member.getMemberID() == null || member.getMemberID().equals("") ||
                memberPw1 == null || memberPw1.equals("") ||
                memberPw2 == null || memberPw2.equals("") ||
                member.getMemberName() == null || member.getMemberName().equals("") ||
                member.getMemberAge() == 0 ||
                member.getMemberGender() == null || member.getMemberGender().equals("") ||
                member.getMemberEmail() == null || member.getMemberEmail().equals("")) {

            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "모든 내용을 입력해야한다");

            return "redirect:/member/update";
        } else if (!memberPw1.equals(memberPw2)) {
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "비밀번호와 비빌번호 확인이 일치하지 않는다");
            return "redirect:/member/update";
        } else {
            if (memberMapper.memberUpdate(member) > 0) {
                rttr.addFlashAttribute("messageType", "성공");
                rttr.addFlashAttribute("message", "회원정보가 수정되었습니다");
                return "redirect:/";
            } else {
                rttr.addFlashAttribute("messageType", "실패");
                rttr.addFlashAttribute("message", "회원정보가 수정을 실패했습니다");
                return "redirect:/member/update";
            }
        }
    }

    @GetMapping("imageForm")
    public String imageForm() {
        return "member/imageForm";
    }

    @PostMapping("imageRegist")
    public String imageRegist(RedirectAttributes rttr, HttpSession session, HttpServletRequest request) throws IOException {
        Member temp = (Member)session.getAttribute("loginMemSession");

        int fileMaxSize = 4*1024*1024;
        String savePath = request.getRealPath("resources/img");
        String encoding = "UTF-8";

        if(request.getContentType() == null){
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "사진 저장을 실패했습니다");
            return "redirect:/member/imageForm";
        }

        MultipartRequest multipartRequest = new MultipartRequest(request, savePath, fileMaxSize, encoding);
        File uploadedFile = multipartRequest.getFile("memberProfile");
        String fileName = null;

        if (uploadedFile != null) {
            // 파일이 업로드되면 세션 ID를 사용한 이름으로 파일을 저장
            //파일명에서 확장자 추출
            String originName = uploadedFile.getName();
            String fileExtension = originName.substring(originName.lastIndexOf("."));
            fileName = temp.getMemberID()+"img"+fileExtension;

            File newFile = new File(savePath, fileName);
            try (InputStream in = new FileInputStream(uploadedFile);
                 OutputStream out = new FileOutputStream(newFile)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            uploadedFile.delete();

            temp.setMemberProfile(fileName);
            if(memberMapper.memberUpdate(temp) > 0) {
                rttr.addFlashAttribute("messageType", "성공");
                rttr.addFlashAttribute("message", "사진이 저장되었습니다");
                session.setAttribute("loginMemSession", temp);
                return "redirect:/";
            }else{
                rttr.addFlashAttribute("messageType", "실패");
                rttr.addFlashAttribute("message", "사진 저장을 실패했습니다");
                return "redirect:/member/imageForm";
            }
        }else{
            rttr.addFlashAttribute("messageType", "실패");
            rttr.addFlashAttribute("message", "사진 저장을 실패했습니다");
            return "redirect:/member/imageForm";
        }
    }
}
