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
            success &= userMngDAO.insertUserInfoFromReq(uuid) > 0;
            success &= userMngDAO.insertUserPowerFromReq(uuid) > 0;
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
