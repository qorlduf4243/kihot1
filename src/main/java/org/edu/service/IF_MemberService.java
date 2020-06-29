package org.edu.service;

import java.util.List;

import org.edu.vo.MemberVO;

public interface IF_MemberService {
	public void insertMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> selectMember() throws Exception;
	public void updateMember(MemberVO memberVO) throws Exception;
	public void deleteMember(String user_id) throws Exception;
	public MemberVO viewMember(String user_id) throws Exception;
}
