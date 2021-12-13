package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import service.MemberService;
import service.MemberServiceImpl;
import vo.MemberVo;

@WebServlet("/member/*")
public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	MemberService memberService;
	
	
	public MemberController() {
		memberService = new MemberServiceImpl();
	}

	
	@Override
	public void init() throws ServletException {
		System.out.println("MemberController init 메서드 호출");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String cmdURI = requestURI.substring(contextPath.length());
		String viewPage = null;
		
		
		// 회원목록 화면제공
		if(cmdURI.equals("/member/list")) {
			viewPage = "list"; // 뷰페이지
			List<MemberVo> memberList = memberService.memberList(); 
			request.setAttribute("list", memberList); // 모델
		}
		
		// 회원가입 화면제공
		if(cmdURI.equals("/member/registerForm")) {
			viewPage = "register";
		}
		
		// 회원가입 처리
		if(cmdURI.equals("/member/register")) {
			MemberVo vo = new MemberVo(
						request.getParameter("username"),
						request.getParameter("password"),
						request.getParameter("email")
					);
						
			
			if(memberService.register(vo)) {
				response.sendRedirect(contextPath + "/member/list");
				return;
			}
			// 예외처리
			
		}
		
		// 회원정보 화면제공
		if(cmdURI.equals("/member/get")) {
			viewPage = "get";
			int id = Integer.parseInt(request.getParameter("id")); 
			MemberVo memberVo = memberService.read(id);
			request.setAttribute("memberVo", memberVo);
		}
		
		
		//회원삭제처리
		if(cmdURI.equals("/member/delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			
			if(memberService.remove(id)) {
				response.sendRedirect(contextPath + "/member/list");
				return;
			}
			// 예외처리
		}
		
		// 회원 수점폼 화면 제공
		if(cmdURI.equals("/member/updateForm")) {
			viewPage = "modify";
			MemberVo memberVo = new MemberVo(
					request.getParameter("username"),
					request.getParameter("password"),
					request.getParameter("email")
					);
			memberVo.setId(Integer.parseInt(request.getParameter("id")));
			System.out.println(memberVo);
			request.setAttribute("memberVo", memberVo);
		}
		
		// 회원정보 수정처리
		if(cmdURI.equals("/member/update")) {
			MemberVo memberVo = new MemberVo(
					request.getParameter("username"), 
					request.getParameter("password"),
					request.getParameter("email"));
			memberVo.setId(Integer.parseInt(request.getParameter("id")));
			
			if(memberService.modify(memberVo)) {
				response.sendRedirect(contextPath + "/member/list");
				return;
			}
		}
		
		
		if(viewPage != null) {
			RequestDispatcher rd =  request.getRequestDispatcher("/WEB-INF/views/member/"+viewPage+".jsp");
			rd.forward(request, response);	
		} 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
