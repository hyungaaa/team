package com.spring.Mng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserMngService {

	@Autowired
	private UserMngDAO userMngDAO;

	@Transactional
	public int deleteUser(String uuid) {
		// 사용자의 권한 레코드 삭제
		int affectedRows = userMngDAO.deleteUserPower(uuid);
		// 사용자 정보 삭제
		affectedRows += userMngDAO.deleteUser(uuid);
		return affectedRows;
	}

	@Transactional
	public boolean approveUsers(List<String> uuids) {
		boolean success = true;
		for (String uuid : uuids) {
			// user_info에 사용자 정보 삽입
			success &= userMngDAO.insertUserInfoFromReq(uuid) > 0;
			// user_power에 사용자 권한 정보 삽입
			success &= userMngDAO.insertUserPowerFromReq(uuid) > 0;
			// req_list에서 사용자 요청 삭제
			success &= userMngDAO.deleteFromReqList(uuid) > 0;
		}
		return success;
	}

	@Transactional
	public boolean rejectUsers(List<String> uuids) {
		boolean success = true;
		for (String uuid : uuids) {
			success &= userMngDAO.deleteFromReqList(uuid) > 0;
		}
		return success;
	}

}
