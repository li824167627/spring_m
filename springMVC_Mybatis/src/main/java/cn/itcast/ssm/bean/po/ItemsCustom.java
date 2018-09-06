package cn.itcast.ssm.bean.po;

public class ItemsCustom extends Items{

		//添加商品信息的扩展属性
	private Items items;
	private ItemsCustom itemsCustom;
	
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
		
}
