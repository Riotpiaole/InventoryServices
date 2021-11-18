package com.Riotpiaole.InventoryManagementService.Model;


public interface LapseItemGroup{
	String getItemName();
	boolean isExpireInPST(Integer day);
	ItemType getType();
}
