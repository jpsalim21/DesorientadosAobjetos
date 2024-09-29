/*
 * João Pedro Miranda Salim
 * Mateus Lopes Felício
 * Thales Gomes Batista
 */
package Torneios;

public class Confronto {
    private final JogadorParticipante jogador1;
    private final JogadorParticipante jogador2;
    private JogadorParticipante vencedor = null;
    private boolean terminouConfronto = false;
    private int resultado = 0;
    private String resultadoString;
    
    public Confronto(JogadorParticipante j1, JogadorParticipante j2){
        jogador1 = j1;
        jogador2 = j2;
        resultadoString = " x ";
    }
    //Pode ter jeitos melhores de setar isso, mas como temos caso de empate, não podemos usar boolean
    public void setResultado(int r){
        resultado = r;
        terminouConfronto = true;
        
        switch(resultado){
            case 0 -> {
                resultadoString = " 1x0 ";
            }
            case 1 ->{
                resultadoString = " 1/2x1/2 ";
            }
            case 2 ->{
                resultadoString = " 0x1 ";
            }
        }
    }
    public void terminarConfronto(){
        switch(resultado){
            case 0 -> {
                jogador1.getUsuario().addVitorias();
                jogador2.getUsuario().addDerrotas();
                vencedor = jogador1;
                jogador1.adicionarPontuacao(1);
            }
            case 1 -> {
                jogador1.getUsuario().addEmpates();
                jogador2.getUsuario().addEmpates();
                jogador1.adicionarPontuacao(0.5f);
                jogador2.adicionarPontuacao(0.5f);
            }
            case 2 -> {
                jogador1.getUsuario().addDerrotas();
                jogador2.getUsuario().addVitorias();
                vencedor = jogador2;
                jogador2.adicionarPontuacao(1);
            }
        }
    }
    public JogadorParticipante getVencedor(){
        return vencedor;
    }
    public boolean getTerminouConfronto(){
        return terminouConfronto;
    }
    //FIXME: Podemos encontrar outra forma de fazer isso
    @Override
    public String toString(){
        return jogador1.getUsuario().getNome() + resultadoString + jogador2.getUsuario().getNome();
    }
}
