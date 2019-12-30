package com.roytuts.lombok.slf4j.java.spring.springboot;

import org.apache.logging.log4j.ThreadContext;
import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LombokSlf4jApp {

	public static void main(String[] args) {
		printLog();
	}

	private static void printLog() {
		log.debug("Debug Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.info("Info Message");
		log.trace("Trace Message");

		MDC.put("module", "MDC");
		log.debug("Debug Message");
		log.warn("Warn Message");
		log.error("Error Message");
		log.info("Info Message");
		log.trace("Trace Message");

		MDC.remove("MDC");

		ThreadContext.put("module", "Module1");
		log.debug("Module1 Debug Message");
		log.warn("Module1 Warn Message");
		log.error("Module1 Error Message");
		log.info("Module1 Info Message");

		ThreadContext.put("module", "Module2");
		log.debug("Module2 Debug Message");
		log.warn("Module2 Warn Message");
		log.error("Module2 Error Message");
		log.info("Module2 Info Message");

		ThreadContext.remove("module");
	}

}
