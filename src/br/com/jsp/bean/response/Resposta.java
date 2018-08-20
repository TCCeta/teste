package br.com.jsp.bean.response;

/**
 *
 * @author 103782
 */
public class Resposta<T> {

    private T objeto = null;

    private Boolean funcionou = null;

    private String mensagem = null;

    public Resposta(String mensagem, T objeto, boolean funcionou) {

        this.objeto = objeto;
        this.funcionou = funcionou;
        this.mensagem = mensagem;

    }
    
    public Resposta(String mensagem) {
    	this(mensagem, null, false);
    }
    
    public Resposta(){
    }

    /**
     * @return the objeto
     */
    public T getObjeto() {
        return objeto;
    }

    /**
     * @return the funcionou
     */
    public boolean getFuncionou() {
        return funcionou;
    }

    /**
     * @return the mensagem
     */
    public String getMensagem() {
        return mensagem;
    }

    /**
     * @param objeto the objeto to set
     */
    public void setObjeto(T objeto) {
        if (this.objeto.equals(null)) {
            this.objeto = objeto;
        }
    }

    /**
     * @param funcionou the funcionou to set
     */
    public void setFuncionou(Boolean funcionou) {
        if (this.funcionou.equals(null)) {
            this.funcionou = funcionou;
        }
    }

    /**
     * @param mensagem the mensagem to set
     */
    public void setMensagem(String mensagem) {
        if (this.mensagem.equals(null)) {
            this.mensagem = mensagem;
        }
    }

}