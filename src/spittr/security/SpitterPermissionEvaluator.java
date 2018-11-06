package spittr.security;

import java.io.Serializable;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class SpitterPermissionEvaluator implements PermissionEvaluator {

	@Override
	public boolean hasPermission(Authentication auth, Object target, Object arg2) {
		if (target instanceof String) {
			String username = (String) target;
			String pName = (String) arg2;
			return username.equals(auth.getName());
		}
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasPermission(Authentication arg0, Serializable arg1, String arg2, Object arg3) {
		// TODO Auto-generated method stub
		return false;
	}

}
