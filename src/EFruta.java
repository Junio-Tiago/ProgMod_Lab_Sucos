public enum EFruta {

	CUPUACU(12.0),
	GRAVIOLA(10.0),
	LARANJA(6.0),
	MANGA(8.0),
	MORANGO(9.0);

	private double valor;

	EFruta(double preco) {
		this.valor = preco;
	}

	public double valor() {
		return valor;
	}
}
