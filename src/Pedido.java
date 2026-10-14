import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private List<Bebida> itens;

	public Pedido() {
		this.itens = new ArrayList<>();
	}

	
	public int adicionar(Bebida item) {
		if (item != null) {
			itens.add(item);
		}
		return itens.size();
	}

	
	public double preco() {
		return itens.stream()
				.mapToDouble(Bebida::preco)
				.sum();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Pedido:\n");
		for (Bebida item : itens) {
			sb.append("  - ").append(item).append("\n");
		}
		sb.append(String.format("Total: R$ %.2f", preco()));
		return sb.toString();
	}

}
