package com.bringmyweb.exceptionalframwork.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Bar implements ExceptionHandler {
	private static final Logger LOGGER = LogManager.getLogger();
	@Override
	public void handleException(Throwable t) {
		LOGGER.catching(t);
	}
}
