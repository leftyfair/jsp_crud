package service;

import java.util.List;

import vo.MemberVo;

public interface MemberService {
	// 회원목록
	List<MemberVo> memberList();
	
	// 회원상세
	MemberVo read(int id);
	
	// 회원가입
	boolean register(MemberVo vo);
	
	// 회원수정
	boolean modify(MemberVo memberVo);
	
	// 회원삭제
	boolean remove(int id);
	
}
