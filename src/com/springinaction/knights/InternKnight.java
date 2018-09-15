package com.springinaction.knights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.springinaction.knights.config.KnightConfig;

@ContextConfiguration(classes = KnightConfig.class)
public class InternKnight implements Knight {

	@Autowired
	private Quest quest;

	@Override
	public void embarkOnQuest() {
		quest.embark();

	}

}
