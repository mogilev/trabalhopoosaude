/* No nosso diagrama colocámos uma classe para Service. Pensar se faz sentido sequer 
 * existir como classe, ou mesmo como enum 
 */
public enum Service {
	CONSULTA(MEDICINA),
	PEQUENACIRURGIA(MEDICINA, ENFERMAGEM, "AUXILIAR"),
	ENFERMAGEM("ENFERMAGEM", "AUXILIAR");
}
