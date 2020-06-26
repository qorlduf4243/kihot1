package org.edu.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.edu.vo.MemberVO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements IF_MemberDAO {

   private static String mapperQuery = "org.edu.dao.IF_MemberDAO";
   @Inject
   private SqlSession sqlSession;
   
   
   
   @Override
   public void insertMember(MemberVO memberVO) throws Exception {
    sqlSession.insert(mapperQuery + ".insertMember",memberVO);
      
   }

   @Override
   public List<MemberVO> selectMember() throws Exception {
      return sqlSession.selectList(mapperQuery + ".selectMember");
   }

   @Override
   public void updateMember(MemberVO memberVO) throws Exception {
      sqlSession.update(mapperQuery + ".updateMember", memberVO);
      
   }

   @Override
   public void deleteMember(String user_id) throws Exception {
      sqlSession.delete(mapperQuery + ".deleteMember", user_id);
      
   }

}