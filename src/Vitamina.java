
public class Vitamina extends Bebida {

	private static final double ACRESCIMO = 2.5;
	private static final int MAX_FRUTAS = 3;

	
	private enum ETamanho {
		PEQUENA(1, 0.0),
		MEDIA(2, 0.40),
		GRANDE(3, 0.60);

		private int qtdFrutas;
		private double acrescimo;

		ETamanho(int qtdFrutas, double acrescimo) {
			this.qtdFrutas = qtdFrutas;
			this.acrescimo = acrescimo;
		}

		private static ETamanho deQuantidade(int qtdFrutas) {
			ETamanho resultado = PEQUENA;
			for (ETamanho t : values()) {
				if (qtdFrutas >= t.qtdFrutas) {
					resultado = t;
				}
			}
			return resultado;
		}
	}

	public Vitamina(EFruta fruta) {
		super("Vitamina");
		adicionar(fruta);
	}

	
	@Override
	public int adicionar(EFruta fruta) {
		if (fruta != null && frutas.size() < MAX_FRUTAS) {
			frutas.add(fruta);
		}
		return frutas.size();
	}

	
	@Override
	public double preco() {
		double media = frutas.stream()
				.mapToDouble(EFruta::valor)
				.average()
				.orElse(0.0);
		return (media + ACRESCIMO) * (1 + tamanho().acrescimo);
	}

	private ETamanho tamanho() {
		return ETamanho.deQuantidade(frutas.size());
	}

	@Override
	public String toString() {
		return super.toString() + " (" + tamanho().name().toLowerCase() + ")";
	}

}
