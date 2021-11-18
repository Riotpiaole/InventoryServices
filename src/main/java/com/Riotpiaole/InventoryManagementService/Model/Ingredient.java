package com.Riotpiaole.InventoryManagementService.Model;

import javax.measure.Quantity;
import javax.measure.quantity.Mass;

import tech.units.indriya.unit.Units;
import tech.units.indriya.quantity.Quantities;


import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;

public class Ingredient implements LapseItemGroup{
	private final ItemType itemType = ItemType.Ingredient;
	protected final DateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");

	
	private String IngredientID;
	private String description;
	private String itemName;
	private String importDate;
	private String expireDate;
	private Quantity<Mass> quantity;
	
	/**
	 * Constructor for quick creation with only weights and day to expire
	 * @param _name: String Name of the ingredient
	 * @param days: int day will be expires 
	 * @param weightKG: double weight of the ingredient in KG.
	 */
	
	public Ingredient(
			String _uuid, 
			String _name, 
			Integer days, 
			double weightKG) 
	{ 
		
		Calendar cal = Calendar.getInstance();
		Date importDate = cal.getTime();
		this.IngredientID = _uuid;
		this.itemName = _name;
		this.importDate = formatter.format(importDate);
		this.setExpireDay(days);
		this.setQuantity(weightKG);
	}
	
	/** 
	 * Constructor for Ingredient Class\
	 * @param _name Name of Ingredient
	 * @param _importDate The date where is imported into the inventory. Format is: "DD/MM/YYYY". For example, 2021-11-17 becomes 17/11/2021.
	 * @param _expireDate The expireday where is imported into the inventory Format is: "DD/MM/YYYY". For example, 2021-11-17 becomes 17/11/2021.
	 * @param _weightKG the weight in kilogram of the given item group
	 * 
	 * <pre>
	 * import com.Riotpiaole.InventoryManagementService.Model.Ingredient;
	 * ingredient = new Ingredient("tomato", "11/11/2000", "13/11/2000", 1);
	 * </pre>
	 */
	public Ingredient(
			String _uuid, 
			String _name, 
			String _importDate, 
			String _expireDate, 
			double _weightKG) 
	{
		this.IngredientID = _uuid;
		this.itemName = _name;
		this.importDate = _importDate;
		this.expireDate = _expireDate;
		this.setQuantity(_weightKG);
	}
	
	@Override
	public String getItemName() {
		return itemName;
	}

	@Override
	public boolean isExpireInPST(Integer days) {
		
		return false;
	}

	@Override
	public ItemType getType() {
		return itemType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Quantity<Mass> getQuantity() {
		return quantity;
	}

	public void setQuantity(double weights) {
		this.quantity = Quantities.getQuantity(weights, Units.KILOGRAM);
	}
	
	public void setExpireDay(Integer days) { 
		// obtain current date
		Calendar cal = Calendar.getInstance();
		Date importDate = cal.getTime();
		cal.setTime(importDate);
		cal.add(Calendar.DATE, days);
		this.expireDate = formatter.format(cal.getTime());
	}
	
	public String getImportDate() {
		return importDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public String getUuid() {
		return IngredientID;
	}
	
}
