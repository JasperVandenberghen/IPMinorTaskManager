package com.taskmanager.taskmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TaskmanagerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void testGetHeads() {
		// setup
		HeadDTO headDTO = new HeadDTO();
		headDTO.setOwner("Wim");
		headDTO.setDecapitated(false);
		headDTO.setDateAndTimeOfBeheading(LocalDateTime.of(2020, 03, 10, 10, 0));
		headService.addHead(headDTO);

		// method to be tested
		List<HeadDTO> heads = headService.getHeads();

		// checks
		assertNotNull(heads);
		assertFalse(heads.isEmpty());
		assertEquals(1, heads.size());
		HeadDTO head = heads.get(0);
		assertNotNull(head);
	}


}
