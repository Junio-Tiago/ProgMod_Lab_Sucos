import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VitaminaTest {

	@Test
	public void vitaminaPequenaCustaFrutaMaisLeite() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);
		assertEquals(10.5, vitamina.preco(), 0.01); // 8 + 2,50
	}

	@Test
	public void vitaminaMediaTemAcrescimoDe40PorCento() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);
		vitamina.adicionar(EFruta.MORANGO);
		assertEquals(15.4, vitamina.preco(), 0.01); // (8,5 + 2,50) * 1,4
	}

	@Test
	public void vitaminaGrandeTemAcrescimoDe60PorCento() {
		Vitamina vitamina = new Vitamina(EFruta.CUPUACU);
		vitamina.adicionar(EFruta.GRAVIOLA);
		vitamina.adicionar(EFruta.LARANJA);
		assertEquals(18.93, vitamina.preco(), 0.01); // (28/3 + 2,50) * 1,6
	}

	@Test
	public void vitaminaNaoAceitaQuartaFruta() {
		Vitamina vitamina = new Vitamina(EFruta.MANGA);
		vitamina.adicionar(EFruta.MORANGO);
		vitamina.adicionar(EFruta.LARANJA);
		assertEquals(3, vitamina.adicionar(EFruta.CUPUACU));
	}
}
