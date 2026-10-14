
public class Suco extends Bebida {

	private static final int MAX_FRUTAS = 2;

	public Suco(EFruta fruta) {
		super("Suco");
		adicionar(fruta);
	}

	
	@Override
	public int adicionar(EFruta fruta) {
		if (fruta != null && podeAdicionar(fruta)) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	private boolean podeAdicionar(EFruta fruta) {
		if (frutas.isEmpty()) {
			return true;
		}
		return frutas.size() < MAX_FRUTAS
				&& (fruta == EFruta.LARANJA || frutas.contains(EFruta.LARANJA));
	}

	
	@Override
	public double preco() {
		return frutas.stream()
				.mapToDouble(EFruta::valor)
				.average()
				.orElse(0.0);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
