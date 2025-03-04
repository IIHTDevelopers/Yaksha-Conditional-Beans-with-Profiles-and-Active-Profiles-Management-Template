package com.yaksha.assignment.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class ProfileUtils {

	@Autowired
	private Environment environment;

	// Get the current active profile
	public String[] getActiveProfiles() {
		return environment.getActiveProfiles();
	}

	// Get the current active profile (return first profile if multiple profiles are
	// active)
	public String getActiveProfile() {
		String[] activeProfiles = environment.getActiveProfiles();
		return activeProfiles.length > 0 ? activeProfiles[0] : "default";
	}
}
