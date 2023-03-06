package dao;
 
import domain.Sale;
import java.util.HashMap;
import java.util.Map;
 
public final class SaleCollectionsDAO implements SaleDAO {
 
	private static final Map<Integer, Sale> sales = new HashMap<>();
 
	@Override
	public void save(Sale sale) {
		System.out.println("Saving sale: " + sale);
		sales.put(sale.getSaleID(), sale);
	}
}
