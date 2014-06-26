package com.xal.ors.biz;

import com.xal.ors.ResultMapper;
import com.xal.ors.model.Manager;

public interface MgrService {
	ResultMapper changePw(Manager mgr, String newPass);

	Manager login(String userName, String password);
}
