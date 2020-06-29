package org.edu.service;

import java.util.List;

import javax.inject.Inject;

import org.edu.dao.IF_MemberDAO;
import org.edu.vo.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IF_MemberService{
	
	@Inject
	private IF_MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO memberVO) throws Exception {
		memberDAO.insertMember(memberVO);
	}

	@Override
	public List<MemberVO> selectMember() throws Exception {
		return memberDAO.selectMember();
	}

	@Override
	public void updateMember(MemberVO memberVO) throws Exception {
		memberDAO.updateMember(memberVO);
		
	}

	@Override
	public void deleteMember(String user_id) throws Exception {
		memberDAO.deleteMember(user_id);
		
	}

	@Override
	public MemberVO viewMember(String user_id) throws Exception {
		return memberDAO.viewMember(user_id);
	}

}
