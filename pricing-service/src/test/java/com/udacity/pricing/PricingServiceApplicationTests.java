package com.udacity.pricing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.udacity.pricing.api.PricingController;

@WebMvcTest(PricingController.class)
public class PricingServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getPrices() throws Exception {
		mockMvc.perform(get("/services/price?vehicleId=" + 1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.currency").value("USD"))
				.andExpect(jsonPath("$.price").exists());
	}
}
