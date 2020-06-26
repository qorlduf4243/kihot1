package org.edu.dao;

import java.util.List;

import org.edu.vo.MemberVO;

public interface IF_MemberDAO {
	public void insertMember(MemberVO memberVO) throws Exception;
	public List<MemberVO> selectMember() throws Exception;
	public void updateMember(MemberVO memberVO) throws Exception;
	public void deleteMember(String user_id) throws Exception;
	

}
