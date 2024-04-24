package com.spring.Mng;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserMngDAO {

	@Autowired
	private SqlSession sqlSession;

	// 사용자 권한 정보를 조회
	public List<UserMngDTO> selectInfoPower() {
		return sqlSession.selectList("mapper.userMng.infoPower");
	}

	// 센터 리스트를 조회
	public List<UserMngDTO> selectCenterList() {
		return sqlSession.selectList("mapper.userMng.centerList");
	}

	// 사용자 권한을 삭제하는 메소드
	public int deleteUserPower(String uuid) {
		return sqlSession.delete("mapper.userMng.deleteUserPower", uuid);
	}

	// 사용자 정보를 삭제하는 메소드
	public int deleteUser(String uuid) {
		return sqlSession.delete("mapper.userMng.deleteUser", uuid);
	}

	// 승인 처리를 위한 메소드: REQ_LIST에서 정보를 가져와 USER_INFO에 삽입
	public int insertUserInfoFromReq(String uuid) {
		return sqlSession.insert("mapper.userMng.insertUserInfoFromReq", uuid);
	}

	public int insertUserPowerFromReq(String uuid) {
		return sqlSession.insert("mapper.userMng.insertUserPowerFromReq", uuid);
	}

	// 거절 처리를 위한 메소드: REQ_LIST에서 사용자 요청을 삭제
	public int deleteFromReqList(String uuid) {
		return sqlSession.delete("mapper.userMng.deleteFromReqList", uuid);
	}

}
