package com.abc.ForexService.service;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import com.abc.ForexService.entity.Admin;
import com.abc.ForexService.repository.AdminRepository;

@SpringBootTest
public class AdminServiceTest {
	
	@InjectMocks
	private AdminServiceImpl adminService = new AdminServiceImpl();
	
	@Mock
	private AdminRepository adminRepository;
	
	@Test
	void testGetAllAdmin() {
	
		List<Admin> admin = new ArrayList<Admin>();
		
		Admin admin1 = new Admin();

		admin1.setAdminId(1);
		admin1.setAdminName("sneha");
		admin1.setAdminEmail("sneha@gmail.com");
		admin1.setAdminUsername("sneha");
		admin1.setAdminPassword("sneha@123");
		
		
		Admin admin2 = new Admin();

		admin2.setAdminId(2);
		admin2.setAdminName("priyanka");
		admin2.setAdminEmail("priyanka@gmail.com");
		admin2.setAdminUsername("priyanka");
		admin2.setAdminPassword("priyanka@123");
		
	
 		admin.add(admin1);
 		admin.add(admin2);
		
		
		when(adminRepository.findAll()).thenReturn(admin);	
		List<Admin> adminList = adminService.getAllAdmin();
				assertEquals(2,adminList.size());		
	}
	@Test
	void testGetSaveAdmin() {
	
		List<Admin> admin = new ArrayList<Admin>();
		
		Admin admin1 = new Admin();

		admin1.setAdminId(1);
		admin1.setAdminName("sneha");
		admin1.setAdminEmail("sneha@gmail.com");
		admin1.setAdminUsername("sneha");
		admin1.setAdminPassword("sneha@123");
		
		
		Admin admin2 = new Admin();

		admin2.setAdminId(2);
		admin2.setAdminName("priyanka");
		admin2.setAdminEmail("priyanka@gmail.com");
		admin2.setAdminUsername("priyanka");
		admin2.setAdminPassword("priyanka@123");
		
	
 		admin.add(admin1);
 		admin.add(admin2);
		
		
		when(adminRepository.findAll()).thenReturn(admin);	
		List<Admin> adminList = adminService.getAllAdmin();
				assertEquals(2,adminList.size());		
	}

}

	

