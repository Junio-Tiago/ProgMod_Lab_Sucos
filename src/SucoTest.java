import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SucoTest {

	@Test
	public void sucoComLaranjaEOutraFrutaCustaAMedia() {
		Suco suco = new Suco(EFruta.LARANJA);
		suco.adicionar(EFruta.MANGA);
		assertEquals(7.0, suco.preco(), 0.01); // (6 + 8) / 2
	}

	@Test
	public void sucoNaoAceitaDuasFrutasSemLaranja() {
		Suco suco = new Suco(EFruta.MANGA);
		assertEquals(1, suco.adicionar(EFruta.MORANGO));
		assertEquals(8.0, suco.preco(), 0.01);
	}

	@Test
	public void sucoNaoAceitaTerceiraFruta() {
		Suco suco = new Suco(EFruta.LARANJA);
		suco.adicionar(EFruta.MANGA);
		assertEquals(2, suco.adicionar(EFruta.MORANGO));
	}
}
