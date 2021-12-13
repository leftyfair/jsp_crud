package dao;

import java.util.List;

import vo.MemberVo;

public interface MemberDao {
	// 회원목록
		List<MemberVo> selectAll();
		
		// 회원상세
		MemberVo selectOne(int id);
		
		// 회원가입

		boolean insert(MemberVo vo);
		
		// 회원수정
		boolean update(MemberVo memberVo);
		
		// 회원삭제
		boolean delete(int id);
	
}
