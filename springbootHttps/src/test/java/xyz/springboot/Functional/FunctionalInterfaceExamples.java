package xyz.springboot.Functional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionalInterfaceExamples {
	
	public static void main(String[] args) {
		
		Product productA = new Product(1L, "A",new BigDecimal("55.00"));
		Product productB = new Product(2L, "B", new BigDecimal("10.00"));
		Product productC = new Product(3L, "c", new BigDecimal("17.45"));
		Product productD = new Product(4L, "d", new BigDecimal("23.00"));
		Product productE = new Product(5L, "e", new BigDecimal("110.99"));
		final List<Product> products = Arrays.asList(
				productA,
				productB,
				productC,
				productD,
				productE
				);

		final BigDecimal total = total(products, product -> product.getPrice());
		final BigDecimal discountedtotal = total(products, product -> product.getPrice());
		System.out.println("total  :" + total);
		
		Order order = new Order(1L,"on-1234", Arrays.asList(
				new OrderedItem(1L,productA, 2),
				new OrderedItem(2L,productA, 1),
				new OrderedItem(3L,productA, 10)
				));

		System.out.println("order Totle: "+order.totalPrice());
		
		BigDecimal orderTotal = BigDecimal.ZERO;
		for (OrderedItem item : order.getItems()) {
			orderTotal = orderTotal.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
		}
		
		System.out.println(orderTotal);
	}
	

	private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {

		BigDecimal total = BigDecimal.ZERO;

		for (final T t : list) {
			total = total.add(mapper.apply(t));
		}
		return total;
	}
	
	
	@Data
	@AllArgsConstructor
	static class Product {
		private Long id;
		private String name;
		private BigDecimal price;
		
	}
	
	@AllArgsConstructor
	@Data
	static class OrderedItem{
		private Long id;
		private Product product;
		private int quantity;
		
		
		public BigDecimal getItemTotal() {
			return product.getPrice().multiply(new BigDecimal(quantity));
		}
	}
	
	@AllArgsConstructor
	@Data
	static class Order{
		private Long id;
		private String orderNumber;
		private List<OrderedItem> items;
		
		public BigDecimal totalPrice() {
		return 	total(items, item -> item.getItemTotal());
		}
	}
}
