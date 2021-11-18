package com.Riotpiaole.InventoryManagementService.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.Riotpiaole.InventoryManagementService.Model.Ingredient;

@RestController
@RequestMapping(path= "ingredient")
public class IngredientController {
	
	
	@GetMapping
	public List<Ingredient> getIngredients() { 
		return List.of( 
			new Ingredient("01","random", 3, 10)
		);		
	}
}
