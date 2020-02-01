package com.simplenotes.user.login;

import com.simplenotes.cache.CacheProvider;
import com.simplenotes.exception.BaseException;
import com.simplenotes.mail.MailService;
import com.simplenotes.mvc.ResultMessage;
import com.simplenotes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi{

	@Autowired
	private MailService mailService;

	@Override
	public ResultMessage submitMsg(User user) {
		validateParam(user);
		if (user.getEmail() != null) {
			mailService.sendEmail(user.getEmail());
		}
		return ResultMessage.success();
	}

	private void validateParam(User user) {
		if (StringUtils.isEmpty(user.getUsername())) {
			throw new BaseException("用户名不得为空");
		}
		if (StringUtils.isEmpty(user.getEmail())
				&& StringUtils.isEmpty(user.getMobile())){
			throw new BaseException("账号不得为空");
		}
	}

}
