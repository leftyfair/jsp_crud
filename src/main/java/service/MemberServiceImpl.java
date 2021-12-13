package service;

import java.util.List;

import dao.MemberDao;
import dao.MemberDaoImpl;
import vo.MemberVo;

public class MemberServiceImpl implements MemberService {
	
	MemberDao memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}

	@Override
	public List<MemberVo> memberList() {
		return memberDao.selectAll();
	}

	@Override
	public MemberVo read(int id) {
		return memberDao.selectOne(id);
	}

	@Override
	public boolean modify(MemberVo memberVo) {
		return memberDao.update(memberVo);
	}

	@Override
	public boolean remove(int id) {
		return memberDao.delete(id);
	}

	@Override
	public boolean register(MemberVo vo) {
		return memberDao.insert(vo);
	}

}
