
package Model;


public class Serie {
    private String serie;    
    private String temporada;
    private String episodio;
    private int ano;
    private boolean jaAssitiu;
    private String nota;


    
    public Serie(String serie,String textEpisodio, String temporada, int ano, boolean jaAssistido,String nota){
        this.setSerie(serie);
        this.setEpisodio(textEpisodio);
        this.setTemporada(temporada);
        this.setAno(ano);
        this.setJaAssitiu(jaAssistido);
        this.setNota(nota);
    }
 
    @Override
    public String toString(){
        return "serie: "+this.getSerie()+
                " | episodio: "+this.getEpisodio() + 
                " | temporada: "+ this.getTemporada()+
                " | ano: " + this.getAno()+
                " | ja assistido? " + (this.getJaAssitiu() ? "sim": "não") + 
                " | nota : " + this.getNota(); 
    }
    
    /**
     * @return the serie
    */
    public String getSerie() {
        return serie;
    }
 
    /**
     * @return the episodio
    */
    public String getEpisodio() {
        return episodio;
    }
    
    /**
     * @return the temporada
     */
    public String getTemporada() {
        return temporada;
    }
 
    /**
     * @return the ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * @return the jaAssitiu
    */
    public boolean isJaAssitiu() {
        return jaAssitiu;
    }
   
    /**
     * @return the jaAssitiu
    */
    public Boolean getJaAssitiu() {
        return jaAssitiu;
    }
    
     /**
     * @return the nota
     */
    public String getNota() {
        return nota;
    }
    
    
    /**
     * @param ano the ano to set
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    /**
     * @param temporada the temporada to set
     */
    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    
    /**
     * @param episodio the episodio to set
     */
    public void setEpisodio(String episodio) {
        this.episodio = episodio;
    }

   
    /**
     * @param serie the episodio to set
    */
    public void setSerie(String serie) {
        this.serie = serie;
    }
    
    /**
     * @param nota the ano to set
    */
    public void setNota(String nota) {
        this.nota = nota;
    }
    
    /**
     * @param jaAssitiu the ano to set
    */
    public void setJaAssitiu(boolean jaAssitiu) {
        this.jaAssitiu = jaAssitiu;
    }
   
}
