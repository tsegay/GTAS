/*
 * All GTAS code is Copyright 2016, The Department of Homeland Security (DHS), U.S. Customs and Border Protection (CBP).
 *
 * Please see LICENSE.txt for details.
 */
package gov.gtas.job.scheduler;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class RuleRunnerCondition implements Condition {

	private static final Logger logger  = LoggerFactory.getLogger(RuleRunnerCondition.class);
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		
		logger.info("Rule runner is not running ");
		
		return true;
	}

}
